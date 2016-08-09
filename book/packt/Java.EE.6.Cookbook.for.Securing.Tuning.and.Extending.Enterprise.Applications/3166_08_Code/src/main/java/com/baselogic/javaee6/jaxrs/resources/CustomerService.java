package com.baselogic.javaee6.jaxrs.resources;

import com.baselogic.javaee6.domain.Customer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;

@WebService
@Path("/customerservice")
@Consumes("application/xml")
@Produces("application/xml")
public interface CustomerService {

    @WebMethod
    @GET
    @Path("/{username}")
    @Consumes("*/*")
    Customer getCustomer(@PathParam("username") @WebParam(name = "username") String username)
            throws CustomerNotFoundFault;

    @WebMethod
    @POST
    @Path("/customers")
    Customer addCustomer(@WebParam(name = "customer") Customer customer);
}