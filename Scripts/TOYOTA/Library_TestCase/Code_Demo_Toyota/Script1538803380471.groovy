import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return as array_return

import com.kms.katalon.core.annotation.TearDownIfFailed
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
import java.io.File as File

//RequestObject GetServiceOperation = findTestObject('Toyota/GetDropOffTimes_JSON', [
//	('Start_Date') : "2018-10-08",
//	('End_Date') : "2018-10-08",
//	('ServiceBay_Type') : "PERIODIC",
//	('Duration_Time') : "1",
//	('Dealer_Code') : "765A",
//	('Location_Code') : "1"])
////Set Authorization in Header
//GetServiceOperation.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Basic " + GlobalVariable.Glb_Authorization_Token))
////Send request
//ResponseObject res_GetServiceOperation = WS.sendRequest(GetServiceOperation)
//
//println res_GetServiceOperation.responseText
println(GlobalVariable.Glb_Dealer_Code)
assert 1 ==2

@TearDownIfFailed
public void failed(){
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.write2File'(GlobalVariable.Glb_Dealer_Code as String, "demo")
}


