package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.trash.Podcast;

@Repository
@Transactional
public class PodcastDao {
	
	@PersistenceContext
	private EntityManager manager; 

	public Podcast findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void gravar(Object object) {
		// TODO Auto-generated method stub
		
	}

	public List<Podcast> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Object object) {
		Podcast podcast = (Podcast) object;
	}

	public void remove(Object object) {
		Podcast podcast = (Podcast) object;		
	}




}
