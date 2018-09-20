<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Holden_Get LaborOperations</name>
   <tag></tag>
   <elementGuidId>df753491-4e49-4a6f-85ac-5cb24a52b1bd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <restRequestMethod></restRequestMethod>
   <restUrl></restUrl>
   <serviceType>SOAP</serviceType>
   <soapBody>&lt;soapenv:Envelope xmlns:soapenv=&quot;http://schemas.xmlsoap.org/soap/envelope/&quot; xmlns:tem=&quot;http://tempuri.org/&quot; xmlns:tran=&quot;http://www.starstandards.org/webservices/2009/transport&quot; xmlns:ns=&quot;http://www.starstandard.org/STAR/5&quot; xmlns:ns1=&quot;http://www.openapplications.org/oagis/9&quot;>
   &lt;soapenv:Header/>
   &lt;soapenv:Body>
      &lt;tem:ProcessMessage>
         &lt;!--Optional:-->
         &lt;tran:processMessage>
            &lt;!--Optional:-->
            &lt;tran:payload>
               &lt;!--Optional:-->
               &lt;tran:content id=&quot;0&quot;>
                  &lt;!--Optional:-->
                  &lt;tran:GetLaborOperations releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
                     &lt;!--Optional:-->
                     &lt;ns:ApplicationArea>
                        &lt;!--Optional:-->
                        &lt;ns:Sender>
                           &lt;!--Optional:-->
                           &lt;ns:CreatorNameCode>GM&lt;/ns:CreatorNameCode>
                           &lt;!--Optional:-->
                           &lt;ns:SenderNameCode>OSS&lt;/ns:SenderNameCode>
                           &lt;!--Optional:-->
                           &lt;ns:DealerNumberID>111148&lt;/ns:DealerNumberID>
                           &lt;!--Optional:-->
                           &lt;ns:DealerCountryCode>US&lt;/ns:DealerCountryCode>
                           &lt;!--Optional:-->
                           &lt;ns:LanguageCode>en-US&lt;/ns:LanguageCode>
                        &lt;/ns:Sender>
                        &lt;ns:CreationDateTime>2016-05-17T13:21:12.582-04:00&lt;/ns:CreationDateTime>
                        &lt;!--Optional:-->
                        &lt;ns:Signature/>
                        &lt;!--Optional:-->
                        &lt;ns:BODID>1a122bf9-558f-45a7-b2c4-bdf7396a5b60&lt;/ns:BODID>
                        &lt;!--Optional:-->
                        &lt;ns:Destination>
                           &lt;!--Optional:-->
                           &lt;ns:DestinationNameCode>QI&lt;/ns:DestinationNameCode>
                           &lt;!--Optional:-->
                           &lt;ns:DestinationSoftwareCode>QI&lt;/ns:DestinationSoftwareCode>
                           &lt;!--Optional:-->
                           &lt;ns:DestinationSoftware>QI&lt;/ns:DestinationSoftware>
                           &lt;ns:DealerNumberID>111148&lt;/ns:DealerNumberID>
                           &lt;!--Optional:-->
                           &lt;ns:DealerTargetCountry>US&lt;/ns:DealerTargetCountry>
                        &lt;/ns:Destination>
                     &lt;/ns:ApplicationArea>
                     &lt;!--Optional:-->
                     &lt;ns:GetLaborOperationsDataArea>
                        &lt;!--Optional:-->
                        &lt;ns:Get uniqueIndicator=&quot;true&quot;>
                           &lt;!--Optional:-->
                           &lt;ns:Expression/>
                        &lt;/ns:Get>
                        &lt;!--Optional:-->
                        &lt;ns:LaborOperations>
                           &lt;!--Optional:-->
                           &lt;ns:LaborOperationsHeader>
                              &lt;!--Optional:-->
                              &lt;ns:LaborOperationsHeaderBase>
                                 &lt;!--Optional:-->
                                 &lt;ns:DocumentIdentificationGroup>
                                    &lt;!--Optional:-->
                                    &lt;ns:DocumentIdentification>
                                       &lt;!--Optional:-->
                                       &lt;ns:DocumentID>0&lt;/ns:DocumentID>
                                    &lt;/ns:DocumentIdentification>
                                 &lt;/ns:DocumentIdentificationGroup>
                              &lt;/ns:LaborOperationsHeaderBase>
                           &lt;/ns:LaborOperationsHeader>
                        &lt;/ns:LaborOperations>
                     &lt;/ns:GetLaborOperationsDataArea>
                  &lt;/tran:GetLaborOperations>
                  &lt;/tran:content>
            &lt;/tran:payload>
         &lt;/tran:processMessage>
      &lt;/tem:ProcessMessage>
   &lt;/soapenv:Body>
&lt;/soapenv:Envelope></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod>SOAP</soapRequestMethod>
   <soapServiceFunction>ProcessMessage</soapServiceFunction>
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
