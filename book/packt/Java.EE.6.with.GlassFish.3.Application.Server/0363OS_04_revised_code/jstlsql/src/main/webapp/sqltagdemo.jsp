<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SQL Tag Demo</title>
</head>
<body>
<sql:setDataSource dataSource="jdbc/__CustomerDBPool" />
<sql:transaction>
  <sql:update>
    insert into CUSTOMERS (CUSTOMER_ID, FIRST_NAME, LAST_NAME) values (((select max(CUSTOMER_ID) from customers) + 1), ?, ?)
    <sql:param value="${param.firstName}" />
    <sql:param value="${param.lastName}" />
  </sql:update>
</sql:transaction>
<p>Successfully inserted the following row into the CUSTOMERS table:</p>
<sql:query var="selectedRows"
  sql="select FIRST_NAME, LAST_NAME from customers where FIRST_NAME = ? and LAST_NAME = ?">
  <sql:param value="${param.firstName}" />
  <sql:param value="${param.lastName}" />
</sql:query>
<table border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td>First Name</td>
    <td>Last Name</td>
  </tr>
  <c:forEach var="currentRow" items="${selectedRows.rows}">
    <tr>
      <td><c:out value="${currentRow.FIRST_NAME}" /></td>
      <td><c:out value="${currentRow.LAST_NAME}" /></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
