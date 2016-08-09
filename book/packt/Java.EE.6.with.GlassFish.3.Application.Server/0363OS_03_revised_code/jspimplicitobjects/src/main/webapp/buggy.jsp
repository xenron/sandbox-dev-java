<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buggy JSP</title>
</head>
<body>
<p>
This text will never be seen in the browser since the exception will be thrown before the page renders.
<%
Object o = null;

out.println(o.toString()); //NullPointerException thrown here.
%>
</p>
</body>
</html>