<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Holden_06_SearchServiceVisit</name>
   <tag></tag>
   <elementGuidId>44ba2824-1df4-4041-9bb2-6a1f17d9b2f8</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;soapenv:Envelope xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot; xmlns:wsse=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd&quot; xmlns:wsu=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd&quot; xmlns:tran=&quot;http://www.starstandards.org/webservices/2009/transport&quot; xmlns:ns=&quot;http://www.starstandard.org/STAR/5&quot; xmlns:ns1=&quot;http://www.openapplications.org/oagis/9&quot;>
   &lt;soapenv:Header>
      &lt;wsse:Security>
         &lt;!--Optional:-->
         &lt;wsu:Timestamp Id=&quot;Timestamp-f1272c36-8b22-41e4-9962-4028429e5315&quot;>
            &lt;wsu:Created>2016-05-17T13:41:04.083Z&lt;/wsu:Created>
            &lt;wsu:Expires>2016-05-17T13:46:04.083Z&lt;/wsu:Expires>
         &lt;/wsu:Timestamp>
         &lt;!--Optional:-->
         &lt;wsse:UsernameToken wsu:Id=&quot;UsernameToken-736fa6d4-6cda-4f4f-b8e6-2c068ede4cf2&quot;>
            &lt;!--Optional:-->
            &lt;wsse:Username>sysad&lt;/wsse:Username>
            &lt;!--Optional:-->
            &lt;wsse:Password Type=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText&quot;>sysad&lt;/wsse:Password>
            &lt;!--Optional:-->
            &lt;wsse:Nonce EncodingType=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary&quot;>sysad&lt;/wsse:Nonce>
            &lt;wsu:Created>2016-05-17T13:41:04.129Z&lt;/wsu:Created>
         &lt;/wsse:UsernameToken>
         &lt;!--Optional:-->
         &lt;wsse:BinarySecurityToken EncodingType=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary&quot; ValueType=&quot;http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-token-profile-1.0#X509&quot; wsu:Id=&quot;x509cert00&quot;>
