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
import static com.xlson.groovycsv.CsvParser.parseCsv
@Grab('com.xlson.groovycsv:groovycsv:1.3')
 
fh = new File('Data Files/Toyota/test.csv')
def csv_content = fh.getText('utf-8')
 
def data_iterator = parseCsv(csv_content, separator: ',', readFirstLine: false)
// println data_iterator.getClass()  // class com.xlson.groovycsv.CsvIterator
 
for (line in data_iterator) {
	println line.Name
}

	def birds = ["Parrot", "Cockatiel", "Pigeon"] as String[]
		
	def birdsWithoutParrot = birds - "Parrot"
		
	println birds // [Parrot, Cockatiel, Pigeon]
		
	println birdsWithoutParrot // [Cockatiel, Pigeon]

assert (4-1)==3
