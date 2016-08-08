package com.sheeom.working_with_namedquery;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		/* Line 1 */ Query query = session.getNamedQuery("getCategoryNameByName");
		/* Line 2 */ query.setString("name", "Stationary");
		List list = query.list();
		System.out.println("Category size: " + list.size());


		session.close();
		HibernateUtil.shutdown();
	}
}
