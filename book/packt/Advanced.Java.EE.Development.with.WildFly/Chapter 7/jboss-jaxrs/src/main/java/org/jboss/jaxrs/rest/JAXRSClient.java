package org.jboss.jaxrs.rest;

import java.net.URI;
import javax.ws.rs.core.*;
import com.sun.jersey.api.client.*;
import com.sun.jersey.api.client.config.*;

public class JAXRSClient {
	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());
	System.out.println(service.path("jaxrs").path("helloworld").accept(MediaType.TEXT_PLAIN).get(String.class));
	System.out.println(service.path("jaxrs").path("helloworld").accept(MediaType.TEXT_XML).get(String.class));

	System.out.println(service.path("jaxrs").path("helloworld").accept(MediaType.TEXT_HTML).get(String.class));
	}
	private static URI getBaseURI() {
		return UriBuilder.fromUri("http://localhost:8080/jboss-jaxrs").build();
	}
} 

