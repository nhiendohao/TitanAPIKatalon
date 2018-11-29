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

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Print all value before request
println GlobalVariable.Glb_Dealer_Code
//Declare request
	RequestObject IntegrationConfig = findTestObject('Holden/Holden_01_GetIntegrationConfiguration', [
		('obj_DealerId') : GlobalVariable.Glb_Dealer_Code])
//Declare response
	ResponseObject res_IntegrationConfig = WS.sendRequest(IntegrationConfig)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	//Dealer Code invalid
	if(!(GlobalVariable.Glb_Dealer_Code == '299560')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_IntegrationConfig, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	else{
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_IntegrationConfig, 200, "")
	
//Validate "Sender"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Sender", "CreatorNameCode", "GM", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Sender", "SenderNameCode", "OSS", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Sender", "DealerCountryCode", "US", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Sender", "LanguageCode", "en-US", 0, 0)
	
//Validate "Destination"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Destination", "DestinationNameCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Destination", "DestinationSoftware", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "Destination", "DealerTargetCountry", "US", 0, 0)
	
//Validate Action Code
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_IntegrationConfig, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)
	
//Validate Integration Config
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "SyncMode", "ASYNCHRONOUS", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AppointmentsUpdatable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AppointmentCustomerUpdatable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AppointmentVehicleUpdatable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AppointmentsRetrievable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AppointmentsSearchable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "RepairOrderCreatable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "RepairOrderUpdatable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "RepairOrderRetrievable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "CustomerSearchable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "VehicleSearchable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "CustomerInformationSearchable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "AdvisorsRetrievable", "true", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_IntegrationConfig, "IntegrationConfigurationDetail", "LaborOperationCodesRetrievable", "true", 0, 0)
	
	//Set Status Method
	GlobalVariable.Glb_Status_Integration = 'passed'
	}
	