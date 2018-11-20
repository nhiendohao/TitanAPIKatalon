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
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import groovy.sql.Sql as Sql
import java.sql.Driver as Driver

/**
 * @author ANH THY
 * 1. add sql for customer information
 */
WS.comment(null)

RequestObject SearchServiceVisit = findTestObject('Holden/Holden_06_SearchServiceVisit', [
	('obj_DealerCode') : '111148'            , 
	('obj_StartSearchDate') : '2018-11-19T00:00:00', 
	('obj_EndSearchDate') : '2018-11-20T23:59:59'])
//Declare response
	ResponseObject res_SearchServiceVisit = WS.sendRequest(SearchServiceVisit)
	
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_SearchServiceVisit, 200, "")
		
	//Validate "Sender" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "CreatorNameCode", "GM", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "SenderNameCode", "OSS", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerNumberID", '111148', 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "DealerCountryCode", "US", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Sender", "LanguageCode", "en-US", 0, 0)
		
	//Validate "Destination" of Application Area
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationNameCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DestinationSoftware", "QI", 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerNumberID", '111148', 0, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Destination", "DealerTargetCountry", "US", 0, 0)
	
	//Get locator of expected Node
		int nodeExpectedIndex = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getLocatorValueSOAPNodeforHoldenOSS'(res_SearchServiceVisit, 'ServiceVisit',"DocumentIdentification", "DocumentID", "257730" )
		println nodeExpectedIndex
	//Validate Customer Information
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "dealerManagementSystemIDField", '678656', nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "AppointmentContactParty", "DealerManagementSystemID", '678656', nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "GivenName", "QATEAM_VINHLE181120164145", nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "TelephoneCommunication", "ChannelCode", GlobalVariable.Glb_Cus_ChannelCode, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "URICommunication", "URIID", GlobalVariable.Glb_Cus_Email, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "URICommunication", "ChannelCode", "EMAIL", 0, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "SpecifiedPerson", "ContactMethodTypeCode", "Day Phone", nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "VehicleInfo", "InDistanceMeasure", "5000", nodeExpectedIndex, 0)
//		
//	Validate unitCode = 'mile'
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_SearchServiceVisit, "VehicleInfo", "InDistanceMeasure", "unitCode", "mile", nodeExpectedIndex, 0)
//		
	//Validate Appointment Id
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "DocumentIdentification", "DocumentID", "257730", nodeExpectedIndex*2+1, 0)
	
	//Validate Service Appointment
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "AppointmentDateTime","2018-11-20T20:21:55" , nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "Appointment", "EndAppointmentDateTime", "2018-11-20T20:21:55", nodeExpectedIndex, 0)
		
	//Validate Request Service
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobNumberString", "A", nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "RepeatRepairIndicator", "false", nodeExpectedIndex, 0)
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "JobTypeString", "Customer Pay", nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "ServiceLaborScheduling", "LaborOperationDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, nodeExpectedIndex, 0)
//		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchServiceVisit, "RequestedService", "CustomerSalesRequestDescription", GlobalVariable.Glb_Ser_LaborCode+' - '+GlobalVariable.Glb_Ser_LaborDescription, nodeExpectedIndex, 0)
//		
	

