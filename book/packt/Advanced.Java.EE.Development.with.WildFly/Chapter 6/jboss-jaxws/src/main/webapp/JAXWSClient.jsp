<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
	import="org.jboss.jaxws.service.*,javax.xml.ws.WebServiceRef,java.net.URL,javax.xml.namespace.QName,javax.xml.ws.Service"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>JAXWS Client</title>
</head>
<body>
	<%URL wsdlLocation = new URL( 
					"http://localhost:8080/jboss-jaxws/HelloWorld?WSDL");
			QName serviceName = new QName("http://org.jboss.jaxws.service/",
					"HelloWorldService");
			Service service = Service.create(wsdlLocation, serviceName);

			HelloWS port = service.getPort(org.jboss.jaxws.service.HelloWS.class);
			String result = port.sayHello("John Smith");
			out.println(result);
	%>
</body>
</html>
