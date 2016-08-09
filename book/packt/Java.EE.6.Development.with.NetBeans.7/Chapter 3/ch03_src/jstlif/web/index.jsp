<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Aug 28, 2010, 6:40:46 PM
    Author     : heffel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <p>
            This paragraph will always be displayed.
        </p>
        <c:if test="${param.displayConditionalText == 'true'}" var="textDisplayed" scope="session">
            <p>
                This paragraph will only be displayed if the request parameter named "displayConditionalText" has a value  of "true".
            </p>
        </c:if>
        <p>
            This paragraph will also always be displayed.
        </p>
    </body>
</html>
