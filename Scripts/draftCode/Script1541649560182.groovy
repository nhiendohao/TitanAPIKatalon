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

WS.sendRequest(findTestObject('Toyota_History/RepairOrderPut_JSON', [('obj_ROId') : GlobalVariable.Glb_Booking_ID, ('obj_ROStatus') : GlobalVariable.Glb_His_ROStatus
            , ('obj_ServiceDate') : GlobalVariable.Glb_ServiceDate, ('obj_VIN') : GlobalVariable.Glb_VIN, ('obj_REGNumber') : GlobalVariable.Glb_REGNumber
            , ('obj_REGState') : GlobalVariable.Glb_His_REGState, ('obj_mileage') : GlobalVariable.Glb_His_mileage, ('obj_tmcaDealerCode') : GlobalVariable.Glb_His_tmcaDealerCode
            , ('obj_DealerName') : GlobalVariable.Glb_His_DealerName, ('obj_tmcaBranchCode') : GlobalVariable.Glb_His_tmcaBranchCode
            , ('obj_BranchName') : GlobalVariable.Glb_His_BranchName, ('obj_DMS') : GlobalVariable.Glb_His_DMS, ('obj_ContactId') : GlobalVariable.Glb_ContactId
            , ('obj_FirstName') : GlobalVariable.Glb_FirstName, ('obj_LastName') : GlobalVariable.Glb_LastName, ('obj_MobileNumber') : GlobalVariable.Glb_His_MobileNumber
            , ('obj_jobNumber') : GlobalVariable.Glb_His_jobNumber, ('obj_jobCategory') : GlobalVariable.Glb_His_jobCategory
            , ('obj_jobServiceType') : GlobalVariable.Glb_His_jobServiceType, ('obj_jobCodeType') : GlobalVariable.Glb_His_CodeType
            , ('obj_jobCode') : GlobalVariable.Glb_His_jobCode, ('obj_jobStatus') : GlobalVariable.Glb_His_jobDescription]))

