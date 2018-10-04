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
println GlobalVariable.Glb_VIN
println GlobalVariable.Glb_REGNumber
println GlobalVariable.Glb_ServiceDate
println GlobalVariable.Glb_DropOffTime
println GlobalVariable.Glb_PickUpTime
println GlobalVariable.Glb_Reserve_Token
println GlobalVariable.Glb_ServiceBay_Type
println GlobalVariable.Glb_Dealer_Code
println GlobalVariable.Glb_Location_Code
println GlobalVariable.Glb_TotalPrice
println GlobalVariable.Glb_TotalDuration
println GlobalVariable.Glb_ContactId
println GlobalVariable.Glb_FirstName
println GlobalVariable.Glb_LastName
println GlobalVariable.Glb_ServiceType
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
	println "available hour is: "+duration_hours
	}

println GlobalVariable.Glb_BookingStatus 
//Verify Response Status
//Clasify case
//Invalid Dealer Code
if (!(GlobalVariable.Glb_Dealer_Code == "765A")){
	println "Invalid Dealer Code"
	VerifyResponse(res_MakeServiceBooking,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
}
//X Reserve Token = no
else if( GlobalVariable.Glb_Reserve_Token.toString().toLowerCase() == "no" ){
	println "X Reserve Token = no"
	 VerifyResponse(res_MakeServiceBooking,404,"Booking not found")
}
//Drop Off Time after Pick Up Time
else if(DropOffTime.after(PickUpTime)){
	println "Drop Off Time after Pick Up Time"
	 VerifyResponse(res_MakeServiceBooking,400,"must be greater then the drop off times")
}
//Total Duration is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalDuration == "1")){
	println "Total Duration is not equal to duration job line"
	VerifyResponse(res_MakeServiceBooking,400,"total duration "+GlobalVariable.Glb_TotalDuration+" of RepairOrder not equals total duration 1 of RepairOrder Line")
}
//Total Price is not equal to duration job line
else if(!(GlobalVariable.Glb_TotalPrice == "110")){
	println "Total Price is not equal to duration job line"
	 VerifyResponse(res_MakeServiceBooking,400,"Booking Rejected - The total price "+GlobalVariable.Glb_TotalPrice+" of RepairOrder not equals total price 110 of RepairOrder Line")
}
//Available is less than need hour
else if(duration_hours < TotalDuration){
	println "Available is less than need hour"
	 VerifyResponse(res_MakeServiceBooking,400,"Booking Rejected - The total duration of service greater than duration booking time")
}
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
	GlobalVariable.Glb_Location_Code == "3"||
	GlobalVariable.Glb_Location_Code == "5"){
	println "Closed Workshop"
	 VerifyResponse(res_MakeServiceBooking,400,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
}
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	 GlobalVariable.Glb_Location_Code == "4"||
	 GlobalVariable.Glb_Location_Code == "360")){
 	println "Not exist Workshop"
	 VerifyResponse(res_MakeServiceBooking,400,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
}
//ServiceDate before Current
else if(Service_Date.before(current)){
	println "ServiceDate before Current"
	VerifyResponse(res_MakeServiceBooking,404,"is before the current date")
}
//Drop Off Time before WS Start Hour
else if( DropOffTime.before(Start_WS_Hr) || GlobalVariable.Glb_BookingStatus == "current"){
	println "Drop Off Time before WS Start Hour"
	VerifyResponse(res_MakeServiceBooking,400,"drop off timeslot is taken")
}
//Pickup Time after WS End Hour
else if( PickUpTime.after(End_WS_Hr)){
	println "Pickup Time after WS End Hour"
	 VerifyResponse(res_MakeServiceBooking,400,"pick up timeslot taken")
}
 
//All valid
else if(!(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" )){
	println "All valid"
	 VerifyResponse(res_MakeServiceBooking,200,"")
	 //Set Status Booking: not yet --> current
	 GlobalVariable.Glb_BookingStatus = "current"

	//Get Reserve Token
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(res_MakeServiceBooking.getResponseText())
	//get the retrieved token
	GlobalVariable.Glb_Booking_ID = res_Text.BookingID
	println GlobalVariable.Glb_Booking_ID
	}
