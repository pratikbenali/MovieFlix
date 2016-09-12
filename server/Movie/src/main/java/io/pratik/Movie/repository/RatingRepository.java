package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Rating;
import java.util.List;

public interface RatingRepository {

	public List<Rating> findAll();

	public Rating findOne(String id);

	public Rating findByName(String name);

	public Rating create(Rating rate);

	public Rating update(Rating rate);

	public void delete(Rating rate);
}
