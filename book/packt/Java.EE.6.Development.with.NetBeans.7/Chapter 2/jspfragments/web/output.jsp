<%-- 
    Document   : output
    Created on : Aug 21, 2010, 12:28:31 PM
    Author     : heffel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <jsp:useBean id="surveyData" scope="request" class="com.ensode.nbbook.model.SurveyData" />
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank You!</title>
    </head>
    <body>
        <h2>Thanks for taking our survey</h2>
        <p>
            <jsp:getProperty name="surveyData" property="fullName" />,
            you indicated you are familiar with the following
            programming languages:</p>
        <ul>
            <%
                        String[] selectedLanguages =
                                surveyData.getProgLangList();
                        if (selectedLanguages != null) {
                            for (int i = 0; i < selectedLanguages.length;
                                    i++) {
            %>

            <li>
                <%= selectedLanguages[i]%>
            </li>

            <%}
                        }
            %>
        </ul>
    </body>
</html>
