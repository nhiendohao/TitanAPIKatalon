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
if(!(Setup_Dealer_Code == "")) GlobalVariable.Glb_Dealer_Code = Setup_Dealer_Code
if(!(Setup_FirstName == "")) GlobalVariable.Glb_FirstName = Setup_FirstName
if(!(Setup_LastName == "")) GlobalVariable.Glb_LastName = Setup_LastName
if(!(Setup_StartSearchDate == "")) GlobalVariable.Glb_StartSearchDate = Setup_StartSearchDate
if(!(Setup_EndSearchDate == "")) GlobalVariable.Glb_EndSearchDate = Setup_EndSearchDate
if(!(Setup_CustomerType == "")) GlobalVariable.Glb_CustomerType = Setup_CustomerType

if(Setup_CustomerType.toString().toLowerCase() == "exist"){
	if(!(Setup_AddJobLine == "")) GlobalVariable.Glb_AddJobLine = Setup_AddJobLine
	println GlobalVariable.Glb_AddJobLine
	if(!(Setup_BookingId == "")) GlobalVariable.Glb_Booking_ID = Setup_BookingId
	println GlobalVariable.Glb_Booking_ID
	if(!(Setup_TradingEntityId == "")) GlobalVariable.Glb_Cus_TradingEntity = Setup_TradingEntityId
	println GlobalVariable.Glb_Cus_TradingEntity
	if(!(Setup_LineOne == "")) GlobalVariable.Glb_Cus_LineOne = Setup_LineOne
	println GlobalVariable.Glb_Cus_LineOne
	if(!(Setup_CityName == "")) GlobalVariable.Glb_Cus_CityName = Setup_CityName
	println GlobalVariable.Glb_Cus_CityName
	if(!(Setup_CountryID == "")) GlobalVariable.Glb_Cus_CountryID = Setup_CountryID
	println GlobalVariable.Glb_Cus_CountryID
	if(!(Setup_Postcode == "")) GlobalVariable.Glb_Cus_Postcode = Setup_Postcode
	println GlobalVariable.Glb_Cus_Postcode
	if(!(Setup_State == "")) GlobalVariable.Glb_Cus_State = Setup_State
	println GlobalVariable.Glb_Cus_State
	if(!(Setup_ChannelCode == "")) GlobalVariable.Glb_Cus_ChannelCode = Setup_ChannelCode
	println GlobalVariable.Glb_Cus_ChannelCode
	if(!(Setup_PhoneNumber == "")) GlobalVariable.Glb_Cus_PhoneNumber = Setup_PhoneNumber
	println GlobalVariable.Glb_Cus_PhoneNumber
	if(!(Setup_Email == "")) GlobalVariable.Glb_Cus_Email = Setup_Email
	println GlobalVariable.Glb_Cus_Email
	if(!(Setup_Model == "")) GlobalVariable.Glb_veh_Model = Setup_Model
	println GlobalVariable.Glb_veh_Model
	if(!(Setup_ModelYear == "")) GlobalVariable.Glb_veh_ModelYear = Setup_ModelYear
	println GlobalVariable.Glb_veh_ModelYear
	if(!(Setup_MakeString == "")) GlobalVariable.Glb_veh_MakeString = Setup_MakeString
	println GlobalVariable.Glb_veh_MakeString
	if(!(Setup_ManufacturerName == "")) GlobalVariable.Glb_veh_ManufacturerName = Setup_ManufacturerName
	println GlobalVariable.Glb_veh_ManufacturerName
	if(!(Setup_VehicleID == "")) GlobalVariable.Glb_veh_VehicleId = Setup_VehicleID
	println GlobalVariable.Glb_veh_VehicleId
}
else{
	//If case New Customer required, add random number for Name Customer
	GlobalVariable.Glb_FirstName = 'INVALID_TITAN'
	GlobalVariable.Glb_LastName = 'INVALID_DMS'
}

if(!(Setup_AdvisorType.toString().toLowerCase() == 'exist')) {
	GlobalVariable.Glb_Adv_Id = 'invalid'
	GlobalVariable.Glb_Adv_FirstName= 'invalid'
	GlobalVariable.Glb_Adv_LastName= 'invalid'
} //Else condition is gather below


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

	
//Set up value Past/Current/Future for Start Date
if(GlobalVariable.Glb_StartSearchDate.toString().toLowerCase() =="cr")
	GlobalVariable.Glb_StartSearchDate = current_date
else if (GlobalVariable.Glb_StartSearchDate.toString().toLowerCase() =="p")
	GlobalVariable.Glb_StartSearchDate = SetDate(today,0,-1,0,"YYYY-MM-dd")
else if (GlobalVariable.Glb_StartSearchDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_StartSearchDate = SetDate(today,0,1,0,"YYYY-MM-dd")

//Set up value Past/Current/Future for End Date
if(GlobalVariable.Glb_EndSearchDate.toString().toLowerCase() =="cr")
	GlobalVariable.Glb_EndSearchDate = current_date
else if (GlobalVariable.Glb_EndSearchDate.toString().toLowerCase() =="p")
	GlobalVariable.Glb_EndSearchDate = SetDate(today,0,-1,0,"YYYY-MM-dd")
else if (GlobalVariable.Glb_EndSearchDate.toString().toLowerCase() =="f")
	GlobalVariable.Glb_EndSearchDate = SetDate(today,0,1,0,"YYYY-MM-dd")
	
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
	
//Query Financial Year 
	int countNumber = 0
	sql.eachRow("select * from ENTERPRISE") {row ->
	if(countNumber == 0){
		GlobalVariable.Glb_FinancialYear = row.CURRENT_FINANCIAL_YEAR_KEY as String
		println GlobalVariable.Glb_FinancialYear
	}
	countNumber += 1
  }
	

//Query information of valid Advisor
	if(Setup_AdvisorType.toString().toLowerCase() == 'exist') {
	countNumber = 0
	//Executive query for database
	sql.eachRow("exec Get_All_Service_Advisors @TerminationDate= '10/12/2018', @FinancialYearKey= 20") {row ->
	if(countNumber == 1){
		GlobalVariable.Glb_Adv_Id = row[0] as String
		GlobalVariable.Glb_Adv_FirstName= row.First_Name as String
		GlobalVariable.Glb_Adv_LastName= row.Family_Name as String
		println GlobalVariable.Glb_Adv_Id + GlobalVariable.Glb_Adv_FirstName  + GlobalVariable.Glb_Adv_LastName
	}
	countNumber += 1
	
  }
	
}
	sql.close()
	conn.close()