package com.sheeom.fetchingAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class ThereIsMore_3 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("\nEmployee get...");
		Employee employeeGet = (Employee) session.get(Employee.class, new Long(
				1));
		System.out.println(employeeGet.toString());

		System.out.println("\nEmployee load...");
		Employee employeeLoad = (Employee) session.load(Employee.class,
				new Long(3));
		System.out.println(employeeLoad.toString());
		session.close();
		HibernateUtil.shutdown();

	}
}
