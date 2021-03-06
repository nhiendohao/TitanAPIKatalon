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
import toyotaOSB.CommonToyota

import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import static org.assertj.core.api.Assertions.*

//V0. Verify response
//V1. Validate Dealer, WS, Service Date
//Validate Saturday and Sunday
//=========================================================================================

//METHOD
//Verify response
def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
	//Verify Response Status = 200 OK
	if(StatusCode == 0) WS.verifyResponseStatusCodeInRange(response, 400, 404)
	else WS.verifyResponseStatusCode(response, StatusCode)
	
	//Transfer response to Text
	def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
}
//=========================================================================================

//CODE
	CommonToyota comm = new CommonToyota()
//Declare request
RequestObject GetTransportOption = findTestObject('Toyota/GetTransportOptions_JSON', [
	('Service_Date') : GlobalVariable.Glb_ServiceDate, 
	('Dealer_Code') : GlobalVariable.Glb_Dealer_Code            , 
	('Location_Code') : GlobalVariable.Glb_Location_Code])
//Set header value
GetTransportOption.getHttpHeaderProperties().add(new TestObjectProperty('Authorization', ConditionType.EQUALS, 'Basic ' + GlobalVariable.Glb_Authorization_Token))
//Declare response
ResponseObject res_GetTransportOption = WS.sendRequest(GetTransportOption)

//Convert String to Date
def Service_Date = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_ServiceDate) as Date
def current = Date.parse("yyyy-MM-dd", GlobalVariable.Glb_Current_Date) as Date

//Classify cases
//Invalid Dealer Code
if (comm.validateInvalidDealerCode(res_GetTransportOption)){}
//Not exist Location Code
else if(!(GlobalVariable.Glb_Location_Code == "765"||
	GlobalVariable.Glb_Location_Code == "37060"))
VerifyResponse(res_GetTransportOption,0,"Workshop for TOYOTA make has not been set up")
//Service Date Past
else if (Service_Date.before(current)){
	println "Service Date Past"
	VerifyResponse(res_GetTransportOption,0,"is before the current date")
}
//All valid
else{
	println "All valid"
	//Verify Response Status = 200 OK
	VerifyResponse(res_GetTransportOption,200,"")
	//Verify OptionType
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].OptionType', 'OSB_TRANSPORT_OPTION_NONE')
	//Verify OptionAvailabilityFlag
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].OptionAvailabilityFlag', 'true')
	//Verify OptionURL
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].OptionURL', 'null')
	//Verify OptionURLLabel
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].OptionURLLabel', 'null')
	//Verify OptionPrice
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].OptionPrice', '0.0')
	//Verify POAFlag
	WS.verifyElementPropertyValue(res_GetTransportOption, '[0].POAFlag', 'false')
	//Set Status
	GlobalVariable.Glb_Status_GetTransportOption = "passed"
}
