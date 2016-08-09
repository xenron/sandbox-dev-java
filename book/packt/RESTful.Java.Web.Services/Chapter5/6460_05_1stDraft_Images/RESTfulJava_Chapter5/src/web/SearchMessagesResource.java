package web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.MessageBO;

@Path("/messages/search/{search_item}")
public class SearchMessagesResource {
	@GET
	@Produces("application/xml")
	public String searchXML(@PathParam("search_item") String search_item) {
		return MessageBO.searchAllXML(search_item);
	}

	@GET
	@Produces("application/json")
	public String searchJSON(@PathParam("search_item") String search_item) {
		return MessageBO.searchAllJSON(search_item);
	}
}
