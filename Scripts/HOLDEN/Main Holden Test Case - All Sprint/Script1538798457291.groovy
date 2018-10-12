import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import java.lang.reflect.Field
import java.nio.charset.CoderMalfunctionError
import java.security.AccessControlContext
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return
import org.sikuli.api.API
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
import com.sun.jna.platform.win32.WinNT.ACCESS_ACEStructure
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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

/**
 * V0. Build framework 12.10.18
 */
//Initial Declare GlobalVariable value


//STEP
//0. Setup Global Variable and other value
WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_00_Setup_Method_And_Variables'), [
	('Setup_Dealer_Code') : var_DealerCode ,
	('Setup_FirstName') : var_FirstName,
	('Setup_LastName') : var_LastName,
	('Setup_AddJobLine') : var_AddJobLine,
	('Setup_BookingId') : var_BookingId,
	('Setup_CustomerType') : var_CustomerType,
	('Setup_TradingEntityId') : var_TradingEntityID,
	('Setup_LineOne') : var_LineOne,
	('Setup_CityName') : var_CityName,
	('Setup_CountryID') : var_CountryID,
	('Setup_Postcode') : var_Postcode,
	('Setup_State') : var_State,
	('Setup_ChannelCode') : var_ChannelCode,
	('Setup_PhoneNumber') : var_PhoneNumber,
	('Setup_Email') : var_Email,
	('Setup_Model') : var_Model,
	('Setup_ModelYear') : var_ModelYear,
	('Setup_MakeString') : var_MakeString,
	('Setup_ManufacturerName') : var_ManufacturerName,
	('Setup_VehicleID') : var_VehicleID,
	('Setup_StartSearchDate') : var_StartSearchDate,
	('Setup_EndSearchDate') : var_EndSearchDate],
	FailureHandling.STOP_ON_FAILURE)

//1. Get Integration
//Verify the authentification of OSS to integrate with DMS
if(var_Status_GetIntegration == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_01_GetIntegrationConfiguration'), [:], FailureHandling.STOP_ON_FAILURE)

//2. Get Customer Information
//Get information and validate them
if(var_Status_GetCustomer == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_02_SearchCustomerInformation'), [:], FailureHandling.STOP_ON_FAILURE)
	
//3. Get Personel
//Get all Advisor and vrify all of them
if(var_Status_GetPersonel == 'true')
	WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_03_GetPersonel'), [:], FailureHandling.STOP_ON_FAILURE)



