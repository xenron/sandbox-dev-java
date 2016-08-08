package com.sheeom.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main2_select {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = (Employee) session.get(Employee.class, 1l);
		System.out.println(employee.toString());

		session.close();
		HibernateUtil.shutdown();
	}
}
