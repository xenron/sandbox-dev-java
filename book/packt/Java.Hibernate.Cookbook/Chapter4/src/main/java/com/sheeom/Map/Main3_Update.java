package com.sheeom.Map;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main3_Update {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = (Employee) session.get(Employee.class, 1l);
		Map<String, String> emails = employee.getEmails();
		emails.put("Personal email 1", "emailaddress3@provider3.com");
		session.getTransaction().begin();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
	  	 System.out.println(employee.toString());

	  	 
		session.close();
		HibernateUtil.shutdown();
	}
}
