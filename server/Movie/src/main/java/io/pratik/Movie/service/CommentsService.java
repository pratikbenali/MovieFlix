package io.pratik.Movie.service;

import io.pratik.Movie.entity.Comments;

public interface CommentsService {

	public Comments findOne(String id);
	
	public Comments findByName(String name);

	public Comments create(Comments com);

	public Comments update(String id, Comments com);

	public void delete(String id);
}
