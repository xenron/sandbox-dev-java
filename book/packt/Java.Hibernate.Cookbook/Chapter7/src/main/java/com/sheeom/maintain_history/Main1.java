package com.sheeom.maintain_history;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();
		transaction.begin();

		Employee employee = new Employee();
		employee.setName("Aarush");
		employee.setPassword("p@$sw0rd");
		session.save(employee);

		transaction.commit();
		session.close();


		HibernateUtil.shutdown();
	}
}
