<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetServiceOperations_JSON</name>
   <tag></tag>
   <elementGuidId>9fc6841f-0112-471e-83b1-a50972ab80c3</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
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
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/${Dealer_Code}/locations/${Location_Code}/serviceOperations?vehicle=${VIN}&amp;serviceType=${Service_Type}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'765A'</defaultValue>
      <description></description>
      <id>fd0a93d3-a900-41e5-9b51-da440552c9ba</id>
      <masked>false</masked>
      <name>Dealer_Code</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>d3776879-69d4-4270-be4d-b7b43cd96a57</id>
      <masked>false</masked>
      <name>Location_Code</name>
   </variables>
   <variables>
      <defaultValue>'VNVNVNVNVNVNVNVNV'</defaultValue>
      <description></description>
      <id>0916d6d5-2e81-43ab-aff2-d7d35dadfa16</id>
      <masked>false</masked>
      <name>VIN</name>
   </variables>
   <variables>
      <defaultValue>'OSB_SERVICE_TYPE_LOGBOOK'</defaultValue>
      <description></description>
      <id>9ae280eb-2cfa-4550-8b00-557b377c0517</id>
      <masked>false</masked>
      <name>Service_Type</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


GlobalVariable.gb_token

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
