import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
//This testcase is followed workflow below:
//1. Setup value for dynamic Global variables
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Setup_Method_And_Variables'), [
	('Setup_Interval') : var_Interval, 
	('Setup_WorkshopStart') : var_WorkshopStart, 
	('Setup_WorkshopEnd') : var_WorkshopEnd, 
	('Setup_Duration') : var_Duration, 
	('Setup_Dealer_Code') : var_Dealer_Code, 
	('Setup_Location_Code') : var_Location_Code,
	('Setup_VIN') : var_VIN,
	('Setup_REGNumber') : var_REGNumber], 
    FailureHandling.STOP_ON_FAILURE)

//2. Get Operation Code for customer
if(var_Status_OpCode == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetServiceOperation_JSON'), [
	('Service_Type') : var_Service_Type], //Set the Type of Service. Ex: OSB_SERVICE_TYPE_LOGBOOK
    FailureHandling.STOP_ON_FAILURE)
}

//3. Get Drop Off Timeslot for Customer
//Customer will enter Start Date and End Date.
//System will show all available timeslots for Dates from Start to End
//If the timeslot is taken, it will not show on the list
if(var_Status_GetOffTime == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON'), [
	('Start_Date') : 'Auto Data', 
	('End_Date') : 'Auto Data', 
	('ServiceBay_Type') : var_ServiceBay_Type], 
	FailureHandling.STOP_ON_FAILURE)
}


//4. Get PickUp Timeslot for Customer
//Customer will enter Service Date and Drop Off times
//System will show all enable timeslots that service can be completed before pick up time
//One pick up time can be chosen by many customer
if(var_Status_PickupTime == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetPickUpTimes_JSON'), [
	('Drop_Off_Time') : var_Drop_Off_Time], 
	FailureHandling.STOP_ON_FAILURE)
}

//5. Make a reservation for Drop off timeslot of service.
//If the timeslot is available, 1 reservation token will be return. This number is unique.
if(var_Status_ReservedTimeslot == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ReserveTimeslots_JSON'), [:], FailureHandling.STOP_ON_FAILURE)
}

//6. Get information about the Transport Option for Customer
if(var_Status_GetTransport == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetTransportOption_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//7. Make Booking with all required information
if(var_Status_MakeBooking == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//8. Get Drop off time and Pickup time and Booking Id from REGNumber
if(var_Status_SearchBooking == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_SearchForBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//9. Get all detail booking service for recheck
if(var_Status_GetBookingDetail == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//10. Change booking detail
if(var_Status_ChangeBooking == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ChangeBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//11. Cancel Booking
if(var_Status_CancelBooking == "true"){
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}
