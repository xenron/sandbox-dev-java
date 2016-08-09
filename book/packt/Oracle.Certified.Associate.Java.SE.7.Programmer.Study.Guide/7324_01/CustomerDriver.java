package com.company.customer;

public class CustomerDriver {

    public static void main(String[] args) {
        // Define a reference and creates a new Customer object
        Customer customer;
        customer = new Customer();
        //customer.balance = new BigDecimal(12506.45f);                
        customer.setBalance(12506.45f);
        System.out.println(customer.toString());
    }
}