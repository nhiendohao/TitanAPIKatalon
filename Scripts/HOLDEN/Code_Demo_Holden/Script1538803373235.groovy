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

RequestObject GetPersonel = findTestObject('Holden/Holden_General_Method')

ResponseObject res_GetPersonel = WSBuiltInKeywords.sendRequest(GetPersonel)

assertThat(res_GetPersonel.getResponseText()).contains('G')

Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(res_GetPersonel.getResponseText())))

NodeList errNodes = doc.getElementsByTagName('Destination')

if (errNodes.getLength() > 0) {
    Element err = ((errNodes.item(0)) as Element)

    println('DestinationNameCode:  ' + err.getElementsByTagName('DestinationNameCode').item(0).getTextContent())
}

verifyValue(res_GetPersonel, 'Destination', 'DestinationNameCode', 'QI')

void verifyValue(ResponseObject response, String parentnode, String childrennode, String expectedValue) {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response.getResponseText())))

    NodeList errNodes = doc.getElementsByTagName(parentnode)

    if (errNodes.getLength() > 0) {
        Element err = ((errNodes.item(0)) as Element)

        println((((parentnode + '.') + childrennode) + ':  ') + err.getElementsByTagName(childrennode).item(0).getTextContent())

        assert expectedValue == err.getElementsByTagName(childrennode).item(0).getTextContent()
    }
}

