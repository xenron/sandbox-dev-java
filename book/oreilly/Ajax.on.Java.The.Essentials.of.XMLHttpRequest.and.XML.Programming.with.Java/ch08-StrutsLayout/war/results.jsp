<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<link href="default.css" media="screen" rel="Stylesheet" type="text/css" />
<layout:html>
Results:
    <layout:row>
        <layout:column>
            Username 
        </layout:column>
        <layout:column>
            <layout:write name="userForm" property="username" />
        </layout:column>
   </layout:row>
   <layout:row>
        <layout:column>
            First Name: 
        </layout:column>
        <layout:column>
            <layout:write name="userForm" property="firstName" />
        </layout:column>
   </layout:row>
   <layout:row>
        <layout:column>
            Last Name: 
        </layout:column>
        <layout:column>
            <layout:write name="userForm" property="lastName" />
        </layout:column>
   </layout:row>
</layout:html>