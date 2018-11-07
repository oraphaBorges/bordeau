package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Episodio;

@Repository
@Transactional
public class IndexDAO {

	@PersistenceContext
	private EntityManager manager; 
	
	public List<Episodio> novos() {
		return manager.createQuery("SELECT p FROM Episodio p ",Episodio.class).setMaxResults(3).getResultList();
	}
	public List<Episodio> emAlta() {
		return manager.createQuery("SELECT p FROM Episodio p ",Episodio.class).setMaxResults(6).getResultList();
	}
}
