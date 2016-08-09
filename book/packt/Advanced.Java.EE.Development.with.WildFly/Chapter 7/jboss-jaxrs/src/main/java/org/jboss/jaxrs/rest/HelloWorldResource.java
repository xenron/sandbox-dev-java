package org.jboss.jaxrs.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorldResource {

	@GET
	@Produces("text/html")
	public String getHTMLMessage() {
		return "<html> " + "<title>" + "Hello JAX-RS" + "</title>"
				+ "<body><h1>" + "Hello JAX-RS" + "</body></h1> " + "</html> ";
	}

	// The Java method will process HTTP GET requests
	//
	// The Java method will produce content identified by the MIME Media
	// type "text/plain"
	@GET
	@Produces("text/plain")
	public String getClichedMessage() {
		// Return some cliched textual content
		return "Hello JAX-RS";
	}
	/*  @GET
	  @Produces("application/xml") public String getXMLMessage() { return
	                                "<?xml version=\"1.0\"?>" +
	                                "<hello> Hello JAX-RS" + "</hello>"; }
	  */
	@GET
	@Produces("text/xml")
	public String getXMLMessage() { 
		return "<?xml version=\"1.0\"?>" + "<hello> Hello JAX-RS" + "</hello>";
	}///java  client
	
	
	 
	//jsp client
	/*@GET
	@Produces("text/xml")
	public String getXMLMessage() {
		return "&lt;?xml version=\"1.0\"?&gt;" + "&lt;hello&gt;Hello JAX-RS" + "&lt;/hello&gt;";
	}*/


	 
}

