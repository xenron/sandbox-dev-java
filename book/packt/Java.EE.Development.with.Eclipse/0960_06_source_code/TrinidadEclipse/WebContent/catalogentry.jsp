<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252 "%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/trinidad" prefix="tr"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Catalog Entry</title>
</head>
<body>
	<f:view>
		<tr:document title="catalogentry" id="d1">
			<tr:form id="f1">
				<h1>
					<font face="Verdana" color="#5252ff"> Catalog Entry </font>
				</h1>
				<h1>
					<tr:panelFormLayout rows="6" maxColumns="2" id="pfl1">
						<tr:outputLabel value="#{pageFlowScope.CatalogIdLabel}" id="ol1"/>
						<tr:outputLabel value="#{pageFlowScope.JournalLabel}" id="ol2" />
						<tr:outputLabel value="#{pageFlowScope.PublisherLabel}" id="ol3" />
						<tr:outputLabel value="#{pageFlowScope.EditionLabel}"  id="ol4" />
						<tr:outputLabel value="#{pageFlowScope.TitleLabel}"  id="ol5" />
						<tr:outputLabel value="#{pageFlowScope.AuthorLabel}" id="ol6" />
						<tr:outputText value="#{pageFlowScope.catalogId}" />
						<tr:outputText value="#{pageFlowScope.journal}" />
						<tr:outputText value="#{pageFlowScope.publisher}" />
						<tr:outputText value="#{pageFlowScope.edition}" />
						<tr:outputText value="#{pageFlowScope.title}" />
						<tr:outputText value="#{pageFlowScope.author}" />
					</tr:panelFormLayout>
				</h1>
			</tr:form>
		</tr:document>
	</f:view>

</body>
</html>
