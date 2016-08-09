package com.baselogic.javaee6.jaxrs.resources;

import com.baselogic.javaee6.domain.Customer;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {

    private Map<String, Customer> customers = new HashMap<String, Customer>();
    private boolean isRest;

    public CustomerServiceImpl(boolean restFlag) {
        isRest = restFlag;
        init();
    }

    public CustomerServiceImpl() {
        init();
    }

    public Customer getCustomer(String username) throws CustomerNotFoundFault {

        if (!customers.containsKey(username) || customers.get(username) == null) {
            CustomerNotFoundDetails details = new CustomerNotFoundDetails();
            details.setUsername(username);
            if (!isRest) {
                throw new CustomerNotFoundFault("Can't find the Customer with username " + username, details);
            } else {
                Response r = Response.status(404).header("CUSTOMER-HEADER",
                        "No Customer with id " + username + " is available").entity(details).build();
                throw new WebApplicationException(r);
            }
        }

        return customers.get(username);
    }

    public Customer addCustomer(Customer customer) {
        customers.put(customer.getUsername(), customer);
        return customers.get(customer.getUsername());
    }

    private void init() {
        Customer customer = new Customer();
        //customer.setId(454L);
        customer.setUsername("mickknutson");
        customer.setFirstName("Mick");
        customer.setLastName("Knutson");
        customers.put(customer.getUsername(), customer);
    }
}