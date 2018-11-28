<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>RepairOrderPut_JSON</name>
   <tag></tag>
   <elementGuidId>6027536f-6787-4552-b57b-1d082d202ad6</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;repairOrderNumber\&quot;: \&quot;${obj_ROId}\&quot;,\n  \&quot;repairOrderStatus\&quot;: \&quot;${obj_ROStatus}\&quot;,\n  \&quot;createdDateTime\&quot;: \&quot;${obj_ServiceDate}T12:00:00.00\&quot;,\n  \&quot;booking\&quot;: {\n    \&quot;bookingReference\&quot;: \&quot;\&quot;,\n    \&quot;MRSPrompt\&quot;: false,\n    \&quot;BookingSrc\&quot;: \&quot;\&quot;,\n    \&quot;transportOption\&quot;: null,\n    \&quot;bookingDateTime\&quot;: \&quot;${obj_ServiceDate}T08:00:00\&quot;,\n    \&quot;estimatedDropOffDateTime\&quot;: \&quot;${obj_ServiceDate}T09:00:00\&quot;,\n    \&quot;estimatedPickupDateTime\&quot;: \&quot;${obj_ServiceDate}T17:00:00\&quot;,\n    \&quot;serviceOperation\&quot;: null\n  },\n  \&quot;vehicle\&quot;: {\n    \&quot;VIN\&quot;: \&quot;${obj_VIN}\&quot;,\n    \&quot;registration\&quot;: \&quot;${obj_REGNumber}\&quot;,\n    \&quot;registrationState\&quot;: \&quot;${obj_REGState}\&quot;,\n    \&quot;${obj_mileage}\&quot;: 0,\n    \&quot;totalPurchased\&quot;: 51513.52\n\n  },\n  \&quot;location\&quot;: {\n    \&quot;dealerCode\&quot;: \&quot;18041901\&quot;,\n    \&quot;tmcaDealerCode\&quot;: \&quot;${obj_tmcaDealerCode}\&quot;,\n    \&quot;dealerName\&quot;: \&quot;${obj_DealerName}\&quot;,\n    \&quot;branchCode\&quot;: \&quot;1\&quot;,\n    \&quot;tmcaBranchCode\&quot;: \&quot;${obj_tmcaBranchCode}\&quot;,\n    \&quot;branchName\&quot;: \&quot;${obj_BranchName}\&quot;,\n    \&quot;department\&quot;: \&quot;Service\&quot;,\n    \&quot;dms\&quot;: \&quot;${obj_DMS}\&quot;\n  },\n  \&quot;contacts\&quot;: [\n    {\n      \&quot;dmsCustId\&quot;: \&quot;${obj_ContactId}\&quot;,\n      \&quot;firstName\&quot;: \&quot;${obj_FirstName}\&quot;,\n      \&quot;lastName\&quot;: \&quot;${obj_LastName}\&quot;,\n      \&quot;mobileNumber\&quot;: \&quot;${obj_MobileNumber}\&quot;,\n      \&quot;homePhone\&quot;: \&quot;08 1804 1901\&quot;,\n      \&quot;businessPhone\&quot;: null,\n      \&quot;email\&quot;: \&quot;QATeam@titandms.com.au\&quot;,\n      \&quot;address\&quot;: {\n        \&quot;street1\&quot;: \&quot;182 Le Dai Hanh\&quot;,\n        \&quot;street2\&quot;: \&quot;\&quot;,\n        \&quot;suburb\&quot;: \&quot;District 11\&quot;,\n        \&quot;state\&quot;: \&quot;Ho Chi Minh\&quot;,\n        \&quot;postcode\&quot;: \&quot;6600\&quot;\n      }\n    }\n  ],\n  \&quot;jobs\&quot;: [\n    {\n      \&quot;jobNumber\&quot;: \&quot;${obj_jobNumber}\&quot;,\n      \&quot;quotedPrice\&quot;: 0.0,\n      \&quot;actualPrice\&quot;: 193.00,\n      \&quot;serviceOperation\&quot;: {\n        \&quot;category\&quot;: \&quot;${obj_jobCategory}\&quot;,\n        \&quot;serviceType\&quot;: \&quot;${obj_jobServiceType}\&quot;,\n        \&quot;type\&quot;: \&quot;Dealer\&quot;,\n        \&quot;codeType\&quot;: \&quot;${obj_jobCodeType}\&quot;,\n        \&quot;code\&quot;: \&quot;${obj_jobCode}\&quot;,\n        \&quot;description\&quot;: \&quot;${obj_jobStatus}\&quot;\n      },\n      \&quot;status\&quot;: \&quot;Scheduled\&quot;,\n      \&quot;startDateTime\&quot;: null,\n      \&quot;completionDateTime\&quot;: null,\n      \&quot;labour\&quot;: {\n        \&quot;labourHoursAvailable\&quot;: 0.9000,\n        \&quot;labourHoursClocked\&quot;: 0.0,\n        \&quot;labourHoursTotal\&quot;: 0.0,\n        \&quot;labourRate\&quot;: 120.0000,\n        \&quot;labourHoursSold\&quot;: 0.90,\n        \&quot;labourValueSold\&quot;: 55.96\n      },\n      \&quot;sundries\&quot;: [\n        {\n          \&quot;displayName\&quot;: \&quot;Waste Removal \u0026 Environmental\&quot;,\n          \&quot;quantity\&quot;: 1.00,\n          \&quot;unitPrice\&quot;: 13.0,\n          \&quot;totalPrice\&quot;: 13.00\n        }\n      ],\n      \&quot;inclusions\&quot;: [],\n      \&quot;parts\&quot;: [\n        {\n          \&quot;partNumber\&quot;: \&quot;G001770A2\&quot;,\n          \&quot;displayName\&quot;: \&quot;FUEL ADDITIVE, PETROL ENG\&quot;,\n          \&quot;quantity\&quot;: 1,\n          \&quot;unitPrice\&quot;: 28.00,\n          \&quot;totalPrice\&quot;: 28.00\n        }\n      ],\n      \&quot;comments\&quot;: [\n\t      \t{\n\t      \t\&quot;body\&quot;: \&quot;Testing\&quot;,\n\t      \t\&quot;authorRole\&quot;: \&quot;guest\&quot;,\n\t      \t\&quot;visibleToGuest\&quot;: true,\n\t      \t\&quot;author\&quot;: \&quot;VinhQA\&quot;\n\t      \t}\n      \t],\n      \&quot;notes\&quot;: []\n    }\n  ],\n  \&quot;summaryTimestamps\&quot;: null,\n  \&quot;sublets\&quot;: [],\n  \&quot;consumables\&quot;: []\n}&quot;,
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
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>https://api-uat.toyota.com.au/ws/rest/services/repair-orders/${obj_ROId}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.Glb_Booking_ID</defaultValue>
      <description></description>
      <id>8826e3ec-679f-4bcf-951f-705a33daed59</id>
      <masked>false</masked>
      <name>obj_ROId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_ROStatus</defaultValue>
      <description></description>
      <id>c265817a-73bb-4ea5-ace7-cbdaa61eef25</id>
      <masked>false</masked>
      <name>obj_ROStatus</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_ServiceDate</defaultValue>
      <description></description>
      <id>32035d48-f50f-4794-89dd-c3fb9a8f4ff5</id>
      <masked>false</masked>
      <name>obj_ServiceDate</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_VIN</defaultValue>
      <description></description>
      <id>ce5f7e03-a034-4a87-886b-b53b8a0256f7</id>
      <masked>false</masked>
      <name>obj_VIN</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_REGNumber</defaultValue>
      <description></description>
      <id>42fea0a7-4cb7-43c4-b199-28dbc0ce0425</id>
      <masked>false</masked>
      <name>obj_REGNumber</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_REGState</defaultValue>
      <description></description>
      <id>b45a61bb-f175-40c1-820b-fa910f848894</id>
      <masked>false</masked>
      <name>obj_REGState</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_mileage</defaultValue>
      <description></description>
      <id>54aa6249-f743-440e-958a-0bf86d84befa</id>
      <masked>false</masked>
      <name>obj_mileage</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_tmcaDealerCode</defaultValue>
      <description></description>
      <id>ca76759c-91b1-4f5a-9c71-de44c6c77cd7</id>
      <masked>false</masked>
      <name>obj_tmcaDealerCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_DealerName</defaultValue>
      <description></description>
      <id>8315a7d6-cb26-42a8-b1d0-e84cddb4558d</id>
      <masked>false</masked>
      <name>obj_DealerName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_tmcaBranchCode</defaultValue>
      <description></description>
      <id>02fafe31-a6b2-4735-80b1-4f4a080e4aec</id>
      <masked>false</masked>
      <name>obj_tmcaBranchCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_BranchName</defaultValue>
      <description></description>
      <id>0e62bbde-2566-42d5-92c3-8d945483e6a6</id>
      <masked>false</masked>
      <name>obj_BranchName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_DMS</defaultValue>
      <description></description>
      <id>41b451de-5b56-4aac-92ba-833b14d54ee1</id>
      <masked>false</masked>
      <name>obj_DMS</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_ContactId</defaultValue>
      <description></description>
      <id>3e8a188e-978e-45ad-ac5e-d3db966acf6f</id>
      <masked>false</masked>
      <name>obj_ContactId</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_FirstName</defaultValue>
      <description></description>
      <id>58ce126f-b131-4e6f-a8ac-2a0e12194635</id>
      <masked>false</masked>
      <name>obj_FirstName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_LastName</defaultValue>
      <description></description>
      <id>756345bb-6ea5-4ce9-a269-eb59f0dc741a</id>
      <masked>false</masked>
      <name>obj_LastName</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_MobileNumber</defaultValue>
      <description></description>
      <id>2e2b2ffa-3df4-40b3-8014-1069df5ccc4a</id>
      <masked>false</masked>
      <name>obj_MobileNumber</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_jobNumber</defaultValue>
      <description></description>
      <id>18785c76-9be1-4003-a1cb-9d6c1ba057f6</id>
      <masked>false</masked>
      <name>obj_jobNumber</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_jobCategory</defaultValue>
      <description></description>
      <id>98d94e65-b358-4024-8e21-3652c231b523</id>
      <masked>false</masked>
      <name>obj_jobCategory</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_jobServiceType</defaultValue>
      <description></description>
      <id>85de6655-a4d6-471d-a394-1f9fa8c4e70b</id>
      <masked>false</masked>
      <name>obj_jobServiceType</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_CodeType</defaultValue>
      <description></description>
      <id>328095b5-77b4-4117-b5d3-4710820b1363</id>
      <masked>false</masked>
      <name>obj_jobCodeType</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_jobCode</defaultValue>
      <description></description>
      <id>54eb9927-cad3-4321-ba58-cf647bba19b6</id>
      <masked>false</masked>
      <name>obj_jobCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_His_jobDescription</defaultValue>
      <description></description>
      <id>40d73998-8e65-40f0-a0ed-48a14a175f41</id>
      <masked>false</masked>
      <name>obj_jobStatus</name>
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
