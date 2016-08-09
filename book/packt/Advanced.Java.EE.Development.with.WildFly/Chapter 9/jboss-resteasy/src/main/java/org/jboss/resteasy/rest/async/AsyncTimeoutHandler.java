package org.jboss.resteasy.rest.async;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.TimeoutHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class AsyncTimeoutHandler implements TimeoutHandler {
	private String _message;
	boolean keepSuspended = false;
	// boolean cancel = true;
	boolean cancel = false;
	int retryPeriod = 10;

	AsyncTimeoutHandler(String message) {
		_message = message;
	}

	@Override
	public void handleTimeout(AsyncResponse ar) {
		System.out.println("handleTimeout - enter");
		if (keepSuspended) {
			ar.setTimeout(10, TimeUnit.SECONDS);
		} else if (cancel) {
			System.out.println("Cancel the suspeneded request processing");
			ar.cancel(retryPeriod);
		} else {
			//ar.resume(_message);
		}
		
		  Response hello =
		  Response.ok("Hello after a timeout").type(MediaType.TEXT_PLAIN
		  ).build(); 
		  ar.resume(hello);
		 
	}
}
