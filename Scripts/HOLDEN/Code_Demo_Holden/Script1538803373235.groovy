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
import java.awt.List
import java.io.File as File
import javax.xml.parsers.DocumentBuilderFactory as DocumentBuilderFactory
import org.w3c.dom.Document as Document
import org.w3c.dom.Element as Element
import org.w3c.dom.NodeList as NodeList
import org.xml.sax.InputSource as InputSource
import java.io.StringReader as StringReader
import groovy.sql.Sql as Sql
import java.sql.Driver as Driver

String Str_xml = ((((((((((((((((((((((((((('<Gbookstore> ' + '<bookstore> ') + '<book category="cooking">') + '<title lang="en">Everyday Italian</title> ') + 
' <author>Giada De Laurentiis</author> ') + '<year>2005</year> ') + '<price>30.00</price> </book> ') + '<book category="children">') + 
'<title lang="en">Harry Potter</title> ') + ' <author>J K. Rowling</author> ') + '<year>2005</year> ') + '<price>29.99</price> </book>') + 
'</bookstore>') + '<bookstore> ') + '<book category="cooking">') + '<title lang="en">Everyday Italian</title> ') + ' <author>Giada De Laurentiis</author> ') + 
'<year>2005</year> ') + '<price>30.00</price> </book> ') + '<book category="children">') + '<title lang="en">Harry Potter</title> ') + 
' <author>J K. Rowling</author> ') + '<year>2005</year> ') + '<price>29.99</price> </book>') + '</bookstore>') + '<bookstore> ') + 
'<year/> ') + '</bookstore>') + '</Gbookstore> '

//String demo =  getValueSOAPNode(Str_xml,"bookstor","yea",2,0)
//println demo
//assert demo == null
//String sqlUser = GlobalVariable.Glb_sqlUser.toString()
//
//String sqlPass = GlobalVariable.Glb_sqlPass.toString()
//
//String sqlURL = GlobalVariable.Glb_sqlURL.toString()
//
//// Create Driver for connection
//def driver = ((Class.forName('com.microsoft.sqlserver.jdbc.SQLServerDriver').newInstance()) as Driver)
//
//// Create Object Properties
//def props = new Properties()
//
//// Setup user and password through Object Properties
//props.setProperty('user', sqlUser)
//
//props.setProperty('password', sqlPass)
//
////Create connection for HCM-DEV-DB;databaseName=qa_owen_1_23
//def conn = driver.connect(sqlURL, props)
//
//def sql = new Sql(conn)
//
//int countNumber = 0
//
////Executive query for database
//sql.eachRow('exec Get_All_Service_Advisors @TerminationDate= \'10/12/2018\', @FinancialYearKey= 20', { def row ->
//        if (countNumber == 1) {
//            GlobalVariable.Glb_Adv_Id = ((row[0]) as String)
//
//            GlobalVariable.Glb_Adv_FirstName = ((row.First_Name) as String)
//
//            GlobalVariable.Glb_Adv_LastName = ((row.Family_Name) as String)
//
//            println((GlobalVariable.Glb_Adv_Id + GlobalVariable.Glb_Adv_FirstName) + GlobalVariable.Glb_Adv_LastName)
//        }
//        
//        countNumber += 1
//    })
//
//sql.close()
//
//conn.close()
//
//WS.sendRequest(findTestObject('Holden/Holden_07_GetServiceVisit', [('obj_DealerCode') : GlobalVariable.Glb_Dealer_Code, ('obj_BookingId') : GlobalVariable.Glb_Booking_ID]))
//
//WebUI.callTestCase(findTestCase('HOLDEN/Library Test Case/Holden_05C_DeleteServiceVisit'), [:], FailureHandling.STOP_ON_FAILURE)
//
//String getValueSOAPNode(String response, String parentnode, String childrennode, int indexParent, int indexChild) {
//    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(response)))
//
//    NodeList errNodes = doc.getElementsByTagName(parentnode)
//
//    String value
//
//    if (errNodes.getLength() > 0) {
//        Element err = ((errNodes.item(indexParent)) as Element)
//
//        println((((parentnode + '.') + childrennode) + ':  ') + err.getElementsByTagName(childrennode).item(indexChild).getTextContent())
//
//        value = err.getElementsByTagName(childrennode).item(indexChild).getTextContent()
//    }
//    
//    return value
//}
//println GlobalVariable.Glb_Dealer_Code
//println GlobalVariable.Glb_ChangeJobNumber
//println GlobalVariable.Glb_ChangeJobType
//println GlobalVariable.Glb_ChangeLaborCode
//println GlobalVariable.Glb_ChangeLaborDescription
//println GlobalVariable.Glb_ChangeNote
//println GlobalVariable.Glb_ChangeTransport
//println GlobalVariable.Glb_Ser_AppointmentNote
//println GlobalVariable.Glb_Ser_JobNumberString
//println GlobalVariable.Glb_Ser_JobTypeString
//println GlobalVariable.Glb_Ser_LaborCode
//println GlobalVariable.Glb_Ser_LaborDescription
//println GlobalVariable.Glb_Ser_LaborId
//println GlobalVariable.Glb_Ser_RepairIndicator
//println GlobalVariable.Glb_Ser_Transportation

def date = new Date()
Date newdate = 
println date
String dateStr =   date.format('yyyyMMdd')
println date
println dateStr.substring(0, 4) as Integer
println date.set(year: dateStr.substring(0, 4) as Integer, month: dateStr.substring(4, 6) as Integer)
println date
