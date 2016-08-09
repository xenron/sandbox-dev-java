
/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch5.hateoas;

import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;


/*
 * This demonstartes use of ResourceConfig to configure resources during deploymnent
 * @author Jobinesh
 */
@Provider
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends ResourceConfig {

    private static final Logger logger = Logger.getLogger(ApplicationConfig.class.getName());

    public ApplicationConfig(@Context ServletContext context) {

        //Registers specifc components
        register(MultiPartFeature.class);
        register(LoggingFilter.class);
        register(DeclarativeLinkingFeature.class);
        //Register components in a pcackage
        packages("com.packtpub.rest.ch5.hateoas.jersey");
        packages("com.packtpub.rest.ch5.hateoas.jaxrs");
  
    }

}
