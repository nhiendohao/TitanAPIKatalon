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
import groovy.sql.Sql
import java.sql.Driver

// Creating a connection to the database
	  
	  def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
	  
	  def props = new Properties()
	  props.setProperty("user", "TitanDBA")
	  props.setProperty("password", "T1t@nDB4F0rBRIS-DEV-QADB")
	  
	  def conn = driver.connect("jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_owen_1_23", props)
	  def sql = new Sql(conn)
	  
	  
	  sql.eachRow("select top 10 * from VEHICLE") {row ->   
		  print row[0] + " "
		  def VIN = row.VIN
		  println VIN
	  }
	  sql.close()
	  conn.close()