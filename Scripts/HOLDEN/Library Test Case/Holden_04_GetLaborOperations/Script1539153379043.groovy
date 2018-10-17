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
import static com.xlson.groovycsv.CsvParser.parseCsv //Reading CSV
@Grab('com.xlson.groovycsv:groovycsv:1.3') //Reading CSV

/**
 * V0. Create framework 09/10/18
 * V1. Verify response 13/10/18
 * Declare request  14/10/18
 */

//CODE 
//## DECLARE VIABLE

//## PROCESS API
//Declare request
	RequestObject GetLaborOperations = findTestObject('Holden/Holden_04_Get LaborOperations', [
		('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code])
//Declare response
	ResponseObject res_GetLaborOperations = WS.sendRequest(GetLaborOperations)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Use If/ If else Statement
	 */
	if(!(GlobalVariable.Glb_Dealer_Code == '111148')){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_GetLaborOperations, 200, "Dealer "+ GlobalVariable.Glb_Dealer_Code +" Not Authorized")
		println "Dealer Code invalid"
		}
	
	else{
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
			
		
		//Get number of Advisors
			int numberPersonel = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSizeSOAPNode'(res_GetLaborOperations, "LaborOperations")
			
		//CSV
		//Get data from CSV file
		int countCSV = 0
		CSVReader = new File("Data Files/Holden/OperationCodeCSV.csv")
		def csv_content = CSVReader.getText('utf-8')
		 //Convert CSV to text
		def CSVData = parseCsv(csv_content, separator: ',', readFirstLine: false)
		 //Get for each column and Assert with Response
		for (line in CSVData) {
			
			  //Get information of all personel
			  def listDocId = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "DocumentIdentification", "DocumentID", countCSV, 0) as String
			  def listLaborId = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "LaborOperationsDetail", "LaborOperationID", countCSV, 0) as String
			  def listLaborOperationDes = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getValueSOAPNode'(res_GetLaborOperations, "LaborOperationsDetail", "LaborOperationDescription", countCSV, 0) as String
				
			  //Handle something
			  String Operation_Code = line.Operation_Code.toString()
			  if(Operation_Code == '50012' ||
				  Operation_Code == '41024' ||
				  Operation_Code == '91020') Operation_Code = '0' + Operation_Code
			  //Assert value between sql and response
			  assert listDocId == Operation_Code	
			  assert listLaborId == Operation_Code 	
			  assert listLaborOperationDes == line.Description as String
			 
			  //Increase count variable
			  countCSV += 1
			  println countCSV
		  }
		
		//Assert number CSV and response
		assert numberPersonel == countCSV
	}
  