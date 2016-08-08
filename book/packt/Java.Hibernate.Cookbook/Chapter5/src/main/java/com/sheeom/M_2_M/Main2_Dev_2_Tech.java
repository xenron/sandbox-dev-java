package com.sheeom.M_2_M;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.HibernateUtil;

public class Main2_Dev_2_Tech {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Developer.class);
		criteria.add(Restrictions.eq("id", 1L));

		Developer developer = (Developer) criteria.uniqueResult();
		System.out.println(developer.toString());

		Set<Technology> tech = developer.getTechnology();
		for (Technology technology : tech) {
			System.out.println(technology.toString());
		}

		session.close();
		HibernateUtil.shutdown();
	}
}
