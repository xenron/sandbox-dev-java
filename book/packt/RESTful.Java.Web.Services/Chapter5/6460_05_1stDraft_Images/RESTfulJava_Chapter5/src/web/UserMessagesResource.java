package web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.MessageBO;

@Path("/messages/users/{username}")
public class UserMessagesResource {
	@GET
	@Produces("application/xml")
	public String getXML(@PathParam("username") String username) {
		return MessageBO.getAllXMLForUser(username);
	}

	@GET
	@Produces("application/json")
	public String getJSON(@PathParam("username") String username) {
		return MessageBO.getAllJSONForUser(username);
	}
}
