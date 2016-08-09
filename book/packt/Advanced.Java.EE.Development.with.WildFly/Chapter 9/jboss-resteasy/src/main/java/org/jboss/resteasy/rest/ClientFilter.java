package org.jboss.resteasy.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
public class ClientFilter implements ClientRequestFilter, ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext arg0, ClientResponseContext arg1)
			throws IOException {
	}

	@Override
	public void filter(ClientRequestContext arg0) throws IOException {

		System.out.println("Entity Class: " + arg0.getEntityClass());
		System.out.println("Accept: " + arg0.getHeaderString("Accept"));
		System.out.println("Accept-Charset: "
				+ arg0.getHeaderString("Accept-Charset"));
		System.out.println("Accept-Encoding: "
				+ arg0.getHeaderString("Accept-Encoding"));
		System.out.println("Accept-Language: "
				+ arg0.getHeaderString("Accept-Language"));
		System.out.println("Accept-Ranges: "
				+ arg0.getHeaderString("Accept-Ranges"));
		System.out.println("Allow: " + arg0.getHeaderString("Allow"));
		System.out.println("Authorization: "
				+ arg0.getHeaderString("Authorization"));
		System.out.println("Cache-Control: "
				+ arg0.getHeaderString("Cache-Control"));
		System.out.println("Content-Encoding: "
				+ arg0.getHeaderString("Content-Encoding"));
		System.out.println("Content-Location: "
				+ arg0.getHeaderString("Content-Location"));
		System.out.println("Accept-Encoding: "
				+ arg0.getHeaderString("Accept-Encoding"));
		System.out.println("Content-Type: "
				+ arg0.getHeaderString("Content-Type"));
		System.out.println("Host: " + arg0.getHeaderString("Host"));
		System.out.println("Pragma: " + arg0.getHeaderString("Pragma"));
		System.out.println("Server: " + arg0.getHeaderString("Server"));
		System.out.println("User-Agent: " + arg0.getHeaderString("User-Agent"));

		try {
			arg0.setUri(new URI(
					"http://localhost:8080/jboss-resteasy/rest/helloworld/text/Smith,John"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//arg0.abortWith(Response.notAcceptable(null).build());
	}

	 

	 

}
