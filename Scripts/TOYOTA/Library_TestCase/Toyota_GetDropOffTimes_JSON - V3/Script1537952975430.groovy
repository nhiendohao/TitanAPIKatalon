import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import static org.assertj.core.api.Assertions.*

import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
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
import toyotaOSB.CommonToyota

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

//V0. Check timeslot for 1 day
//V1. Check timeslot for more days from TODAY. Check for Saturday and Sunday
//Get the current Date
//V2. Check the number of drop off list == expected timeslot.
//V3. Check Status code response when Start Date is after End Date
//Check Status code response when ServiceBay Type is wrong
//Validate Duration
//V4. Validate response = "" when Service Date = Saturday and Sunday
//V5. Validate for Current date, only show timeslot after current HH:mm, next day always show all timeslot

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

//CODE
	CommonToyota comm = new CommonToyota()
//Parse String data to Date type Data
Date current_hour = ConvertObjectToDate(GlobalVariable.Glb_Current_Hour)
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date
def Start_Date_Str = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_StartDate) as Date
String Start_Date = Start_Date_Str.format("yyyy-MM-dd") as String
def End_Date_Str = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_EndDate) as Date
//Declare Time Workshop Open and Time WS Close
int Start = GlobalVariable.Glb_WorkshopStart as Integer
int End = GlobalVariable.Glb_WorkshopEnd as Integer
//Declare Interval for Timeslots and Duration for Service
int Interval = GlobalVariable.Glb_Interval as Integer
int Duration = GlobalVariable.Glb_Duration_Time as Integer
// Declare request with parameter
println GlobalVariable.Glb_StartDate
println GlobalVariable.Glb_EndDate
println GlobalVariable.Glb_ServiceBay_Type
println GlobalVariable.Glb_Duration_Time
println GlobalVariable.Glb_Dealer_Code
println GlobalVariable.Glb_Location_Code
RequestObject GetServiceOperation = findTestObject('Toyota/GetDropOffTimes_JSON', [
	('Start_Date') : GlobalVariable.Glb_StartDate, 
	('End_Date') : GlobalVariable.Glb_EndDate, 
	('ServiceBay_Type') : GlobalVariable.Glb_ServiceBay_Type,
	('Duration_Time') : GlobalVariable.Glb_Duration_Time,
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code])
//Set Authorization in Header
GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))
//Send request
ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)

//Verify Response Status
//Clasify case
//StartDate  after EndDate
if (comm.validateInvalidDealerCode(res_GetServiceOperation)){}
//Start Date after End Date
else if(Start_Date_Str.after(End_Date_Str))
	 VerifyResponse(res_GetServiceOperation,0,"cannot be greater than end date")
//Duration <=0
else if(Duration <= 0)
	 VerifyResponse(res_GetServiceOperation,0,"The duration must be greater than 0")
//Invalid Servicebay
else if(!(GlobalVariable.Glb_ServiceBay_Type == "PERIODIC"||
	 GlobalVariable.Glb_ServiceBay_Type == "EXPRESS"||
	 GlobalVariable.Glb_ServiceBay_Type == "REPAIR"||
	 GlobalVariable.Glb_ServiceBay_Type == "DIAGNOSTIC"))
	 VerifyResponse(res_GetServiceOperation,0,"Service Bay Type is unknown")
 //Not exist Location Code
else if(!(GlobalVariable.Glb_Location_Code == "765"||
	GlobalVariable.Glb_Location_Code == "37060"))
VerifyResponse(res_GetServiceOperation,0,"Workshop for TOYOTA make has not been set up")
//StartDate before Current
else if(Start_Date_Str.before(current))
	VerifyResponse(res_GetServiceOperation,0,"is before the current date")
//Duration >= 10
else if(Duration >= 10)
	 VerifyResponse(res_GetServiceOperation,0,"Duration " +Duration+ " cannot be completed in a single day")
//All valid
else {
	 VerifyResponse(res_GetServiceOperation,200,"")

//Get duration days
int duration_days
use(groovy.time.TimeCategory) {
	def duration = End_Date_Str - Start_Date_Str
	duration_days = duration.days as Integer
	println duration_days
	}

//Check each Date
for (def i=0;i< duration_days+1;i++){
	if(!(Start_Date_Str.format("E")=="Sat" || Start_Date_Str.format("E")=="Sun" )){
//Verify for each date
WS.verifyElementPropertyValue(res_GetServiceOperation, "["+i+"].Date", Start_Date + "T00:00:00")

//Set IsCurrentDate = false
def IsCurrentDate = "false"
//Setup IsCurrentDate = true if isCurrent
if(Start_Date_Str.equals(current)) IsCurrentDate = "true"
def today = new Date()
use(groovy.time.TimeCategory){
	today = today + 4.hour 
}

//Verify response Times array
//Create Data Times Array
//Create real time variable
def realtime_ws = new Date()
//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start, minute:00)
println realtime_ws.format("HH:mm")
//Set Time WS Close
def time_close_ws = new Date()
time_close_ws.set(hourOfDay: End - Duration, minute: 00)

//Create Array for Times
def times = new String[100]
def count = 0
while(!(realtime_ws.after(time_close_ws))){
	//If point is Current Date, dont get the timeslot before current hours
	if(IsCurrentDate == "true"){
		if(realtime_ws.after(today)){
	times[count]=realtime_ws.format("HH:mm") as String
	count=count +1
		}
	} else {
	times[count]=realtime_ws.format("HH:mm") as String
	count=count +1
	}
	//Auto increase timeslot follow the interval
	use(groovy.time.TimeCategory){
	realtime_ws = realtime_ws + Interval.minute }
}

//Handle for unavailable timeslot
if((!(Reserve_Timeslot == ""))&&(Service_Date.equals(Start_Date_Str))){
	times = times - Reserve_Timeslot
	count = count - 1
}
println times

//Convert JSON data into Array string
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetServiceOperation.getResponseText())
def timeslotJSON = 0
println res_Text[i].Times
res_Text[i].Times.each{ timeslotJSON += 1}

//Verify number of element between JSON response and slot of WS
assert timeslotJSON == count
//Loop Verification
for(def j  = 0;j<count;j++) WS.verifyElementPropertyValue(res_GetServiceOperation, "["+i+"].Times["+j+"]", times[j])

//Set to nextday
use(groovy.time.TimeCategory) {
	Start_Date_Str = Start_Date_Str + 1.day}
	Start_Date = Start_Date_Str.format("yyyy-MM-dd") as String
	}
	//Set IsCurrentDate = false
	IsCurrentDate = "false"
  }
	GlobalVariable.Glb_Status_GetDropOffTime = "passed"
	
}
