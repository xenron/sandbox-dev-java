/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.embedded;

 

public class CustomerInfo {

	String name;
	Info info;
 
	public CustomerInfo(String name, int age, String email, String phone) {

		this.name = name;

		this.info = new Info(age, email, phone);
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CustomerInfo [name=" + name + ", info=" + this.info + "] " ;
	}

	class Info {

		public Info(int age, String email, String phone) {
			super();
			this.email = email;
			this.phone = phone;
			this.age = age;
		}
		public Info( ) {
			 
		}
		String email;
		String phone;
		int age;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Info [email=" + email + ", phone=" + phone + ", age=" + age
					+ "]";
		}

	}
}