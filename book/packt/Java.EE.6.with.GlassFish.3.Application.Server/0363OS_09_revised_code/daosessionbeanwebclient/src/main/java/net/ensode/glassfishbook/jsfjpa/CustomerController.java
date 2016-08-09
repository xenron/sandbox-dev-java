package net.ensode.glassfishbook.jsfjpa;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import net.ensode.glassfishbook.Customer;
import net.ensode.glassfishbook.CustomerDaoBean;

@ManagedBean
public class CustomerController {

    @EJB
    CustomerDaoBean customerDaoBean;
    @ManagedProperty(value = "#{customer}")
    private Customer customer;

    public String saveCustomer() {
        String returnValue = "customer_saved";

        try {
            customerDaoBean.saveCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            returnValue = "error_saving_customer";
        }

        return returnValue;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
