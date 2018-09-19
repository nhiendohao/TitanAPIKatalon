import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.reflect.Array

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

//Create real time variable
def realtime_ws = new Date()
//Declare Time Workshop Open and Time WS Close
int Start = GlobalVariable.Glb_WorkshopStart as Integer
int End = GlobalVariable.Glb_WorkshopEnd as Integer
//Declare Interval for Timeslots
int Interval = GlobalVariable.Glb_Interval as Integer
//Set realtime as Time Workshop Open
realtime_ws.set(hourOfDay: Start, minute:00)
println realtime_ws.format("HH:mm")
//Set Time WS Close, this time is early 15 minutes
def time_close_ws = new Date()
time_close_ws.set(hourOfDay: End-1, minute: 45)

//Create Array for Times
def times = new String[40]
def count = 0
while(realtime_ws.before(time_close_ws)){
use(groovy.time.TimeCategory) {
	realtime_ws = realtime_ws + Interval.minute }
times[count]=realtime_ws.format("HH:mm") as String
count=count +1}
//println date.format("HH:mm")
//for(def i = 0;i<count;i++) println times[i]
println count

