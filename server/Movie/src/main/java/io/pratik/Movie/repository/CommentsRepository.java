package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Comments;

public interface CommentsRepository {
	
    public Comments findOne(String id);
	
	public Comments findByName(String name);

	public Comments create(Comments com);

	public Comments update(Comments com);

	public void delete(Comments com);
}
