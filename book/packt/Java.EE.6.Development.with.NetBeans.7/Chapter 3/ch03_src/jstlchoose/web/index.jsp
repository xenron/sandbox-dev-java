<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : Aug 28, 2010, 7:14:51 PM
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
        <p>
            <c:choose>
                <c:when
                    test="${param.displayConditionalText == '1'}">
                    This paragraph will only be displayed if the request
                    parameter named "displayConditionalText" has a value
                    of "1".
                </c:when>
                <c:when
                    test="${param.displayConditionalText == '2'}">
                    This paragraph will only be displayed if the request
                    parameter named "displayConditionalText" has a value
                    of "2".
                </c:when>
                <c:otherwise>
                    This paragraph will only be displayed if the request
                    parameter named "displayConditionalText" is either not
                    present or has a value different from "1" or
                    "2".
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            This paragraph will also always be displayed.
        </p>
</html>
