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
	('Setup_Interval') : Interval, 
	('Setup_WorkshopStart') : WorkshopStart, 
	('Setup_WorkshopEnd') : WorkshopEnd, 
	('Setup_Duration') : Duration, 
	('Setup_Dealer_Code') : Dealer_Code, 
	('Setup_Location_Code') : Location_Code,
	('Setup_VIN') : VIN,
	('Setup_REGNumber') : REGNumber], 
    FailureHandling.STOP_ON_FAILURE)

//2. Get Operation Code for customer
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetServiceOperation_JSON'), [
	('Service_Type') : Service_Type], //Set the Type of Service. Ex: OSB_SERVICE_TYPE_LOGBOOK
    FailureHandling.STOP_ON_FAILURE)

//3. Get Drop Off Timeslot for Customer
//Customer will enter Start Date and End Date.
//System will show all available timeslots for Dates from Start to End
//If the timeslot is taken, it will not show on the list
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON'), [
	('Start_Date') : 'Auto Data', 
	('End_Date') : 'Auto Data', 
	('ServiceBay_Type') : ServiceBay_Type], 
	FailureHandling.STOP_ON_FAILURE)

//4. Get PickUp Timeslot for Customer
//Customer will enter Service Date and Drop Off times
//System will show all enable timeslots that service can be completed before pick up time
//One pick up time can be chosen by many customer

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetPickUpTimes_JSON'), [
	('Drop_Off_Time') : Drop_Off_Time], 
	FailureHandling.STOP_ON_FAILURE)

//5. Make a reservation for Drop off timeslot of service.
//If the timeslot is available, 1 reservation token will be return. This number is unique.
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ReserveTimeslots_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//6. Get information about the Transport Option for Customer
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetTransportOption_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//7. Make Booking with all required information
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//8. Get Drop off time and Pickup time and Booking Id from REGNumber
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_SearchForBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//9. Get all detail booking service for recheck
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ChangeBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

//WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

