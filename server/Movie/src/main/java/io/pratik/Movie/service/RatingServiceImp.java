package io.pratik.Movie.service;

import io.pratik.Movie.entity.Rating;
import io.pratik.Movie.entity.User;
import io.pratik.Movie.exception.RatingAlreadyExistsException;
import io.pratik.Movie.exception.RatingNotFoundException;
import io.pratik.Movie.exception.UserNotFoundException;
import io.pratik.Movie.repository.RatingRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository repository;
	@Autowired
	UserService uService;
	
	@Override
	public List<Rating> findAll() {
		return repository.findAll();
		
	}

	@Override
	public Rating findOne(String id) {
		Rating existing = repository.findOne(id);
		if(existing == null){
			throw new RatingNotFoundException("Raing with id "+ id + "not found");
		}
		return existing;
		
	}

	@Override
	@Transactional
	public Rating create(Rating rate) {
		String userId = rate.getUser().getId();
		System.out.println("UserId "+ userId);
		
    	Rating existing = repository.findOne(rate.getId());
		if(existing != null){
			throw new RatingAlreadyExistsException("Rating with id "+ rate.getId() +" already exists");
		}
		else
		{
			User user = uService.findOne(userId);
			rate.setUser(user);
		}
		return repository.create(rate);
	}

	@Override
	@Transactional
	public Rating update(String id, Rating rate) {
		Rating existing = repository.findOne(id);
		if(existing == null){
			throw new RatingNotFoundException("Rating with id "+ id + "not found");
		}
		return repository.update(rate);
		
	}

	@Override
	@Transactional
	public void delete(String id) {
		Rating existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("Rating with id "+ id + "not found");
		}
		repository.delete(existing);
		
	}

}
