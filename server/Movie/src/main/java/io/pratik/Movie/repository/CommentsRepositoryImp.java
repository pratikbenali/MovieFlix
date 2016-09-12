package io.pratik.Movie.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.pratik.Movie.entity.Comments;

@Repository
public class CommentsRepositoryImp implements CommentsRepository {

	@PersistenceContext
	private EntityManager em;
	
	//User user = new User();
	
	@Override
	public Comments findOne(String id) {
			return em.find(Comments.class, id);		
	}
	

	@Override
	public Comments findByName(String name) {
		TypedQuery<Comments> query = em.createNamedQuery("Comments.findByName", Comments.class);
		query.setParameter("pName", name);
		List<Comments> comment = query.getResultList();
		if (comment != null && comment.size() == 1) {
			return comment.get(0);
		}
		return null;
		
	}
	
	@Override
	public Comments create(Comments com) {
	//	em.persist(user);
	//	com.setUser(user);
		em.persist(com);
		return null;
	}

	@Override
	public Comments update(Comments com) {
	//	em.merge(user);
	//	com.setUser(user);
		em.persist(com);
		return null;
	}

	@Override
	public void delete(Comments com) {
	em.remove(com);
		
	}




}
