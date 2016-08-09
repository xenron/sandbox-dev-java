<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
<f:loadBundle basename="resources.application" var="msg"/>
<html>
<head>
  <title><h:outputText value="#{msg.welcomeTitle}" /></title>
</head>
<body>

<h3><h:outputText value="#{msg.welcomeHeading}" /></h3>

<p><h:outputText value="#{msg.welcomeMessage}" /></p>
  
</body>
</html>
</f:view>
