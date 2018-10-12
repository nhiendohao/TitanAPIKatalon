import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import static org.assertj.core.api.Assertions.*
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath as Xpath
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
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import java.io.File as File
import javax.xml.parsers.DocumentBuilderFactory as DocumentBuilderFactory
import org.w3c.dom.Document as Document
import org.w3c.dom.Element as Element
import org.w3c.dom.NodeList as NodeList
import org.xml.sax.InputSource as InputSource
import java.io.StringReader as StringReader
import groovy.sql.Sql
import java.sql.Driver


//	// Create Driver for connection
//	  def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
//	// Create Object Properties  
//	  def props = new Properties()
//	// Setup user and password through Object Properties
//	  props.setProperty("user", "TitanDBA")
//	  props.setProperty("password", "T1t@nDB4F0rBRIS-DEV-QADB")
//	//Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
//	  def conn = driver.connect("jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_bmg_1_24", props)
//	  def sql = new Sql(conn)
//	//Executive query for database
//	//Read data row by row by expression eachRow  
//	  sql.eachRow("exec Get_All_Service_Advisors @TerminationDate= '12/10/2018', @FinancialYearKey= 20") {row ->
//		  def VEH = row[0]
//		  def VIN = row.Name
//		  println VIN
//		  println VEH
//	  }
//	  sql.close()
//	  conn.close()
	  
//	  int size = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSQLSize'("TitanDBA", "T1t@nDB4F0rBRIS-DEV-QADB", "jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_bmg_1_24", "exec Get_All_Service_Advisors @TerminationDate= '12/10/2018', @FinancialYearKey= 20")
//	  //String demo = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getSQLValue'("TitanDBA", "T1t@nDB4F0rBRIS-DEV-QADB", "jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_bmg_1_24", "exec Get_All_Service_Advisors @TerminationDate= '12/10/2018', @FinancialYearKey= 20", 0)
//	  
//	  def sql
//	  CustomKeywords.'qaVinhLe.Library_Method_VinhLe.connectSQL'(sql, "TitanDBA", "T1t@nDB4F0rBRIS-DEV-QADB", "jdbc:sqlserver://HCM-DEV-DB;databaseName=qa_bmg_1_24", "exec Get_All_Service_Advisors @TerminationDate= '12/10/2018', @FinancialYearKey= 20")
//	  sql.eachRow("exec Get_All_Service_Advisors @TerminationDate= '12/10/2018', @FinancialYearKey= 20") {row ->
//  		  def VEH = row[0]
//  		  def VIN = row.Name
//  		  println VIN
//  		  println VEH
//	  }
//	  	  sql.close()
//	  	  conn.close()
	  
String Str_xml = (((((((((((((((((((((((('<Gbookstore> ' + '<bookstore1> ') + '<book category="cooking">') + '<title lang="en">Everyday Italian</title> ') + 
' <author>Giada De Laurentiis</author> ') + '<year>2005</year> ') + '<price>30.00</price> </book> ') + '<book category="children">') + 
'<title lang="en">Harry Potter</title> ') + ' <author>J K. Rowling</author> ') + '<year>2005</year> ') + '<price>29.99</price> </book>') + 
'</bookstore1>') + '<bookstore> ') + '<book category="cooking">') + '<title lang="en">Everyday Italian</title> ') + ' <author>Giada De Laurentiis</author> ') + 
'<year>2005</year> ') + '<price>30.00</price> </book> ') + '<book category="children">') + '<title lang="en">Harry Potter</title> ') + 
' <author>J K. Rowling</author> ') + '<year>2005</year> ') + '<price>29.99</price> </book>') + '</bookstore>') + '</Gbookstore> '

String demo  = CustomKeywords.'qaVinhLe.Library_Method_VinhLe.getDateFormat'("dd/MM/YYYY")
println demo