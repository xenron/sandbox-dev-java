package web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;

import business.UserBO;

@Path("/users")
public class UsersResource {
	@GET
	@Produces("application/xml")
	public String getXML() {
		return UserBO.getAllXML();
	}

	@GET
	@Produces("application/json")
	public String getJSON() {
		return UserBO.getAllJSON();
	}
	
	@POST
	@Consumes("application/xml")
	@Produces("application/xml")	
	public String createUser(String representation) {
	
	// This is likely wrong...
	// public String createUser(@PathParam("username") String username) {
		// TODO: I may need to use Page 19 of C:\jose\doc\BookREST_978-1-84719-646-0\6460_Chapters\6460_Chapter5\Jersey_RESTfulWebServices.PDF
		/*
@PUT
public Response putContainer() {
System.out.println("PUT CONTAINER " + container);
URI uri = uriInfo.getAbsolutePath();
Container c = new Container(container, uri.toString());
Response r;
if (!MemoryStore.MS.hasContainer(c)) {
r = Response.created(uri).build();
} else {
r = Response.noContent().build();
}
MemoryStore.MS.createContainer(c);
return r;
}		 */
		
		// TODO: use MessageBodyReader - talk about this in the book

		try {
			return UserBO.create(representation);			
		} catch (InvalidXMLException e) {
			throw new WebApplicationException(400);
		} catch (ItemAlreadyExistsException e) {
			throw new WebApplicationException(403);
		}		
	}
	
	// TODO: talk about providing two types of POST and PUT consumption of data.
	// For example, using forms to pass in the values and not XML representations: this is only to be flexible, as we said that
	// we pass XML representations (I need to be consitent)
	/*
@POST
@Consumes("application/x-www-form-urlencoded")
public void post(@FormParam("name") String name) {
// Store the message
}

OR I could use this:

@POST
@Consumes("application/x-www-form-urlencoded")
public void post(MultivaluedMap<String, String> formParams) {
// Store the message
}
	 */
	
}
