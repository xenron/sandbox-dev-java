/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch06.filters;

import java.util.List;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Administrator
 */
@Provider
public class MyJaxRsRequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext crq) {
//        If the user has not been authenticated
//        if(crq.getSecurityContext().getUserPrincipal() == null)
//            throw new WebApplicationException(Status.UNAUTHORIZED);

        List<MediaType> supportedMedia = crq.getAcceptableMediaTypes();
        if("GET".equals(crq.getMethod()) && 
                !(supportedMedia.contains(MediaType.APPLICATION_JSON_TYPE) || supportedMedia.contains(MediaType.APPLICATION_XML_TYPE) ))
            throw new WebApplicationException(Status.UNSUPPORTED_MEDIA_TYPE);
        
//        external users must only access student methods
        String path = crq.getUriInfo().getPath();
        if(!path.startsWith("/students"))
            throw new WebApplicationException(Status.FORBIDDEN);
        
        List<String> encoding = crq.getHeaders().get("accept-encoding");  
//        If the client does not support the gzip compression
        if(!encoding.toString().contains("gzip"))
            throw new WebApplicationException(Status.EXPECTATION_FAILED);            
    }    
}
