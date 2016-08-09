<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" isErrorPage="true" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Server Date And Time</title>
</head>
<body>
<p>Server date and time: <% out.print(new Date()); %>
<% pageContext. %>
</p>
</body>
</html>
