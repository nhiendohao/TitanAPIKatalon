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

//V0. Check status code = 200 OK
//V1. Check response []
//Check the Search booking request, Drop Off Time request
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
//=========================================================================================

//CODE
//Declare request
RequestObject CancelBooking = findTestObject('Toyota/CancelBooking_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('BookingID') : GlobalVariable.Glb_Booking_ID])
//Setup header value
CancelBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Declare response
ResponseObject res_CancelBooking = WS.sendRequest(CancelBooking)

//Classify cases
//Invalid Dealer Code
if (!(GlobalVariable.Glb_Dealer_Code == "765A"))
	VerifyResponse(res_CancelBooking,0,"Authorization has been denied for this request")
//Not exist Location Code
else if(!(GlobalVariable.Glb_Location_Code == "765"||
	GlobalVariable.Glb_Location_Code == "37060"))
VerifyResponse(res_CancelBooking,0,"Workshop for TOYOTA make has not been set up")
//Service Date Past
else if (GlobalVariable.Glb_Booking_ID == "1901" || GlobalVariable.Glb_BookingStatus == "cancel" ||GlobalVariable.Glb_Booking_ID == "wrong")
	VerifyResponse(res_CancelBooking,0,"Booking ID " +GlobalVariable.Glb_Booking_ID+ " not found")
//All valid
else{
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(res_CancelBooking, 200)
	//Set Booking Status = "cancel"
	GlobalVariable.Glb_BookingStatus = "cancel"
	println GlobalVariable.Glb_BookingStatus
	
	//Set Status
	GlobalVariable.Glb_Status_CancelBooking = "passed"
	
	//Set StartDrop and EndDrop
	GlobalVariable.Glb_StartDate = GlobalVariable.Glb_ServiceDate
	GlobalVariable.Glb_EndDate = GlobalVariable.Glb_ServiceDate
	//Re-check call Get Off Time again
	WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON - V3'), [
		('Reserve_Timeslot') : ''],
	FailureHandling.STOP_ON_FAILURE)

}
