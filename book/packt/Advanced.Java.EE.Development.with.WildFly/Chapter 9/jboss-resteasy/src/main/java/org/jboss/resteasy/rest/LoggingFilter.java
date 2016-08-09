package org.jboss.resteasy.rest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class LoggingFilter implements ContainerRequestFilter,
		ContainerResponseFilter {

	public LoggingFilter() {
	}

	@Override
	public void filter(ContainerRequestContext requestContext)
			throws IOException {
		System.out.println("Request Method: " + requestContext.getMethod());
		System.out.println("Request URI: "+ requestContext.getUriInfo().getAbsolutePath());
		System.out.println("Media Type : "+ requestContext.getMediaType());
		List<MediaType> mediaTypes = requestContext.getAcceptableMediaTypes();
		Iterator<MediaType> iter = mediaTypes.iterator();
		System.out.println("Acceptable Media Types: ");
		while (iter.hasNext()) {
			MediaType mediaType = iter.next();
			System.out.println(mediaType.getType() + ", ");

		}
	}
	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		 
	}
}
