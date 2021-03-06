package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Podcast;

@Repository
@Transactional
public class PodcastDAO {
	
	@PersistenceContext
	private EntityManager manager; 

	public Podcast findById(Long id) {
		return manager.find(Podcast.class, id);
	}

	public void gravar(Object object) {
		Podcast podcast = (Podcast) object;
		manager.persist(podcast);
	}

	public List<Podcast> listar() {
		return manager.createQuery("SELECT p FROM Podcast p",Podcast.class).getResultList();
	}
	
	public List<Podcast> novos() {
		return manager.createQuery("SELECT p FROM Podcast p ORDER BY RAND() ",Podcast.class).setMaxResults(3).getResultList();
	}
	public List<Podcast> emAlta() {
		return manager.createQuery("SELECT p FROM Podcast p ORDER BY RAND() ",Podcast.class).setMaxResults(6).getResultList();
	}

	public void update(Object object) {
		Podcast podcast = (Podcast) object;
		manager.merge(podcast);
	}

	public void remove(Object object) {
		Podcast podcast = (Podcast) object;
		manager.remove(podcast);	
	}

	public List<Podcast> recomendacoes() {
		return manager.createQuery("SELECT p FROM Podcast p ORDER BY RAND()",Podcast.class).setMaxResults(5).getResultList();
	}




}
