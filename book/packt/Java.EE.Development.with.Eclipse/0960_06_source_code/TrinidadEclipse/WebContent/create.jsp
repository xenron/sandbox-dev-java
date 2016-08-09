<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib
uri="http://myfaces.apache.org/trinidad" prefix="tr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create a Catalog Entry</title>
</head>
<body>
<f:view>
  <tr:document id="d1" binding="#{catalog.d1}">
    <tr:form id="f1" binding="#{catalog.f1}">
      <h1>
        <font color="#6363ff" face="Verdana">
          Create a Catalog Entry
        </font>
        &nbsp;
      </h1> 
        <h1>
        <tr:panelFormLayout binding="#{catalog.pfl1}" id="pfl1">
          <f:facet name="form">
            <tr:group binding="#{catalog.g1}" id="g1">
<tr:inputText label="Catalog Id" value="#{catalog.input1}"
                        id="it1"/>
<tr:inputText label="Journal" value="#{catalog.input2}"
                            id="it2"/>
<tr:inputText label="Publisher" value="#{catalog.input3}"
                            id="it3"/>
<tr:inputText label="Edition" value="#{catalog.input4}"
                            id="it4"/>
<tr:inputText label="Title" value="#{catalog.input5}"
                            id="it5"/>
<tr:inputText label="Author" value="#{catalog.input6}"
                            id="it6"/>
              <tr:commandButton text="Create"
                                binding="#{catalog.cb1}" id="cb1"
                                action="#{catalog.cb1_action}"/>
            </tr:group>
          </f:facet>
          
        </tr:panelFormLayout>
      </h1></tr:form>
  </tr:document>
</f:view>
</body>
</html>
