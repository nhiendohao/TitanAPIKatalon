import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

// FIRST STEP
// load test request object which will do the login step and retrieve the token for later usages
RequestObject getTokenTestObject = findTestObject('Toyota/Toyota_Logon')

ResponseObject responseTokenObject = WS.sendRequest(getTokenTestObject)

// suppose that the responseTokenObject.getResponseText() is { accessToken: "xxx", expiredTime: "yyy" }
// use groovy.json.JsonSlurper to parse the text into object
def tokenObject = new groovy.json.JsonSlurper().parseText(responseTokenObject.getResponseText())

// get the retrieved token
token = tokenObject.access_token

// SECOND STEP
// load test request object which will use token above in Authorization
RequestObject mainrequest = findTestObject('Toyota/GetServiceOperations_JSON')

// if getUserInfoTestObject HTTP headers have no Authorization item
mainrequest.getHttpHeaderProperties().add(new TestObjectProperty("Authorization", ConditionType.EQUALS, "Bearer " + token))


response =  WS.sendRequest(mainrequest)
WS.verifyResponseStatusCode(response, 200)
