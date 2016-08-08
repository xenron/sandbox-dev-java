package com.sheeom.List.ThereIsMore;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sheeom.common.HibernateUtil;

public class Main1_insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Employee employee = new Employee();
		employee.setName("yogesh");

		List<Degree> degrees = new ArrayList<Degree>();
		degrees.add(new Degree("B.E.", 2008));
		degrees.add(new Degree("M.S.", 2011));

		employee.setDegrees(degrees);

		session.getTransaction().begin();
		session.save(employee);
		session.getTransaction().commit();

		session.close();
		HibernateUtil.shutdown();

	}
}
