<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Format Tag Demo</title>
</head>
<body>
<jsp:useBean id="today" class="java.util.Date" />
<fmt:setLocale value="en_US" />
<fmt:bundle basename="ApplicationResources">
  <fmt:message key="greeting">
  </fmt:message>
  ,<br />
  <fmt:message key="proposal" />
  <fmt:formatNumber type="currency" value="42000" />.<br />
  <fmt:message key="offer_ends" />
  <fmt:formatDate value="${today}" type="date" dateStyle="full" />.
</fmt:bundle>
<br />
<br />
<fmt:setLocale value="es_ES" />
<fmt:bundle basename="ApplicationResources">
  <fmt:message key="greeting" />,<br />
  <fmt:message key="proposal" />
  <fmt:formatNumber type="currency" value="42000" />.<br />
  <fmt:message key="offer_ends" />
  <fmt:formatDate value="${today}" type="date" dateStyle="full" />
</fmt:bundle>
</body>
</html>
