import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
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
 * V0. Build Framework
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Declare request
	RequestObject ProcessServiceVisit = findTestObject("", null)
//Declare response
	ResponseObject res_ProcessServiceVisit = WS.sendRequest(ProcessServiceVisit)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ProcessServiceVisit, 200, "")
//Validate "Sender" of Application Area
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "CreatorNameCode", "GM", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "SenderNameCode", "OSS", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "DealerCountryCode", "US", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "LanguageCode", "en-US", 0, 0)
	
//Validate "Destination" of Application Area
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationNameCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationSoftware", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DealerTargetCountry", "US", 0, 0)

//Validate "Sender" of Acknowledge Service Area
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "CreatorNameCode", "GM", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "SenderNameCode", "OSS", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "DealerCountryCode", "US", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Sender", "LanguageCode", "en-US", 1, 0)
	
//Validate "Destination" of Acknowledge Service Area
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationNameCode", "QI", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DestinationSoftware", "QI", 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Destination", "DealerTargetCountry", "US", 1, 0)

//Validate "actionCode" = Accepted
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_ProcessServiceVisit, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)

//Validate Document Id
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_DocumentId, 0, 0)

//Validate Customer Information
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 1)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_LastName, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "TelephoneCommunication", "ChannelCode", GlobalVariable.Glb_Cus_ChannelCode, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "URICommunication", "URIID", GlobalVariable.Glb_Cus_Email, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "URICommunication", "ChannelCode", "EMAIL", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "SpecifiedPerson", "ContactMethodTypeCode", "Day Phone", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "VehicleInfo", "InDistanceMeasure", "5000", 0, 0)
	
//Validate unitCode = 'mile'
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_ProcessServiceVisit, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", 0, 0)
	
//Get Appointment Id
	GlobalVariable.Glb_Booking_ID = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_ProcessServiceVisit, "DocumentIdentification", "DocumentID", 1, 0)

//Validate Service Appointment
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Appointment", "AppointmentNotes", "Please wash car. Thank you.", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Appointment", "AppointmentStatus", "SCHEDULED", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "Appointment", "AlternateTransportation", "WAIT_AT_DEALER", 0, 0)
	
//Validate Request Service
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "RequestedService", "JobNumberString", "A", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ServiceLaborScheduling", "LaborOperationID", "1", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ServiceLaborScheduling", "LaborOperationIdTypeCode", "", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", "", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "RequestedService", "CustomerSalesRequestDescription", "", 0, 0)
	
//Validate Advisor Party
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ServiceAdvisorParty", "PartyID", GlobalVariable.Glb_PartyID, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "ServiceAdvisorParty", "DealerManagementSystemID", GlobalVariable.Glb_Adv_Id, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_Adv_FirstName, 1, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_ProcessServiceVisit, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_Adv_LastName, 1, 0)
	