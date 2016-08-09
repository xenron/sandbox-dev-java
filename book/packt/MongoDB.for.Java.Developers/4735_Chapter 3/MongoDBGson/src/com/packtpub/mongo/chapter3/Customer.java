package com.packtpub.mongo.chapter3;

public class Customer {

	String name;
	int age;
	String email;
	String phone;

	public Customer(String name, int age, String email, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
}

 

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", email=" + email	+ ", phone=" + phone + "]";
	}
}