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


//V0. Check send request successfully and get Booking Id
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
//Setup DMSOperationCode base on Service Type
String DMSOperationCode
if(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK") DMSOperationCode = "OSB_SERVICE_TYPE_LOGBOOK"
	else DMSOperationCode = "OSB_SERVICE_TYPE_ADDITIONAL"

//Declare request
RequestObject MakeServiceBooking = findTestObject('Toyota/MakeServiceBooking_JSON', [
	('VIN') : GlobalVariable.Glb_VIN, 
	('REGNumber') : GlobalVariable.Glb_REGNumber, 
	('Service_Date') : GlobalVariable.Glb_ServiceDate, 
	('Drop_Off_Time') : GlobalVariable.Glb_DropOffTime, 
	('Pick_Up_Time') : GlobalVariable.Glb_PickUpTime, 
	('Reserve_Token') : GlobalVariable.Glb_Reserve_Token, 
	('ServiceBay_Type') : GlobalVariable.Glb_ServiceBay_Type,
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code,
	('TotalPrice') : GlobalVariable.Glb_TotalPrice,
	('TotalDuration') : GlobalVariable.Glb_TotalDuration,
	('ContactId') : GlobalVariable.Glb_ContactId,
	('FirstName') : GlobalVariable.Glb_FirstName,
	('LastName') : GlobalVariable.Glb_LastName,
	('ServiceType') : GlobalVariable.Glb_ServiceType,
	('DMSOperationCode') : DMSOperationCode])
//Setup header value
MakeServiceBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))
//Declare response
ResponseObject res_MakeServiceBooking = WS.sendRequest(MakeServiceBooking)

//Convert type data section
//Convert String to Integer
int TotalDuration = GlobalVariable.Glb_TotalDuration as Integer
//Convert String to Date
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date
def DropOffTime = Date.parse("HH:mm", GlobalVariable.Glb_DropOffTime) as Date
def PickUpTime = Date.parse("HH:mm", GlobalVariable.Glb_PickUpTime) as Date
//Convert String to Date
Start_WS_Str = "0" + GlobalVariable.Glb_WorkshopStart + ":00"
def Start_WS_Hr = ConvertString_toDate(Start_WS_Str,"HH:mm")
End_WS_Str = GlobalVariable.Glb_WorkshopEnd + ":00"
def End_WS_Hr = ConvertString_toDate(End_WS_Str,"HH:mm")
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
	VerifyResponse(res_MakeServiceBooking,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
//Drop Off Time after Pick Up Time
else if(DropOffTime.after(PickUpTime))
	 VerifyResponse(res_MakeServiceBooking,400,"must be greater then the drop off times")
//Total Duration is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalDuration == "1"))
		 VerifyResponse(res_MakeServiceBooking,400,"total duration "+GlobalVariable.Glb_TotalDuration+" of RepairOrder not equals total duration 1 of RepairOrder Line")
//Total Price is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalPrice == "110"))
	 VerifyResponse(res_MakeServiceBooking,400,"Booking Rejected - The total price "+GlobalVariable.Glb_TotalPrice+" of RepairOrder not equals total price 110 of RepairOrder Line")
else if(duration_hours < TotalDuration)
	 VerifyResponse(res_MakeServiceBooking,400,"Booking Rejected - The total duration of service greater than duration booking time")
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
	GlobalVariable.Glb_Location_Code == "3"||
	GlobalVariable.Glb_Location_Code == "5")
	 VerifyResponse(res_MakeServiceBooking,400,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	 GlobalVariable.Glb_Location_Code == "4"||
	 GlobalVariable.Glb_Location_Code == "360"))
	 VerifyResponse(res_MakeServiceBooking,400,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
//ServiceDate before Current
else if(Service_Date.before(current))
	VerifyResponse(res_MakeServiceBooking,404,"is before the current date")
//Drop Off Time before WS Start Hour
else if( DropOffTime.before(Start_WS_Hr) || GlobalVariable.Glb_BookingStatus == "current")
	VerifyResponse(res_MakeServiceBooking,400,"drop off timeslot taken")
//Pickup Time after WS End Hour
else if( PickUpTime.after(End_WS_Hr)(Start_WS_Hr))
	 VerifyResponse(res_MakeServiceBooking,400,"pick up timeslot taken")
/*else if((DropOffTime.before(Start_WS_Hr) || DropOffTime.after(End_WS_Hr) || duration_hours < Duration) &&
	 !(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" ))
	 VerifyResponse(res_ReserveTimeslot,400,"Duration " +Duration+ " do not match values from GetDropOffTimes")*/
//All valid
else if(!(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" )){
	 VerifyResponse(res_MakeServiceBooking,200,"")
	 //Set Status Booking: not yet --> current
	 GlobalVariable.Glb_BookingStatus == "current"

	//Get Reserve Token
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(res_MakeServiceBooking.getResponseText())
	//get the retrieved token
	GlobalVariable.Glb_Booking_ID = res_Text.BookingID
	println GlobalVariable.Glb_Booking_ID
	}
