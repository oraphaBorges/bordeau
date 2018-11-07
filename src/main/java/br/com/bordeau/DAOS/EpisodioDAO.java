package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Episodio;

@Repository
@Transactional
public class EpisodioDAO{
	
	@PersistenceContext
	private EntityManager manager; 

	public Episodio findById(Integer id) {
		return manager.createQuery("SELECT distinct(p) FROM Episodio p "
				+ "WHERE p.id = :id",Episodio.class)
			.setParameter("id",id)
			.getSingleResult();
	}

	public void gravar(Object object) {
		Episodio episodio = (Episodio) object;
		manager.persist(episodio);
	}

	public List<Episodio> listar() {
		return manager.createQuery("SELECT p FROM Episodio p",Episodio.class).getResultList();
	}

	public void update(Object object) {
		Episodio episodio = (Episodio) object;
		manager.merge(episodio);
	}

	public void remove(Object object) {
		Episodio episodio = (Episodio) object;
		manager.remove(episodio);
	}




}
