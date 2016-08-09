<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<link href="default.css" media="screen" rel="Stylesheet" type="text/css" />
<layout:html>
    <layout:form action="useraction.do" styleClass="FORM" key="Suggest Test">
        <layout:suggest name="username" suggestAction="/getSuggestionList" property="username" key="Username" styleId="myTextField" value="" suggestCount="8" />
        <layout:submit />
    </layout:form>
</layout:html>
