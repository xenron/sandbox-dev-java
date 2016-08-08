package com.sheeom.List;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1_Insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setName("yogesh");

		List<String> emails = new ArrayList<String>();
		emails.add("emailaddress1@provider1.com");
		emails.add("emailaddress2@provider2.com");
		emails.add("emailaddress3@provider3.com");
		employee.setEmails(emails);

		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
