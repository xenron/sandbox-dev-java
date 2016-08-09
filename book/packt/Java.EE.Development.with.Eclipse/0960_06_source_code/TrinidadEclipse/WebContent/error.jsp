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
<title>Error Page</title>
</head>
<body>
<f:view>
	<tr:document id="d1">
		<tr:form id="f1">
			<tr:outputText value="Error Generated" id="ot1" />
		</tr:form>
	</tr:document>
</f:view>
</body>
</html>
