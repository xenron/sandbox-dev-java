<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.ensode.glassfishbook.jdbcselect.UsStateBean"%>

<%
          ArrayList<UsStateBean> stateList = (ArrayList<UsStateBean>) request
          .getAttribute("stateList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>US States</title>
</head>
<body>
<table border="1" cellpadding="0" cellspacing="0" align="center">
	<caption><b>US State List</b></caption>
	<tr>
		<td><b>Name</b></td>
		<td><b>Abbreviation</b></td>
	</tr>
	<%
	      for (UsStateBean state : stateList)
	      {
	%>
	<tr>
		<td><%=state.getStateName()%></td>
		<td><%=state.getStateCode()%></td>
	</tr>
	<%
	}
	%>

</table>
</body>
</html>
