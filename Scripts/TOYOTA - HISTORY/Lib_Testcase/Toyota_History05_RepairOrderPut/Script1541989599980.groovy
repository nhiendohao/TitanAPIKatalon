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
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

/**
 * V0. Create framework 08/11/18
 * Validate for Mandatory field
 * Valiate for pass response
 */

//CODE
//## DECLARE VIABLE

//## PROCESS API
println GlobalVariable.Glb_Booking_ID
println GlobalVariable.Glb_His_ROStatus
println GlobalVariable.Glb_ServiceDate
println GlobalVariable.Glb_VIN
println GlobalVariable.Glb_REGNumber
println GlobalVariable.Glb_His_REGState
println GlobalVariable.Glb_His_mileage
println GlobalVariable.Glb_His_tmcaDealerCode
println GlobalVariable.Glb_His_DealerName
println GlobalVariable.Glb_His_tmcaBranchCode
println GlobalVariable.Glb_His_BranchName
println GlobalVariable.Glb_His_DMS
println GlobalVariable.Glb_ContactId
println GlobalVariable.Glb_FirstName
println GlobalVariable.Glb_LastName
println GlobalVariable.Glb_His_MobileNumber
println GlobalVariable.Glb_His_jobNumber
println GlobalVariable.Glb_His_jobCategory
println GlobalVariable.Glb_His_jobServiceType
println GlobalVariable.Glb_His_CodeType
println GlobalVariable.Glb_His_jobCode
println GlobalVariable.Glb_His_jobDescription

//Declare request
	RequestObject ROPut = findTestObject('Toyota_History/RepairOrderPut_JSON', [
	('obj_ROId') : GlobalVariable.Glb_Booking_ID, 
	('obj_ROStatus') : GlobalVariable.Glb_His_ROStatus, 
	('obj_ServiceDate') : GlobalVariable.Glb_ServiceDate, 
	('obj_VIN') : GlobalVariable.Glb_VIN, 
	('obj_REGNumber') : GlobalVariable.Glb_REGNumber, 
	('obj_REGState') : GlobalVariable.Glb_His_REGState, 
	('obj_mileage') : GlobalVariable.Glb_His_mileage, 
	('obj_tmcaDealerCode') : GlobalVariable.Glb_His_tmcaDealerCode, 
	('obj_DealerName') : GlobalVariable.Glb_His_DealerName, 
	('obj_tmcaBranchCode') : GlobalVariable.Glb_His_tmcaBranchCode, 
	('obj_BranchName') : GlobalVariable.Glb_His_BranchName, 
	('obj_DMS') : GlobalVariable.Glb_His_DMS, 
	('obj_ContactId') : GlobalVariable.Glb_ContactId, 
	('obj_FirstName') : GlobalVariable.Glb_FirstName, 
	('obj_LastName') : GlobalVariable.Glb_LastName, 
	('obj_MobileNumber') : GlobalVariable.Glb_His_MobileNumber, 
	('obj_jobNumber') : GlobalVariable.Glb_His_jobNumber, 
	('obj_jobCategory') : GlobalVariable.Glb_His_jobCategory, 
	('obj_jobServiceType') : GlobalVariable.Glb_His_jobServiceType, 
	('obj_jobCodeType') : GlobalVariable.Glb_His_CodeType, 
	('obj_jobCode') : GlobalVariable.Glb_His_jobCode, 
	('obj_jobStatus') : GlobalVariable.Glb_His_jobDescription])
//Declare response
	ResponseObject res_ROPut = WS.sendRequest(ROPut)
	
//## RESPONSE ACCESS
//All negative case

	/**
	 * Validate for any Mandaroty field is null
	 */
	//Miss Booking Id
	if(GlobalVariable.Glb_Booking_ID == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "repairOrderNumber [null]")
		println "Booking_ID = null"
	}
	//Miss ROStatus
	if(GlobalVariable.Glb_His_ROStatus == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "repairOrderStatus [null]")
		println "ROStatus = null"
	}
	//Miss VIN
	if(GlobalVariable.Glb_VIN == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "VIN [null]")
		println "VIN = null"
	}
	//Miss REGNumber
	if(GlobalVariable.Glb_REGNumber == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "Registration [null]")
		println "REGNumber = null"
	}
	//Miss REGState
	if(GlobalVariable.Glb_His_REGState == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "State [null]")
		println "REGState = null"
	}
	//Miss mileage
	if(GlobalVariable.Glb_His_mileage == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "Milage [null]")
		println "mileage = null"
	}
	//Miss tmcaDealerCode
	if(GlobalVariable.Glb_His_tmcaDealerCode == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "tmcaDealerCode [null]")
		println "tmcaDealerCode = null"
	}
	//Miss DealerName
	if(GlobalVariable.Glb_His_DealerName == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "dealerName [null]")
		println "DealerName = null"
	}
	//Miss tmcaBranchCode
	if(GlobalVariable.Glb_His_tmcaBranchCode == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "tmcaBranchCode [null]")
		println "tmcaBranchCode = null"
	}
	//Miss BranchName
	if(GlobalVariable.Glb_His_BranchName == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "branchName [null]")
		println "BranchName = null"
	}
	//Miss DMS
	if(GlobalVariable.Glb_His_DMS == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "dms [null]")
		println "DMS = null"
	}
	//Miss ContactId
	if(GlobalVariable.Glb_ContactId == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "dmsCustId [null]")
		println "ContactId = null"
	}
	//Miss FirstName
	if(GlobalVariable.Glb_FirstName == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "firstName [null]")
		println "FirstName = null"
	}
	//Miss LastName
	if(GlobalVariable.Glb_LastName == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "lastName [null]")
		println "LastName = null"
	}
	//Miss MobileNumber
	if(GlobalVariable.Glb_His_MobileNumber == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "mobileNumber [null]")
		println "MobileNumber = null"
	}
	//Miss jobNumber
	if(GlobalVariable.Glb_His_jobNumber == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "jobNumber [null]")
		println "jobNumber = null"
	}
	//Miss jobCategory
	if(GlobalVariable.Glb_His_jobCategory == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "category [null]")
		println "jobCategory = null"
	}
	//Miss jobServiceType
	if(GlobalVariable.Glb_His_jobServiceType == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "serviceType [null]")
		println "jobServiceType = null"
	}
	//Miss CodeType
	if(GlobalVariable.Glb_His_CodeType == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "codeType [null]")
		println "CodeType = null"
	}
	//Miss jobCode
	if(GlobalVariable.Glb_His_jobCode == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "code [null]")
		println "jobCode = null"
	}
	//Miss jobStatus
	if(GlobalVariable.Glb_His_jobDescription == ''){
		CustomKeywords.'qaVinhLe.Library_Method_VinhLe.verifyResponseCode_Msg'(res_ROPut, 400, "description [null]")
		println "jobStatus = null"
	}
	
	
	/**
	 * If valid values are populated to mandaroty field, reponse will be started with "id: ..." and response code  = 200OK
	 */
	
	else{
//## VALID RESPONSE VERIFICATION
//Validate Response Status Code
	WS.verifyElementPropertyValue(res_ROPut, "", GlobalVariable.Glb_Booking_ID)	
	}