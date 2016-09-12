package io.pratik.Movie.service;

import io.pratik.Movie.entity.Genre;
import io.pratik.Movie.exception.GenreNotFoundException;
import io.pratik.Movie.repository.GenreRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GenreServiceImp implements GenreService {
	
	@Autowired
	GenreRepository repository;

	@Override
	public List<Genre> findAll() {
		return repository.findAll();
	}

	@Override
	public Genre findOne(String id) {
		Genre existing = repository.findOne(id);
		if(existing == null){
			throw new GenreNotFoundException("Genre with id "+ id + "not found");
		}
		return existing;
		
	}

	@Override
	@Transactional
	public Genre create(Genre genre) {
		return repository.create(genre);
	}

	@Override
	@Transactional
	public Genre update(String id, Genre genre) {
		Genre existing = repository.findOne(id);
		if(existing == null){
			throw new GenreNotFoundException("Genre with id "+ id + "not found");
		}
		return repository.update(genre);
		
	}

	@Override
	@Transactional
	public void delete(String id) {
		Genre existing = repository.findOne(id);
		if(existing == null){
			throw new GenreNotFoundException("Genre with id "+ id + "not found");
		}
		repository.delete(existing);
		
	}

}
