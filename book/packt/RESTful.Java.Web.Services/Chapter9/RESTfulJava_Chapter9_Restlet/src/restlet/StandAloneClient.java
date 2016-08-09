package restlet;

import java.io.IOException;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class StandAloneClient {

	public static void main(String[] args) {
		try {
			new ClientResource("http://www.google.com/").get().write(System.out);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ResourceException e) {
			e.printStackTrace();
		}
	}
}
