import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfFailed
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
//Dataline
println var_LineNumber
//0. Set Status for each Sprint
GlobalVariable.Glb_Status_GetOperationCode = "failed"
GlobalVariable.Glb_Status_GetDropOffTime = "failed"
GlobalVariable.Glb_Status_GetPickupTime = "failed"
GlobalVariable.Glb_Status_ReserveTimeslot = "failed"
GlobalVariable.Glb_Status_GetTransportOption = "failed"
GlobalVariable.Glb_Status_MakeServiceBooking = "failed"
GlobalVariable.Glb_Status_SearchBooking = "failed"
GlobalVariable.Glb_Status_GetBookingDetail = "failed"
GlobalVariable.Glb_Status_ChangeBooking = "failed"
GlobalVariable.Glb_Status_CancelBooking = "failed"
GlobalVariable.Glb_Reserve_Token = "no"
GlobalVariable.Glb_BookingStatus = "not yet"
GlobalVariable.Glb_Booking_ID = "wrong"
//1. Setup value for dynamic Global variables
WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Setup_Method_And_Variables - V1 - Dev'), [
	('Setup_Interval') : var_Interval, 
	('Setup_WorkshopStart') : var_WorkshopStart, 
	('Setup_WorkshopEnd') : var_WorkshopEnd, 
	('Setup_Duration') : var_Duration, 
	('Setup_Dealer_Code') : var_Dealer_Code, 
	('Setup_Location_Code') : var_Location_Code, 
	('Setup_VIN') : var_VIN, 
	('Setup_REGNumber') : var_REGNumber, 
	('Setup_ServiceDate') : var_ServiceDate, 
	('Setup_DropOffTime') : var_Drop_Off_Time, 
	('Setup_PickUpTime') : var_PickUpTime,
	('Setup_TotalPrice') : var_TotalPrice, 
	('Setup_TotalDuration') : var_TotalDuration, 
	('Setup_FirstName') : var_FirstName , 
	('Setup_LastName') :var_LastName, 
	('Setup_StartDropDate') : var_StartDropDate, 
	('Setup_EndDropDate') : var_EndDropDate, 
	('Setup_StartSearchDate') : var_StartSearchDate , 
	('Setup_EndSearchDate') : var_EndSearchDate,
	('Setup_BookingId') : var_BookingId,
	('Setup_ServiceType') : var_Service_Type,
	('Setup_ServiceBay_Type') : var_ServiceBay_Type,
	('Setup_AddJobLine') : var_AddJobLine
	], FailureHandling.STOP_ON_FAILURE)

//2. Get Operation Code for customer
if (var_Status_OpCode == 'true') {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetServiceOperation_JSON - V2'), [:], FailureHandling.STOP_ON_FAILURE)
}

//3. Get Drop Off Timeslot for Customer
//Customer will enter Start Date and End Date.
//System will show all available timeslots for Dates from Start to End
//If the timeslot is taken, it will not show on the list
if (var_Status_GetOffTime == 'true') {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON - V3'), [
		('Reserve_Timeslot') : ''], 
        FailureHandling.STOP_ON_FAILURE)
}

