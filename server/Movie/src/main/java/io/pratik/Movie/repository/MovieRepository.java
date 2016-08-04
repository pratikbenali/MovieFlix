package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Movie;
import java.util.List;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findByName(String name);

	public Movie create(Movie mov);

	public Movie update(Movie mov);

	public void delete(Movie mov);
}
