package br.com.bordeau.DAOS;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Role;

@Repository
@Transactional
public class RoleDAO {

	@PersistenceContext
	private EntityManager manager;

	public Role findByRole(String roleNome) {
		Role role = new Role(roleNome);
		if(!manager.contains(role)) {
			manager.persist(role);
		}
		return manager.find(Role.class , roleNome);
	}

}
