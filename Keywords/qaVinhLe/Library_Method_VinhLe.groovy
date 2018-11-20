package qaVinhLe
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.w3c.dom.Document;//Convert String to XML object
import org.w3c.dom.Element;//Convert String to XML object
import org.w3c.dom.NodeList;//Convert String to XML object
import org.xml.sax.InputSource;//Convert String to XML object
import java.io.StringReader;//Convert String to XML object
import javax.xml.parsers.DocumentBuilderFactory;//Convert String to XML object
import groovy.sql.Sql //SQL Connection
import java.sql.Driver //SQL Connection
import static org.assertj.core.api.Assertions.*//Assert that
import java.text.DecimalFormat //Round Number
import java.text.ParseException;//String2Date
import java.text.SimpleDateFormat;//String2Date
import java.util.Date;//String2Date



class Library_Method_VinhLe {
	/**
	 * VERIFY VALUE FROM SOAP NODE WITH EXPECTED VALUE
	 * Send request and verify text value of node with the expected value
	 * @response response, must be an instance of ResponseObject
	 * @parentnode parent node
	 * @childrennode children node
	 * @expectedValue expected value
	 * @return a boolean 
	 */
	@Keyword
	def verifyValueSOAPNode(ResponseObject response, String parentnode, String childrennode, String expectedValue, int indexParent, int indexChild){
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(indexParent);
			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
			assert expectedValue == err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
		}
	}

	/**
	 * VERIFY VALUE FROM ATTRIBUTE SOAP NODE WITH EXPECTED VALUE
	 * Send request and verify text value of node with the expected value
	 * @response response, must be an instance of ResponseObject
	 * @parentnode parent node
	 * @childrennode children node
	 * @expectedValue expected value
	 * @return a boolean
	 */
	@Keyword
	def verifyAttributeSOAPNode(ResponseObject response, String parentnode, String childrennode, String attributeName, String expectedValue,int indexParent, int indexChild){
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(indexParent);
			println parentnode + "." + childrennode +  "(" + attributeName + "): " +err.getElementsByTagName(childrennode).item(indexChild).getAttributes().getNamedItem(attributeName).getTextContent()
			assert expectedValue == err.getElementsByTagName(childrennode).item(indexChild).getAttributes().getNamedItem(attributeName).getTextContent()
		}
	}

	/**
	 * GET VALUE FROM SOAP NODE
	 * Send request and get text value of node
	 * @response response, must be an instance of ResponseObject
	 * @parentnode parent node
	 * @childrennode children node
	 * @return a string value
	 */
	@Keyword
	def getValueSOAPNode(ResponseObject response, String parentnode, String childrennode,int indexParent, int indexChild) {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		String value
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(indexParent);
			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
			value = err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
		}
		return value
	}

	/**
	 * GET VALUE FROM ATTRIBUTE SOAP NODE
	 * Send request and get text value of node
	 * @response response, must be an instance of ResponseObject
	 * @parentnode parent node
	 * @childrennode children node
	 * @return a string value
	 */
	@Keyword
	def getAttributeSOAPNode(ResponseObject response, String parentnode, String childrennode,String attributeName,int indexParent, int indexChild) {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		String value
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(indexParent);
			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(indexChild).getAttributes().getNamedItem(attributeName).getTextContent()
			value = err.getElementsByTagName(childrennode).item(indexChild).getAttributes().getNamedItem(attributeName).getTextContent()
		}
		return value
	}

	/**
	 * GET SIZE OF NODE
	 */
	@Keyword
	def getSizeSOAPNode(ResponseObject response, String parentnode) {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		int sizeNode = 0
		sizeNode = errNodes.getLength()
		println "Number of Element: " + sizeNode
		return sizeNode
	}

	/**
	 * GET LOCATOR OF VALUE FROM NODE
	 */
	@Keyword
	int getLocatorValueSOAPNodeforHoldenOSS(ResponseObject response, String rootNode, String parentnode, String childrennode, String valueExpected ) {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(rootNode)
		int sizeNode = getSizeSOAPNode(response, rootNode)
		int locatorNumber = 0
		for(int i = 0;i<sizeNode;i++){
			if(getValueSOAPNode(response, parentnode, childrennode, (1 + 2*i), 0).toString() == valueExpected){
				locatorNumber = i
				break
			}
		}
		println locatorNumber
		return locatorNumber
	}

	/**
	 * SET DATE
	 * @date_time request request object, must be an instance of RequestObject
	 * @number_month number of month
	 * @number_day number of day
	 * @number_hour number of hour
	 * @format_date format date want to format
	 * @return Date after format
	 */
	@Keyword
	def setDate(Date date_time ,int number_month, int number_day, int number_hour, String format_date) {
		use(groovy.time.TimeCategory) {
			def Expected_Date = date_time + number_day.day + number_month.month + number_hour.hour
			return Expected_Date.format(format_date)
		}
	}

	/**
	 *	VERIFY RESPONSE CODE AND THE RETURNED MESSAGE
	 * @response response, must be an instance of ResponseObject
	 * @StatusCode Code of Status response
	 * @ExpectedMessage Expected message want to display
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	@Keyword
	def verifyResponseCode_Msg(ResponseObject response, int StatusCode, String ExpectedMessage) {

		//Verify Response Status = 200 OK
		if(StatusCode == 0) WS.verifyResponseStatusCodeInRange(response, 400, 404)
		else WS.verifyResponseStatusCode(response, StatusCode)

		//Transfer response to Text
		if(!(ExpectedMessage==""))
			assertThat(response.getResponseText()).contains(ExpectedMessage)

	}

	/**
	 *	ROUND NUMBER		
	 * @response response, must be an instance of ResponseObject
	 * @StatusCode Code of Status response
	 * @ExpectedMessage Expected message want to display
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	@Keyword
	def roundNumber(Float floatnumber, String formatDecimal, String addDecimal0) { //formatDecimal = "#.##"
		String roundvalue =  new DecimalFormat(formatDecimal).format(floatnumber)
		//Handle for missing .000...
		if (!(roundvalue.contains("."))) roundvalue = roundvalue + addDecimal0  //addDecimal0 = ".00"
		return roundvalue

	}


	/**
	 *	GET SQL SIZE
	 * @response response, must be an instance of ResponseObject
	 * @StatusCode Code of Status response
	 * @ExpectedMessage Expected message want to display
	 * @return a boolean to indicate whether the response status code equals the expected one
	 */
	@Keyword
	int getSQLSize( String user, String pass, String URL, String queryCmd ) {
		// Create Driver for connection
		def driver = Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance() as Driver
		// Create Object Properties
		def props = new Properties()
		// Setup user and password through Object Properties
		props.setProperty("user", user)
		props.setProperty("password", pass)
		//Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
		def conn = driver.connect(URL, props)
		def sql = new Sql(conn)
		//Executive query for database
		//Read data row by row by expression eachRow
		int sizeSQL = 0
		sql.eachRow(queryCmd) {row -> sizeSQL += 1 }
		sql.close()
		conn.close()
		println sizeSQL
		return sizeSQL

	}

	/**
	 * GET DATE WITH FORMAT
	 * @date_time request request object, must be an instance of RequestObject
	 * @number_month number of month
	 * @number_day number of day
	 * @number_hour number of hour
	 * @format_date format date want to format
	 * @return Date after format
	 */
	@Keyword
	String getDateFormat(String formatDate) {
		Date today = new Date()
		String dateFormat = today.format(formatDate)
		return dateFormat
	}

	/**
	 * 	WRITE TO FILE
	 */
	@Keyword
	String write2File(String fileNameStr, String typeMsgName) {
		def txtFileInfo = []
		def directory = "C:/Users/vinh.le/git/TitanAPIKatalon/LineTracking"
		def fileName = fileNameStr + "_" +typeMsgName
		def extension = ".txt"
		new File("$directory/$fileName$extension").withWriter { out ->
			txtFileInfo.each { out.println it }
		}
	}

	/**
	 * CONVERT STRING TO DATE TYPE
	 * 
	 */
	@Keyword
	Date convertStringtoDate(String stringDate, String formatDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(formatDate);
		Date date
		try {

			date = formatter.parse(stringDate);
			System.out.println(date);
			System.out.println(formatter.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date
	}



}
