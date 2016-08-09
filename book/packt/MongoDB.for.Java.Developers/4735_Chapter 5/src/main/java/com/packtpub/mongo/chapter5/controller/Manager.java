package com.packtpub.mongo.chapter5.controller;

import java.util.*;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
 
import com.packtpub.mongo.chapter5.ejb.StoreManagerEJB;
import com.packtpub.mongo.chapter5.model.Customer;
import com.packtpub.mongo.chapter5.model.Item;
import javax.annotation.PostConstruct;

 
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

@Model
public class Manager   {

    @Inject
    StoreManagerEJB storeManager;

    private String customerId;
    private int orderQuantity;
    private int orderPrice;
    private String customerName;
    private String customerCountry;
    private String orderProduct;

    List<Item> listOrders;
    List<SelectItem> listCustomers;

    public Manager() {   }

    @PostConstruct
    public void init() {
        getListCustomers();
        if (listCustomers.size() > 0) {
            this.customerId = listCustomers.get(0).getValue().toString();
            listOrders = storeManager.findAllItems(this.customerId);
        }
    }

    public void findAllCustomers() {
        List<Customer> listCustomersEJB
                = storeManager.findAllCustomers();
        for (Customer customer : listCustomersEJB) {
            listCustomers.add(new SelectItem(customer.getId(), customer.getName()));
        }
    }

    public void createCustomer() {
        storeManager.createCustomer(this.customerCountry,
                this.customerName);
        FacesMessage fm = new FacesMessage("Created Customer" + this.customerName + " from " + this.customerCountry);
        FacesContext.getCurrentInstance().addMessage("Message", fm);
        this.customerName = null;
        this.customerCountry = null;
        this.listCustomers = null;
    }

    public void saveOrder() {
        storeManager.saveOrder(customerId, this.orderPrice,
                this.orderQuantity, this.orderProduct);
        FacesMessage fm = new FacesMessage("Saved order for" + this.orderQuantity + " of " + this.orderProduct + " and customer " + customerId);
        FacesContext.getCurrentInstance().addMessage("Message", fm);
        this.orderPrice = 0;
        this.orderQuantity = 0;
        this.orderProduct = null;
    }


    public void changeListener(ValueChangeEvent e) {
        Object oldValue = e.getNewValue();
        this.customerId = e.getNewValue().toString();
        listOrders = storeManager.findAllItems(this.customerId);
    }

    public List<SelectItem> getListCustomers() {
        if (listCustomers == null) {
            listCustomers = new ArrayList();
            findAllCustomers();
        }
        return listCustomers;
    }

 
 

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public List<Item> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<Item> listOrders) {
        this.listOrders = listOrders;
    }
}
