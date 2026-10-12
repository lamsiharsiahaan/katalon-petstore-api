<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Post_API_Pet</name>
   <tag></tag>
   <elementGuidId>e5b209af-0cfb-4677-9393-b323369b5884</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <smartLocatorEnabled>false</smartLocatorEnabled>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>true</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;id\&quot;: ${petId},\n  \&quot;category\&quot;: {\n    \&quot;id\&quot;: 15,\n    \&quot;name\&quot;: \&quot;Rocky\&quot;\n  },\n  \&quot;name\&quot;: \&quot;doggie\&quot;,\n  \&quot;photoUrls\&quot;: [\n    \&quot;string\&quot;\n  ],\n  \&quot;tags\&quot;: [\n    {\n      \&quot;id\&quot;: 15,\n      \&quot;name\&quot;: \&quot;cuttie\&quot;\n    }\n  ],\n  \&quot;status\&quot;: \&quot;${petStatus}\&quot;\n}&quot;,
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
      <webElementGuid>33eed2f1-aa19-4495-9d48-dae76f0ff689</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Accept</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>37465281-628c-4f93-bd63-7873decc4895</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>11.4.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <path></path>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://petstore.swagger.io/v2/pet</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>'0'</defaultValue>
      <description></description>
      <id>3147a425-8507-41d5-8d79-ed936d4d8f8d</id>
      <masked>false</masked>
      <name>petId</name>
   </variables>
   <variables>
      <defaultValue>'doggie'</defaultValue>
      <description></description>
      <id>bae73434-f55a-4722-9de1-357332f7bffb</id>
      <masked>false</masked>
      <name>petName</name>
   </variables>
   <variables>
      <defaultValue>'available'</defaultValue>
      <description></description>
      <id>d7c42352-67f8-43e3-b183-c8da222764db</id>
      <masked>false</masked>
      <name>petStatus</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
