package com.packt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.packt.modal.Film;

public class FilmDaoImpl implements FilmDao {

	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Film film) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(film);
		tx.commit();
		session.close();
	}

	public List<Film> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Film> filmList = session.createQuery("from Film").list();
		session.close();
		return filmList;
	}

	public Film getById(long filmId) {
		Session session = this.sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Film.class);
		criteria.add(Restrictions.eq("id", filmId));
		Film film = (Film) criteria.uniqueResult();
		session.close();
		return film;
	}

}
