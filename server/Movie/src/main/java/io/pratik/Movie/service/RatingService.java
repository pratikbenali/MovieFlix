package io.pratik.Movie.service;


import io.pratik.Movie.entity.Rating;
import java.util.List;

public interface RatingService {

	public List<Rating> findAll();

	public Rating findOne(String id);

	public Rating create(Rating rate);

	public Rating update(String id, Rating rate);

	public void delete(String id);
}
