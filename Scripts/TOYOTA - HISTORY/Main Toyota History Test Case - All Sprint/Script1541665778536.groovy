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
//Dataline
println var_LineNumber
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
	('Setup_VIN') : var_VIN],
FailureHandling.STOP_ON_FAILURE)

//1. Get Integration
//Verify the authentification of OSS to integrate with DMS
if(var_Status_GetIntegration == 'true')
	

//2. Get Customer Information
//Get information and validate them
if(var_Status_GetCustomer == 'true')
	
	
//3. Get Personel
//Get all Advisor and vrify all of them
if(var_Status_GetPersonel == 'true')
	
	
//4. Get Labor Operation Code
//Get all Labor Op Code and vrify all of them
if(var_Status_GetLaborCode == 'true')
	
	
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceAdd == 'true')
	
	
//6. Search Service Visit
//Search there has any appointment in range of day
if(var_Status_ProcessServiceAdd == 'true')
	
	
//7. Get Service Visit
//Get all information about the service with specific Booking Id
if(var_Status_ProcessServiceAdd == 'true')
	
	
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceChange == 'true'){
	
	
	}
		
//5. Process service Add action
//Create Appointment
if(var_Status_ProcessServiceDelete == 'true')
	
	
@TearDown
public void HandleFailing(){
	//Handle GetOperationCode for case all = TRUE
	if(var_Status_OpCode == 'true'
		&& var_Status_GetIntegration == 'true'
		&& var_Status_GetCustomer == 'true'
		&& var_Status_GetPersonel == 'true'
		&& var_Status_GetLaborCode == 'true'
		&& var_Status_ProcessServiceAdd == 'true'
		&& var_Status_ProcessServiceChange == 'true'
		&& var_Status_ProcessServiceDelete == 'true'
		&& var_Status_SearchService == 'true'
		&& var_Status_GetService == 'true'){
		if(!(GlobalVariable.Glb_Status_Integration == "passed"))	println "Test Case GetOperationCode: FAILED"
			else{
				println "Test Case GetIntegration: PASSED"
				if(GlobalVariable.Glb_Status_GetCustomer == "passed") {
					println "Test Case GetCustomer: PASSED"
					if(GlobalVariable.Glb_Status_GetAdvisor == "passed"){
						println "Test Case GetAdvisor: PASSED"
						if(GlobalVariable.Glb_Status_GetLabor== "passed"){
							println "Test Case GetLaborCode: PASSED"
							if(GlobalVariable.Glb_Status_ProcessAdd== "passed"){
								println "Test Case ProcessServiceAdd: PASSED"
								if(GlobalVariable.Glb_Status_SearchService== "passed"){
									println "Test Case SearchService: PASSED"
									if(GlobalVariable.Glb_Status_GetService== "passed"){
										println "Test Case GetService: PASSED"
										if(GlobalVariable.Glb_Status_ProcessChange== "passed"){
											println "Test Case ProcessServiceChange: PASSED"
											if(GlobalVariable.Glb_Status_ProcessDelete== "passed"){
												println "Test Case ProcessServiceDelete: PASSED"
											}
										}
									}
								}
							}
						}
					}
				}
			}
	}
}
		