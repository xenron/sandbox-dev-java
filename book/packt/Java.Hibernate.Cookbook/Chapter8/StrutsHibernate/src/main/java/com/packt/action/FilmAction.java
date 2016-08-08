package com.packt.action;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.packt.common.HibernateUtil;
import com.packt.dao.FilmDao;
import com.packt.dao.FilmDaoImpl;
import com.packt.modal.Film;

public class FilmAction extends ActionSupport implements ModelDriven {

	Film film = new Film();
	List<Film> films = new ArrayList<Film>();

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public Object getModel() {
		return film;
	}
	
	public String saveFilm(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		FilmDao filmDao = new FilmDaoImpl(sessionFactory);
		filmDao.save(film);
		
		// refresh films
		films = filmDao.getAll();
		
		return SUCCESS;
	}
	
	public String listAllFilms(){
		films = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		FilmDao filmDao = new FilmDaoImpl(sessionFactory);
		films = filmDao.getAll();
		
		return SUCCESS;
	}

}
