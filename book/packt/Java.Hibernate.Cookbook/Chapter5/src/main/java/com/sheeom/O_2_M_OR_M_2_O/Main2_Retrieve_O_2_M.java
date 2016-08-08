package com.sheeom.O_2_M_OR_M_2_O;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.HibernateUtil;

public class Main2_Retrieve_O_2_M {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Actor.class);
		criteria.add(Restrictions.eq("actorName", "Paul Walker"));
		Actor actor = (Actor) criteria.uniqueResult();

		System.out.println(actor);
		System.out.println(actor.getMovie());


		session.close();
		HibernateUtil.shutdown();
	}
}
