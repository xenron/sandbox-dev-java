package com.sheeom.removingAnObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.Employee;
import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.getTransaction().begin();
		Employee employee = (Employee) session.get(Employee.class, new Long(1));
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.shutdown();
	}
}
