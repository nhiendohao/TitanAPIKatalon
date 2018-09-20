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
  &quot;text&quot;: &quot;{\n    \&quot;Vehicle\&quot;: {\n        \&quot;VIN\&quot;: \&quot;${VIN}\&quot;,\n        \&quot;RegistrationNumber\&quot;: \&quot;${REGNumber}\&quot;,\n        \&quot;RegistrationState\&quot;: \&quot;OSB_STATE_VIC\&quot;,\n        \&quot;CustomerOdometerReading\&quot;: 20500,\n        \&quot;VehicleInformation\&quot;: {\n            \&quot;VehicleDetail\&quot;: [\n                {\n                    \&quot;Key\&quot;: 0,\n                    \&quot;Value\&quot;: \&quot;TOYOTA\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 1,\n                    \&quot;Value\&quot;: \&quot;Corolla Sedan\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 3,\n                    \&quot;Value\&quot;: \&quot;2016-09\&quot;\n                }\n            ]\n        }\n    },\n    \&quot;RepairOrder\&quot;: {\n        \&quot;TotalPriceQuoted\&quot;: 110,\n        \&quot;TotalDuration\&quot;: 1,\n        \&quot;Services\&quot;: [\n            {\n                \&quot;Name\&quot;: \&quot;VW105 - Carry out 105,000km service as per VW schedule\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;OSB_SERVICE_TYPE_LOGBOOK\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;VW105\&quot;,\n                \&quot;Duration\&quot;: 1,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 110\n            }\n         ]   \n        \n    },\n    \&quot;Appointment\&quot;: {\n        \&quot;BookingDate\&quot;: \&quot;${Service_Date}T00:00:00\&quot;,\n        \&quot;DropOffTime\&quot;: \&quot;${Drop_Off_Time}\&quot;,\n        \&quot;PickUpTime\&quot;: \&quot;${Pick_Up_Time}\&quot;,\n        \&quot;XReserveToken\&quot;: ${Reserve_Token},\n        \&quot;ServiceBayType\&quot;: \&quot;${ServiceBay_Time}\&quot;\n    },\n    \&quot;Contact\&quot;: {\n        \&quot;ToyotaContactID\&quot;: \&quot;43054\&quot;,\n        \&quot;FirstName\&quot;: \&quot;John\&quot;,\n        \&quot;LastName\&quot;: \&quot;Smith\&quot;,\n        \&quot;PhoneNumber\&quot;: \&quot;0411555666\&quot;,\n        \&quot;Email\&quot;: \&quot;john.smith@imaginaryemail.com\&quot;,\n        \&quot;DealerMarketingAllowedFlag\&quot;: false,\n        \&quot;ContactRelationship\&quot;: \&quot;OSB_CUSTOMER_OWNER\&quot;,\n        \&quot;AlternativeContactName\&quot;: \&quot;Jane Smith\&quot;,\n        \&quot;AlternativeContactNumber\&quot;: \&quot;0396474677\&quot;\n    },\n     \&quot;Comment\&quot;: {\n\t    \&quot;CommentLine\&quot;: [\n\t      \&quot;Engine\&quot;,\n\t      \&quot;Engine gives a rough sound when sharply braking from 100 km/h.\&quot;\n\t    ]\n\t  },\n    \&quot;BookingSource\&quot;: null,\n    \&quot;ExpressMaintenanceBookingRequest\&quot;: false,\n    \&quot;TransportOption\&quot;: 3,\n    \&quot;PreferredContactMethod\&quot;: 0,\n    \&quot;ConfirmationMessageByDMS\&quot;: false\n}&quot;,
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
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/${Dealer_Code}/locations/${Location_Code}/services</restUrl>
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
