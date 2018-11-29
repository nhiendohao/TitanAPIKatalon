import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.lang.reflect.Array as Array
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
import static org.assertj.core.api.Assertions.*
import java.text.ParseException as ParseException
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import groovy.sql.Sql as Sql
import java.sql.Driver as Driver

/**
 * @author ANH THY
 * 1. add sql for customer information
 */
WS.comment(null)

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

//Query Model Key from Make ID
String makeID
sql.eachRow("select * from MAKE where MAKE_ID = 'FIAT'") {row ->
	makeID = row.MAKE_KEY as String
	println makeID
}

String modelKeyQuery = "SELECT TOP 1 M.MODEL_KEY FROM MODEL M "+
					    "INNER JOIN MODEL_TYPE MT "+
						    "ON M.MODEL_TYPE_KEY = MT.MODEL_TYPE_KEY "+
					    "WHERE MT.MAKE_KEY = "+GlobalVariable.Glb_veh_MakeString+" AND "+
						        "M.SERIES = '"+GlobalVariable.Glb_veh_Model+"' "+
					    "ORDER BY M.MODEL_KEY DESC"

sql.eachRow(modelKeyQuery) {row ->
	GlobalVariable.Glb_veh_modelKey = row[0] as String
	println GlobalVariable.Glb_veh_modelKey
}
sql.close()
conn.close()