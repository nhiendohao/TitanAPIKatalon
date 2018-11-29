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
//Declare request
	RequestObject GetPersonel = findTestObject('Holden/Holden_03_GetPersonel', [('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code])
//Declare response
	ResponseObject res_GetPersonel = WS.sendRequest(GetPersonel)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	//Dealer Code invalid
	if(!(GlobalVariable.Glb_Dealer_Code == '299560')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(GetPersonel, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
	
	else{
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_GetPersonel, 200, "")
	
//Validate "Sender"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Sender", "CreatorNameCode", "GM", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Sender", "SenderNameCode", "OSS", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Sender", "DealerCountryCode", "US", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Sender", "LanguageCode", "en-US", 0, 0)
	
//Validate "Destination"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Destination", "DestinationNameCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Destination", "DestinationSoftware", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Destination", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetPersonel, "Destination", "DealerTargetCountry", "US", 0, 0)
	
//Get information of all personel
	def listDocId = new String[100]
	def listGivenName = new String[100]
	def listFamilyName = new String[100]
	
	int numberPersonel = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSizeSOAPNode'(res_GetPersonel, "DocumentID")
	for (int i = 0;i<numberPersonel;i++){
		listDocId[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetPersonel, "DocumentIdentification", "DocumentID", i, 0) as String
		//println listDocId[i]
		listGivenName[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetPersonel, "SpecifiedPerson", "GivenName", i, 0) as String
		//println listGivenName[i]
		listFamilyName[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetPersonel, "SpecifiedPerson", "FamilyName", i, 0) as String
		//println listFamilyName[i]
	}

//Code to get data from SQL 
//Declare information
	String currentDate = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getDateFormat'("MM/dd/YYYY") //TerminationDate =currentDate
	String sqlUser = GlobalVariable.Glb_sqlUser.toString()
	String sqlPass = GlobalVariable.Glb_sqlPass.toString()
	String sqlURL = GlobalVariable.Glb_sqlURL.toString()
	String sqlQuery = "exec Get_All_Service_Advisors @TerminationDate= '"+currentDate+"', @FinancialYearKey= 20"
	int sizeSQl = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSQLSize'(sqlUser, sqlPass, sqlURL, sqlQuery)
	
//Assert value
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
	  int countNumber = 0
	//Executive query for database
	//Read data row by row by expression eachRow
	  sql.eachRow(sqlQuery) {row ->
		assert listDocId[countNumber] == row[0] as String
		assert listGivenName[countNumber] == row.First_Name as String
	  	assert listFamilyName[countNumber] == row.Family_Name as String
		  countNumber += 1
		  
	  }
	  sql.close()
	  conn.close()
	
	  //Set Status Method
	  GlobalVariable.Glb_Status_GetAdvisor = 'passed'
	}