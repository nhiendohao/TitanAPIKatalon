<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>ChangeBooking_JSON</name>
   <tag></tag>
   <elementGuidId>45f74dbb-8320-438a-bc14-b0595db62a88</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;Vehicle\&quot;: {\n        \&quot;VIN\&quot;: \&quot;${VIN}\&quot;,\n        \&quot;RegistrationNumber\&quot;: \&quot;${REGNumber}\&quot;,\n        \&quot;RegistrationState\&quot;: \&quot;OSB_STATE_VIC\&quot;,\n        \&quot;CustomerOdometerReading\&quot;: 20500,\n        \&quot;VehicleInformation\&quot;: {\n            \&quot;VehicleDetail\&quot;: []\n        }\n    },\n    \&quot;RepairOrder\&quot;: {\n        \&quot;TotalPriceQuoted\&quot;: 110,\n        \&quot;TotalDuration\&quot;: 1,\n        \&quot;Services\&quot;: [\n            {\n                \&quot;Name\&quot;: \&quot;VW105 - VW105 - Carry out 105,000km service as per VW schedule\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;OSB_SERVICE_TYPE_LOGBOOK\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;VW105\&quot;,\n                \&quot;Duration\&quot;: 1,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 110\n            }\n        ]\n    },\n    \&quot;Appointment\&quot;: {\n        \&quot;BookingDate\&quot;: \&quot;${Service_Date}T00:00:00\&quot;,\n        \&quot;DropOffTime\&quot;: \&quot;${Drop_Off_Time_Change}\&quot;,\n        \&quot;PickUpTime\&quot;: \&quot;${Pick_Up_Time}\&quot;,\n        \&quot;ServiceBayType\&quot;: \&quot;${ServiceBay_Time}\&quot;\n    },\n    \&quot;Contact\&quot;: {\n        \&quot;ToyotaContactID\&quot;: \&quot;43054\&quot;,\n        \&quot;FirstName\&quot;: \&quot;John\&quot;,\n        \&quot;LastName\&quot;: \&quot;Smith\&quot;,\n        \&quot;PhoneNumber\&quot;: \&quot;0411555666\&quot;,\n        \&quot;Email\&quot;: \&quot;john.smith@imaginaryemail.com\&quot;,\n        \&quot;DealerMarketingAllowedFlag\&quot;: false,\n        \&quot;ContactRelationship\&quot;: \&quot;OSB_CUSTOMER_OWNER\&quot;,\n        \&quot;AlternativeContactName\&quot;: \&quot;Jane Smith\&quot;,\n        \&quot;AlternativeContactNumber\&quot;: \&quot;0396474677\&quot;\n    },\n    \&quot;Comment\&quot;: null,\n    \&quot;BookingSource\&quot;: \&quot;OSB_SOURCE_DEALER_WEBSITE\&quot;,\n    \&quot;ExpressMaintenanceBookingRequest\&quot;: false,\n    \&quot;TransportOption\&quot;: \&quot;OSB_TRANSPORT_OPTION_NONE\&quot;,\n    \&quot;PreferredContactMethod\&quot;: \&quot;OSB_CONTACT_PHONE\&quot;,\n    \&quot;ConfirmationMessageByDMS\&quot;: false\n}&quot;,
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
      <defaultValue>'136872'</defaultValue>
      <description></description>
      <id>de5eadab-8d1c-4bd4-90bf-1b245086885d</id>
      <masked>false</masked>
      <name>BookingID</name>
   </variables>
   <variables>
      <defaultValue>'2018-09-21'</defaultValue>
      <description></description>
      <id>8c29fa83-4ea7-40c4-a56f-2fd9b0351173</id>
      <masked>false</masked>
      <name>Service_Date</name>
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
