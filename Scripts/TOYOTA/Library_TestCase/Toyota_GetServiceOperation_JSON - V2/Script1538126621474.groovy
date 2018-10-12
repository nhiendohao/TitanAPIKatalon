import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return as array_return
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.sun.jna.StringArray
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static com.xlson.groovycsv.CsvParser.parseCsv
import static org.assertj.core.api.Assertions.*
import java.text.DecimalFormat
@Grab('com.xlson.groovycsv:groovycsv:1.3')

//V0. Verify Status code and get Json data
//V1. Get data from CSV file
//Verify data
//V2. Verify the quantity OpCode
//====================================================================================================

//METHOD
//Method veirfy Status Code for each case
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	if(StatusCode == 0) WS.verifyResponseStatusCodeInRange(response, 400, 404)
	else WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage=="")) assertThat(response.getResponseText()).contains(ExpectedMessage)
}

//Round number
	def RoundNumber = { Float floatnumber ->
		String roundvalue =  new DecimalFormat("#.##").format(floatnumber)
			if (!(roundvalue.contains("."))) roundvalue = roundvalue + ".0"
		return roundvalue
}
//=====================================================================================================

//CODE
//Set Service Type
	ServiceType = GlobalVariable.Glb_ServiceType
//Declare File path CSV
String Filepath
if(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK")
	Filepath = "Data Files/Toyota/OperationCode_LOGBOOK.csv"
	else Filepath = "Data Files/Toyota/OperationCode_ADDITIONAL.csv"
	
	println GlobalVariable.Glb_Dealer_Code
	println GlobalVariable.Glb_Location_Code
	println GlobalVariable.Glb_VIN
	println GlobalVariable.Glb_ServiceType
	
//Declare request
RequestObject GetServiceOperation = findTestObject('Toyota/GetServiceOperations_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('VIN') : GlobalVariable.Glb_VIN, 
	('Service_Type') : GlobalVariable.Glb_ServiceType])
//Declare header
GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)

//Classify case
//Invalid Dealer Code
if(!(GlobalVariable.Glb_Dealer_Code == "765A")) 
	VerifyResponse(res_GetServiceOperation,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
//Invalid Service Type
else if(!(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK" || GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_ADDITIONAL"))
	VerifyResponse(res_GetServiceOperation,400,"Service Type Unknown")
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
		GlobalVariable.Glb_Location_Code == "3"||
		GlobalVariable.Glb_Location_Code == "5")
	VerifyResponse(res_GetServiceOperation,400,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	GlobalVariable.Glb_Location_Code == "4"||
	GlobalVariable.Glb_Location_Code == "360"))
VerifyResponse(res_GetServiceOperation,400,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
//Invalid VIN
else if(GlobalVariable.Glb_VIN.toString().toLowerCase() == "vininvalid")
	VerifyResponse(res_GetServiceOperation,404,"VIN mapping to many vehicles")
//Valid All
else { VerifyResponse(res_GetServiceOperation,200,"")

//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetServiceOperation.getResponseText())
def OpCodeJSON = 0
res_Text.each{ OpCodeJSON += 1}

//Get data from CSV file
int count_CSV = 0
CSVReader = new File(Filepath)
def csv_content = CSVReader.getText('utf-8')
 //Convert CSV to text
def CSVData = parseCsv(csv_content, separator: ',', readFirstLine: false)
 //Get for each column and Assert with Response
for (line in CSVData) {
	 assert res_Text[count_CSV].Name == line.Name
	 assert res_Text[count_CSV].DMSOperationalCode == line.DMSOperationalCode
	 //Modify format for Duration in CSV file
	 _duration = line.Duration as String
	 if(!_duration.contains(".")) _duration = line.Duration + ".0"
	 assert RoundNumber(res_Text[count_CSV].Duration) == _duration
	 //Modify format for Price in CSV file
	 _price = line.DealerPrice as String
	 if(!_price.contains(".")) _price = line.DealerPrice + ".0"
	 assert RoundNumber(res_Text[count_CSV].DealerPrice as Float) == _price
	 assert res_Text[count_CSV].ServiceType == ServiceType
	 assert res_Text[count_CSV].ServiceCode == null
	 assert res_Text[count_CSV].EMFlag as String == "false"
	 assert res_Text[count_CSV].EMDuration as String == "0.0"
	 assert res_Text[count_CSV].POAFlag as String == "false"
	 assert res_Text[count_CSV].Price as String== "0.0"
	 count_CSV += 1
  }

//Verify number of element between JSON response and slot of WS
assert OpCodeJSON == count_CSV
GlobalVariable.Glb_Status_GetOperationCode = "passed"
}

