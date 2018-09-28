import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
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


def SetDate = {Date current_time ,int number_month, int number_day ->
	use(groovy.time.TimeCategory) {
	  def Expected_Date = current_time + number_day.day + number_month.month
	  Expected_Date.format("YYYY-MM-dd")
   }
}

def today = new Date()
def current_date = today.format("YYYY-MM-dd")
GlobalVariable.Glb_Current_Date = current_date

//Set up value Past/Current/Future for Service Date

	GlobalVariable.Glb_ServiceDate = current_date
println GlobalVariable.Glb_ServiceDate
	GlobalVariable.Glb_ServiceDate = SetDate(today,0,-1)
println GlobalVariable.Glb_ServiceDate
	GlobalVariable.Glb_ServiceDate = SetDate(today,0,1)
println GlobalVariable.Glb_ServiceDate