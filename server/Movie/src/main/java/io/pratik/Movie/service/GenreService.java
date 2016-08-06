package io.pratik.Movie.service;

import io.pratik.Movie.entity.Genre;

import java.util.List;

public interface GenreService {

	public List<Genre> findAll();

	public Genre findOne(String id);

	public Genre create(Genre gen);

	public Genre update(String id, Genre gen);

	public void delete(String id);
}
