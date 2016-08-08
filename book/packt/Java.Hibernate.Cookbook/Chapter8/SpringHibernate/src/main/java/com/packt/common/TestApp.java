package com.packt.common;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.packt.dao.FilmDao;
import com.packt.modal.Film;

public class TestApp {

	public static void main(String[] args) {

		/* Line 18 */ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		/* Line 18 */FilmDao filmDao = (FilmDao) context.getBean("filmDao");

		/* Line 18 */Film film1 = new Film("Film 1", 2013);
		/* Line 18 */filmDao.save(film1);
		/* Line 18 */System.out.println("Film Saved: " + film1);

		/* Line 18 */Film film2 = new Film("Film 2", 2014);
		/* Line 18 */filmDao.save(film2);
		/* Line 18 */System.out.println("Film Saved: " + film2);

		/* Line 18 */System.out.println("\nAll Film List");
		/* Line 18 */List<Film> films = filmDao.getAll();
		/* Line 18 */for (Film filmObj : films) {
		/* Line 18 */	System.out.println(filmObj);
		/* Line 18 */}

		/* Line 18 */System.out.println("\nGet Film by id 1");
		/* Line 18 */Film film = filmDao.getById(1);
		/* Line 18 */System.out.println(film);
		/* Line 18 */context.close();
	}
}
