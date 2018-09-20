<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Holden_SearchServiceVisit</name>
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
                  &lt;tran:SearchServiceVisit releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
                     &lt;!--Optional:-->
                     &lt;ns:ApplicationArea>
						&lt;ns:Sender>
							&lt;ns:CreatorNameCode>GM&lt;/ns:CreatorNameCode>
							&lt;ns:SenderNameCode>OSS&lt;/ns:SenderNameCode>
							&lt;ns:DealerNumberID>111148&lt;/ns:DealerNumberID>
							&lt;ns:DealerCountryCode>US&lt;/ns:DealerCountryCode>
							&lt;ns:LanguageCode>en-US&lt;/ns:LanguageCode>
						&lt;/ns:Sender>
						&lt;ns:CreationDateTime>2016-05-17T09:41:01.673-04:00&lt;/ns:CreationDateTime>
						&lt;ns:Signature/>
						&lt;ns:BODID>5ab690dd-4580-4b00-b988-f826b83c44ca&lt;/ns:BODID>
						&lt;ns:Destination>
							&lt;ns:DestinationNameCode>QI&lt;/ns:DestinationNameCode>
							&lt;ns:DestinationSoftwareCode>QI&lt;/ns:DestinationSoftwareCode>
							&lt;ns:DestinationSoftware>QI&lt;/ns:DestinationSoftware>
							&lt;ns:DealerNumberID>111148&lt;/ns:DealerNumberID>
							&lt;ns:DealerTargetCountry>US&lt;/ns:DealerTargetCountry>
						&lt;/ns:Destination>
					&lt;/ns:ApplicationArea>
                     &lt;!--Optional:-->
                     &lt;ns:SearchServiceVisitDataArea>
                        &lt;!--Optional:-->
                        &lt;ns:Get uniqueIndicator=&quot;true&quot;>
                           &lt;!--Optional:-->
                           &lt;ns:Expression/>
                        &lt;/ns:Get>
                        &lt;!--Optional:-->
                        &lt;ns:SearchServiceVisitDataCriteria>
                           &lt;!--Optional:-->
                           &lt;ns:SearchField>DateLastModified&lt;/ns:SearchField>
                           &lt;ns:BeginDateTime>2018-07-31T00:00:00.000-00:00&lt;/ns:BeginDateTime>
                           &lt;ns:EndDateTime>2018-07-31T00:00:00.000-23:59&lt;/ns:EndDateTime>
                        &lt;/ns:SearchServiceVisitDataCriteria>
                     &lt;/ns:SearchServiceVisitDataArea>
                  &lt;/tran:SearchServiceVisit>
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
