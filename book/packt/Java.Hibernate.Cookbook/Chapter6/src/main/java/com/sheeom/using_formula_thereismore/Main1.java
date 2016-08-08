package com.sheeom.using_formula_thereismore;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> list = criteria.list();
		for(Product product : list){
			System.out.println("\nProduct name: " + product.getName());
			System.out.println("Category name: " + product.getCategoryName());
		}

		session.close();
		HibernateUtil.shutdown();
	}
}