//4. Get PickUp Timeslot for Customer
//Customer will enter Service Date and Drop Off times
//System will show all enable timeslots that service can be completed before pick up time
//One pick up time can be chosen by many customer
if (var_Status_PickupTime == 'true') {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetPickUpTimes_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//5. Make a reservation for Drop off timeslot of service.
//If the timeslot is available, 1 reservation token will be return. This number is unique.
if (var_Status_ReservedTimeslot == 'true') {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ReserveTimeslots_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
} else GlobalVariable.Glb_Reserve_Token = "0"

//6. Get information about the Transport Option for Customer
if (var_Status_GetTransport == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetTransportOption_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//7. Make Booking with all required information
if (var_Status_MakeBooking == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
	//Recall again
	WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//8. Get Drop off time and Pickup time and Booking Id from REGNumber
if (var_Status_SearchBooking == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_SearchForBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//9. Get all detail booking service for recheck
if (var_Status_GetBookingDetail == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

//10. Change booking detail
if (var_Status_ChangeBooking == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ChangeBooking_JSON - V1 - Dev'), [
	('var_PriceChange') : var_PriceChange, 
	('var_DurationChange') : var_DurationChange, 
	('var_DropOffChange') : var_DropOffChange, 
	('var_PickUpChange') : var_PickUpChange, 
	('var_DateChange') : var_DateChange], 
    FailureHandling.STOP_ON_FAILURE)
	
	if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == "true"){
		//Reset value for default AddJobLineMethod
		GlobalVariable.Glb_AddJobLine = "false"
		//Call method again to delete Job line
	WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ChangeBooking_JSON - V1 - Dev'), [
	('var_PriceChange') : var_PriceChange,
	('var_DurationChange') : var_DurationChange,
	('var_DropOffChange') : var_DropOffChange,
	('var_PickUpChange') : var_PickUpChange,
	('var_DateChange') : var_DateChange],
	FailureHandling.STOP_ON_FAILURE)
	}
}

//11. Cancel Booking
if (var_Status_CancelBooking == 'true' && !(GlobalVariable.Glb_Reserve_Token == "no")) {
    WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
	//Re-Check call Cancel again
	WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
}

@TearDown
public void HandleFailing(){
	//Handle GetOperationCode for case all = TRUE
	if(var_Status_OpCode == 'true'
		&& var_Status_GetOffTime == 'true'
		&& var_Status_PickupTime == 'true'
		&& var_Status_ReservedTimeslot == 'true'
		&& var_Status_GetTransport == 'true'
		&& var_Status_MakeBooking == 'true'
		&& var_Status_SearchBooking == 'true'
		&& var_Status_GetBookingDetail == 'true'
		&& var_Status_ChangeBooking == 'true'
		&& var_Status_CancelBooking == 'true'){
		if(!(GlobalVariable.Glb_Status_GetOperationCode == "passed"))	println "Test Case GetOperationCode: FAILED"
			else{
				println "Test Case GetOperationCode: PASSED"
				if(GlobalVariable.Glb_Status_GetDropOffTime == "passed"){
					println "Test Case GetDropOffTime: PASSED"
					if(GlobalVariable.Glb_Status_GetPickupTime == "passed"){
						println "Test Case GetPickupTime: PASSED"
						if(GlobalVariable.Glb_Status_ReserveTimeslot == "passed"){
							println "Test Case ReserveTimeslot: PASSED"
							if(GlobalVariable.Glb_Status_GetTransportOption == "passed"){
								println "Test Case GetTransportOption: PASSED"
								if(GlobalVariable.Glb_Status_MakeServiceBooking == "passed"){
									println "Test Case MakeServiceBooking: PASSED"
									if(GlobalVariable.Glb_Status_SearchBooking == "passed"){
										println "Test Case SearchBooking: PASSED"
										if(GlobalVariable.Glb_Status_GetBookingDetail == "passed"){
											println "Test Case GetBookingDetail: PASSED"
											if(GlobalVariable.Glb_Status_ChangeBooking == "passed"){
												println "Test Case ChangeBooking: PASSED"
												if(GlobalVariable.Glb_Status_CancelBooking == "passed"){
													println "Test Case CancelBooking: PASSED"
												}
											}
											else{
												println "Test Case ChangeBooking: FAILED"
												//Cancel Booking to make timeslot available
												WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
											}
										}
										else{
											println "Test Case GetBookingDetail: FAILED"
											//Cancel Booking to make timeslot available
											WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
										}
									}
									else{
										println "Test Case SearchBooking: FAILED"
										//Cancel Booking to make timeslot available
										WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
									}
								}
								else{
									println "Test Case MakeServiceBooking: FAILED"
									//Make Booking
									WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
									//Cancel Booking to make timeslot available
									WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
								}
							}
							else{
								println "Test Case GetTransportOption: FAILED"
								//Make Booking
								WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
								//Cancel Booking to make timeslot available
								WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON - V1'), [:], FailureHandling.STOP_ON_FAILURE)
							}
						}
					}
				}
			}
	
	}
}