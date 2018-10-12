<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>MakeServiceBooking_JSON</name>
   <tag></tag>
   <elementGuidId>186c10a4-e911-4c64-b835-352d19bdbad4</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;Vehicle\&quot;: {\n        \&quot;VIN\&quot;: \&quot;${VIN}\&quot;,\n        \&quot;RegistrationNumber\&quot;: \&quot;${REGNumber}\&quot;,\n        \&quot;RegistrationState\&quot;: \&quot;OSB_STATE_VIC\&quot;,\n        \&quot;CustomerOdometerReading\&quot;: 20500,\n        \&quot;VehicleInformation\&quot;: {\n            \&quot;VehicleDetail\&quot;: [\n                {\n                    \&quot;Key\&quot;: 0,\n                    \&quot;Value\&quot;: \&quot;TOYOTA\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 1,\n                    \&quot;Value\&quot;: \&quot;Corolla Sedan\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 3,\n                    \&quot;Value\&quot;: \&quot;2016-09\&quot;\n                }\n            ]\n        }\n    },\n    \&quot;RepairOrder\&quot;: {\n        \&quot;TotalPriceQuoted\&quot;: ${TotalPrice},\n        \&quot;TotalDuration\&quot;: ${TotalDuration},\n        \&quot;Services\&quot;: [\n            {\n                \&quot;Name\&quot;: \&quot;Operation Code for Test\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;${ServiceType}\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;${DMSOperationCode}\&quot;,\n                \&quot;Duration\&quot;: 1,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0.0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 110\n            }\n         ]   \n        \n    },\n    \&quot;Appointment\&quot;: {\n        \&quot;BookingDate\&quot;: \&quot;${Service_Date}T00:00:00\&quot;,\n        \&quot;DropOffTime\&quot;: \&quot;${Drop_Off_Time}\&quot;,\n        \&quot;PickUpTime\&quot;: \&quot;${Pick_Up_Time}\&quot;,\n        \&quot;XReserveToken\&quot;: ${Reserve_Token},\n        \&quot;ServiceBayType\&quot;: \&quot;${ServiceBay_Time}\&quot;\n    },\n    \&quot;Contact\&quot;: {\n        \&quot;ToyotaContactID\&quot;: \&quot;${ContactId}\&quot;,\n        \&quot;FirstName\&quot;: \&quot;${FirstName}\&quot;,\n        \&quot;LastName\&quot;: \&quot;${LastName}\&quot;,\n        \&quot;PhoneNumber\&quot;: \&quot;0983612137\&quot;,\n        \&quot;Email\&quot;: \&quot;QAteam.automation@titandms.com\&quot;,\n        \&quot;DealerMarketingAllowedFlag\&quot;: false,\n        \&quot;ContactRelationship\&quot;: \&quot;OSB_CUSTOMER_OWNER\&quot;,\n        \&quot;AlternativeContactName\&quot;: \&quot;ANH THY\&quot;,\n        \&quot;AlternativeContactNumber\&quot;: \&quot;0919011995\&quot;\n    },\n     \&quot;Comment\&quot;: {\n\t    \&quot;CommentLine\&quot;: [\n\t      \&quot;TITANDMS\&quot;,\n\t      \&quot;TITAN DMS - QA TEAM - AUTOMATION - VINH LE\&quot;\n\t    ]\n\t  },\n    \&quot;BookingSource\&quot;: null,\n    \&quot;ExpressMaintenanceBookingRequest\&quot;: false,\n    \&quot;TransportOption\&quot;: 3,\n    \&quot;PreferredContactMethod\&quot;: 0,\n    \&quot;ConfirmationMessageByDMS\&quot;: false\n}&quot;,
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
   <restUrl>http://hcm-dev-web/api/dealers/${Dealer_Code}/locations/${Location_Code}/services</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'JTDKB3FU703535140'</defaultValue>
      <description></description>
      <id>35bcb6cd-3244-4d55-8832-0d116c74e3e8</id>
      <masked>false</masked>
      <name>VIN</name>
   </variables>
   <variables>
      <defaultValue>'REG12121240'</defaultValue>
      <description></description>
      <id>74d85048-d9b2-40ca-8205-f32cb01609e0</id>
      <masked>false</masked>
      <name>REGNumber</name>
   </variables>
   <variables>
      <defaultValue>'2018-09-20'</defaultValue>
      <description></description>
      <id>fd98facb-65a6-477b-944a-29db5331913b</id>
      <masked>false</masked>
      <name>Service_Date</name>
   </variables>
   <variables>
      <defaultValue>'15:00'</defaultValue>
      <description></description>
      <id>b7ba151a-6f39-4064-82bb-145e8f159051</id>
      <masked>false</masked>
      <name>Drop_Off_Time</name>
   </variables>
   <variables>
      <defaultValue>'17:00'</defaultValue>
      <description></description>
      <id>c6a18143-ded0-46ba-9fda-3226c39b3071</id>
      <masked>false</masked>
      <name>Pick_Up_Time</name>
   </variables>
   <variables>
      <defaultValue>'56'</defaultValue>
      <description></description>
      <id>8cd511a7-4e0c-492e-ab70-201fbdbfdb3e</id>
      <masked>false</masked>
      <name>Reserve_Token</name>
   </variables>
   <variables>
      <defaultValue>'PERIODIC'</defaultValue>
      <description></description>
      <id>2a607707-3803-44e6-a4bd-7c53b772aab7</id>
      <masked>false</masked>
      <name>ServiceBay_Type</name>
   </variables>
   <variables>
      <defaultValue>'110'</defaultValue>
      <description></description>
      <id>e989d975-0b3c-4ac2-a35a-0e309afc3e46</id>
      <masked>false</masked>
      <name>TotalPrice</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>2186be28-46a8-4a4d-85ac-fe912d359ddf</id>
      <masked>false</masked>
      <name>TotalDuration</name>
   </variables>
   <variables>
      <defaultValue>'1901'</defaultValue>
      <description></description>
      <id>ccecc091-9d12-4444-8336-7b62561c30f5</id>
      <masked>false</masked>
      <name>ContactId</name>
   </variables>
   <variables>
      <defaultValue>'TITAN'</defaultValue>
      <description></description>
      <id>a9c883b4-aeff-4fc9-a4b1-7859eb244f6e</id>
      <masked>false</masked>
      <name>FirstName</name>
   </variables>
   <variables>
      <defaultValue>'DMS'</defaultValue>
      <description></description>
      <id>9d0ba3d2-b0d9-48c8-a5c5-e07d7c6d7f0a</id>
      <masked>false</masked>
      <name>LastName</name>
   </variables>
   <variables>
      <defaultValue>'OSB_SERVICE_TYPE_LOGBOOK'</defaultValue>
      <description></description>
      <id>ca9eb618-6ba2-4019-91aa-d8c2aa01d760</id>
      <masked>false</masked>
      <name>ServiceType</name>
   </variables>
   <variables>
      <defaultValue>'TITAN_OP_CODE_LOG'</defaultValue>
      <description></description>
      <id>1c82ab21-9c06-4c36-9a55-a0af2966d730</id>
      <masked>false</masked>
      <name>DMSOperationCode</name>
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
