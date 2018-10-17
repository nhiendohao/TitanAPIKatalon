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

//V0. Get pick up timeslot and check all slot for any date input, not validate
//V1. Check the number element between JSON and timeslot of WS
//Valiate Service Date, Duration, Drop Off Time and ServiceBay Type, Saturday and Sunday
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
//Convert String to Date
def ConvertString_toDate = {String Date_Str, String format ->
	SimpleDateFormat formatter = new SimpleDateFormat(format);
	
		Date _date = formatter.parse(Date_Str);
		System.out.println(_date);
		return _date
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
// Declare request
println GlobalVariable.Glb_ServiceDate
println GlobalVariable.Glb_DropOffTime
println GlobalVariable.Glb_ServiceBay_Type
println GlobalVariable.Glb_Duration_Time
println GlobalVariable.Glb_Dealer_Code
println GlobalVariable.Glb_Location_Code
RequestObject GetPickupTime = findTestObject('Toyota/GetPickUpTimes_JSON', [
	('Service_Date') : GlobalVariable.Glb_ServiceDate, 
	('Drop_Off_Time') : GlobalVariable.Glb_DropOffTime, 
	('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type, 
	('Duration_Time') : GlobalVariable.Glb_Duration_Time,
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code])
//Declare Header for request
GetPickupTime.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetPickupTime = WS.sendRequest(GetPickupTime)
//Convert String to Integer
int Duration = GlobalVariable.Glb_Duration_Time as Integer
//Convert String to Date
Date current_hour = ConvertObjectToDate(GlobalVariable.Glb_Current_Hour)
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date
Date DropOffTime = ConvertObjectToDate(GlobalVariable.Glb_DropOffTime)
//Calculate time customer can pick up car
Date TimeCanPickUp
use(groovy.time.TimeCategory){
	TimeCanPickUp = DropOffTime + Duration.hour
}
println "Time can pickup is: " + TimeCanPickUp
//Declare Time Workshop Open and Time WS Close
//Convert String to Date
//Create real time variable
def realtime_ws = new Date()
//Declare Time Workshop Open and Time WS Close
int Start = ((GlobalVariable.Glb_WorkshopStart) as Integer)
int End = ((GlobalVariable.Glb_WorkshopEnd) as Integer)
//Declare Interval for Timeslots and Duration for Service
int Interval = ((GlobalVariable.Glb_Interval) as Integer)

//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start + Duration, minute:00,second: 0)
println(realtime_ws.format('HH:mm'))

//Set Time WS Close, this time is early 15 minutes
def time_close_ws = new Date()
time_close_ws.set(hourOfDay: End, minute:00,second: 0)

Date Start_WS_Hr = realtime_ws
println  Start_WS_Hr
Date End_WS_Hr = time_close_ws
println  Start_WS_Hr
//Calculate Time avalable for service
int duration_hours
use(groovy.time.TimeCategory) {
	def _duration = End_WS_Hr - DropOffTime
	duration_hours = _duration.hours as Integer
	println "Available hours is: " + duration_hours
	}
//Classify cases 
//Invalid Dealer Code
if (!(GlobalVariable.Glb_Dealer_Code == "765A")) {
	println "Invalid Dealer Code"
	VerifyResponse(res_GetPickupTime,0,"Authorization has been denied for this request")
}
//Duration = 0
else if(Duration <= 0){
	println "Duration = 0"
	VerifyResponse(res_GetPickupTime, 0, "duration must be greater than 0")
	}
//Invalid Service bay
else if(!(GlobalVariable.Glb_ServiceBay_Type == "PERIODIC"||
	GlobalVariable.Glb_ServiceBay_Type == "EXPRESS"||
	GlobalVariable.Glb_ServiceBay_Type == "REPAIR"||
	GlobalVariable.Glb_ServiceBay_Type == "DIAGNOSTIC")){
	println "Invalid Service bay"
	VerifyResponse(res_GetPickupTime,0,"Service Bay Type is unknown")
	}
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
		GlobalVariable.Glb_Location_Code == "3"||
		GlobalVariable.Glb_Location_Code == "5"){
		println "Closed Workshop"
	VerifyResponse(res_GetPickupTime,0,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
}
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	GlobalVariable.Glb_Location_Code == "4"||
	GlobalVariable.Glb_Location_Code == "360")){
	println "Not exist Workshop"
	VerifyResponse(res_GetPickupTime,0,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
}
//Service Date Past
else if (Service_Date.before(current)){
	println "Service Date Past"
	VerifyResponse(res_GetPickupTime,0,"is before the current date")
	}
//Duration >=10
else if (Duration >= 10){
	println "Duration >=10"
	VerifyResponse(res_GetPickupTime,0,"Duration " +Duration+ " cannot be completed in a single day")
}
//DropOff Time is before Current Hour
else if (DropOffTime.before(current_hour) && GlobalVariable.Glb_ServiceDate == GlobalVariable.Glb_Current_Date){
	println "DropOff Time is before Current Hour"
	VerifyResponse(res_GetPickupTime,0,"Drop Off Time "+ GlobalVariable.Glb_DropOffTime +" do not match values from GetDropOffTimes")
}
//Drop Off time before WS Start, after WS End or need time < expected duration
else if((DropOffTime.before(Start_WS_Hr) || DropOffTime.after(End_WS_Hr) || duration_hours < Duration) &&
	!(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" )){
	println "Drop Off time before WS Start, after WS End or need time < expected duration"
	VerifyResponse(res_GetPickupTime,0,"Drop Off Time "+ GlobalVariable.Glb_DropOffTime +" do not match values from GetDropOffTimes")
}
//All valid
else {
	println "All valid"
	//Verify Response Status = 200 OK
	VerifyResponse(res_GetPickupTime,200,"")
	//Case Saturday, Sunday
	if(Service_Date.format("E")=="Sat" || Service_Date.format("E")=="Sun" ){
		println "Service Date is weekend"
		def res_Text = new groovy.json.JsonSlurper().parseText(res_GetPickupTime.getResponseText())
		assert  res_Text[0] == null
	}
	//Remained Date
	else{
		WS.verifyElementPropertyValue(res_GetPickupTime, '[0].Date', GlobalVariable.Glb_ServiceDate + 'T00:00:00')
		
		//Verify response Times array
		//Create Data Times Array
		
		
		//Create Array for Times
		def times = new String[100]
		def count = 0
		while (!realtime_ws.after(time_close_ws)) {
		    if(!realtime_ws.before(TimeCanPickUp)){
				(times[count]) = ((realtime_ws.format('HH:mm')) as String)
				count = (count + 1)
				}
		    use(groovy.time.TimeCategory, { 
		            realtime_ws = (realtime_ws + Interval.minute)
		        })
		}
		println times
		//Convert JSON data into Array string
		def res_Text = new groovy.json.JsonSlurper().parseText(res_GetPickupTime.getResponseText())
		def timeslotJSON
		println res_Text.Times
		res_Text.Times.each{ timeslotJSON = it}
		
		//Verify number of element between JSON response and slot of WS
		assert timeslotJSON.size == count
		println count
		//Loop Verification
		for (def j = 0; j < count; j++) {
		    WS.verifyElementPropertyValue(res_GetPickupTime, ('[0].Times[' + j) + ']', times[j])
		}
	}
	GlobalVariable.Glb_Status_GetPickupTime = "passed"
}
