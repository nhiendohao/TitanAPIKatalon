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
import com.sun.jna.StringArray as StringArray
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static org.assertj.core.api.Assertions.*
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Setup_Method_And_Variables - V1'), [
	('Setup_Interval') : '15', 
	('Setup_WorkshopStart') : '8'        , 
	('Setup_WorkshopEnd') : '17', 
	('Setup_Duration') : '1', 
	('Setup_Dealer_Code') : '764A', 
	('Setup_Location_Code') : '1'        , 
	('Setup_VIN') : 'VNVNVNVNVNVNVNVNV', 
	('Setup_REGNumber') : 'REG_TITAN_API', 
	('Setup_ServiceDate') : '', 
	('Setup_DropOffTime') : '08:00'        , 
	('Setup_PickUpTime') : '17:00', 
	('Setup_TotalPrice') : '', 
	('Setup_TotalDuration') : '', 
	('Setup_FirstName') : 'TITAN'        , 
	('Setup_LastName') : 'DMS',
	 ('Setup_StartDropDate') : '', 
	 ('Setup_EndDropDate') : '',
	  ('Setup_StartSearchDate') : ''        , 
	  ('Setup_EndSearchDate') : '', 
		('Setup_BookingId') : '', 
		('Setup_ServiceType') : 'OSB_SERVICE_TYPE_ADDITIONAL'], 
    FailureHandling.STOP_ON_FAILURE)

