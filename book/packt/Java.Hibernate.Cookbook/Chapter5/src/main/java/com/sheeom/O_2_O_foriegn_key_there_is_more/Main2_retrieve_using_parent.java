package com.sheeom.O_2_O_foriegn_key_there_is_more;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main2_retrieve_using_parent {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Person.class);
		Person person = (Person) criteria.uniqueResult();
		System.out.println(person.toString());

		session.close();
		HibernateUtil.shutdown();
	}
}
