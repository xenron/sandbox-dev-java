package org.jboss.resteasy.rest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/helloworld")
public class HelloWorldResource {

	@GET
	@Produces("text/plain")
	@Path("/text/{name}")
	public String getClichedMessage(@PathParam("name") String name) {

		return "Hello " + name;
	}

}
