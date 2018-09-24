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
import groovy.sql.Sql
import java.sql.Driver

	// SQL
	// Create Driver for connection
	  def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
	// Create Object Properties  
	  def props = new Properties()
	// Setup user and password through Object Properties
	  props.setProperty("user", "TitanDBA")
	  props.setProperty("password", "T1t@nDB4F0rBRIS-DEV-QADB")
	//Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
	  def conn = driver.connect("jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_owen_1_23", props)
	  def sql = new Sql(conn)
	//Executive query for database
	//Read data row by row by expression eachRow  
	  sql.eachRow("select top 10 * from VEHICLE") {row ->
		  def VEH = row[0]
		  def VIN = row.VIN
		  print VIN
		  println VEH
	  }
	  sql.close()
	  conn.close()

	  //--------------------------------------------------------------------------------------------------------
	  // Convert String to Date and calculate Duration
	  String Strdate= "2018-09-24"
	  def date = Date.parse("yyyy-MM-dd", Strdate)
	  
	  String Strdate1= "2018-09-28"
	  def date1 = Date.parse("yyyy-MM-dd", Strdate1)
	  
	  use(groovy.time.TimeCategory) {
		  def duration = date1 - date
		  println duration
		  println  "Days: ${duration.days}, Hours: ${duration.hours}, etc."
	  }
	  //--------------------------------------------------------------------------------------------------------
	  
	  