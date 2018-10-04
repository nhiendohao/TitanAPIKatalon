import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import static org.assertj.core.api.Assertions.*
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
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

//Declare request
//RequestObject ChangeBooking = findTestObject('Toyota/ChangeBooking_JSON', [('Dealer_Code') : '765A', ('Location_Code') : '1'
//        , ('BookingID') : '136910', ('Service_Date_Change') : '2018-10-04', ('Drop_Off_Time_Change') : '08:30', ('Pick_Up_Time') : '17:00'
//        , ('ServiceBay_Time') : GlobalVariable.Glb_ServiceBay_Type, ('TotalPrice_Change') : '110', ('TotalDuration_Change') : '1'
//        , ('ContactId') : '123', ('FirstName') : 'le', ('LastName') : 'vinh', ('ServiceType') : GlobalVariable.Glb_ServiceType
//        , ('DMSOperationCode') : 'DMSOperationCode', ('VIN_Change') : 'VINChange', ('REGNumber_Change') : 'REGNumberChange'])
//
////Setup header value
//ChangeBooking.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))
//
////Declare respone
//ResponseObject res_ChangeBooking = WS.sendRequest(ChangeBooking)
//
//WS.verifyResponseStatusCode(res_ChangeBooking, 200)
//
////Verify Booking ID
//WS.verifyElementPropertyValue(res_ChangeBooking, 'BookingID', GlobalVariable.Glb_Booking_ID)
WS.sendRequest(findTestObject('Toyota/ChangeBooking_JSON', [('Dealer_Code') : '765A', ('Location_Code') : '1', ('BookingID') : '136910'
            , ('Service_Date_Change') : '2018-10-04', ('Drop_Off_Time_Change') : '10:30', ('Pick_Up_Time') : '17:00', ('ServiceBay_Time') : 'PERIODIC'
            , ('TotalPrice_Change') : '110', ('TotalDuration_Change') : '1', ('VIN_Change') : 'VINhle', ('REGNumber_Change') : 'REGCHANGE'
            , ('ContactId') : '1901', ('FirstName') : 'TITAN', ('LastName') : 'DMS', ('ServiceType') : 'OSB_SERVICE_TYPE_LOGBOOK'
            , ('DMSOperationCode') : 'TITAN_OP_CODE_LOG']))

WS.delay(0)

try {
}
catch (Exception e) {
    throw new com.kms.katalon.core.exception.StepFailedException()
} 
finally { 
}

