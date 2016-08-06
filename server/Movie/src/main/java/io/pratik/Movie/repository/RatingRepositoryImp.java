package io.pratik.Movie.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.pratik.Movie.entity.Rating;
import io.pratik.Movie.entity.User;

@Repository
public class RatingRepositoryImp implements RatingRepository {

	@PersistenceContext
	private EntityManager em;
	
	User user = new User();

	@Override
	public List<Rating> findAll() {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findAll", Rating.class);
		return query.getResultList();
	}

	@Override
	public Rating findOne(String id) {
		return em.find(Rating.class, id);
	}

	@Override
	public Rating findByName(String name) {
		TypedQuery<Rating> query = em.createNamedQuery("Rating.findByName", Rating.class);
		query.setParameter("pName", name);
		List<Rating> rate = query.getResultList();
		if (rate != null && rate.size() == 1) {
			return rate.get(0);
		}
		return null;
	}

	@Override
	public Rating create(Rating rate) {
	//	em.persist(user);
	//	rate.setUser(user);
		em.persist(rate);
		return rate;
	}

	@Override
	public Rating update(Rating rate) {
		return em.merge(rate);
	}

	@Override
	public void delete(Rating rate) {
		em.remove(rate);
	}
}
