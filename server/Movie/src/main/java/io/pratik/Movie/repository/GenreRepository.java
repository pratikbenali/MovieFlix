package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Genre;
import java.util.List;

public interface GenreRepository {

	public List<Genre> findAll();

	public Genre findOne(String id);

	public Genre create(Genre gen);

	public Genre update(Genre gen);

	public void delete(Genre gen);
}
