package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.bordeau.model.Podcast;

@Repository
@Transactional
public class PodcastDao implements DAO{
	
	@PersistenceContext
	private EntityManager manager; 

	public Podcast findById(Integer id) {
		return manager.createQuery("SELECT distinct(p) FROM Podcast p "
				+ "WHERE p.id = :id",Podcast.class)
			.setParameter("id",id)
			.getSingleResult();
	}

	@Override
	public void gravar(Object object) {
		Podcast podcast = (Podcast) object;
		manager.persist(podcast);
	}

	@Override
	public List<Podcast> listar() {
		return manager.createQuery("SELECT p FROM Podcast p",Podcast.class).getResultList();
	}

	@Override
	public void update(Object object) {
		Podcast podcast = (Podcast) object;
		manager.merge(podcast);
	}

	@Override
	public void remove(Object object) {
		Podcast podcast = (Podcast) object;
		manager.remove(podcast);
	}




}
