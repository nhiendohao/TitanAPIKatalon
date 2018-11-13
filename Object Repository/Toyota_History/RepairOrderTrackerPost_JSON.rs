<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>RepairOrderTrackerPost_JSON</name>
   <tag></tag>
   <elementGuidId>38e79fd6-b399-4f89-bed1-ae0fbff6abf4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;entry\&quot;: \&quot;${obj_Entry}\&quot;,\n  \&quot;timestamp\&quot;: \&quot;${obj_Date}\&quot;,\n  \&quot;staff\&quot;: {\n    \&quot;name\&quot;: \&quot;${obj_staffName}\&quot;,\n    \&quot;role\&quot;: \&quot;Technician\&quot;\n  }\n}&quot;,
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
      <name>Authorization</name>
      <type>Main</type>
      <value>Basic VGl0YW5ETVM6RVFuYmY2Nmg=</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>x-api-key</name>
      <type>Main</type>
      <value>8873f928-a903-4182-936b-6451eeebb8de</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://api-uat.toyota.com.au/ws/rest/services/repair-orders/${obj_ROId}/tracker</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>e6349b3c-a321-4b98-b63c-7c448f0027d5</id>
      <masked>false</masked>
      <name>obj_Entry</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>7e27caa3-b881-4f5e-a896-489cc5a38817</id>
      <masked>false</masked>
      <name>obj_Date</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f4c386db-848f-430e-9da9-2cdbd9228a5d</id>
      <masked>false</masked>
      <name>obj_staffName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_Booking_ID</defaultValue>
      <description></description>
      <id>0ecbe42c-33a6-46a1-a295-5ae942a4828f</id>
      <masked>false</masked>
      <name>obj_ROId</name>
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
