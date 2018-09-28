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

//V0. Get pick up timeslot and check all slot for any date input, not validate
//V1. Check the number element between JSON and timeslot of WS
//Valiate Service Date, Duration, Drop Off Time and ServiceBay Type

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}

//CODE
// Declare request
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
//Convert String to Date
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date
def DropOffTime = Date.parse("HH:mm", GlobalVariable.Glb_DropOffTime) as Date
//Convert String to Integer
int Duration = GlobalVariable.Glb_Duration_Time as Integer
//Declare Time Workshop Open and Time WS Close
//Convert String to Date
Start_WS_Str = "0" + GlobalVariable.Glb_WorkshopStart + ":00"
def Start_WS_Hr = Date.parse("HH:mm", Start_WS_Str) as Date
End_WS_Str = GlobalVariable.Glb_WorkshopEnd + ":00"
def End_WS_Hr = Date.parse("HH:mm", End_WS_Str) as Date
//Calculate Time avalable for service
int duration_hours
use(groovy.time.TimeCategory) {
	def duration = End_WS_Hr - DropOffTime
	duration_hours = duration.hours as Integer
	println duration_hours
	}
//Validate Negative parameters 
if (!(GlobalVariable.Glb_Dealer_Code == "765A")) 
	VerifyResponse(res_GetPickupTime, duration_hours, End_WS_Str)
else if(!(GlobalVariable.Glb_ServiceBay_Type == "PERIODIC"||
	GlobalVariable.Glb_ServiceBay_Type == "EXPRESS"||
	GlobalVariable.Glb_ServiceBay_Type == "REPAIR"||
	GlobalVariable.Glb_ServiceBay_Type == "DIAGNOSTIC"))
	{VerifyResponse(res_GetPickupTime,400,"Service Bay Type Unknown")
    Duration <= 0
	Duration >= 10
	DropOffTime.before(Start_WS_Hr)
	DropOffTime.after(End_WS_Hr)
	(Service_Date.before(current)) VerifyResponse(res_GetPickupTime,404,"Service Bay Type Unknown")
	duration_hours < Duration }
	else {
//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_GetPickupTime, 200)

WS.verifyElementPropertyValue(res_GetPickupTime, '[0].Date', GlobalVariable.Glb_ServiceDate + 'T00:00:00')

//Verify response Times array
//Create Data Times Array
//Create real time variable
def realtime_ws = new Date()
//
//Declare Time Workshop Open and Time WS Close
int Start = ((GlobalVariable.Glb_WorkshopStart) as Integer)
int End = ((GlobalVariable.Glb_WorkshopEnd) as Integer)

//Declare Interval for Timeslots and Duration for Service
int Interval = ((GlobalVariable.Glb_Interval) as Integer)
int Duration = GlobalVariable.Glb_Duration_Time as Integer
//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start + Duration, minute:00)

println(realtime_ws.format('HH:mm'))

//Set Time WS Close, this time is early 15 minutes
def time_close_ws = new Date()

time_close_ws.set(hourOfDay: End, minute:00)

//Create Array for Times
def times = new String[100]

def count = 0

while (realtime_ws.before(time_close_ws)) {
    (times[count]) = ((realtime_ws.format('HH:mm')) as String)
    count = (count + 1)
    use(groovy.time.TimeCategory, { 
            realtime_ws = (realtime_ws + Interval.minute)
        })
}

//Convert JSON data into Array string
def res_Text = new groovy.json.JsonSlurper().parseText(res_GetPickupTime.getResponseText())
def timeslotJSON
res_Text.Times.each{ timeslotJSON = it}

//Verify number of element between JSON response and slot of WS
assert timeslotJSON.size == count
println count
//Loop Verification
for (def j = 0; j < count; j++) {
    WS.verifyElementPropertyValue(res_GetPickupTime, ('[0].Times[' + j) + ']', times[j])
  }
}
