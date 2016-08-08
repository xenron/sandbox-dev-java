package com.sheeom.Array;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1_Insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setName("vishal");
		employee.setEmails (new String []{"emailaddress1@provider1.com", "emailaddress2@provider2.com", "emailaddress3@provider3.com", "emailaddress4@provider4.com"});

		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
