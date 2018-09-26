import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
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
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

//V0. Check timeslot for 1 day
//V1. Check timeslot for more days from TODAY. Check for Saturday and Sunday
//Get the current Date
//V2. Check the number of drop off list == expected timeslot.
Start_Date = GlobalVariable.Glb_ServiceDate
def Start_Date_Str = Date.parse("yyyy-MM-dd", Start_Date) as Date
def End_Date_Str = Date.parse("yyyy-MM-dd", End_Date) as Date

// load test request object which will use token above in Authorization
RequestObject mainrequest = findTestObject('Toyota/GetDropOffTimes_JSON', [('Start_Date') : Start_Date, ('End_Date') : End_Date
		, ('ServiceBay_Type') : GlobalVariable.Glb_ServiceBay_Type,('Duration_Time') : GlobalVariable.Glb_Duration_Time,('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, ('Location_Code') : GlobalVariable.Glb_Location_Code])
mainrequest.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))
ResponseObject response = WS.sendRequest(mainrequest)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(response, 200)

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
WS.verifyElementPropertyValue(response, "["+i+"].Date", Start_Date + "T00:00:00")
//Verify response Times array
//Create Data Times Array
//Create real time variable
def realtime_ws = new Date()
//Declare Time Workshop Open and Time WS Close
int Start = GlobalVariable.Glb_WorkshopStart as Integer
int End = GlobalVariable.Glb_WorkshopEnd as Integer
//Declare Interval for Timeslots and Duration for Service
int Interval = GlobalVariable.Glb_Interval as Integer
int Duration = GlobalVariable.Glb_Duration_Time as Integer
//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start, minute:00)
println realtime_ws.format("HH:mm")
//Set Time WS Close
def time_close_ws = new Date()
time_close_ws.set(hourOfDay: End - Duration, minute: 00)

//Create Array for Times
def times = new String[100]
def count = 0
while(realtime_ws.before(time_close_ws)){
	times[count]=realtime_ws.format("HH:mm") as String
	count=count +1
	use(groovy.time.TimeCategory){
	realtime_ws = realtime_ws + Interval.minute }
}

//Handle for unavailable timeslot
if(!(Reserve_Timeslot == "")){
	times = times - Reserve_Timeslot
	count = count - 1
}
println times

//Convert JSON data into Array string
def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
def timeslotJSON
res_Text.Times.each{ timeslotJSON = it}

//Verify number of element between JSON response and slot of WS
assert timeslotJSON.size == count
//Loop Verification
//for(def j  = 0;j<count;j++) WS.verifyElementPropertyValue(response, "["+i+"].Times["+j+"]", times[j])

//Set to nextday
use(groovy.time.TimeCategory) {
	Start_Date_Str = Start_Date_Str + 1.day}
	Start_Date = Start_Date_Str.format("yyyy-MM-dd") as String
	}
}

