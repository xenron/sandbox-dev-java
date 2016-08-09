/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.adapter;

public class Customer {
        Object _id;
	String name;
	int age;
	String email;
	String phone;

 

    public Customer(Object _id, String name, int age, String email, String phone) {
        		super();
                        this._id = _id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "_id=" + _id + ", name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + '}';
    }

 
	 
}