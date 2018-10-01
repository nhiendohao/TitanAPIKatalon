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
import com.sun.jna.StringArray as StringArray
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static org.assertj.core.api.Assertions.*
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import static com.xlson.groovycsv.CsvParser.parseCsv
import java.text.DecimalFormat

@Grab('com.xlson.groovycsv:groovycsv:1.3')

//CODE
//Declare request
RequestObject GetServiceOperation = findTestObject('Toyota/GetServiceOperations_JSON', [
	('Dealer_Code') : '765A', 
	('Location_Code') : '1', 
	('VIN') : 'VNVNVNVNVNVNVNVNV', 
	('Service_Type') : 'OSB_SERVICE_TYPE_ADDITIONAL'])
//Declare header
GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)

String ServiceType = "OSB_SERVICE_TYPE_ADDITIONAL"
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetServiceOperation.getResponseText())
def OpCodeJSON = 0
res_Text.each{ OpCodeJSON += 1}

def RoundNumber = { Float floatnumber ->
String roundvalue =  new DecimalFormat("#.##").format(floatnumber)
	if (!(roundvalue.contains("."))) roundvalue = roundvalue + ".0"
return roundvalue
}
println  RoundNumber(5)


//Get data from CSV file
int count_CSV = 0
CSVReader = new File('Data Files/Toyota/OperationCode_ADDITIONAL.csv')
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
