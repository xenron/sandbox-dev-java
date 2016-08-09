<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%><%@taglib
	uri="http://java.sun.com/jsf/html" prefix="h"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSF Data Table</title>
</head>
<body>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<f:view>
	<h:form binding="#{catalog.form1}">
	<h2>JSF Data Table</h2>
		<h:inputText binding="#{catalog.inputText1}" required="true"></h:inputText>
		<h:commandButton  
			action="#{catalog.commandButton1_action}" value="Submit Query" binding="#{catalog.commandButton1}"/>
		<h:dataTable  binding="#{catalog.dataTable1}" border="1" rows="5">
			<h:column binding="#{catalog.column1}"></h:column>
			<h:column binding="#{catalog.column2}"></h:column>
			<h:column binding="#{catalog.column3}"></h:column>
			<h:column binding="#{catalog.column4}"></h:column>
			<h:column binding="#{catalog.column5}"></h:column>
			<h:column binding="#{catalog.column6}"></h:column>
		</h:dataTable>


	</h:form>

</f:view>
</body>
</html>