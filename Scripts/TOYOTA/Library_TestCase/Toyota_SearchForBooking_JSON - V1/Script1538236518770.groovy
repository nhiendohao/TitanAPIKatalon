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

//V0. Verify response JSON
//V1. Validate dealer, WS, Start after End Date
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
println GlobalVariable.Glb_Dealer_Code
println GlobalVariable.Glb_Location_Code
println GlobalVariable.Glb_StartSearchDate
println GlobalVariable.Glb_EndSearchDate
println GlobalVariable.Glb_REGNumber
//Declare request
RequestObject SearchForBooking = findTestObject('Toyota/SearchForBooking_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('StartSearchDate') : GlobalVariable.Glb_StartSearchDate            , 
	('EndSearchDate') : GlobalVariable.Glb_EndSearchDate            , 
	('REGNumber') : GlobalVariable.Glb_REGNumber])
//Set header value
SearchForBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + 
    GlobalVariable.Glb_Authorization_Token))
//Declare response
ResponseObject res_SearchForBooking = WS.sendRequest(SearchForBooking)

//Convert String to Date
def StartSearchDate = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_StartSearchDate) as Date
def EndSearchDate = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_EndSearchDate) as Date
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date

//Classify cases
//Invalid Dealer Code
if (!(GlobalVariable.Glb_Dealer_Code == "765A")){
	println "Invalid Dealer Code"
	VerifyResponse(res_SearchForBooking,0,"Authorization has been denied for this request")
}
//Service Date Past
else if (StartSearchDate.after(EndSearchDate)){
	println "Service Date Past"
	VerifyResponse(res_SearchForBooking,0,"cannot be greater than end date")
}
//Closed Workshop
else if(GlobalVariable.Glb_Location_Code == "2"||
		GlobalVariable.Glb_Location_Code == "3"||
		GlobalVariable.Glb_Location_Code == "5"){
		println "Closed Workshop"
	VerifyResponse(res_SearchForBooking,0,"Workshop "+ GlobalVariable.Glb_Location_Code +" is closed")
}
//Not exist Workshop
else if(!(GlobalVariable.Glb_Location_Code == "1"||
	GlobalVariable.Glb_Location_Code == "4"||
	GlobalVariable.Glb_Location_Code == "360")){
	println "Not exist Workshop"
	VerifyResponse(res_SearchForBooking,0,"Workshop "+ GlobalVariable.Glb_Location_Code + " not found")
}

//All valid
else{
	println "All valid"
	//Verify Response Status = 200 OK
	VerifyResponse(res_SearchForBooking,200,"")
	//Validate Search Date do not include Service Date && validate not exist REGNumber
	if(EndSearchDate.before(Service_Date) || 
		StartSearchDate.after(Service_Date) || 
		!(GlobalVariable.Glb_REGNumber == "REG_TITAN_API") ||
		GlobalVariable.Glb_BookingStatus == "cancel")
	{
		def res_Text = new groovy.json.JsonSlurper().parseText(res_SearchForBooking.getResponseText())
		assert  res_Text[0] == null
	}
	//Validate response content
	else{
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

		}
	//Set Status
	GlobalVariable.Glb_Status_SearchBooking = "passed"
}