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

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Setup_Method_And_Variables'), [('Setup_Interval') : '15', ('Setup_WorkshopStart') : '8'
        , ('Setup_WorkshopEnd') : '17', ('Setup_Duration') : '1', ('Setup_Dealer_Code') : '764A', ('Setup_Location_Code') : '1'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetServiceOperation_JSON'), [('Service_Type') : 'OSB_SERVICE_TYPE_LOGBOOK'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON'), [('Start_Date') : '', ('End_Date') : ''
        , ('Service_Type') : 'PERIODIC'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetPickUpTimes_JSON'), [('Drop_Off_Time') : '08:00'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ReserveTimeslots_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetTransportOption_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_MakeServiceBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_SearchForBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetBookingDetail_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_ChangeBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_CancelBooking_JSON'), [:], FailureHandling.STOP_ON_FAILURE)

