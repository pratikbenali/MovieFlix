package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Comments;
import io.pratik.Movie.entity.Rating;
import io.pratik.Movie.entity.User;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	List<Comments> comment = new ArrayList<Comments>();

//	Rating rate = new Rating();
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		List<User> user = query.getResultList();
		if (user != null && user.size() == 1) {
			return user.get(0);
		}
		return null;
	}

	@Override
	public User create(User user) {
//		em.persist(rate);
//		user.setRating(rate);
//		em.persist(comment);
//		user.setComment(comment);
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
	      em.remove(user);
		
	}

}
