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
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

/**
 * V0. Create framework 08/11/18
 * Validate for Mandatory field
 * Valiate for pass response
 */

//CODE
//## DECLARE VIABLE
Date today = new Date()
String currentTime = ''
if(var_timeTracker.toString().toUpperCase()=='R') currentTime = today.format("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	else if(var_timeTracker.toString().toUpperCase()=='W') currentTime = "WRONG FORMAT TIME"
	
//## PROCESS API
println var_Entry
println currentTime
println var_staffName
println GlobalVariable.Glb_Booking_ID

//Declare request
	RequestObject ROTracker = findTestObject('Toyota_History/RepairOrderTrackerPost_JSON', [
	('obj_Entry') : var_Entry, 
	('obj_Date') : currentTime, 
	('obj_staffName') : var_staffName, 
	('obj_ROId') : GlobalVariable.Glb_Booking_ID])
//Declare response
	ResponseObject res_ROTracker = WS.sendRequest(ROTracker)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Validate for any Mandaroty field is null
	 */
	//Wrong time format
	if(currentTime == 'WRONG FORMAT TIME')
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROTracker, 400, "Expected Format yyyy-MM-dd'T'HH:mm:ss.SSS'Z': Unparseable date")
	else {
		//Miss Entry
		if(var_Entry.toString() == ''){
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROTracker, 400, "entry [null]")
			println "Entry = null"
		}
		//Miss ROStatus
		if(var_staffName.toString() == ''){
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROTracker, 400, "name [null]")
			println "ROStatus = null"
		}
		
		/**
		 * If valid values are populated to mandaroty field, reponse will be started with "id: ..." and response code  = 200OK
		 */
		
		else{
	//## VALID RESPONSE VERIFICATION
	//Validate Response Status Code
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROTracker, 200, "id")
		GlobalVariable.Glb_His_Status_ROTracker = 'passed'
		}
	}