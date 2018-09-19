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

// FIRST STEP
// load test request object which will do the login step and retrieve the token for later usages
RequestObject getTokenTestObject = findTestObject('Toyota/Toyota_Logon')

ResponseObject responseTokenObject = WS.sendRequest(getTokenTestObject)

// suppose that the responseTokenObject.getResponseText() is { accessToken: "xxx", expiredTime: "yyy" }
// use groovy.json.JsonSlurper to parse the text into object
def tokenObject = new groovy.json.JsonSlurper().parseText(responseTokenObject.getResponseText())

// get the retrieved token
token = tokenObject.access_token

//Set Global viable
 GlobalVariable.Glb_Token = token

// SECOND STEP
//Get the current Date
def today = new Date()
def current = today.format("YYYY-MM-dd")
GlobalVariable.Glb_ServiceDate = current
Start_Date = GlobalVariable.Glb_ServiceDate

End_Date = GlobalVariable.Glb_ServiceDate

// load test request object which will use token above in Authorization
RequestObject mainrequest = findTestObject('Toyota/GetDropOffTimes_JSON', [('Start_Date') : Start_Date, ('End_Date') : End_Date
        , ('ServiceBay_Type') : ServiceBay_Type])

// if getUserInfoTestObject HTTP headers have no Authorization item
mainrequest.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Bearer ' + GlobalVariable.Glb_Token))
ResponseObject response = WS.sendRequest(mainrequest)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, "[0].Date", GlobalVariable.Glb_ServiceDate + "T00:00:00")

//Verify response Times array
//Create Data Times Array
//Create real time variable
def realtime_ws = new Date()
//Declare Time Workshop Open and Time WS Close
int Start = GlobalVariable.Glb_WorkshopStart as Integer
int End = GlobalVariable.Glb_WorkshopEnd as Integer
//Declare Interval for Timeslots
int Interval = GlobalVariable.Glb_Interval as Integer
//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start, minute:00)
println realtime_ws.format("HH:mm")
//Set Time WS Close, this time is early 15 minutes
def time_close_ws = new Date()
time_close_ws.set(hourOfDay: End-1, minute: 45)

//Create Array for Times
def times = new String[40]
def count = 0
while(realtime_ws.before(time_close_ws)){
	times[count]=realtime_ws.format("HH:mm") as String
	count=count +1
	use(groovy.time.TimeCategory) {
	realtime_ws = realtime_ws + Interval.minute }
}
//Loop Verification
for(def j  = 0;j<count;j++) WS.verifyElementPropertyValue(response, "[j].Times[j]", times[j])
