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

//V0. Check response and get token
//V1. Check reserve timeslot will be unavailable
RequestObject ReserveTimeslot = findTestObject('Toyota/ReserveTimeslots_JSON', [
	('Service_Date') : GlobalVariable.Glb_ServiceDate        , 
	('Duration') : GlobalVariable.Glb_Duration_Time, 
	('Drop_Off_Time') : GlobalVariable.Glb_DropOffTime, 
	('Pick_Up_Time') : GlobalVariable.Glb_PickUpTime        , 
	('ServiceBay_Type') : GlobalVariable.Glb_ServiceBay_Type, 
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code, 
	('Location_Code') : GlobalVariable.Glb_Location_Code])

ReserveTimeslot.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))

ResponseObject res_ReserveTimeslot = WS.sendRequest(ReserveTimeslot)

//Verify Response Status = 200 OK
WS.verifyResponseStatusCode(res_ReserveTimeslot, 200)

//Verify ServiceBay Type
WS.verifyElementPropertyValue(res_ReserveTimeslot, 'ServiceBayType', GlobalVariable.Glb_ServiceBay_Type)

//Verify Action
WS.verifyElementPropertyValue(res_ReserveTimeslot, 'Action', 'HOLD')

//Get Reserve Token
//Transfer response to Text
def res_Text = new groovy.json.JsonSlurper().parseText(res_ReserveTimeslot.getResponseText())

//get the retrieved token
GlobalVariable.Glb_Reserve_Token = res_Text.XReserveToken

if (GlobalVariable.Glb_Reserve_Token == '') {
    println('Error')
} else {
    println(GlobalVariable.Glb_Reserve_Token)
}

WebUI.callTestCase(findTestCase('TOYOTA/Library_TestCase/Toyota_GetDropOffTimes_JSON - V3'), [
	('Start_Date') : GlobalVariable.Glb_ServiceDate, 
	('End_Date') : GlobalVariable.Glb_ServiceDate, 
	('Service_Type') : GlobalVariable.Glb_ServiceBay_Type,
	('Reserve_Timeslot') : GlobalVariable.Glb_DropOffTime], 
FailureHandling.STOP_ON_FAILURE)

