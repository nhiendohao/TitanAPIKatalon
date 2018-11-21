import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.sql.SQLClientInfoException
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
import groovy.sql.Sql
import java.sql.Driver

//Set Value for GlobalVariable
if(!(Setup_BookingId == "Null")) GlobalVariable.Glb_Booking_ID = Setup_BookingId
println GlobalVariable.Glb_Booking_ID
if(!(Setup_ROStatus == "Null")) GlobalVariable.Glb_His_ROStatus = Setup_ROStatus
println GlobalVariable.Glb_His_ROStatus
if(!(Setup_VIN == "Null")) GlobalVariable.Glb_VIN = Setup_VIN
println GlobalVariable.Glb_VIN
if(!(Setup_LastName == "Null")) GlobalVariable.Glb_LastName = Setup_LastName
println GlobalVariable.Glb_LastName
if(!(Setup_FirstName == "Null")) GlobalVariable.Glb_FirstName = Setup_FirstName
println GlobalVariable.Glb_FirstName
if(!(Setup_REGNumber == "Null")) GlobalVariable.Glb_REGNumber = Setup_REGNumber
println GlobalVariable.Glb_REGNumber
if(!(Setup_REGState == "Null")) GlobalVariable.Glb_His_REGState = Setup_REGState
println GlobalVariable.Glb_His_REGState
if(!(Setup_Mileage == "Null")) GlobalVariable.Glb_His_mileage = Setup_Mileage
println GlobalVariable.Glb_His_mileage
if(!(Setup_tmcaDealerCode == "Null")) GlobalVariable.Glb_His_tmcaDealerCode = Setup_tmcaDealerCode
println GlobalVariable.Glb_His_tmcaDealerCode
if(!(Setup_tmcaBranchCode == "Null")) GlobalVariable.Glb_His_tmcaBranchCode = Setup_tmcaBranchCode
println GlobalVariable.Glb_His_tmcaBranchCode
if(!(Setup_DealerName == "Null")) GlobalVariable.Glb_His_DealerName = Setup_DealerName
println GlobalVariable.Glb_His_DealerName
if(!(Setup_BranchName == "Null")) GlobalVariable.Glb_His_BranchName = Setup_BranchName
println GlobalVariable.Glb_His_BranchName
if(!(Setup_DMS == "Null")) GlobalVariable.Glb_His_DMS = Setup_DMS
println GlobalVariable.Glb_His_DMS
if(!(Setup_ContactId == "Null")) GlobalVariable.Glb_ContactId = Setup_ContactId
println GlobalVariable.Glb_ContactId
if(!(Setup_MobileNumber == "Null")) GlobalVariable.Glb_His_MobileNumber = Setup_MobileNumber
println GlobalVariable.Glb_His_MobileNumber
if(!(Setup_jobNumber == "Null")) GlobalVariable.Glb_His_jobNumber = Setup_jobNumber
println GlobalVariable.Glb_His_jobNumber
if(!(Setup_jobCategory == "Null")) GlobalVariable.Glb_His_jobCategory = Setup_jobCategory
println GlobalVariable.Glb_His_jobCategory
if(!(Setup_jobServiceType == "Null")) GlobalVariable.Glb_His_jobServiceType = Setup_jobServiceType
println GlobalVariable.Glb_His_jobServiceType
if(!(Setup_CodeType == "Null")) GlobalVariable.Glb_His_CodeType = Setup_CodeType
println GlobalVariable.Glb_His_CodeType
if(!(Setup_jobCode == "Null")) GlobalVariable.Glb_His_jobCode = Setup_jobCode
println GlobalVariable.Glb_His_jobCode
if(!(Setup_Description == "Null")) GlobalVariable.Glb_His_jobDescription = Setup_Description
println GlobalVariable.Glb_His_jobDescription

//METHOD
//Create Date Past/Future with specific Date from current Date
def SetDate = {Date current_time ,int number_month, int number_day, int number_hour, String format_date ->
	use(groovy.time.TimeCategory) {
	  def Expected_Date = current_time + number_day.day + number_month.month + number_hour.hour
	  Expected_Date.format(format_date)
   }
}
//Create random number
def RandomNumber = {int number ->
	Random random = new Random()
	def number_random = random.nextInt(number)
	println number_random
	return number_random
}

//CODE EXECUTIVE
//Create Current Date & Time
def today = new Date()
//Set current Date
def current_date = today.format("YYYY-MM-dd")
GlobalVariable.Glb_Current_Date = current_date
//Set current Time. AUS is earlier than VN 4 hours
GlobalVariable.Glb_Current_Hour = SetDate(today,0,0,4,"HH:mm")

	
//Set up value Past/Current/Future for ServiceDate
if(GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="cr")
	GlobalVariable.Glb_ServiceDate = current_date
else if (GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="p")
	GlobalVariable.Glb_ServiceDate = SetDate(today,0,-1,0,"YYYY-MM-dd")
else if (GlobalVariable.Glb_ServiceDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_ServiceDate = SetDate(today,0,1,0,"YYYY-MM-dd")

	
//Set up ContactId
	GlobalVariable.Glb_ContactId = "1901" + RandomNumber(999999)
	
	
	
//SQL
	String sqlUser = GlobalVariable.Glb_sqlUser.toString()
	String sqlPass = GlobalVariable.Glb_sqlPass.toString()
	String sqlURL = GlobalVariable.Glb_sqlURL.toString()
	// Create Driver for connection
	def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
	// Create Object Properties
	def props = new Properties()
	// Setup user and password through Object Properties
	props.setProperty("user", sqlUser)
	props.setProperty("password", sqlPass)
	//Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
	def conn = driver.connect(sqlURL, props)
	def sql = new Sql(conn)
	
/**
 * Query SQL
 */
	sql.close()
	conn.close()