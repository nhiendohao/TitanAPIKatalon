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
@Grab('com.xlson.groovycsv:groovycsv:1.3')

//V0. Verify Status code and get Json data
//V1. Get data from CSV file
//Verify data
//====================================================================================================

//METHOD
//Method veirfy Status Code for each case
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}
//=====================================================================================================

//CODE
//Declare request
RequestObject GetServiceOperation = findTestObject('Toyota/GetServiceOperations_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('VIN') : GlobalVariable.Glb_VIN, 
	('Service_Type') : Service_Type])
//Declare header
GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)

//Classify case
if(!(GlobalVariable.Glb_Dealer_Code == "765A")) 
	VerifyResponse(res_GetServiceOperation,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
else if(GlobalVariable.Glb_VIN.toString().toLowerCase() == "invalid")
	VerifyResponse(res_GetServiceOperation,404,"The VIN mapping to many vehicles")
else if(!(GlobalVariable.Glb_Location_Code == "1"||
		GlobalVariable.Glb_Location_Code == "4"||
		GlobalVariable.Glb_Location_Code == "360")
	VerifyResponse(res_GetServiceOperation,400,"The Workshop"+ GlobalVariable.Glb_Location_Code +"is close")
//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetServiceOperation.getResponseText())

//Get the retrieved operation code
//Declare Array to store data JSON
/*def Op_Code = new String[50][4]
Op_Code[0][0] = res_Text[0].Name
println  Op_Code[0][0]
int count_JSON =0
for(int i = 0;i<50;i++) {
	if( res_Text[i] == null) break
	else {
		Op_Code[i][0] = res_Text[i].Name
		Op_Code[i][1] = res_Text[i].DMSOperationalCode
		Op_Code[i][2] = res_Text[i].Duration
		Op_Code[i][3] = res_Text[i].DealerPrice		
		count_JSON +=1	
	}
}
println count_JSON*/

//Get data from CSV file
int count_CSV = 0
CSVReader = new File('Data Files/Toyota/test.csv')
def csv_content = CSVReader.getText('utf-8')
 //Convert CSV to text
def CSVData = parseCsv(csv_content, separator: ',', readFirstLine: false)
 //Get for each column and Assert with Response
for (line in CSVData) {
	 assert res_Text[count_CSV].Name == line.Name
	 assert res_Text[count_CSV].DMSOperationalCode == line.DMSOperationalCode
	 assert res_Text[count_CSV].Duration == line.Duration
	 assert res_Text[count_CSV].DealerPrice == line.DealerPrice
	 count_CSV += 1
}
