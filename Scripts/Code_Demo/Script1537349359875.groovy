import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
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

//Get the current Date
def today = new Date()
def day = today.getDate()
def month  =today.getMonth() + 1
def year =today.getYear() + 1900

if (day < 10) day = '0' + day
if (month < 10) month = '0'+month

def current = year + "-"+month+"-"+day
println current

println today.format("YYYY-MM-dd")

//set time for variable
def date = new Date()
int Start = GlobalVariable.Glb_WorkshopStart as Integer
int End = GlobalVariable.Glb_WorkshopEnd as Integer

date.set(hourOfDay: Start, minute:00)
println date.format("HH:mm")
def time_validate = new Date()
time_validate.set(hourOfDay: End-1, minute:45)

//Create dataset for times

while(date.before(time_validate)){
use(groovy.time.TimeCategory) {
	date = date + 15.minute }

println date.format("HH:mm")}
