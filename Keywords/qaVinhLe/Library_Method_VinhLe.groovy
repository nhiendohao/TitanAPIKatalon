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
	def verifyValueSOAPNode(ResponseObject response, String parentnode, String childrennode, String expectedValue){
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(0);
			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(0).getTextContent()
			assert expectedValue == err.getElementsByTagName(childrennode).item(0).getTextContent()
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
	def getValueSOAPNode(ResponseObject response, String parentnode, String childrennode,int index) {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new InputSource(new StringReader(response.getResponseText())))
		NodeList errNodes = doc.getElementsByTagName(parentnode)
		String value
		if (errNodes.getLength() > 0) {
			Element err = (Element)errNodes.item(index);
			println parentnode + "." + childrennode +  ":  "+err.getElementsByTagName(childrennode).item(0).getTextContent()
			value = err.getElementsByTagName(childrennode).item(0).getTextContent()
		}
		return value
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
		WS.verifyResponseStatusCode(response, StatusCode)

		//Transfer response to Text
		def res_Text = new groovy.json.JsonSlurper().parseText(response.getResponseText())
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
	
}