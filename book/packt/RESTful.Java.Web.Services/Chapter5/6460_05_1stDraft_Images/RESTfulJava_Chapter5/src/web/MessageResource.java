package web;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

import business.MessageBO;
import exception.ItemNotFoundException;

@Path("/messages/{messageID}")
public class MessageResource {
	@GET
	@Produces("application/xml")
	public String getXML(@PathParam("messageID") String messageID) {
		String xml = MessageBO.getXML(messageID);
		if (xml != null) {
			return xml;
		} else {
			throw new WebApplicationException(404);
		}
	}

	@GET
	@Produces("application/json")
	public String getJSON(@PathParam("messageID") String messageID) {
		String json = MessageBO.getJSON(messageID);
		if (json != null) {
			return json;
		} else {
			throw new WebApplicationException(404);
		}
	}
	
	@DELETE
	public void deleteMessage(@PathParam("messageID") String messageID) {
		try {
			MessageBO.delete(messageID);
		} catch (ItemNotFoundException e) {
			throw new WebApplicationException(404);
		}
	}
}
