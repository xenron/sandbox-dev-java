<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib
uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib
uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib
uri="http://myfaces.apache.org/trinidad" prefix="tr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trinidad UIs</title>
</head>
<body>
<f:view locale="en_US">
	<tr:document id="d1">
		<tr:form id="f1"><h1>
				<font color="#3173ff">
					Trinidad  UIs </font>
			</h1><h1><tr:commandLink text="Create New Catalog Entry"
					action="create" id="cl1" /></h1><h1>
<tr:commandLink text="Find a Catalog Entry" action="find"
				id="cl2" /></h1></tr:form>
	</tr:document>
</f:view>
</body>
</html>