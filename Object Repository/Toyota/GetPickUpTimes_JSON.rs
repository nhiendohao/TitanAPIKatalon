<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetPickUpTimes_JSON</name>
   <tag></tag>
   <elementGuidId>11793534-4b84-4a97-9fb0-7bd56f4e5d8d</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic c3lzYWQ6a3I0N1h0MzUh</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/${Dealer_Code}/locations/${Location_Code}/pickUps?duration=${Duration_Time}&amp;date=${Service_Date}&amp;dropOff=${Drop_Off_Time}&amp;serviceBayType=${ServiceBay_Time}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'2018-09-21'</defaultValue>
      <description></description>
      <id>11312aef-1a38-4e1f-b1de-5ba8f233a73b</id>
      <masked>false</masked>
      <name>Service_Date</name>
   </variables>
   <variables>
      <defaultValue>'08:00'</defaultValue>
      <description></description>
      <id>4ede1f38-d83a-4651-b3a7-3604641d374f</id>
      <masked>false</masked>
      <name>Drop_Off_Time</name>
   </variables>
   <variables>
      <defaultValue>'PERIODIC'</defaultValue>
      <description></description>
      <id>190ddb9f-5145-4ff2-88db-d29ba48d6003</id>
      <masked>false</masked>
      <name>ServiceBay_Time</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>6a958b05-ca92-427f-ab5b-254c83c2706b</id>
      <masked>false</masked>
      <name>Duration_Time</name>
   </variables>
   <variables>
      <defaultValue>'765A'</defaultValue>
      <description></description>
      <id>fd968552-a12d-4ec4-af2b-ff06590eec6a</id>
      <masked>false</masked>
      <name>Dealer_Code</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>97021cbc-1942-46ef-935e-a5d2840a078d</id>
      <masked>false</masked>
      <name>Location_Code</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
