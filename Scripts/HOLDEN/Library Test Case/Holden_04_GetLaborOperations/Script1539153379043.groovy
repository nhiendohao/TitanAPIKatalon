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
 * V0. Build Framework
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Declare request
	RequestObject GetLaborOperations = findTestObject("", null)
//Declare response
	ResponseObject res_GetLaborOperations = WS.sendRequest(GetLaborOperations)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_GetLaborOperations, 200, "")
//Validate "Sender"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Sender", "CreatorNameCode", "GM", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Sender", "SenderNameCode", "OSS", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Sender", "DealerNumberID", GlobalVariable.Glb_Dealer_Code, 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Sender", "DealerCountryCode", "US", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Sender", "LanguageCode", "en-US", 0, 0)
	
//Validate "Destination"
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Destination", "DestinationNameCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Destination", "DestinationSoftwareCode", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Destination", "DestinationSoftware", "QI", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Destination", "DealerNumberID", "111148", 0, 0)
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyValueSOAPNode'(res_GetLaborOperations, "Destination", "DealerTargetCountry", "US", 0, 0)
	
//Get information of all personel
	def listDocId = new String[100]
	def listLaborId = new String[100]
	def listLaborOperationDes = new String[100]
	
	int numberPersonel = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSizeSOAPNode'(res_GetLaborOperations, "LaborOperations")
	for (int i = 0;i<numberPersonel;i++){
		listDocId[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "DocumentIdentification", "DocumentID", i, 0) as String
		listLaborId[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "LaborOperationsDetail", "LaborOperationID", i, 0) as String
		listLaborOperationDes[i] = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "LaborOperationsDetail", "LaborOperationDescription", i, 0) as String
	}

//Code to get data from SQL
	//Declare information
	String sqlUser = GlobalVariable.Glb_sqlUser.toString()
	String sqlPass = GlobalVariable.Glb_sqlPass.toString()
	String sqlURL = GlobalVariable.Glb_sqlURL.toString()
	String sqlQuery = "exec Get_Search_Operation_Code @OperationCode = null, @ModelID = null, @EngineCode = null, @TransmissionCode=null, @Description= null, @Section=null, @OperationClass= null,@CurrentLanguage = 'en',@CodebookSourceCode= 1,  @ExactMatch= true, @DMSMakeCode= 17, @VehicleKey=0"
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
	assert listDocId[countNumber] == row.Operation_Code as String
	assert listLaborId[countNumber] == row.Operation_Code as String
	  assert listLaborOperationDes[countNumber] == row.Description as String
	  countNumber += 1
	  
  }
  sql.close()
  conn.close()