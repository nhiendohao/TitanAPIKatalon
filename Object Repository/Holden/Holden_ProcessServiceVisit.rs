<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Holden_ProcessServiceVisit</name>
   <tag></tag>
   <elementGuidId>2146a771-99c2-4644-9ea5-d1be7bb70fda</elementGuidId>
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
                  &lt;tran:ProcessServiceVisit releaseID=&quot;5.6.4&quot; versionID=&quot;5.6.4&quot; systemEnvironmentCode=&quot;Test&quot; languageCode=&quot;en-US&quot;>
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
		            &lt;ns:ProcessServiceVisitDataArea>
					&lt;ns:Process>
						&lt;ns1:ActionCriteria>
							&lt;ns1:ActionExpression actionCode=&quot;Add&quot;>Add&lt;/ns1:ActionExpression>
						&lt;/ns1:ActionCriteria>
					&lt;/ns:Process>
					&lt;ns:ServiceVisit>
						&lt;ns:ServiceVisitHeader>
							&lt;ns:DocumentIdentificationGroup>
								&lt;ns:DocumentIdentification>
									&lt;ns:DocumentID>69246578&lt;/ns:DocumentID>
								&lt;/ns:DocumentIdentification>
							&lt;/ns:DocumentIdentificationGroup>
							&lt;ns:CustomerInfo>
								&lt;ns:AppointmentContactParty>
									&lt;ns:SpecifiedPerson>
										&lt;ns:GivenName>John&lt;/ns:GivenName>
										&lt;ns:FamilyName>Doe&lt;/ns:FamilyName>
										&lt;ns:ResidenceAddress>
											&lt;ns:LineOne>123 Congress Ave&lt;/ns:LineOne>
											&lt;ns:CityName>Austin&lt;/ns:CityName>
											&lt;ns:CountryID>US&lt;/ns:CountryID>
											&lt;ns:Postcode>78704&lt;/ns:Postcode>
											&lt;ns:StateOrProvinceCountrySub-DivisionID>TX&lt;/ns:StateOrProvinceCountrySub-DivisionID>
										&lt;/ns:ResidenceAddress>
										&lt;ns:TelephoneCommunication>
											&lt;ns:ChannelCode>PHONE&lt;/ns:ChannelCode>
											&lt;ns:CompleteNumber>5121234567&lt;/ns:CompleteNumber>
										&lt;/ns:TelephoneCommunication>
										&lt;ns:URICommunication>
											&lt;ns:URIID>John.Doe@noreply.com&lt;/ns:URIID>
											&lt;ns:ChannelCode>EMAIL&lt;/ns:ChannelCode>
										&lt;/ns:URICommunication>
										&lt;ns:ContactMethodTypeCode>Day Phone&lt;/ns:ContactMethodTypeCode>
									&lt;/ns:SpecifiedPerson>
								&lt;/ns:AppointmentContactParty>
							&lt;/ns:CustomerInfo>
							&lt;ns:VehicleInfo>
								&lt;ns:Vehicle>
									&lt;ns:Model>Camaro&lt;/ns:Model>
									&lt;ns:ModelYear>2016&lt;/ns:ModelYear>
									&lt;ns:MakeString>Chevrolet&lt;/ns:MakeString>
									&lt;ns:ManufacturerName>Chevrolet&lt;/ns:ManufacturerName>
								&lt;/ns:Vehicle>
								&lt;ns:InDistanceMeasure unitCode=&quot;mile&quot;>5000&lt;/ns:InDistanceMeasure>
							&lt;/ns:VehicleInfo>
						&lt;/ns:ServiceVisitHeader>
						&lt;ns:ServiceVisitDetail>
							&lt;ns:ServiceAppointment>
								&lt;ns:ServiceVisitAppointmentHeader>
									&lt;ns:DocumentIdentificationGroup>
										&lt;ns:DocumentIdentification>
											&lt;ns:DocumentID>&lt;/ns:DocumentID>
										&lt;/ns:DocumentIdentification>
									&lt;/ns:DocumentIdentificationGroup>
								&lt;/ns:ServiceVisitAppointmentHeader>
								&lt;ns:ServiceVisitAppointmentDetail>
									&lt;ns:Appointment>
										&lt;ns:AppointmentDateTime>2016-05-19T13:00:00.000-04:00&lt;/ns:AppointmentDateTime>
										&lt;ns:AppointmentNotes>Please wash car. Thank you.&lt;/ns:AppointmentNotes>
										&lt;ns:AppointmentStatus>SCHEDULED&lt;/ns:AppointmentStatus>
										&lt;ns:AlternateTransportation>WAIT_AT_DEALER&lt;/ns:AlternateTransportation>
										&lt;ns:EndAppointmentDateTime>2016-05-19T13:10:00.000-04:00&lt;/ns:EndAppointmentDateTime>
										&lt;ns:RequestedService>
											&lt;ns:JobNumberString>A&lt;/ns:JobNumberString>
											&lt;ns:RepeatRepairIndicator>false&lt;/ns:RepeatRepairIndicator>
											&lt;ns:JobTypeString>Customer Pay&lt;/ns:JobTypeString>
											&lt;ns:ServiceLaborScheduling>
												&lt;ns:LaborOperationID>1&lt;/ns:LaborOperationID>
												&lt;ns:LaborOperationIdTypeCode>1234&lt;/ns:LaborOperationIdTypeCode>
												&lt;ns:LaborOperationDescription>Change Oil &amp;amp; Filter&lt;/ns:LaborOperationDescription>
											&lt;/ns:ServiceLaborScheduling>
											&lt;ns:CustomerSalesRequestDescription>Change Oil &amp;amp; Filter&lt;/ns:CustomerSalesRequestDescription>
										&lt;/ns:RequestedService>
										&lt;ns:RequestedService>
											&lt;ns:JobNumberString>B&lt;/ns:JobNumberString>
											&lt;ns:RepeatRepairIndicator>false&lt;/ns:RepeatRepairIndicator>
											&lt;ns:JobTypeString>Customer Pay&lt;/ns:JobTypeString>
											&lt;ns:ServiceLaborScheduling>
												&lt;ns:LaborOperationID>2&lt;/ns:LaborOperationID>
												&lt;ns:LaborOperationIdTypeCode>9401-4&lt;/ns:LaborOperationIdTypeCode>
												&lt;ns:LaborOperationDescription>Alignment&lt;/ns:LaborOperationDescription>
											&lt;/ns:ServiceLaborScheduling>
											&lt;ns:CustomerSalesRequestDescription>Alignment&lt;/ns:CustomerSalesRequestDescription>
										&lt;/ns:RequestedService>
										&lt;ns:ServiceAdvisorParty>
											&lt;ns:PartyID>553058218&lt;/ns:PartyID>
											&lt;ns:DealerManagementSystemID>AH11&lt;/ns:DealerManagementSystemID>
											&lt;ns:SpecifiedPerson>
												&lt;ns:GivenName>Tom&lt;/ns:GivenName>
												&lt;ns:FamilyName>Jones&lt;/ns:FamilyName>
											&lt;/ns:SpecifiedPerson>
										&lt;/ns:ServiceAdvisorParty>
									&lt;/ns:Appointment>
								&lt;/ns:ServiceVisitAppointmentDetail>
							&lt;/ns:ServiceAppointment>
						&lt;/ns:ServiceVisitDetail>
					&lt;/ns:ServiceVisit>
				&lt;/ns:ProcessServiceVisitDataArea>	
                  &lt;/tran:ProcessServiceVisit>
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
