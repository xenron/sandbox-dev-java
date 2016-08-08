package com.sheeom.executing_sql_query;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1_scalar {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM product");

		List<Object[]> list = sqlQuery.list();
		for(Object[] object : list){
			System.out.println("\nId: " + object[0]);
			System.out.println("Name: " + object[1]);
			System.out.println("Price: " + object[2]);
			System.out.println("Category id: " + object[3]);
		}

		
		session.close();
		HibernateUtil.shutdown();
	}
}
