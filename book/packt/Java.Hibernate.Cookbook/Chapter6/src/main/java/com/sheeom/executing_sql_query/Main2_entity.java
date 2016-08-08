package com.sheeom.executing_sql_query;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;
import com.sheeom.performing_aggregate_operation.Category;

public class Main2_entity {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM category");
		/* Line 2 */ sqlQuery.addEntity(Category.class);
				
		List<Category> list = sqlQuery.list();
		for(Category category: list){
			System.out.println("\nCategory id: " + category.getId());
			System.out.println("Category name: " + category.getName());

		}	
		session.close();
		HibernateUtil.shutdown();
	
}
}
