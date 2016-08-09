<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Enumeration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Implicit Objects Demo</title>
</head>
<body>
<p>This page uses JSP Implicit objects to attach objects to the
request, session, and application scopes.<br />
It also retrieves some initialization parameters sent in the web.xml
configuration file.<br />
The third thing it does is get the buffer size from the implicit
response object.<br />
</p>
<p>
<%
          application.setAttribute("applicationAttribute", new String(
          "This string is accessible accross sessions."));
      session.setAttribute("sessionAttribute", new String(
          "This string is accessible accross requests"));
      request.setAttribute("requestAttribute", new String(
          "This string is accessible in a single request"));

      Enumeration initParameterNames = config.getInitParameterNames();

      out.println("Initialization parameters obtained from the implicit <br/>");
      out.println("config object:<br/><br/>");
      while (initParameterNames.hasMoreElements())
      {
        String parameterName = (String) initParameterNames.nextElement();
        out.print(parameterName + " = ");
        out.print(config.getInitParameter((String) parameterName));
        out.print("<br/>");
      }

      out.println("<br/>");

      out.println("Implicit object <b>page</b> is of type "
          + page.getClass().getName() + "<br/><br/>");

      out.println("Buffer size is: " + response.getBufferSize() + " bytes");
%>
</p>
<p><a href="implicitobjects2.jsp">Click here to continue.</a></p>
</body>
</html>
