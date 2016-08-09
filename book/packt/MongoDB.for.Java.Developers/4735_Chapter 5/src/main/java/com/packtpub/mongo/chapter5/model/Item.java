/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter5.model;

 

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Item   {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private int price;

    private String product;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customerFK;

    public Item() {     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomerFK() {
        return customerFK;
    }

    public void setCustomerFK(Customer customerFK) {
        this.customerFK = customerFK;
    }

  
}
