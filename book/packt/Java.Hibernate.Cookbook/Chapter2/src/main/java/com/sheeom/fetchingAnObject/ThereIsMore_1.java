package com.sheeom.fetchingAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class ThereIsMore_1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		System.out.println("Employee get...");
		Employee employeeGet = (Employee) session.get(Employee.class, Long.valueOf(2));
		System.out.println(employeeGet .toString());
		   	 
		System.out.println("Employee load...");
		Employee employeeLoad = (Employee) session.load(Employee.class,Long.valueOf(2));
		System.out.println(employeeLoad .toString());
		session.close();
		HibernateUtil.shutdown();
	}
}
