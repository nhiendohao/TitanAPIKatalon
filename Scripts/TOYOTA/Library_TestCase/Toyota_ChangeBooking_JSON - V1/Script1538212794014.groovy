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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static org.assertj.core.api.Assertions.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date


//V0. Check send request successfully and verify return right Booking ID
//V1. Vaidate dealer, WS, duration, need Duration, drop off and pick up time,
//=========================================================================================

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}
//Convert String to Date
def ConvertString_toDate = {String Date_Str, String format ->
	SimpleDateFormat formatter = new SimpleDateFormat(format);
	
		Date _date = formatter.parse(Date_Str);
		System.out.println(_date);
		return _date
}
//=========================================================================================

//CODE
//Set up value for variable depend on input value
if(var_DateChange == "") var_DateChange = GlobalVariable.Glb_ServiceDate
if(var_DropOffChange == "") var_DropOffChange = GlobalVariable.Glb_DropOffTime
if(var_PickUpChange == "") var_PickUpChange = GlobalVariable.Glb_PickUpTime
if(var_PriceChange == "") var_PriceChange = GlobalVariable.Glb_TotalPrice
if(var_DurationChange == "") var_DurationChange = GlobalVariable.Glb_TotalDuration
if(var_VINChange == "") var_VINChange = GlobalVariable.Glb_VIN
if(var_REGNumberChange == "") var_REGNumberChange = GlobalVariable.Glb_REGNumber
//Setup DMSOperationCode base on Service Type
String DMSOperationCode
if(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK") DMSOperationCode = "OSB_SERVICE_TYPE_LOGBOOK"
	else DMSOperationCode = "OSB_SERVICE_TYPE_ADDITIONAL"
//Declare request
RequestObject ChangeBooking = findTestObject('Toyota/ChangeBooking_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('BookingID') : GlobalVariable.Glb_Booking_ID, 
	('Service_Date') : var_DateChange, 
	('Drop_Off_Time_Change') : var_DropOffChange, 
	('Pick_Up_Time_Change') : var_PickUpChange, 
	('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type,
	('TotalPrice_Change') : var_PriceChange,
	('TotalDuration_Change') : var_DurationChange,
	('ContactId') : GlobalVariable.Glb_ContactId,
	('FirstName') : GlobalVariable.Glb_FirstName,
	('LastName') : GlobalVariable.Glb_LastName,
	('ServiceType') : GlobalVariable.Glb_ServiceType,
	('DMSOperationCode') : DMSOperationCode,
	('VIN') : var_VINChange , 
	('REGNumber') : var_REGNumberChange ,])
//Setup header value
ChangeBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Declare respone
ResponseObject res_ChangeBooking = WS.sendRequest(ChangeBooking)
//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_ChangeBooking, 200)

//Verify Booking ID
WS.verifyElementPropertyValue(res_ChangeBooking, 'BookingID', GlobalVariable.Glb_Booking_ID)

