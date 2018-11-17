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
  *V0. Create framework 09/10/18
  *V1. Verify response 13/10/18
  *Declare request  14/10/18
  */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Declare request
	RequestObject SearchServiceVisit = findTestObject('Holden/Holden_06_SearchServiceVisit', [
	('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code            , 
	('obj_StartSearchDate') : GlobalVariable.Glb_StartSearchDate, 
	('obj_EndSearchDate') : GlobalVariable.Glb_EndSearchDate])
//Declare response
	ResponseObject res_SearchServiceVisit = WS.sendRequest(SearchServiceVisit)
	
//## RESPONSE ACCESS
//All negative case
	//Invalid dealer code
	if(!(GlobalVariable.Glb_Dealer_Code == '111148')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ProcessServiceVisit, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
	//End Date is before Start Date
	/**
	 * Use If/ If else Statement
	 */
	else{
	//## VALID RESPONSE VERIFICATION
	//Validate Response Status Code
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_SearchServiceVisit, 200, "")
		
		if(GlobalVariable.Glb_BookingStatus.toString().toLowerCase() == 'current'){
	//Validate "Sender" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "CreatorNameCode", "GM", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "SenderNameCode", "OSS", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerCountryCode", "US", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "LanguageCode", "en-US", 0, 0)
		
	//Validate "Destination" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationNameCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftware", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerTargetCountry", "US", 0, 0)
	
	//Validate "Sender" of Acknowledge Service Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "CreatorNameCode", "GM", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "SenderNameCode", "OSS", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerCountryCode", "US", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "LanguageCode", "en-US", 1, 0)
		
	//Validate "Destination" of Acknowledge Service Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationNameCode", "QI", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftware", "QI", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerTargetCountry", "US", 1, 0)
	
	//Validate "actionCode" = Accepted
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_SearchServiceVisit, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)
	
	//Validate Document Id
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_DocumentId, 0, 0)
	
	//Validate Customer Information
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 1)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_LastName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "TelephoneCommunication", "ChannelCode", GlobalVariable.Glb_Cus_ChannelCode, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "URICommunication", "URIID", GlobalVariable.Glb_Cus_Email, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "URICommunication", "ChannelCode", "EMAIL", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "ContactMethodTypeCode", "Day Phone", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "VehicleInfo", "InDistanceMeasure", "5000", 0, 0)
		
	//Validate unitCode = 'mile'
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_SearchServiceVisit, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", 0, 0)
		
	//Validate Appointment Id
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID, 1, 0)
	
	//Validate Service Appointment
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AppointmentNotes", "Please wash car. Thank you.", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AppointmentStatus", "SCHEDULED", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AlternateTransportation", "WAIT_AT_DEALER", 0, 0)
		
	//Validate Request Service
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobNumberString", "A", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationID", "1", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationIdTypeCode", "", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", "", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "CustomerSalesRequestDescription", "", 0, 0)
		
	//Validate Advisor Party
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceAdvisorParty", "PartyID", GlobalVariable.Glb_PartyID, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceAdvisorParty", "DealerManagementSystemID", GlobalVariable.Glb_Adv_Id, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_Adv_FirstName, 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_Adv_LastName, 1, 0)
		}
		else {
			String verifyNotAppointmentReturn = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", 0, 0)
			assert verifyNotAppointmentReturn == null
		}
	}