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
@Grab('com.xlson.groovycsv:groovycsv:1.3')

//V0. Verify Status code and get Json data
//V1. Get data from CSV file
//Verify data

//Declare request
RequestObject GetServiceOperation = findTestObject('Toyota/GetServiceOperations_JSON', [('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, ('Location_Code') : GlobalVariable.Glb_Location_Code, ('VIN') : GlobalVariable.Glb_VIN
            , ('Service_Type') : Service_Type])
//Declare header
GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_GetServiceOperation, 200)

//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetServiceOperation.getResponseText())

//Get the retrieved operation code
//Declare Array to store data
def Op_Code = new String[50][4]
Op_Code[0][0] = res_Text[0].Name
println  Op_Code[0][0]
int count =0
for(int i = 0;i<50;i++) {
	if( res_Text[i] == null) break
	else {
		Op_Code[i][0] = res_Text[i].Name
		Op_Code[i][1] = res_Text[i].DMSOperationalCode
		Op_Code[i][2] = res_Text[i].Duration
		Op_Code[i][3] = res_Text[i].DealerPrice		
		count +=1	
	}
}
println count

//Get data from CSV file
CSVReader = new File('Data Files/Toyota/test.csv')
def csv_content = CSVReader.getText('utf-8')
 //Convert CSV to text
def CSVData = parseCsv(csv_content, separator: ',', readFirstLine: false)
 //Get for each column
for (line in CSVData) {
	 lineName = line.Name
}
for (line in CSVData) {
	lineDMSOperationalCode = line.DMSOperationalCode
}
for (line in CSVData) {
	lineDuration = line.Duration
}
for (line in CSVData) {
	lineDealerPrice = line.DealerPrice
}
