package com.sheeom.O_2_M_OR_M_2_O;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sheeom.common.HibernateUtil;

public class Main1_Insert {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Movie movie= new Movie();
		movie.setName("Furious 7");

		Actor actor1 = new Actor();
		actor1.setActorName("Vin Diesel");
		actor1.setMovie(movie);

		Actor actor2= new Actor();
		actor2.setActorName("Paul Walker");
		actor2.setMovie(movie);

		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(movie);
		session.save(actor1);
		session.save(actor2);
		transaction.commit();

		session.close();
		HibernateUtil.shutdown();
	}
}
