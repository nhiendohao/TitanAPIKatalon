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
RequestObject SearchForBooking = findTestObject('Toyota/SearchForBooking_JSON', [('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, ('Location_Code') : GlobalVariable.Glb_Location_Code, ('Service_Date') : GlobalVariable.Glb_ServiceDate
            , ('REGNumber') : GlobalVariable.Glb_REGNumber])

SearchForBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))

ResponseObject res_SearchForBooking = WS.sendRequest(SearchForBooking)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_SearchForBooking, 200)

//Verify Booking ID
WS.verifyElementPropertyValue(res_SearchForBooking, '[0].BookingID', GlobalVariable.Glb_Booking_ID)

//Verify REG Number
WS.verifyElementPropertyValue(res_SearchForBooking, '[0].RegistrationNumber', GlobalVariable.Glb_REGNumber)

//Verify Booking Date
WS.verifyElementPropertyValue(res_SearchForBooking, '[0].BookingDate', GlobalVariable.Glb_ServiceDate + "T00:00:00")

//Verify Drop off Time
WS.verifyElementPropertyValue(res_SearchForBooking, '[0].DropOffTime', GlobalVariable.Glb_DropOffTime)

//Verify Pick Up Time
WS.verifyElementPropertyValue(res_SearchForBooking, '[0].PickUpTime', GlobalVariable.Glb_PickUpTime)
