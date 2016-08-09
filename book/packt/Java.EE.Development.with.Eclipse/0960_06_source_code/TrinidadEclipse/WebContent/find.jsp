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
<title>Find a Catalog Entry</title>
</head>
<body>
<f:view>
	<tr:document title="find" id="d1">
		<tr:form id="f1">
			<h1>
				<font color="#5252ff">
					Find a Catalog Entry
        </font>
			</h1>
			<h1>
				<tr:panelFormLayout id="pfl1">
					<f:facet name="footer" />
					<tr:inputText label="Catalog Id" id="it7"
						binding="#{catalog.input7}" />
					<tr:commandButton text="Find" id="cb2"
binding="#{catalog.cb2}" action="#{catalog.cb2_action1}" />
				</tr:panelFormLayout>
			</h1>
		</tr:form>
	</tr:document>
</f:view>
</body>
</html>
