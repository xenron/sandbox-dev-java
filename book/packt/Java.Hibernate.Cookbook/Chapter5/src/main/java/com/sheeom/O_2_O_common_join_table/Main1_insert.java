package com.sheeom.O_2_O_common_join_table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1_insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Detail detail = new Detail();
		detail.setCity("AHM");

		Employee employee = new Employee();
		employee.setName("vishal");
		employee.setEmployeeDetail(detail);

		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.save(employee);
		transaction.commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
