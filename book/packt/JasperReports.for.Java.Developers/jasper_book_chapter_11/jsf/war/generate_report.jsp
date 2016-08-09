<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Generate Report</title>
</head>
<body>
<f:view>
	<h:outputText value="Click on the link below to generate the report." />
	<h:form>
		<h:commandLink action="generate_report"
			actionListener="#{reportGenerator.generateReport}">
			<h:outputText value="Generate Report" />
		</h:commandLink>
	</h:form>
</f:view>
</body>
</html>
