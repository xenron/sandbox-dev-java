package web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import exception.InvalidXMLException;
import exception.UserNotFoundException;

import business.MessageBO;

@Path("/messages")
public class MessagesResource {
	@GET
	@Produces("application/xml")
	public String getXML() {
		return MessageBO.getAllXML();
	}

	@GET
	@Produces("application/json")
	public String getJSON() {
		return MessageBO.getAllJSON();
	}
	
	@POST
	@Consumes("application/xml")
	@Produces("application/xml")	
	public String createMessage(String representation) {	
		try {
			return MessageBO.create(representation);			
		} catch (InvalidXMLException e) {
			throw new WebApplicationException(400);
		} catch (UserNotFoundException e) {
			throw new WebApplicationException(403);
		}		
	}	
}
