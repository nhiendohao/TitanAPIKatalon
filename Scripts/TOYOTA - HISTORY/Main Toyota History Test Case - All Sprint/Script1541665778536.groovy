import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array
import java.lang.reflect.Field
import java.nio.charset.CoderMalfunctionError
import java.security.AccessControlContext
import static org.assertj.core.api.Assertions.*
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.array_return
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.value_return
import org.sikuli.api.API
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownIfError
import com.kms.katalon.core.annotation.TearDownIfFailed
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
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 * V0. Build framework 10.10.18
 * V1. Add before and after 
 */
//Initial Declare GlobalVariable value
//Setup
GlobalVariable.Glb_His_Status_ROPost = 'failed'
GlobalVariable.Glb_His_Status_ROPut = 'failed'
GlobalVariable.Glb_His_Status_InvoicePost = 'failed'
GlobalVariable.Glb_His_Status_InvoiceCredit = 'failed'
GlobalVariable.Glb_His_Status_ROTracker = 'failed'
GlobalVariable.Glb_His_Status_ROAttachment = 'failed'
GlobalVariable.Glb_BookingStatus = 'not yet'

//STEP
//0. Setup Global Variable and other value
WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History00_SetupMethod.Variables'), [
	('Setup_ROStatus') : var_ROStatus,
	('Setup_FirstName') : var_FirstName,
	('Setup_LastName') : var_LastName,
	('Setup_ServiceDate') : var_ServiceDate,
	('Setup_BookingId') : var_BookingId,
	('Setup_REGNumber') : var_REGNumber,
	('Setup_REGState') : var_REGState,
	('Setup_Mileage') : var_Mileage,
	('Setup_tmcaDealerCode') : var_tmcaDealerCode,
	('Setup_DealerName') : var_DealerName,
	('Setup_tmcaBranchCode') : var_tmcaBranchCode,
	('Setup_BranchName') : var_BranchName,
	('Setup_DMS') : var_DMS,
	('Setup_ContactId') : var_ContactId,
	('Setup_MobileNumber') : var_MobileNumber,
	('Setup_jobNumber') : var_jobNumber,
	('Setup_jobCategory') : var_jobCategory,
	('Setup_jobServiceType') : var_jobServiceType,
	('Setup_CodeType') : var_CodeType,
	('Setup_jobCode') : var_jobCode,
	('Setup_Description') : var_jobDescription,
	('Setup_VIN') : var_VIN,
	('Setup_invoiceType') : var_InvoiceType,
	('Setup_invoiceNumber') : var_InvoiceNumber],
FailureHandling.STOP_ON_FAILURE)

//1. Repair Order Post
if(var_Status_ROPost == 'true')
	WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History01_RepairOrderPost'), [:], FailureHandling.STOP_ON_FAILURE)

//2. Repair Order Tracker
if(var_Status_ROTracker == 'true')
	WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History02_RepairOrderTracker'), [
		('var_Entry') : var_Entry,
		('var_staffName') : var_staffName,
		('var_timeTracker') : var_timeTracker],
	FailureHandling.STOP_ON_FAILURE)
	
//3. Repair Order Put
if(var_Status_ROPut == 'true')
	WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History05_RepairOrderPut'), [:], FailureHandling.STOP_ON_FAILURE)
	
//4. Invoice Post
if(var_Status_InvoicePost == 'true')
	WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History03_InvoicePost'), [:], FailureHandling.STOP_ON_FAILURE)
	
//5. Invoice Credit
if(var_Status_InvoiceCredit == 'true')
	WebUI.callTestCase(findTestCase('TOYOTA - HISTORY/Lib_Testcase/Toyota_History04_InvoiceCredit'), [:], FailureHandling.STOP_ON_FAILURE)
	
//6. Search Service Visit

@TearDownIfError
public void printLineError(){
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.write2File'(var_LineNumber as String, "Error")
}

@TearDownIfFailed
public void printLineFailed(){
	CustomKeywords.'qaVinhLe.Library_Method_VinhLe.write2File'(var_LineNumber as String, "Failed")
}
	
@TearDown
public void HandleFailing(){
	//Handle GetOperationCode for case all = TRUE
	if(var_Status_ROPost == 'true'
		&& var_Status_ROTracker == 'true'
		&& var_Status_ROPut == 'true'
		&& var_Status_InvoicePost == 'true'
		&& var_Status_InvoiceCredit == 'true'){
		if(!(GlobalVariable.Glb_His_Status_ROPost == "passed"))	println "Test Case ROPost: FAILED"
			else{
				println "Test Case ROPost: PASSED"
				if(GlobalVariable.Glb_His_Status_ROTracker == "passed") {
					println "Test Case ROTracker: PASSED"
					if(GlobalVariable.Glb_His_Status_ROPut == "passed"){
						println "Test Case ROPut: PASSED"
						if(GlobalVariable.Glb_His_Status_InvoicePost== "passed"){
							println "Test Case InvoicePost: PASSED"
							if(GlobalVariable.Glb_His_Status_InvoiceCredit== "passed"){
								println "Test Case InvoiceCredit: PASSED"
							}
						}
					}
				}
			}
		}
	}
		