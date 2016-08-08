package com.sheeom.O_2_O_foriegn_key;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		PassportDetail detail = new PassportDetail();
		detail.setPassportNo("G51546645");

		Person person = new Person();
		person.setName("Vishal");
		person.setPassportDetail(detail);

		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.save(person);
		transaction.commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
