<%-- 
    Document   : error
    Author     : Osama Oransa
    Create For : Java Enterprise Edition 7 Performance Tuning (EN6428)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Unexpected Error!</h1>
        <h2>Reason is <%=session.getAttribute("reason") %></h2>
        <h2><a href="index.jsp">Login Again</a></h2>
    </body>
</html>
