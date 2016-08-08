package com.sheeom.first_level_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class ThereIsMore2_clear {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("\nLoading employee#1...");
		/* Line 2 */ Employee employee1 = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1.toString());

		/* Line 5 */ session.evict(employee1);
		System.out.println("\nEmployee#1 removed using evict(…)...");

		System.out.println("\nLoading employee#1 again...");
		/* Line 9*/ Employee employee1_dummy = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1_dummy.toString());


		session.close();
		HibernateUtil.shutdown();
	}
}
