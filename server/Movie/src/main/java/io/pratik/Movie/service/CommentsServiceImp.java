package io.pratik.Movie.service;

import io.pratik.Movie.entity.Comments;
import io.pratik.Movie.exception.CommentNotFoundException;
import io.pratik.Movie.repository.CommentsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsServiceImp implements CommentsService {
      
	@Autowired
	CommentsRepository repository;

	@Override
	public Comments findOne(String id) {
		Comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Comment for "+ id +"not found");
		}
		return existing;
	}

	@Override
	public Comments findByName(String name) {
			Comments existing = repository.findByName(name);
			if(existing == null){
				throw new CommentNotFoundException("Comment for "+ name +"not found");
			}
			return null;
		}

	@Override
	@Transactional
	public Comments create(Comments com) {
		return repository.create(com);
	}

	@Override
	@Transactional
	public Comments update(String id, Comments com) {
		Comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Comment for "+ id +"not found");
		}
		return repository.update(com);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Comments existing = repository.findOne(id);
		if(existing == null){
			throw new CommentNotFoundException("Comment for "+ id +"not found");
		}
		repository.delete(existing);
		
	}


	
	
}
