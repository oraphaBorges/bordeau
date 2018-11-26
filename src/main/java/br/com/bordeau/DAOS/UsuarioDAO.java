package br.com.bordeau.DAOS;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public Usuario findByEmail(String email) {
		Usuario usuario = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
				.setParameter("email", email).getSingleResult();

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário " + email + " não exite");
		}
		System.out.println("Usuario Encontrado:" + usuario.getEmail());
		return usuario;
	}

	public void gravar(Usuario usuario) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hasSenha = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(hasSenha);
		
		manager.persist(usuario);
		System.out.println("Usuário Criado");
	}

	public List<Usuario> lista() {
		return manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
		System.out.println("Usuário Atualizado");
	}

}
