package org.jboss.resteasy.rest.async;

import java.util.concurrent.TimeUnit;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/helloworld")
//@Stateless 
public class AsyncResource {

	 
	@GET
	@Path("/timeout/{timeout}")
	@Produces("text/plain")
	public void timeout(@PathParam("timeout") String timeoutStr,
			@Suspended AsyncResponse ar) {

		try {
			long timeout = Long.parseLong(timeoutStr);
			System.out.println("timeout - enter with timeout=" + timeoutStr
					+ "s");
			ar.setTimeoutHandler(new AsyncTimeoutHandler("Timeouted after "
					+ timeout + " seconds"));
			ar.setTimeout(timeout, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
