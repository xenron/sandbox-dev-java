package com.sheeom.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main4_delete {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setId(1);
		session.getTransaction().begin();
		session.delete(employee);
		session.getTransaction().commit();
		
		session.close();
		HibernateUtil.shutdown();
	}
}
