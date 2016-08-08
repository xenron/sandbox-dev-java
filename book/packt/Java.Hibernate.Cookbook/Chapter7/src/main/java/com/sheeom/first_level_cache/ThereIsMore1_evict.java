package com.sheeom.first_level_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class ThereIsMore1_evict {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("\nLoading employee#1...");
		/* Line 2 */ Employee employee1 = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1.toString());

		System.out.println("\nLoading employee#2...");
		/* Line 6 */ Employee employee2 = (Employee) session.load(Employee.class, new Long(2));
		System.out.println(employee2.toString());

		/* Line 9 */ session.clear();
		System.out.println("\nAll objects removed from session cache using clear()...");

		System.out.println("\nLoading employee#1 again...");
		/* Line 13 */ Employee employee1_dummy = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1_dummy.toString());

		System.out.println("\nLoading employee#2 again...");
		/* Line 17 */ Employee employee2_dummy = (Employee) session.load(Employee.class, new Long(2));
		System.out.println(employee2_dummy.toString());


		session.close();
		HibernateUtil.shutdown();
	}
}
