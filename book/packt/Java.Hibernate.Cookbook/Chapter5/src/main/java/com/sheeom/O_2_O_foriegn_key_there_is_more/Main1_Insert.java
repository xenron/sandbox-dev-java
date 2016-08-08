package com.sheeom.O_2_O_foriegn_key_there_is_more;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1_Insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		PassportDetail detail = new PassportDetail();
		detail.setPassportNo("G54624512");

		Person person = new Person();
		person.setName("Yogesh");
		person.setPassportDetail(detail);

		Transaction transaction = session.getTransaction();
		transaction.begin();

		session.save(person);
		transaction.commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
