package org.jboss.resteasy.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
 
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;

public class RESTEasyClient {

	public static void main(String[] args) {
		 
		Client client =	ClientBuilder.newClient();
	//	client.register(ClientFilter.class);
	//	client.register(LoggingFilter.class);
		String response = client.target("http://localhost:8080/jboss-resteasy/rest/helloworld/text/John Smith").request("text/plain").get(String.class);
		 
		 System.out.println(response);
}
	
}
