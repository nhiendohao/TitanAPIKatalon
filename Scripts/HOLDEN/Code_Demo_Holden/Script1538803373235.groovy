import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
import static org.assertj.core.api.Assertions.*

import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument.Field.Xpath
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
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPMessage

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilderFactory;

RequestObject GetPersonel = findTestObject('Holden/Holden_General_Method')
ResponseObject res_GetPersonel = WS.sendRequest(GetPersonel)

WS.verifyResponseStatusCode(res_GetPersonel, 200)



//String locator = "//*[local-name()='Value']"//*[local-name()='Value']
//Xpath Xlocator = locator as Xpath
////WS.verifyElementPropertyValue(res_GetPersonel, "ProcessMessageResponse.ProcessMessageResult.payload.content.RespondPersonnel.ApplicationArea.Sender.CreatorNameCode", "GM")
////WS.verifyElementPropertyValue(res_GetPersonel, "ProcessMessageResult.payload.content.RespondPersonnel.ApplicationArea.Sender.CreatorNameCode", "GM")
////WS.verifyElementPropertyValue(res_GetPersonel, "payload.content.RespondPersonnel.ApplicationArea.Sender.CreatorNameCode", "GM")
////WS.verifyElementPropertyValue(res_GetPersonel, "content.RespondPersonnel.ApplicationArea.Sender.CreatorNameCode", "GM")
////WS.verifyElementPropertyValue(res_GetPersonel, "ApplicationArea.Sender.CreatorNameCode", "GM")
////WS.verifyElementPropertyValue(res_GetPersonel, "Sender.CreatorNameCode", "GM")
//WS.verifyElementPropertyValue(res_GetPersonel, locator, "GM")
//WS.verifyElementPropertyValue(res_GetPersonel, "ProcessMessageResponse.ProcessMessageResult.payload.content.RespondPersonnel.ApplicationArea.Sender.CreatorNameCode", "GM")

//Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
//.parse(new InputSource(new StringReader(res_GetPersonel.toString())));
//NodeList errNodes = doc.getElementsByTagName("Sender");
//if (errNodes.getLength() > 0) {
// Element err = (Element)errNodes.item(0);
// println "CreatorNameCode"+err.getElementsByTagName("CreatorNameCode").item(0).getTextContent();
//}

BufferedReader xml = new BufferedReader(
	new InputStreamReader(res_GetPersonel.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
	while ((inputLine = xml.readLine()) != null) {
	  response.append(inputLine);
	}
   xml.close();
   //print in String
   // System.out.println(response.toString());
	   Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
		.parse(new InputSource(new StringReader(response.toString())));
   NodeList errNodes = doc.getElementsByTagName("TimeZoneResponse");
	   if (errNodes.getLength() > 0) {
		 Element err = (Element)errNodes.item(0);
		 System.out.println("raw_offset -"+err.getElementsByTagName("raw_offset").item(0).getTextContent());
}