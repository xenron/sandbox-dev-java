package com.sheeom.execute_query_using_HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main2_Select {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("SELECT id, name from Category");
		List list = query.list();
		System.out.println("Result size: " + list.size());

		
		session.close();
		HibernateUtil.shutdown();
		
	}
}
