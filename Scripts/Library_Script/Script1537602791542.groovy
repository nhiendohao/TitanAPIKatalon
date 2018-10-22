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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


	// SQL
	import groovy.sql.Sql
	import java.sql.Driver
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
	  // Convert Object to Date and calculate Duration
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
	  //Convert Json --> Array
	  def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
	  res_Text.Times.each{ times = it}
	  //--------------------------------------------------------------------------------------------------------
	  //Reading CSV
	  import static com.xlson.groovycsv.CsvParser.parseCsv
	  @Grab('com.xlson.groovycsv:groovycsv:1.3')
	   
	  fh = new File('Data Files/Toyota/test.csv')
	  def csv_content = fh.getText('utf-8')
	   
	  def data_iterator = parseCsv(csv_content, separator: ',', readFirstLine: false)
	   
	  for (line in data_iterator) {
		  println line.Name
	  }
	  
	  //--------------------------------------------------------------------------------------------------------------------------
	  //Method create Date from current Date
	  def nextDay = {Date current_time ,int number ->
		  use(groovy.time.TimeCategory) {
			def Expected_Date = current_time + number.day
			Expected_Date.format("yyyy-MM-dd")
		 }
	  }
	  
	  //--------------------------------------------------------------------------------------------------------------------------
	  //Create random number
	  Random random = new Random()
	  def number_random = random.nextInt(9999)
	  println number_random
	  
	  
	  //--------------------------------------------------------------------------------------------------------------------------
	  //Method assert reponse and message contain
	  import static org.assertj.core.api.Assertions.*
	  
	  def VerifyResponse(ResponseObject response, int StatusCode, String ExpectedMessage){
		  //Verify Response Status = 200 OK
		  WS.verifyResponseStatusCode(response, StatusCode)
		  
		  //Transfer response to Text
		  def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
		  if(!(ExpectedMessage==""))assertThat(response.getResponseText()).contains(ExpectedMessage)
	  }
	  //--------------------------------------------------------------------------------------------------------------------------
	  //Convert String to Date and Date to String
	  import java.text.ParseException
	  import java.text.SimpleDateFormat
	  import java.util.Date
	  String Start_WS_Str = "0" + GlobalVariable.Glb_WorkshopStart + ":00"
	  //Set format
	  SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
	  //Convert String to Date
		  Date date = formatter.parse(Start_WS_Str);
		  System.out.println(date);
		  //Print Date after converting to String
		  System.out.println(formatter.format(date));
		  
		  //--------------------------------------------------------------------------------------------------------------------------
		  //Round method
		  import java.text.DecimalFormat
		  def RoundNumber = { Float floatnumber ->
			  String roundvalue =  new DecimalFormat("#.##").format(floatnumber)
			  //Handle for missing .000...
			  import static org.assertj.core.api.Assertions.*
			  if (!(roundvalue.contains("."))) roundvalue = roundvalue + ".0....."
			  return roundvalue
			  }
		  
		  
		  //--------------------------------------------------------------------------------------------------------------------------
		  //Write to txt file
		  import java.io.File
		  public void writeToFile(def directory, def fileName, def extension, def infoList) {
			  new File("$directory/$fileName$extension").withWriter { out ->
				infoList.each {
				  out.println it
				}
			  }
			}
			
			def txtFileInfo = []
			
			String a = "Today is a new day"
			String b = "Tomorrow is the future"
			//String d = "Yesterday is the past"
			
			txtFileInfo << a
			txtFileInfo << b
			//txtFileInfo << d
			
			writeToFile("C:/Users/vinh.le", "demo_writertxt", ".txt", txtFileInfo)
			
			//--------------------------------------------------------------------------------------------------------------------------
			//Get value from SOAP response
			import javax.xml.parsers.DocumentBuilderFactory;
			import org.w3c.dom.Document;
			import org.w3c.dom.Element;
			import org.w3c.dom.NodeList;
			import org.xml.sax.InputSource;
			import java.io.StringReader;
			
			
			RequestObject GetPersonel = findTestObject('Holden/Holden_03_GetPersonel')
			ResponseObject res_GetPersonel = WSBuiltInKeywords.sendRequest(GetPersonel)
			
			assertThat(res_GetPersonel.getResponseText()).contains('G')
			
			Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
			.parse(new InputSource(new StringReader(res_GetPersonel.getResponseText())));
			NodeList errNodes = doc.getElementsByTagName("Ex: ParentNode");
			if (errNodes.getLength() > 0) {
			 Element err = (Element)errNodes.item(0);
			 println "Ex: ChildrenNode:  "+err.getElementsByTagName("Ex: ChildrenNode").item(0).getTextContent();
			}