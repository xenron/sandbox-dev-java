package com.sheeom.execute_query_using_HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class ThereisMore {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// Where Clause
		String hql = "FROM Category c WHERE c.id=1";
		
		// ORDER BY Clause
		// String hql = "FROM Category c ORDER BY c.id DESC";
		
		// GROUP BY
		// String hql = "SELECT COUNT(p.id), p.name FROM Product p GROUP BY p.category";
		
		Query query = session.createQuery(hql);
		List list = query.list();
		System.out.println("Result size: " + list.size());	
		
		session.close();
		HibernateUtil.shutdown();
		
	}
}
