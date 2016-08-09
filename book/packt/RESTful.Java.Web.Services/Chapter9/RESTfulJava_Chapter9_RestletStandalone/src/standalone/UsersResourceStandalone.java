package standalone;

import java.io.IOException;

import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;

import business.UserBO;

public class UsersResourceStandalone extends ServerResource {
	public static void main(String[] args) throws Exception {
		new Server(Protocol.HTTP, 8007, UsersResourceStandalone.class).start();
	}
	
	@Get("xml")
	public Representation getXML() {
		String xml = UserBO.getAllXML();
		Representation representation = new StringRepresentation(xml, MediaType.APPLICATION_XML);

		return representation;
	}
	
	@Post
	public Representation createtUser(Representation entity) {
		Representation representation = null;
		
		try {
			representation = new StringRepresentation(UserBO.create(entity.getText()), MediaType.APPLICATION_XML);
		} catch (InvalidXMLException e) {
			setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
			representation = new StringRepresentation("Invalid XML.", MediaType.TEXT_PLAIN);
		} catch (ItemAlreadyExistsException e) {
			setStatus(Status.CLIENT_ERROR_FORBIDDEN);
			representation = new StringRepresentation("Item already exists.", MediaType.TEXT_PLAIN);
		} catch (IOException e) {
			setStatus(Status.SERVER_ERROR_INTERNAL );			
		}

		return representation;
	}
}
