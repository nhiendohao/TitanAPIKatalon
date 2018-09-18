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
  &quot;text&quot;: &quot;{\n    \&quot;Vehicle\&quot;: {\n        \&quot;VIN\&quot;: \&quot;JTDKB3FU703535140\&quot;,\n        \&quot;RegistrationNumber\&quot;: \&quot;REG12121240\&quot;,\n        \&quot;RegistrationState\&quot;: \&quot;OSB_STATE_VIC\&quot;,\n        \&quot;CustomerOdometerReading\&quot;: 20500,\n        \&quot;VehicleInformation\&quot;: {\n            \&quot;VehicleDetail\&quot;: [\n                {\n                    \&quot;Key\&quot;: 0,\n                    \&quot;Value\&quot;: \&quot;TOYOTA\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 1,\n                    \&quot;Value\&quot;: \&quot;Corolla Sedan\&quot;\n                },\n                {\n                    \&quot;Key\&quot;: 3,\n                    \&quot;Value\&quot;: \&quot;2016-09\&quot;\n                }\n            ]\n        }\n    },\n    \&quot;RepairOrder\&quot;: {\n        \&quot;TotalPriceQuoted\&quot;: 110,\n        \&quot;TotalDuration\&quot;: 1.5,\n        \&quot;Services\&quot;: [\n            {\n                \&quot;Name\&quot;: \&quot;VW105 - Carry out 105,000km service as per VW schedule\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;OSB_SERVICE_TYPE_LOGBOOK\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;VW105\&quot;,\n                \&quot;Duration\&quot;: 1,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 110\n            },\n            {\n                \&quot;Name\&quot;: \&quot;Car Wash\&quot;,\n                \&quot;Description\&quot;: null,\n                \&quot;ServiceType\&quot;: \&quot;OSB_SERVICE_TYPE_ADDITIONAL\&quot;,\n                \&quot;ServiceCode\&quot;: null,\n                \&quot;DMSOperationalCode\&quot;: \&quot;CARWASH\&quot;,\n                \&quot;Duration\&quot;: 0.5,\n                \&quot;EMFlag\&quot;: false,\n                \&quot;EMDuration\&quot;: 0,\n                \&quot;DealerPrice\&quot;: 0,\n                \&quot;POAFlag\&quot;: false,\n                \&quot;Price\&quot;: 0\n            }\n        ]\n    },\n    \&quot;Appointment\&quot;: {\n        \&quot;BookingDate\&quot;: \&quot;2018-09-17T00:00:00\&quot;,\n        \&quot;DropOffTime\&quot;: \&quot;08:00\&quot;,\n        \&quot;PickUpTime\&quot;: \&quot;17:00\&quot;,\n        \&quot;XReserveToken\&quot;: 14,\n        \&quot;ServiceBayType\&quot;: \&quot;PERIODIC\&quot;\n    },\n    \&quot;Contact\&quot;: {\n        \&quot;ToyotaContactID\&quot;: \&quot;43054\&quot;,\n        \&quot;FirstName\&quot;: \&quot;John\&quot;,\n        \&quot;LastName\&quot;: \&quot;Smith\&quot;,\n        \&quot;PhoneNumber\&quot;: \&quot;0411555666\&quot;,\n        \&quot;Email\&quot;: \&quot;john.smith@imaginaryemail.com\&quot;,\n        \&quot;DealerMarketingAllowedFlag\&quot;: false,\n        \&quot;ContactRelationship\&quot;: \&quot;OSB_CUSTOMER_OWNER\&quot;,\n        \&quot;AlternativeContactName\&quot;: \&quot;Jane Smith\&quot;,\n        \&quot;AlternativeContactNumber\&quot;: \&quot;0396474677\&quot;\n    },\n     \&quot;Comment\&quot;: {\n\t    \&quot;CommentLine\&quot;: [\n\t      \&quot;Engine\&quot;,\n\t      \&quot;Engine gives a rough sound when sharply braking from 100 km/h.\&quot;\n\t    ]\n\t  },\n    \&quot;BookingSource\&quot;: null,\n    \&quot;ExpressMaintenanceBookingRequest\&quot;: false,\n    \&quot;TransportOption\&quot;: 3,\n    \&quot;PreferredContactMethod\&quot;: 0,\n    \&quot;ConfirmationMessageByDMS\&quot;: false\n}&quot;,
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
      <value></value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://hcm-dev-web/ThirdPartyAPIGetway/api/v1/dealers/765A/locations/1/services</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
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
