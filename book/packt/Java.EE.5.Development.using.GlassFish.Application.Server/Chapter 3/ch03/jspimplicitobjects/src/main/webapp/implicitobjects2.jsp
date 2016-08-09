<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Enumeration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sanity Check</title>
</head>
<body>
<p>This page makes sure we can retrieve the application, session and
request attributes set in the previous page. <br />
</p>
<p>applicationAttribute value is: <%=application.getAttribute("applicationAttribute")%>
<br />
sessionAttribute value is: <%=session.getAttribute("sessionAttribute")%>
<br />
requestAttribute value is: <%=request.getAttribute("requestAttribute")%>
<br />
</p>
<p>

The following attributes were found at the application scope:<br/><br/>
<%
          Enumeration applicationAttributeNames = pageContext
          .getAttributeNamesInScope(pageContext.APPLICATION_SCOPE);

      while (applicationAttributeNames.hasMoreElements())
      {
        out.println(applicationAttributeNames.nextElement() + "<br/>");
      }
%>
</p>
<p><a href="buggy.jsp">This hyperlink points to a JSP that will throw an exception.</a></p>
</body>
</html>
