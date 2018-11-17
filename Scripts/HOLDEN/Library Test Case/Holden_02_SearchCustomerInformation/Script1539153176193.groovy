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
import groovy.sql.Sql
import java.sql.Driver

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
println GlobalVariable.Glb_Dealer_Code
println GlobalVariable.Glb_FirstName
println GlobalVariable.Glb_LastName
//Declare request
	RequestObject SearchCustomerInformation = findTestObject('Holden/Holden_02_SearchCustomerInformation', [
	('obj_DealerId') : GlobalVariable.Glb_Dealer_Code, 
	('obj_GivenName') : GlobalVariable.Glb_FirstName, 
	('obj_FamilyName') : GlobalVariable.Glb_LastName])
//Declare response
	ResponseObject res_SearchCustomerInformation = WS.sendRequest(SearchCustomerInformation)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	//Dealer Code invalid
	if(!(GlobalVariable.Glb_Dealer_Code == '111148')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_SearchCustomerInformation, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
	/**
	 * COnfirm validate Given Name and Family name is null
	 */
	
	else{
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_SearchCustomerInformation, 200, "")
	if(GlobalVariable.Glb_CustomerType.toString().toLowerCase() == 'new')
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "CustomerParty", "DealerManagementSystemID", null, 0, 0)
		else if(GlobalVariable.Glb_CustomerType.toString().toLowerCase() == 'old'){
		//Validate "Sender"
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Sender", "CreatorNameCode", "GM", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Sender", "SenderNameCode", "OSS", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Sender", "DealerCountryCode", "US", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Sender", "LanguageCode", "en-US", 0, 0)
			
		//Validate "Destination"
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Destination", "DestinationNameCode", "QI", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Destination", "DestinationSoftware", "QI", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Destination", "DealerNumberID", "111148", 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Destination", "DealerTargetCountry", "US", 0, 0)
			
		//Validate Action Code
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyAttributeSOAPNode'(res_SearchCustomerInformation, "ResponseCriteria", "ResponseExpression", "actionCode", "Accepted", 0, 0)
			
		//Validate "Customer Information Detail"
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "CustomerParty", "DealerManagementSystemID", GlobalVariable.Glb_Cus_TradingEntity, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "SpecifiedPerson", "GivenName", GlobalVariable.Glb_FirstName, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "SpecifiedPerson", "FamilyName", GlobalVariable.Glb_LastName, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "ResidenceAddress", "LineOne", GlobalVariable.Glb_Cus_LineOne, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "ResidenceAddress", "CityName", GlobalVariable.Glb_Cus_CityName, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "ResidenceAddress", "CountryID", GlobalVariable.Glb_Cus_CountryID, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "ResidenceAddress", "Postcode", GlobalVariable.Glb_Cus_Postcode, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "ResidenceAddress", "StateOrProvinceCountrySub-DivisionID", GlobalVariable.Glb_Cus_State, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "TelephoneCommunication", "ChannelCode", GlobalVariable.Glb_Cus_ChannelCode, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "TelephoneCommunication", "CompleteNumber", GlobalVariable.Glb_Cus_PhoneNumber, 0, 0)
			
		//Validate "Vehicle"
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Vehicle", "Model", GlobalVariable.Glb_veh_Model, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Vehicle", "ModelYear", GlobalVariable.Glb_veh_ModelYear, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Vehicle", "MakeString", GlobalVariable.Glb_veh_MakeString, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Vehicle", "ManufacturerName", GlobalVariable.Glb_veh_ManufacturerName, 0, 0)
			CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_SearchCustomerInformation, "Vehicle", "VehicleID", GlobalVariable.Glb_veh_VehicleId, 0, 0)
			
		/**
		 * Verify customer information in database
		 */
			//SQL
			String sqlUser = GlobalVariable.Glb_sqlUser.toString()
			String sqlPass = GlobalVariable.Glb_sqlPass.toString()
			String sqlURL = GlobalVariable.Glb_sqlURL.toString()
			// Create Driver for connection
			def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
			// Create Object Properties
			def props = new Properties()
			// Setup user and password through Object Properties
			props.setProperty("user", sqlUser)
			props.setProperty("password", sqlPass)
			//Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
			def conn = driver.connect(sqlURL, props)
			def sql = new Sql(conn)
			
			//Query and assert Customer's information
			sql.eachRow("") {row ->
			/**
			 * assert body for Customer
			 */
			}
			
			//Query and assert Vehicle's information
			sql.eachRow("") {row ->
			/**
			 * assert body for Vehicle
			 */
			}
			
		//Set Status Method
			GlobalVariable.Glb_Status_GetCustomer = 'passed'
		}
	}