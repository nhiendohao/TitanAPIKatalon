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
import static org.assertj.core.api.Assertions.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

RequestObject GetPickupTime = findTestObject('Toyota/GetPickUpTimes_JSON', [
	('Service_Date') : '2018-09-29',
	('Drop_Off_Time') : '08:00',
	('ServiceBay_Time') : 'PERIODIC',
	('Duration_Time') : '1',
	('Dealer_Code') : '765A',
	('Location_Code') : '1'])
//Declare Header for request
GetPickupTime.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetPickupTime = WS.sendRequest(GetPickupTime)

def res_Text = new groovy.json.JsonSlurper().parseText(res_GetPickupTime.getResponseText())

assert  res_Text[0] == null

Start_WS_Str = "0" + GlobalVariable.Glb_WorkshopStart + ":00"
def ConvertString_toDate = {String Date_Str, String format ->
SimpleDateFormat formatter = new SimpleDateFormat(format);

	Date date = formatter.parse(Date_Str);
	System.out.println(date);
	return date
}

Date dateconv = ConvertString_toDate(GlobalVariable.Glb_StartDate as String,"yyyy-MM-dd")
println  dateconv
