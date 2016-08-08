package com.sheeom.Map;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1_Insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setName("yogesh");
			
		Map<String, String> emails = new HashMap<String, String>();
		emails.put("Business email", "emailaddress1@provider1.com");
		emails.put("Personal email", "emailaddress2@provider2.com");
		employee.setEmails(emails);

		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

		
		session.close();
		HibernateUtil.shutdown();
	}
}
