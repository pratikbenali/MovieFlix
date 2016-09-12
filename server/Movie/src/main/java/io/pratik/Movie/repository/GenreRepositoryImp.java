package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Genre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class GenreRepositoryImp implements GenreRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Genre> findAll() {
		TypedQuery<Genre> query = em.createNamedQuery("Genre.findAll", Genre.class);
		return query.getResultList();
	}

	@Override
	public Genre findOne(String id) {
		return em.find(Genre.class, id);
	}

	@Override
	public Genre create(Genre gen) {
		em.persist(gen);
		return gen;
	}

	@Override
	public Genre update(Genre gen) {
		return em.merge(gen);
	}

	@Override
	public void delete(Genre gen) {
		em.remove(gen);
	}
}
