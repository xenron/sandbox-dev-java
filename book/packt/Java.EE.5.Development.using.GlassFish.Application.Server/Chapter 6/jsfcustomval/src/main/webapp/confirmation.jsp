<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Customer Data Entered</title>
</head>
<body>
<p>The following data was entered:</p>
<f:view>
  <h:panelGrid columns="2">
    <h:outputText value="First Name:"></h:outputText>
    <h:outputText value="#{Customer.firstName}"></h:outputText>
    <h:outputText value="Last Name:"></h:outputText>
    <h:outputText value="#{Customer.lastName}"></h:outputText>
    <h:outputText value="Email:"></h:outputText>
    <h:outputText value="#{Customer.email}"></h:outputText>
  </h:panelGrid>
</f:view>
</body>
</html>
