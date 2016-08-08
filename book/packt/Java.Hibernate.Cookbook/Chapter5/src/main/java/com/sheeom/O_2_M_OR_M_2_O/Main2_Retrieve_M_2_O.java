package com.sheeom.O_2_M_OR_M_2_O;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.sheeom.common.HibernateUtil;

public class Main2_Retrieve_M_2_O {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(Movie.class);
		criteria.add(Restrictions.eq("id", 1L));
		Movie movie = (Movie) criteria.uniqueResult();
		System.out.println(movie);

		Set<Actor> actors = movie.getActors();
		for(Actor actor : actors){
			System.out.println(actor);
		}

		session.close();
		HibernateUtil.shutdown();
	}
}
