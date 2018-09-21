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

//
RequestObject MakeServiceBooking = findTestObject('Toyota/MakeServiceBooking_JSON', [('VIN') : GlobalVariable.Glb_VIN, ('REGNumber') : GlobalVariable.Glb_REGNumber
            , ('Service_Date') : GlobalVariable.Glb_ServiceDate, ('Drop_Off_Time') : GlobalVariable.Glb_DropOffTime, ('Pick_Up_Time') : GlobalVariable.Glb_PickUpTime, ('Reserve_Token') : GlobalVariable.Glb_Reserve_Token
            , ('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type,('Dealer_Code') : GlobalVariable.Glb_Dealer_Code
            , ('Location_Code') : GlobalVariable.Glb_Location_Code])

MakeServiceBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))

ResponseObject res_MakeServiceBooking = WS.sendRequest(MakeServiceBooking)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_MakeServiceBooking, 200)

//Get Reserve Token
//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_MakeServiceBooking.getResponseText())
//get the retrieved token
GlobalVariable.Glb_Booking_ID = res_Text.BookingID
if(GlobalVariable.Glb_Reserve_Token == "") println "Error"
else println GlobalVariable.Glb_Booking_ID

