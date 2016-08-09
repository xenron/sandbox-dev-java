<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
	import="java.net.URI,javax.ws.rs.core.*,com.sun.jersey.api.client.*,com.sun.jersey.api.client.config.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>JAX-RS Client</title>
</head>
<body>
	<%
		ClientConfig clientconfig = new DefaultClientConfig();
		Client client = Client.create(clientconfig);
		WebResource service = client.resource(UriBuilder.fromUri(
				"http://localhost:8080/jboss-jaxrs").build());
		out.println(service.path("jaxrs").path("helloworld")
				.accept(MediaType.TEXT_PLAIN).get(String.class));
		out.println(service.path("jaxrs").path("helloworld")
				.accept(MediaType.TEXT_XML).get(String.class));
		out.println(service.path("jaxrs").path("helloworld")
				.accept(MediaType.TEXT_HTML).get(String.class));
	%>
</body>
</html>
