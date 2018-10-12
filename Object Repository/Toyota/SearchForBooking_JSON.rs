<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>SearchForBooking_JSON</name>
   <tag></tag>
   <elementGuidId>38ccc243-4e33-47e3-9273-c053b33d87d3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\t \&quot;SearchStartDate\&quot;: \&quot;${StartSearchDate}\&quot;,\n\t \&quot;SearchEndDate\&quot;: \&quot;${EndSearchDate}\&quot;,\n\t \&quot;RegistrationNumber\&quot;: \&quot;${REGNumber}\&quot;\n}&quot;,
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
   <restUrl>http://hcm-dev-web/api/dealers/${Dealer_Code}/locations/${Location_Code}/services/search</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'765A'</defaultValue>
      <description></description>
      <id>9ab55bad-64a5-491f-9152-7e5b013888d6</id>
      <masked>false</masked>
      <name>Dealer_Code</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>4212a1f6-bdd1-47a6-a0ae-fb775ce1e1d7</id>
      <masked>false</masked>
      <name>Location_Code</name>
   </variables>
   <variables>
      <defaultValue>'2018-09-21'</defaultValue>
      <description></description>
      <id>049fe140-0c94-491a-a872-e0d18dfadd53</id>
      <masked>false</masked>
      <name>StartSearchDate</name>
   </variables>
   <variables>
      <defaultValue>'REG12121240'</defaultValue>
      <description></description>
      <id>fb7ea01d-e663-429c-ae7e-af1afd342ebf</id>
      <masked>false</masked>
      <name>REGNumber</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>ab234097-987d-4231-8f39-c54eae5701ab</id>
      <masked>false</masked>
      <name>EndSearchDate</name>
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
