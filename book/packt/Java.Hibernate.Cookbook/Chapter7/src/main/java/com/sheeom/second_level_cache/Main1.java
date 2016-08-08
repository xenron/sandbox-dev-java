package com.sheeom.second_level_cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();

		/* Line 1*/ Session session = sessionFactory.openSession();
		/* Line 2 */ Employee employee = (Employee) session.load(Employee.class, new Long(1));
		System.out.println(employee.toString());
		/* Line 4 */ session.close();
				
		/* Line 6 */ Session anotherSession = sessionFactory.openSession();
		/* Line 7 */ Employee employee_dummy = (Employee) anotherSession.load(Employee.class, new Long(1));
		System.out.println(employee_dummy.toString());
		/* Line 9 */ anotherSession.close();

		
//		session.close();
		HibernateUtil.shutdown();
	}
}
