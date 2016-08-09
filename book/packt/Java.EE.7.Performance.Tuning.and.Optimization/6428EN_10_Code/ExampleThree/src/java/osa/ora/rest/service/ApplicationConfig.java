/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */

package osa.ora.rest.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Osama Oransa
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(osa.ora.rest.service.ContactDetailsFacadeREST.class);
        resources.add(osa.ora.rest.service.EmpolyeeFacadeREST.class);
    }
    
}
