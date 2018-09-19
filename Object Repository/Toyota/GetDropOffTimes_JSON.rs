<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GetDropOffTimes_JSON</name>
   <tag></tag>
   <elementGuidId>5c366d94-8d7c-468a-a467-156a8f68f489</elementGuidId>
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
      <value>Bearer heZOUNHZi0m7huMppeiL09xxUsah1Lnu_52FgpjGz5CB_FNOm5t7I5ZL1fmn6Y5zBIZWKR2TW11pYas3CbpKrHUyj4J3nnACC1zv-Brxh0nifZ5lUVfmYUnH12oOOLcAhbnsfFzx_m_knEFlENxSaljAlksQyYxZPVXa4yK58AaqEc-pjKrRnEE-jWDPHni96LYC173hhnpw8m6oGzaR-gBsoXodv-T6SVAFUU-2YMCAB8NMHu06_Va_Y_wV5bAFSuhy1xE6YGAPp2teUdPVRDKxFsuhVxCnAo_Ln_YS36MNblnDhcj-cnBmGXwMEIQBXtCGN2GcPuNtG77SWL3VCA</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/765A/locations/1/dropOffs?duration=1&amp;start=${Start_Date}&amp;end=${End_Date}&amp;serviceBayType=${ServiceBay_Type}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'2018-09-19'</defaultValue>
      <description></description>
      <id>e27e2852-5da6-4488-9ff7-27f334ac0311</id>
      <masked>false</masked>
      <name>Start_Date</name>
   </variables>
   <variables>
      <defaultValue>'2018-09-19'</defaultValue>
      <description></description>
      <id>c39d794a-0736-4d6a-8c4e-8cea279699e1</id>
      <masked>false</masked>
      <name>End_Date</name>
   </variables>
   <variables>
      <defaultValue>'PERIODIC'</defaultValue>
      <description></description>
      <id>a9517ef3-5517-439d-9c6e-9c7cfc572882</id>
      <masked>false</masked>
      <name>ServiceBay_Type</name>
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
