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
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Declare request
	RequestObject GetServiceVisit = findTestObject('Holden/Holden_07_GetServiceVisit', [
	('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code, 
	('obj_BookingId') : GlobalVariable.Glb_Booking_ID])
//Declare response
	ResponseObject res_GetServiceVisit = WS.sendRequest(GetServiceVisit)
	
//## RESPONSE ACCESS
//All negative case
	//Invalid dealer code
	if(!(GlobalVariable.Glb_Dealer_Code == '299560')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_GetServiceVisit, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
	/**
	 * Use If/ If else Statement
	 */
	else{
	//## VALID RESPONSE VERIFICATION
	//Validate Response Status Code
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_GetServiceVisit, 200, "")
	//Validate "Sender" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Sender", "CreatorNameCode", "GM", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Sender", "SenderNameCode", "OSS", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Sender", "DealerCountryCode", "US", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Sender", "LanguageCode", "en-US", 0, 0)
		
	//Validate "Destination" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Destination", "DestinationNameCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Destination", "DestinationSoftware", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Destination", "DealerTargetCountry", "US", 0, 0)
	
	//Validate Customer Information
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "AppointmentContactParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "TelephoneCommunication", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_ChannelCode, 0, 0)
		
		if(GlobalVariable.Glb_VehicleType.toString().toLowerCase() == 'old') CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, 0, 0)
		
		if(GlobalVariable.Glb_VehicleType.toString().toLowerCase() == 'old') CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Vehicle", "VehicleID", GlobalVariable.Glb_veh_VehicleId, 0, 0)
		
	//Validate unitCode = 'mile'
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_GetServiceVisit, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", 0, 0)
		
	//Get Appointment Id
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID, 1, 0)
	
	//Validate Service Appointment
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Appointment", "AppointmentDateTime",GlobalVariable.Glb_ServiceDate , 0, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "Appointment", "EndAppointmentDateTime", GlobalVariable.Glb_ServiceEndDate, 0, 0)
		
	//Validate Request Service 01
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "JobNumberString", "A", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", 0, 0)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()==''){
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
		}
		else{
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
		}
		
	//Validate Request Service 02 (if any)
		if(GlobalVariable.Glb_AddJobLine.toString().toLowerCase() == 'true'){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "JobNumberString", "B", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", 1, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", 1, 0)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()==''){
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
		}
		else{
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			}
		}
	}	
