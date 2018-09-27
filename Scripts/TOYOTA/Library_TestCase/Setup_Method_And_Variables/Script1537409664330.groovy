import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.sql.Time

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

//Set Value for GlobalVariable
GlobalVariable.Glb_Interval = Setup_Interval
GlobalVariable.Glb_WorkshopStart = Setup_WorkshopStart
GlobalVariable.Glb_WorkshopEnd = Setup_WorkshopEnd
GlobalVariable.Glb_Dealer_Code = Setup_Dealer_Code
GlobalVariable.Glb_Location_Code = Setup_Location_Code
GlobalVariable.Glb_VIN = Setup_VIN
GlobalVariable.Glb_REGNumber = Setup_REGNumber
GlobalVariable.Glb_ServiceDate = Setup_ServiceDate

//Set up Service Time
def today = new Date()
def current = today.format("YYYY-MM-dd")
GlobalVariable.Glb_ServiceDate = current