package com.company.customer;

public class CustomerDriver {

    public static void main(String[] args) {
        Customer customer;			// defines a reference to a Customer
        customer = new Customer();	// Creates a new Customer object		customer.setBalance(12506.45f);
        System.out.println(customer.toString());
    }
}
