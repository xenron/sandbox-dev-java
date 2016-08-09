/*
 * Copyright © 2015 Packt Publishing  - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 */
package com.packtpub.rest.ch4.service;

import com.packtpub.rest.ch4.ext.CSVMessageBodyReader;
import com.packtpub.rest.ch4.ext.CSVMessageBodyWriter;
import com.packtpub.rest.ch4.ext.DynamicFeatureRegister;
import com.packtpub.rest.ch4.validation.DepartmentNotFoundExceptionMapper;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;

/**
 * Defines the components of a JAX-RS application and supplies additional
 * metadata.
 *
 * @author Jobinesh
 */
@Provider
@javax.ws.rs.ApplicationPath("webresources")
public class AppConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(HRService.class);
        resources.add(HRServiceCache.class);
        resources.add(HRAsynchService.class);
        resources.add(CSVMessageBodyWriter.class);
        resources.add(CSVMessageBodyReader.class);
        resources.add(DynamicFeatureRegister.class);
        resources.add(DepartmentNotFoundExceptionMapper.class);
        return resources;
    }

    @Override
    public Map<String, Object> getProperties() {
        return super.getProperties(); 
    }

    @Override
    public Set<Object> getSingletons() {
        return super.getSingletons();
    }

}
