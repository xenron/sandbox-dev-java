<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="customers.xml" var="xml" />
<x:parse doc="${xml}" var="doc" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XML Tag Demo</title>
</head>
<body>
<table cellpadding="0" cellspacing="0" border="1">
  <tr>
    <td>First Name</td>
    <td>Last Name</td>
    <td>Email</td>
  </tr>
  <x:forEach select="$doc/customers/customer">
    <tr>
      <td><x:out select="firstName" /></td>
      <td><x:out select="lastName" /></td>
      <td><x:choose>
        <x:when select="email">
          <x:out select="email" />
        </x:when>
        <x:otherwise>
          <c:out value="N/A" />
        </x:otherwise>
      </x:choose></td>
    </tr>
  </x:forEach>
</table>
</body>
</html>
