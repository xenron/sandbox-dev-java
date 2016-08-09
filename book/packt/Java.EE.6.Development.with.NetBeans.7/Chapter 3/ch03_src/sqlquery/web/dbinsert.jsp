<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : dbinsert
    Created on : Aug 29, 2010, 8:24:53 AM
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
    <sql:update var="insertedRows" dataSource="jdbc/sample">
        INSERT INTO customer (customer_id, name, discount_code,zip) values
        (((select max(customer_id) from customer) + 1),
        'Ensode Technology, LLC', 'H', '22030')
    </sql:update>

    <sql:query var="result" dataSource="jdbc/sample">
        SELECT customer_id, name, discount_code, zip FROM
        customer where name like ?
        <sql:param value="Ensode%"/>
    </sql:query>

    <table border="1">
        <!-- column headers -->
        <tr>
        <c:forEach var="columnName" items="${result.columnNames}">
            <th><c:out value="${columnName}"/></th>
        </c:forEach>
    </tr>
    <!-- column data -->
    <c:forEach var="row" items="${result.rowsByIndex}">
        <tr>
        <c:forEach var="column" items="${row}">
            <td><c:out value="${column}"/></td>
        </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>
