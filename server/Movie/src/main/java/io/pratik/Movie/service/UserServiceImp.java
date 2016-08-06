package io.pratik.Movie.service;

import java.util.List;

import io.pratik.Movie.entity.Rating;
import io.pratik.Movie.entity.User;
import io.pratik.Movie.exception.UserAlreadyExistsException;
import io.pratik.Movie.exception.UserNotFoundException;
import io.pratik.Movie.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserRepository repository;
	
	//@Autowired
	//RatingServiceImp rService;
	

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("User with id "+ id + "not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
//		String ratingId = user.getRating().getId();
//		System.out.println("ratingId:" + ratingId);
//		
//		Rating rate = rService.findOne(ratingId);
//	//	rService.create(rate);
//		user.setRating(rate);
				
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			throw new UserAlreadyExistsException("User with email "+ user.getEmail() +" already exists");
		}
		return repository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("User with id "+ id + "not found");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFoundException("User with id "+ id + "not found");
		}
		repository.delete(existing);
	}

}