MIIC+DCCAeCgAwIBAgIQfltWZ4+cJb5OShl7HFO4lDANBgkqhkiG9w0BAQsFADAl
MSMwIQYDVQQDExpIQ00tREVWLVdFQi50aXRhbmRtcy5sb2NhbDAeFw0xODA5MjQw
MzUxMjJaFw0xOTA5MjQwMDAwMDBaMCUxIzAhBgNVBAMTGkhDTS1ERVYtV0VCLnRp
dGFuZG1zLmxvY2FsMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuBWf
Jyr4KqmbieRceUVlEgTrlRMOpwcaS4g604TaTBaXHbkOATt2WO0u1Psk1ff0uw6m
oTujDDghdAoHaCM5LEFSliffD9SAN3xoWkXrVZqf9RFOMZJh2ZNpLSfGtnBhcibt
M0A1f77ue2c17SmR4fJ/E/nlW5pSNtRNYju7MmmnSyIyhbDXc9R55F6fBQZWxHz5
EHhvZuB71zlwr0Q85QBBGvnf4Erai0iTWhtDUaWNyzfSL485U1xxEN7jRlABOikp
CNLNC3rtLXkFbkPopiaEBdkDWWVvwUgSmtyhYrqjsyGSNR94K7x3Mle7Td64ve6n
FT7qSMpt/Y3M+ulYRwIDAQABoyQwIjALBgNVHQ8EBAMCBDAwEwYDVR0lBAwwCgYI
KwYBBQUHAwEwDQYJKoZIhvcNAQELBQADggEBAB90tsS1S2/8p1W1aFlE8O5PE4XL
dveCNbuZAYiK26W1gqQNs0Bh0yBj7LDernsEXzbG/st2wm/8PO+STJP5telsAYpl
+bqu6ZpOApA4LD4oyanYelwwBq2XeG3WDqLB9mI8AIR2nxtEqAhEazkE2ygJtg4I
q4WDHGGGwBDcd49E7YgjDrMK1kZbXYdly1OtBvc3FbLZ13texNbxNRRn5GhDk8UH
IiVxWWBkLbvUK/Ps61Zm1vBLS+1RoZnvGJiNMXGPGwTwf8wAQ8fyK8I6Nt/tCL1P
sdpxgYSkV0O8aLijdskqX1IklBTR61eOhmzBh9V0SAMxV+mfZD8i4uy2LEk=&lt;/wsse:BinarySecurityToken>
      &lt;/wsse:Security>
   &lt;/soapenv:Header>
   &lt;soapenv:Body>
      &lt;tran:ProcessMessage>
            &lt;!--Optional:-->
            &lt;tran:payload>
               &lt;!--Optional:-->
               &lt;tran:content id=&quot;0&quot;>
               &lt;!--Optional:-->
                  &lt;ns:SearchServiceVisit releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
                     &lt;!--Optional:-->
                     &lt;ns:ApplicationArea>
						&lt;ns:Sender>
							&lt;ns:CreatorNameCode>GM&lt;/ns:CreatorNameCode>
							&lt;ns:SenderNameCode>OSS&lt;/ns:SenderNameCode>
							&lt;ns:DealerNumberID>${obj_DealerCode}&lt;/ns:DealerNumberID>
							&lt;ns:DealerCountryCode>US&lt;/ns:DealerCountryCode>
							&lt;ns:LanguageCode>en-US&lt;/ns:LanguageCode>
						&lt;/ns:Sender>
						&lt;ns:CreationDateTime>2016-05-17T09:41:01.673-04:00&lt;/ns:CreationDateTime>
						&lt;ns1:Signature/>
						&lt;ns:BODID>5ab690dd-4580-4b00-b988-f826b83c44ca&lt;/ns:BODID>
						&lt;ns:Destination>
							&lt;ns:DestinationNameCode>QI&lt;/ns:DestinationNameCode>
							&lt;ns:DestinationSoftwareCode>QI&lt;/ns:DestinationSoftwareCode>
							&lt;ns:DestinationSoftware>QI&lt;/ns:DestinationSoftware>
							&lt;ns:DealerNumberID>${obj_DealerCode}&lt;/ns:DealerNumberID>
							&lt;ns:DealerTargetCountry>US&lt;/ns:DealerTargetCountry>
						&lt;/ns:Destination>
					&lt;/ns:ApplicationArea>
                     &lt;!--Optional:-->
                     &lt;ns:SearchServiceVisitDataArea>
                        &lt;!--Optional:-->
                        &lt;ns:Get uniqueIndicator=&quot;true&quot;>
                           &lt;!--Optional:-->
                           &lt;ns1:Expression/>
                        &lt;/ns:Get>
                        &lt;!--Optional:-->
                        &lt;ns:SearchServiceVisitDataCriteria>
                           &lt;!--Optional:-->
                           &lt;ns:SearchField>DateLastModified&lt;/ns:SearchField>
                           &lt;ns:BeginDateTime>${obj_StartSearchDate}&lt;/ns:BeginDateTime>
                           &lt;ns:EndDateTime>${obj_EndSearchDate}&lt;/ns:EndDateTime>
                        &lt;/ns:SearchServiceVisitDataCriteria>
                     &lt;/ns:SearchServiceVisitDataArea>
                  &lt;/ns:SearchServiceVisit>
                &lt;/tran:content>
            &lt;/tran:payload>
      &lt;/tran:ProcessMessage>
   &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>ProcessMessage</soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.Glb_Dealer_Code</defaultValue>
      <description></description>
      <id>53e1fee3-9d66-4bf5-a69c-d3a93f9ddebc</id>
      <masked>false</masked>
      <name>obj_DealerCode</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_StartSearchDate</defaultValue>
      <description></description>
      <id>21358620-cadf-4705-9c3b-70acc129a818</id>
      <masked>false</masked>
      <name>obj_StartSearchDate</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Glb_EndSearchDate</defaultValue>
      <description></description>
      <id>fe6f375e-2a37-46fe-b57b-2d79c6e5fa8f</id>
      <masked>false</masked>
      <name>obj_EndSearchDate</name>
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
   <wsdlAddress>http://hcm-dev-testing.titandms.net.au:55551/NightlyBuildManufacturerInterfacesFacade/HoldenManufacturerInterface.asmx?WSDL</wsdlAddress>
</WebServiceRequestEntity>
