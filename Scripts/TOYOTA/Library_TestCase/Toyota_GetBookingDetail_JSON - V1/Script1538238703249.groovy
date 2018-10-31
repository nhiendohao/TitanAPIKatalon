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

//V0. Get booking detail and verify all of them
//V1. Validate dealer, WS and booking Id
//=========================================================================================

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}
//=========================================================================================

//CODE
//Setup DMSOperationCode base on Service Type
String DMSOperationCode
if(GlobalVariable.Glb_ServiceType == "OSB_SERVICE_TYPE_LOGBOOK") DMSOperationCode = "OSB_SERVICE_TYPE_LOGBOOK"
	else DMSOperationCode = "OSB_SERVICE_TYPE_ADDITIONAL"
	
	println GlobalVariable.Glb_Dealer_Code
	println GlobalVariable.Glb_Location_Code
	println GlobalVariable.Glb_Booking_ID
//Declare request
RequestObject GetBookingDetail = findTestObject('Toyota/GetBookingDetails_JSON', [
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code, 
	('BookingID') : GlobalVariable.Glb_Booking_ID])
//Setup header value
GetBookingDetail.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', 
    ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))
//Declare response
ResponseObject res_GetBookingDetail = WS.sendRequest(GetBookingDetail)

//Classify cases
//Invalid Dealer Code
if (!(GlobalVariable.Glb_Dealer_Code == "765A")){
	println "Invalid Dealer Code"
	VerifyResponse(res_GetBookingDetail,500,"Dealer Code "+GlobalVariable.Glb_Dealer_Code+" has not been setup")
}
//Not exist Location Code
else if(!(GlobalVariable.Glb_Location_Code == "765"||
	GlobalVariable.Glb_Location_Code == "37060"))
VerifyResponse(res_GetBookingDetail,0,"Workshop for TOYOTA make has not been set up")
//Booking ID wrong or booking cancled
else if (GlobalVariable.Glb_Booking_ID == "1901" || GlobalVariable.Glb_BookingStatus == "cancel"){
	println "Booking ID wrong or booking cancled"
	VerifyResponse(res_GetBookingDetail,404,"Booking ID " +GlobalVariable.Glb_Booking_ID+ " not found")
}
//All valid
else{
	println "All valid"
	//Verify Response Status = 200 OK
	VerifyResponse(res_GetBookingDetail,200,"")
	//Verify Booking ID
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'BookingID', GlobalVariable.Glb_Booking_ID)
	
	//Verify Vehicle Information
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Vehicle.VIN', GlobalVariable.Glb_VIN)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Vehicle.RegistrationNumber', GlobalVariable.Glb_REGNumber)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RegistrationState', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Vehicle.CustomerOdometerReading', '20500')
	
	//Verify Repair Order Information
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.TotalPriceQuoted', GlobalVariable.Glb_TotalPrice + '.0000')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.TotalDuration', GlobalVariable.Glb_Duration_Time + '.00')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].Name', DMSOperationCode + ' - Operation Code for Test')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].Description', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].ServiceType', 'OSB_SERVICE_TYPE_ADDITIONAL')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].ServiceCode', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].DMSOperationalCode', DMSOperationCode)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].Duration', '1.00')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].EMFlag', 'false')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].EMDuration', '0.0')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].DealerPrice', '0.0')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].POAFlag', 'false')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'RepairOrder.Services[0].Price', '110.0000')
	
	//Verify Appointment Information
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Appointment.BookingDate', GlobalVariable.Glb_ServiceDate + 'T00:00:00')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Appointment.DropOffTime', GlobalVariable.Glb_DropOffTime)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Appointment.PickUpTime', GlobalVariable.Glb_PickUpTime)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Appointment.XReserveToken', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Appointment.ServiceBayType', 'null')
	
	//Verify Contact Information
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.ToyotaContactID', GlobalVariable.Glb_ContactId)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.FirstName', GlobalVariable.Glb_FirstName)
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.LastName', GlobalVariable.Glb_LastName)
	//WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.PhoneNumber', '0983612137')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.Email', 'QAteam.automation@titandms.com')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.DealerMarketingAllowedFlag', 'false')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.ContactRelationship', 'OSB_CUSTOMER_OWNER')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.AlternativeContactName', 'ANH THY')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Contact.AlternativeContactNumber', '0919011995')
	
	//Verify remained information
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'Comment', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'BookingSource', 'OSB_SOURCE_DEALER_WEBSITE')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'ExpressMaintenanceBookingRequest', 'false')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'TransportOption', 'OSB_TRANSPORT_OPTION_NONE')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'PreferredContactMethod', 'null')
	WS.verifyElementPropertyValue(res_GetBookingDetail, 'ConfirmationMessageByDMS', 'false')
	
	//Set Status
	GlobalVariable.Glb_Status_GetBookingDetail = "passed"
	}
