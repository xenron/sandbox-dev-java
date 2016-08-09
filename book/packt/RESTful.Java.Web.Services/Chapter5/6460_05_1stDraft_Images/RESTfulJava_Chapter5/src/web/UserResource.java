package web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import business.UserBO;
import exception.InvalidXMLException;
import exception.ItemNotFoundException;

// When talking about this annotation, talk about the ability to regular expressions (explain what regular expression is in an info box)
@Path("/users/{username}")
public class UserResource {
	// TODO: Page 19 says that I should return void or Resource - talk about this in the book
	@GET
	@Produces("application/xml")
	// TODO: note that @Produces annotation mapped with String return type
	// Also note that the name of the methods doesn't matter. It's the annotation that matters.
	public String getXML(@PathParam("username") String username) {
		String xml = UserBO.getXML(username);
		if (xml != null) {
			return xml;
		} else {
			throw new WebApplicationException(404);
		}
	}

	@GET
	@Produces("application/json")
	public String getJSON(@PathParam("username") String username) {
		// This shows two different models of validation: exception and null objects
		String json = UserBO.getJSON(username);
		if (json != null) {
			return json;
		} else {
			throw new WebApplicationException(404);
		}
	}
	
// TODO: OK...THis is the way to get the actual representation from the HTTP request: content is the actual representation of the XML...
	// This will be the same for POST and PUT...
	// Write: the key to get the representation is to know how to get it: in this case it's the String content parameter of the method (this took me
	// a long time to fine...
/*
/**
* PUT method for updating or creating an instance of HelloWorldResource
* @param content representation for the resource
* @return an HTTP response with content of the updated or created resource.
*
@PUT
@Consumes("application/xml")
public void putXml(String content) {
}	
 */
	@PUT
	@Consumes("application/xml")
	@Produces("application/xml")
	public String updateUser(@PathParam("username") String username, String representation) {
		// TODO: use MessageBodyReader - talk about thin in the book
		try {
			return UserBO.update(representation);		
		} catch (InvalidXMLException e) {
			throw new WebApplicationException(400);
		} catch (ItemNotFoundException e) {
			throw new WebApplicationException(404);
		}
	}

	@DELETE
	public void deleteUser(@PathParam("username") String username) {
		try {
			UserBO.delete(username);
		} catch (ItemNotFoundException e) {
			throw new WebApplicationException(404);
		}
	}
}
