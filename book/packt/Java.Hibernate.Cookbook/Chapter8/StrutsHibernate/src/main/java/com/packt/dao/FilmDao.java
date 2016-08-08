package com.packt.dao;

import java.util.List;

import com.packt.modal.Film;

public interface FilmDao {

	public void save(Film film);

	public List<Film> getAll();
}
