<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.leftAlign { text-align: left;}
.rightAlign { text-align: right;}
</style>
<title>Enter Customer Data</title>
</head>
<body>
<f:view>
  <h:form>
    <h:messages style="color: red;"></h:messages>
    <h:panelGrid columns="2" columnClasses="rightAlign,leftAlign">
      <h:outputText value="First Name:">
      </h:outputText>
      <h:inputText label="First Name" value="#{Customer.firstName}"
        required="true">
        <f:validateLength minimum="2" maximum="30"></f:validateLength>
      </h:inputText>
      <h:outputText value="Last Name:"></h:outputText>
      <h:inputText label="Last Name" value="#{Customer.lastName}"
        required="true">
        <f:validateLength minimum="2" maximum="30"></f:validateLength>
      </h:inputText>
      <h:outputText value="Email:">
      </h:outputText>
      <h:inputText label="Email" value="#{Customer.email}">
        <f:validator validatorId="emailValidator" />
      </h:inputText>
      <h:panelGroup></h:panelGroup>
      <h:commandButton action="save" value="Save"></h:commandButton>
    </h:panelGrid>
  </h:form>
</f:view>
</body>
</html>
