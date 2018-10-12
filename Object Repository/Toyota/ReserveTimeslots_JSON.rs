<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ReserveTimeslots_JSON</name>
   <tag></tag>
   <elementGuidId>367e3764-3b7c-4f46-93ee-e3b9816438fe</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;RepairOrderDuration\&quot;: ${Duration},\n  \&quot;ServiceDate\&quot;: \&quot;${Service_Date}\&quot;,\n  \&quot;DropOffTime\&quot;: \&quot;${Drop_Off_Time}\&quot;,\n  \&quot;PickUpTime\&quot;: \&quot;${Pick_Up_Time}\&quot;,\n  \&quot;ServiceBayType\&quot;: \&quot;${ServiceBay_Type}\&quot;,\n  \&quot;Action\&quot;: \&quot;HOLD\&quot;\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
      <name>Accept</name>
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
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://hcm-dev-web/api/dealers/${Dealer_Code}/locations/${Location_Code}/reserveTimeslot</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'2018-10-04'</defaultValue>
      <description></description>
      <id>3d00d777-dbed-4af8-bd45-0ef37a744f50</id>
      <masked>false</masked>
      <name>Service_Date</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>867c84e5-d3bb-4318-8e9e-19f095bb9556</id>
      <masked>false</masked>
      <name>Duration</name>
   </variables>
   <variables>
      <defaultValue>'13:00'</defaultValue>
      <description></description>
      <id>17b59cb1-1613-48eb-af8b-b2c22051cf3c</id>
      <masked>false</masked>
      <name>Drop_Off_Time</name>
   </variables>
   <variables>
      <defaultValue>'17:00'</defaultValue>
      <description></description>
      <id>5cd3ec93-b648-4836-b4b0-103dd25259fd</id>
      <masked>false</masked>
      <name>Pick_Up_Time</name>
   </variables>
   <variables>
      <defaultValue>'PERIODIC'</defaultValue>
      <description></description>
      <id>80d572fa-79e7-4239-9f6a-16323cc279e8</id>
      <masked>false</masked>
      <name>ServiceBay_Type</name>
   </variables>
   <variables>
      <defaultValue>'765A'</defaultValue>
      <description></description>
      <id>b91c11a3-ba08-4636-8774-ab096b193627</id>
      <masked>false</masked>
      <name>Dealer_Code</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>a481d5e4-7462-4489-b28b-a0c99caad81d</id>
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
