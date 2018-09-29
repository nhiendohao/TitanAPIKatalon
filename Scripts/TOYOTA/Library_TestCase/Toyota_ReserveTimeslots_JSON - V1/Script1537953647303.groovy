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

//V0. Check response and get token
//V1. Check reserve timeslot will be unavailable
//Validate dealer, WS, Duration, Service Date
//=========================================================================================

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage=="")) assertThat(response.getResponseText()).contains(ExpectedMessage)
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
//Declare request
RequestObject ReserveTimeslot = findTestObject('Toyota/ReserveTimeslots_JSON', [
	('Service_Date') : GlobalVariable.Glb_ServiceDate        , 
	('Duration') : GlobalVariable.Glb_Duration_Time, 
	('Drop_Off_Time') : GlobalVariable.Glb_DropOffTime, 
	('Pick_Up_Time') : GlobalVariable.Glb_PickUpTime        , 
	('ServiceBay_Type') : GlobalVariable.Glb_ServiceBay_Type, 
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code])
//Set header value
ReserveTimeslot.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_ReserveTimeslot = WS.sendRequest(ReserveTimeslot)

//Convert String to Integer
int Duration = GlobalVariable.Glb_Duration_Time as Integer
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
	def _duration = End_WS_Hr - DropOffTime
	duration_hours = _duration.hours as Integer
	println duration_hours
	}


//Verify Response Status
//Clasify case
//StartDate  after EndDate
if (!(GlobalVariable.Glb_Dealer_Code == "765A"))
	VerifyResponse(res_ReserveTimeslot,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
//Duration <=0
else if(Duration <= 0)
	 VerifyResponse(res_ReserveTimeslot,400,"The duration must be greater than 0")
//Invalid Servicebay
else if(!(GlobalVariable.Glb_ServiceBay_Type == "PERIODIC"||
	 GlobalVariable.Glb_ServiceBay_Type == "EXPRESS"||
	 GlobalVariable.Glb_ServiceBay_Type == "REPAIR"||
	 GlobalVariable.Glb_ServiceBay_Type == "DIAGNOSTIC"))
	 VerifyResponse(res_ReserveTimeslot,400,"Service Bay Type Unknown")
 //Closed Workshop
 else if(GlobalVariable.Glb_Location_Code == "2"||
	GlobalVariable.Glb_Location_Code == "3"||
	GlobalVariable.Glb_Location_Code == "5")
	 VerifyResponse(res_ReserveTimeslot,400,"The Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
 //Not exist Workshop
 else if(!(GlobalVariable.Glb_Location_Code == "1"||
	 GlobalVariable.Glb_Location_Code == "4"||
	 GlobalVariable.Glb_Location_Code == "360"))
	 VerifyResponse(res_ReserveTimeslot,400,"The Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
//StartDate before Current
else if(Service_Date.before(current))
	VerifyResponse(res_ReserveTimeslot,404,"is partially outside days when DMS will take bookings")
//Duration >= 10
else if(Duration >= 10)
	 VerifyResponse(res_ReserveTimeslot,400,"Duration " +Duration+ " cannot be completed in a single day")
/*else if((DropOffTime.before(Start_WS_Hr) || DropOffTime.after(End_WS_Hr) || duration_hours < Duration) &&
	 !(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" ))
 	VerifyResponse(res_ReserveTimeslot,400,"Duration " +Duration+ " do not match values from GetDropOffTimes")*/
//All valid
else {
	 VerifyResponse(res_ReserveTimeslot,200,"")


//Verify ServiceBay Type
WS.verifyElementPropertyValue(res_ReserveTimeslot, 'ServiceBayType', GlobalVariable.Glb_ServiceBay_Type)

//Verify Action
WS.verifyElementPropertyValue(res_ReserveTimeslot, 'Action', 'HOLD')

//Get Reserve Token
//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_ReserveTimeslot.getResponseText())

//get the retrieved token
GlobalVariable.Glb_Reserve_Token = res_Text.XReserveToken
println(GlobalVariable.Glb_Reserve_Token)

//Verify the Drop Off Timeslot is not available when send request Get Off Time again
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON - V3'), [
	('Start_Date') : GlobalVariable.Glb_ServiceDate, 
	('End_Date') : GlobalVariable.Glb_ServiceDate, 
	('Service_Type') : GlobalVariable.Glb_ServiceBay_Type,
	('Reserve_Timeslot') : GlobalVariable.Glb_DropOffTime], 
FailureHandling.STOP_ON_FAILURE)
}
