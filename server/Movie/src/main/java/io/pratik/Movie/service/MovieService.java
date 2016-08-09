package io.pratik.Movie.service;

import io.pratik.Movie.entity.Movie;

import java.util.List;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findByName(String name);

	public Movie create(Movie mov);

	public Movie update(String id, Movie mov);

	public void delete(String id);
}
