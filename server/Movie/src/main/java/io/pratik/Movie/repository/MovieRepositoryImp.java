package io.pratik.Movie.repository;

import io.pratik.Movie.entity.Genre;
import io.pratik.Movie.entity.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


@Repository
public class MovieRepositoryImp implements MovieRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	Genre genre = new Genre();

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findByName(String name) {
		return em.find(Movie.class, name);

	}

	@Override
	public Movie create(Movie mov) {
		em.persist(genre);
	//	mov.setGenre((List<Genre>) genre);
		em.persist(mov);
		return mov;
	}

	@Override
	public Movie update(Movie mov) {
		return em.merge(mov);
	}

	@Override
	public void delete(Movie mov) {
		em.remove(mov);		
	}

}
