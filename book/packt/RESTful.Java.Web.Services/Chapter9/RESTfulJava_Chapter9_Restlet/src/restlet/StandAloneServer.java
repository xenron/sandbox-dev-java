package restlet;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class StandAloneServer extends ServerResource {
	public static void main(String[] args) throws Exception {
		new Server(Protocol.HTTP, 8006, StandAloneServer.class).start();
	}

	@Get
	public String toString() {
		return "HTTP GET - RESTful Java Web Services with Restlet.";
	}
	
	@Post
	public String handlePost() {
		return "HTTP POST - RESTful Java Web Services with Restlet.";
	}
	
	@Put
	public String handlePut() {
		return "HTTP PUT - RESTful Java Web Services with Restlet.";
	}
	
	@Delete
	public String handleDelete() {
		return "HTTP DELETE - RESTful Java Web Services with Restlet.";
	}
}
