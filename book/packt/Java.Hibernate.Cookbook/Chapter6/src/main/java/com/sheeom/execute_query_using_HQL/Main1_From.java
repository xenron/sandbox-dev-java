package com.sheeom.execute_query_using_HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;
import com.sheeom.performing_aggregate_operation.Category;

public class Main1_From {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// Single Table
		Query query = session.createQuery("FROM Category");
		List<Category> list = query.list();
		System.out.println("Category size: " + list.size());

		// Multiple Table
//		Query query = session.createQuery("FroM Category, Product");
//		List list = query.list();
//		System.out.println("Result size: " + list.size());

		
		session.close();
		HibernateUtil.shutdown();
		
	}
}
