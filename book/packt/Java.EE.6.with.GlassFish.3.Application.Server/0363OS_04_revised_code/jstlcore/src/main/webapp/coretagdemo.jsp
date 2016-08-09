<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<html>
<%
      ArrayList<String> nameList = new ArrayList<String>(4);

      nameList.add("David");
      nameList.add("Raymond");
      nameList.add("Beth");
      nameList.add("Joyce");

      request.setAttribute("nameList", nameList);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Core Tag Demo</title>
</head>
<body>
<c:set var="name" scope="page" value="${param.name}"></c:set>

<c:out value="Hello"></c:out>
<c:choose>
  <c:when test="${!empty name}">
    <c:out value="${name}"></c:out>
  </c:when>
  <c:otherwise>
    <c:out value="stranger"></c:out>
    <br />
    <c:out value="Need a name? Here are a few options:" />
    <br />
    <ul>
      <c:forEach var="nameOption" items="${requestScope.nameList}">
        <li /><c:out value="${nameOption}"></c:out>
      </c:forEach>
    </ul>
  </c:otherwise>
</c:choose>
<c:remove var="name" scope="page" />
</body>
</html>
