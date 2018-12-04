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
	if(!(GlobalVariable.Glb_Dealer_Code == '299560')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_SearchServiceVisit, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
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
	
	//Get locator of expected Node
		int nodeExpectedIndex = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getLocatorValueSOAPNodeforHoldenOSS'(res_SearchServiceVisit, 'ServiceVisit',"DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID )
		
	//Validate Customer Information
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", GlobalVariable.Glb_Cus_TradingEntity, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_State, nodeExpectedIndex, 0)
		
		if(GlobalVariable.Glb_VehicleType.toString().toLowerCase() == 'old') CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, nodeExpectedIndex, 0)
		
		if(GlobalVariable.Glb_VehicleType.toString().toLowerCase() == 'old') CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "VehicleID", GlobalVariable.Glb_veh_VehicleId, nodeExpectedIndex, 0)
		
	//Validate unitCode = 'mile'
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_SearchServiceVisit, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", nodeExpectedIndex, 0)
		
	//Validate Appointment Id
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "DocumentIdentification", "DocumentID", GlobalVariable.Glb_Booking_ID, nodeExpectedIndex*2+1, 0)
	
	//Validate Service Appointment
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AppointmentDateTime",GlobalVariable.Glb_ServiceDate , nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "EndAppointmentDateTime", GlobalVariable.Glb_ServiceEndDate, nodeExpectedIndex, 0)
		if(GlobalVariable.Glb_BookingStatus.toString().toLowerCase() == "cancel") 
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AppointmentStatus", "CANCELLED", nodeExpectedIndex, 0)
		
	//Validate Request Service
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobNumberString", "A", nodeExpectedIndex, 0)
		//CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", nodeExpectedIndex, 0)
		if(GlobalVariable.Glb_Ser_LaborCode.toString().toLowerCase()==''){
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
		}
		else{
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborDescription, 0, 0)
		}
	}