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

// load test request object which will use token above in Authorization
RequestObject GetPickupTime = findTestObject('Toyota/GetPickUpTimes_JSON', [('Service_Date') : GlobalVariable.Glb_ServiceDate, ('Drop_Off_Time') : Drop_Off_Time
            , ('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type, ('Duration_Time') : GlobalVariable.Glb_Duration_Time,('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, ('Location_Code') : GlobalVariable.Glb_Location_Code])
GetPickupTime.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))

ResponseObject res_GetPickupTime = WS.sendRequest(GetPickupTime)

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

//Loop Verification
for (def j = 0; j < count; j++) {
    WS.verifyElementPropertyValue(res_GetPickupTime, ('[0].Times[' + j) + ']', times[j])
}

