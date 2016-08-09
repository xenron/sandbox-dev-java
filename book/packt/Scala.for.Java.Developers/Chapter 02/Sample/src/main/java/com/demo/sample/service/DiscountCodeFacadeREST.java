/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.sample.service;

import com.demo.sample.DiscountCode;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author thomas
 */
@Stateless
@Path("com.demo.sample.discountcode")
public class DiscountCodeFacadeREST extends AbstractFacade<DiscountCode> {
    @PersistenceContext(unitName = "com.demo_Sample_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public DiscountCodeFacadeREST() {
        super(DiscountCode.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(DiscountCode entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(DiscountCode entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id.charAt(0)));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public DiscountCode find(@PathParam("id") String id) {
        return super.find(id.charAt(0));
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<DiscountCode> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<DiscountCode> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
