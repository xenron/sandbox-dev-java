package com.sheeom.first_level_cache;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		System.out.println("\nLoading employee#1...");
		/* Line 2 */ Employee employee1 = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1.toString());

		System.out.println("\nLoading employee#2...");
		/* Line 6 */ Employee employee2 = (Employee) session.load(Employee.class, new Long(2));
		System.out.println(employee2.toString());

		System.out.println("\nLoading employee#1 again...");
		/* Line 10 */ Employee employee1_dummy = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee1_dummy.toString());

		System.out.println("\nLoading employee#2 again...");
		/* Line 15 */ Employee employee2_dummy = (Employee) session.load(Employee.class, new Long(2));
		System.out.println(employee2_dummy.toString());

		Criteria criteria = session.createCriteria(Employee.class);
		System.out.println(criteria.list());
		System.out.println(criteria.list());
		
		session.close();
		HibernateUtil.shutdown();
	}
}
