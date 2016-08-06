package io.pratik.Movie.service;

import io.pratik.Movie.entity.Movie;
import io.pratik.Movie.exception.MovieAlreadyExistsException;
import io.pratik.Movie.exception.MovieNotFoundException;
import io.pratik.Movie.repository.MovieRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository repository;
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	@Override
	public Movie findByName(String name) {
			Movie existing = repository.findByName(name);
			if(existing == null){
				throw new MovieNotFoundException("Movie with name "+ name +" not found");
			}
			return existing;
		}

	@Override
	@Transactional
	public Movie create(Movie mov) {
		Movie existing = repository.findByName(mov.getName());
		if(existing != null){
			throw new MovieAlreadyExistsException("Movie "+ mov.getName() +" already exists");
		}
		return repository.create(mov);
	}

	@Override
	@Transactional
	public Movie update(String name, Movie mov) {
		Movie existing = repository.findByName(name);
		if(existing == null){
			throw new MovieNotFoundException("Movie with name "+ name +" not found");
		}
		return repository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String name) {
		Movie existing = repository.findByName(name);
		if(existing == null){
			throw new MovieNotFoundException("Movie with name "+ name +" not found");
		}
		repository.delete(existing);
	}
	
	}


