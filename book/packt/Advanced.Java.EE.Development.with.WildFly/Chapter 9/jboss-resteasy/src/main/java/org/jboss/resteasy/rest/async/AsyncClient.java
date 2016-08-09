package org.jboss.resteasy.rest.async;

import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;

public class AsyncClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();

		WebTarget target = client
				.target("http://localhost:8080/jboss-resteasy/rest/helloworld/timeout/60");
		AsyncInvoker asyncInvoker = target.request("text/plain").async();
		asyncInvoker.get(new InvocationCallback<String>() {
			@Override
			public void completed(String response) {
				System.out
						.println("Invocation completed and response available");
			}

			@Override
			public void failed(Throwable arg0) {

			}
		});

		System.out.println("Call to get returns immediately");

	}

}
