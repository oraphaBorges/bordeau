package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Episodio;
import br.com.bordeau.model.Podcast;

@Repository
@Transactional
public class IndexDAO {

	@PersistenceContext
	private EntityManager manager;

	public List<Episodio> novosEpisodios() {
		return manager.createQuery("SELECT p FROM Episodio p ORDER BY RAND() ", Episodio.class).setMaxResults(3)
				.getResultList();
	}

	public List<Episodio> EpisodiosEmAlta() {
		return manager.createQuery("SELECT p FROM Episodio p ORDER BY RAND() ", Episodio.class).setMaxResults(6)
				.getResultList();
	}

	public List<Podcast> novosPodcasts() {
		return manager.createQuery("SELECT p FROM Podcast p WHERE ativo = true ORDER BY RAND()", Podcast.class).setMaxResults(3)
				.getResultList();
	}

	public List<Podcast> PodcastsEmAlta() {
		return manager.createQuery("SELECT p FROM Podcast p WHERE ativo = true ORDER BY RAND() ", Podcast.class).setMaxResults(6)
				.getResultList();
	}
}
