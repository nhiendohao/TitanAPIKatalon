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
if(!(Setup_Interval == "")) GlobalVariable.Glb_Interval = Setup_Interval
if(!(Setup_WorkshopStart == "")) GlobalVariable.Glb_WorkshopStart = Setup_WorkshopStart
if(!(Setup_WorkshopEnd == "")) GlobalVariable.Glb_WorkshopEnd = Setup_WorkshopEnd
if(!(Setup_Dealer_Code == "")) GlobalVariable.Glb_Dealer_Code = Setup_Dealer_Code
if(!(Setup_Location_Code == "")) GlobalVariable.Glb_Location_Code = Setup_Location_Code
if(!(Setup_VIN == "")) GlobalVariable.Glb_VIN = Setup_VIN
if(!(Setup_REGNumber == "")) GlobalVariable.Glb_REGNumber = Setup_REGNumber
if(!(Setup_ServiceDate == "")) GlobalVariable.Glb_ServiceDate = Setup_ServiceDate

//METHOD
//Create Date Past/Future with specific Date from current Date
def SetDate = {Date current_time ,int number ->
	use(groovy.time.TimeCategory) {
	  def Expected_Date = current_time + number.day
	  Expected_Date.format("YYYY-MM-dd")
   }
}

//Create Current Date
def today = new Date()
def current_date = today.format("YYYY-MM-dd")
GlobalVariable.Glb_Current_Date = current_date

//Set up value Past/Current/Future for Service Date
if(GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="cr") 
	GlobalVariable.Glb_ServiceDate = current_date
else if (GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="p") 
	GlobalVariable.Glb_ServiceDate = SetDate(current_date,-1)
else if (GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_ServiceDate = SetDate(current_date,1)

//Set up value Past/Current/Future for Service Date
if(GlobalVariable.Glb_StartDate.toString().toLowerCase() =="cr")
	GlobalVariable.Glb_StartDate = current_date
else if (GlobalVariable.Glb_StartDate.toString().toLowerCase() =="p")
	GlobalVariable.Glb_StartDate = SetDate(current_date,-1)
else if (GlobalVariable.Glb_StartDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_StartDate = SetDate(current_date,1)

//Set up value Past/Current/Future for Service Date
if(GlobalVariable.Glb_EndDate.toString().toLowerCase() =="cr")
	GlobalVariable.Glb_EndDate = current_date
else if (GlobalVariable.Glb_EndDate.toString().toLowerCase() =="p")
	GlobalVariable.Glb_EndDate = SetDate(current_date,-1)
else if (GlobalVariable.Glb_EndDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_EndDate = SetDate(current_date,1)