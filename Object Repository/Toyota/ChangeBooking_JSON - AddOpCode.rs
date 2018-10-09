<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ChangeBooking_JSON - AddOpCode</name>
   <tag></tag>
   <elementGuidId>e80fffb8-9ee5-4719-9a4e-79f5488582cd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;Vehicle\&quot;: {\n        \&quot;VIN\&quot;: \&quot;${VIN}\&quot;,\n        \&quot;RegistrationNumber\&quot;: \&quot;${REGNumber}\&quot;,\n        \&quot;RegistrationState\&quot;: \&quot;OSB_STATE_VIC\&quot;,\n        \&quot;CustomerOdometerReading\&quot;: 20500,\n        \&quot;VehicleInformation\&quot;: {\n            \&quot;VehicleDetail\&quot;: []\n        }\n    },\n    \&quot;RepairOrder\&quot;: {\n        \&quot;TotalPriceQuoted\&quot;: ${TotalPrice_Change},\n        \&quot;TotalDuration\&quot;: ${TotalDuration_Change},\n        \&quot;Services\&quot;: [\n            {\n                \&quot;Name\&quot;: \&quot;Operation Code for Test\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;${ServiceType}\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;${DMSOperationCode}\&quot;,\n                \&quot;Duration\&quot;: 1,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 110\n            },\n          {\n                \&quot;Name\&quot;: \&quot;Add Operation Code for Test\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;${ServiceType}\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;ADD_OP_CODE\&quot;,\n                \&quot;Duration\&quot;: 0,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 0\n            }\n        ]\n    },\n    \&quot;Appointment\&quot;: {\n        \&quot;BookingDate\&quot;: \&quot;${Service_Date_Change}T00:00:00\&quot;,\n        \&quot;DropOffTime\&quot;: \&quot;${Drop_Off_Time_Change}\&quot;,\n        \&quot;PickUpTime\&quot;: \&quot;${Pick_Up_Time}\&quot;,\n        \&quot;ServiceBayType\&quot;: \&quot;${ServiceBay_Time}\&quot;\n    },\n    \&quot;Contact\&quot;: {\n        \&quot;ToyotaContactID\&quot;: \&quot;19011995\&quot;,\n        \&quot;FirstName\&quot;: \&quot;QATEAM\&quot;,\n        \&quot;LastName\&quot;: \&quot;VINHLE\&quot;,\n        \&quot;PhoneNumber\&quot;: \&quot;0983612137\&quot;,\n        \&quot;Email\&quot;: \&quot;QAteam.automation@titandms.com\&quot;,\n        \&quot;DealerMarketingAllowedFlag\&quot;: false,\n        \&quot;ContactRelationship\&quot;: \&quot;OSB_CUSTOMER_OWNER\&quot;,\n        \&quot;AlternativeContactName\&quot;: \&quot;ANH THY\&quot;,\n        \&quot;AlternativeContactNumber\&quot;: \&quot;0919011995\&quot;\n    },\n    \&quot;Comment\&quot;: null,\n    \&quot;BookingSource\&quot;: \&quot;OSB_SOURCE_DEALER_WEBSITE\&quot;,\n    \&quot;ExpressMaintenanceBookingRequest\&quot;: false,\n    \&quot;TransportOption\&quot;: \&quot;OSB_TRANSPORT_OPTION_NONE\&quot;,\n    \&quot;PreferredContactMethod\&quot;: \&quot;OSB_CONTACT_PHONE\&quot;,\n    \&quot;ConfirmationMessageByDMS\&quot;: false\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/${Dealer_Code}/locations/${Location_Code}/services/${BookingID}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'765A'</defaultValue>
      <description></description>
      <id>efbca45f-7a65-492f-9aec-e72c703190c3</id>
      <masked>false</masked>
      <name>Dealer_Code</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>88585ebd-902c-4a15-8244-a9d28d29ef2c</id>
      <masked>false</masked>
      <name>Location_Code</name>
   </variables>
   <variables>
      <defaultValue>'136910'</defaultValue>
      <description></description>
      <id>de5eadab-8d1c-4bd4-90bf-1b245086885d</id>
      <masked>false</masked>
      <name>BookingID</name>
   </variables>
   <variables>
      <defaultValue>'2018-10-04'</defaultValue>
      <description></description>
      <id>8c29fa83-4ea7-40c4-a56f-2fd9b0351173</id>
      <masked>false</masked>
      <name>Service_Date_Change</name>
   </variables>
   <variables>
      <defaultValue>'09:45'</defaultValue>
      <description></description>
      <id>ca4d74e0-a6a0-4ce6-bbf1-3ee934ec5f0a</id>
      <masked>false</masked>
      <name>Drop_Off_Time_Change</name>
   </variables>
   <variables>
      <defaultValue>'17:00'</defaultValue>
      <description></description>
      <id>20957e50-c2b2-46e0-bae1-36b751a3fa26</id>
      <masked>false</masked>
      <name>Pick_Up_Time</name>
   </variables>
   <variables>
      <defaultValue>'PERIODIC'</defaultValue>
      <description></description>
      <id>6f94ffff-4657-42e6-8238-61f577305e48</id>
      <masked>false</masked>
      <name>ServiceBay_Time</name>
   </variables>
   <variables>
      <defaultValue>'110'</defaultValue>
      <description></description>
      <id>7d955ce2-c7bd-4d23-b50e-3c1b2bfce1ea</id>
      <masked>false</masked>
      <name>TotalPrice_Change</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>80690c08-185c-4715-b5cc-bf99d099b33c</id>
      <masked>false</masked>
      <name>TotalDuration_Change</name>
   </variables>
   <variables>
      <defaultValue>'VINCHANGE'</defaultValue>
      <description></description>
      <id>75cdcb41-508a-40de-908e-cffd91d1ecbd</id>
      <masked>false</masked>
      <name>VIN</name>
   </variables>
   <variables>
      <defaultValue>'REGCHANGE'</defaultValue>
      <description></description>
      <id>af503f4c-6867-49b2-bfc1-e295912b538f</id>
      <masked>false</masked>
      <name>REGNumber</name>
   </variables>
   <variables>
      <defaultValue>'1901'</defaultValue>
      <description></description>
      <id>9829c61c-5a89-40df-8b39-df992e5fa6f8</id>
      <masked>false</masked>
      <name>ContactId</name>
   </variables>
   <variables>
      <defaultValue>'TITAN'</defaultValue>
      <description></description>
      <id>626f5a24-38b0-43e7-b6f2-aac366909dd6</id>
      <masked>false</masked>
      <name>FirstName</name>
   </variables>
   <variables>
      <defaultValue>'DMS'</defaultValue>
      <description></description>
      <id>9bdc219e-f3e9-4c4d-85b3-19786437dba5</id>
      <masked>false</masked>
      <name>LastName</name>
   </variables>
   <variables>
      <defaultValue>'OSB_SERVICE_TYPE_LOGBOOK'</defaultValue>
      <description></description>
      <id>bf61a1cb-52a1-4eda-8f6b-d9e4ac965195</id>
      <masked>false</masked>
      <name>ServiceType</name>
   </variables>
   <variables>
      <defaultValue>'TITAN_OP_CODE_LOG'</defaultValue>
      <description></description>
      <id>b13c2a6b-b124-43dc-97cd-c4aa3f6c596d</id>
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
