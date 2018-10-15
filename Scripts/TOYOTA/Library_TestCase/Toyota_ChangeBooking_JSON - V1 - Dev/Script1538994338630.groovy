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
//V1. Vaidate dealer, WS, duration, need Duration, drop off and pick up time
//V2. Add function Add Job Line and Delete Job Line and Change Contact
//=========================================================================================

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	if(StatusCode == 0) WS.verifyResponseStatusCodeInRange(response, 400, 404)
	else WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}
//Convert Object to Time
def ConvertObjectToDate = {Object global ->
	String Time_Str = global as String
	int Time_hour = Time_Str.substring(0, 2) as Integer
	int Time_min = Time_Str.substring(3) as Integer
	def Time = new Date()
	Time.set(hourOfDay: Time_hour, minute:Time_min, second: 0)
	println Time
	return Time
	}
//=========================================================================================

//CODE
//Set up value for variable depend on input value
//Set service date change
if(var_DateChange == "") var_DateChange = GlobalVariable.Glb_ServiceDate
	else GlobalVariable.Glb_ServiceDate = var_DateChange
//Set Drop Off Time Change
if(var_DropOffChange == "") var_DropOffChange = GlobalVariable.Glb_DropOffTime
	else GlobalVariable.Glb_DropOffTime = var_DropOffChange
//Set Pick Up Change
if(var_PickUpChange == "") var_PickUpChange = GlobalVariable.Glb_PickUpTime
	else GlobalVariable.Glb_PickUpTime = var_PickUpChange
//Set Total Price Change
if(var_PriceChange == "") var_PriceChange = GlobalVariable.Glb_TotalPrice
	else GlobalVariable.Glb_TotalPrice = var_PriceChange
//Set Total Duration change
if(var_DurationChange == "") var_DurationChange = GlobalVariable.Glb_TotalDuration
	else GlobalVariable.Glb_TotalDuration = var_DurationChange
//Setup DMSOperationCode base on Service Type
String DMSOperationCode
if(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK") DMSOperationCode = "OSB_SERVICE_TYPE_LOGBOOK"
	else DMSOperationCode = "OSB_SERVICE_TYPE_ADDITIONAL"

//Setup Action Add Jobline for Method Change
String AddJobLineMethod = 'Toyota/ChangeBooking_JSON'
if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == "true") AddJobLineMethod = 'Toyota/ChangeBooking_JSON - AddOpCode'


	println GlobalVariable.Glb_Dealer_Code
	println GlobalVariable.Glb_Location_Code
	println GlobalVariable.Glb_Booking_ID
	println GlobalVariable.Glb_ServiceBay_Type
	println GlobalVariable.Glb_ContactId
	println GlobalVariable.Glb_FirstName
	println GlobalVariable.Glb_LastName
	println GlobalVariable.Glb_ServiceType
	println var_DateChange
	println var_DropOffChange
	println var_PickUpChange
//Declare request
RequestObject ChangeBooking = findTestObject(AddJobLineMethod, [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('BookingID') : GlobalVariable.Glb_Booking_ID, 
	('Service_Date_Change') : var_DateChange, 
	('Drop_Off_Time_Change') : var_DropOffChange, 
	('Pick_Up_Time') : var_PickUpChange, 
	('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type,
	('TotalPrice_Change') : var_PriceChange,
	('TotalDuration_Change') : var_DurationChange,
	('ContactId') : GlobalVariable.Glb_ContactId,
	('FirstName') : GlobalVariable.Glb_FirstName,
	('LastName') : GlobalVariable.Glb_LastName,
	('ServiceType') : GlobalVariable.Glb_ServiceType,
	('DMSOperationCode') : DMSOperationCode,
	('VIN') : GlobalVariable.Glb_VIN , 
	('REGNumber') : GlobalVariable.Glb_REGNumber ])
//Setup header value
ChangeBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Declare respone
ResponseObject res_ChangeBooking = WS.sendRequest(ChangeBooking)

//Convert type data section
//Convert String to Integer
int TotalDuration = GlobalVariable.Glb_TotalDuration as Integer
//Convert String to Date
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date
Date DropOffTime = ConvertObjectToDate(GlobalVariable.Glb_DropOffTime)
Date PickUpTime = ConvertObjectToDate(GlobalVariable.Glb_PickUpTime)
//Convert String to Date
Object Start_WS_Hr_Obj = "0" + GlobalVariable.Glb_WorkshopStart +":00"
Date Start_WS_Hr = ConvertObjectToDate(Start_WS_Hr_Obj)
Object End_WS_Hr_Obj = GlobalVariable.Glb_WorkshopEnd +":00"
Date End_WS_Hr = ConvertObjectToDate(End_WS_Hr_Obj)
//Calculate Time avalable for service
int duration_hours
use(groovy.time.TimeCategory) {
	def _duration = PickUpTime - DropOffTime
	duration_hours = _duration.hours as Integer
	println duration_hours
	}

//Verify Response Status
//Clasify case
//StartDate  after EndDate
if (!(GlobalVariable.Glb_Dealer_Code == "765A"))
	VerifyResponse(res_ChangeBooking,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
//Drop Off Time after Pick Up Time
else if(DropOffTime.after(PickUpTime))
	 VerifyResponse(res_ChangeBooking,0,"must be greater then the drop off times")
//Total Duration is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalDuration == "1"))
		 VerifyResponse(res_ChangeBooking,0,"total duration "+GlobalVariable.Glb_TotalDuration+" of RepairOrder not equals total duration 1 of RepairOrder Line")
//Total Price is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalPrice == "110"))
	 VerifyResponse(res_ChangeBooking,0,"Booking Rejected - The total price "+GlobalVariable.Glb_TotalPrice+" of RepairOrder not equals total price 110 of RepairOrder Line")
else if(duration_hours < TotalDuration)
	 VerifyResponse(res_ChangeBooking,0,"Booking Rejected - The total duration of service greater than duration booking time")
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
	GlobalVariable.Glb_Location_Code == "3"||
	GlobalVariable.Glb_Location_Code == "5")
	 VerifyResponse(res_ChangeBooking,0,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	 GlobalVariable.Glb_Location_Code == "4"||
	 GlobalVariable.Glb_Location_Code == "360"))
	 VerifyResponse(res_ChangeBooking,0,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
//StartDate before Current
else if(!(var_DateChange == GlobalVariable.Glb_ServiceDate))
	VerifyResponse(res_ChangeBooking,0,"pick up timeslot taken")
//Drop Off Time before WS Start Hour
else if( DropOffTime.before(Start_WS_Hr))
	VerifyResponse(res_ChangeBooking,0,"drop off timeslot taken")
//Pickup Time after WS End Hour
else if( PickUpTime.after(End_WS_Hr))
	 VerifyResponse(res_ChangeBooking,0,"pick up timeslot taken")
//All valid
else {
	 VerifyResponse(res_ChangeBooking,200,"")

	//Verify Booking ID
	WS.verifyElementPropertyValue(res_ChangeBooking, 'BookingID', GlobalVariable.Glb_Booking_ID)
	
	//Call Get Booking Detail for each Method
	if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == "true") 
		WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON - V1 - Add_Code'), [:], FailureHandling.STOP_ON_FAILURE)
	else
		WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
	
	//Set Status
	GlobalVariable.Glb_Status_ChangeBooking = "passed"
	} 
