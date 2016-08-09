/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ensode.nbbook.buggywebapp.controller;

import com.ensode.nbbook.buggywebapp.entitity.Customer;
import com.ensode.nbbook.buggywebapp.model.CustomerModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author heffel
 */
@Named
@RequestScoped
@Stateful
public class CustomerController {

    @PersistenceContext(unitName = "BuggyWebAppPU")
    private EntityManager em;
    @Inject
    private CustomerModel customerModel;

    public String createCustomer() {
        Customer customer = entityFromModel(customerModel);
        try {
            persist(customer);
            return "confirmation";
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            return "error";
        }
    }

    public void persist(Object object) {
        try {
            em.persist(object);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    private Customer entityFromModel(CustomerModel customerModel) {
        Customer customer = new Customer();

        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());

        return customer;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
