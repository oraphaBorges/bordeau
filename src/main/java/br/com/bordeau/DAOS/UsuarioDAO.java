package br.com.bordeau.DAOS;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bordeau.model.Role;
import br.com.bordeau.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;

	public Usuario findByEmail(String email) {
		Usuario usuario = manager.find(Usuario.class, email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário " + email + " não exite");
		}
		return usuario;
	}

	public List<Usuario> lista() {
		return manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
	}

	public void gravar(Usuario usuario) {
		passwordEncoder(usuario);
		setPermissoes(usuario);
		manager.persist(usuario);
	}

	public void update(Usuario usuario) {
		passwordEncoder(usuario);
		setPermissoes(usuario);
		usuario.getAuthorities().forEach(autho -> manager.merge(autho));
		manager.merge(usuario);
	}

	private void passwordEncoder(Usuario usuario) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hasSenha = passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(hasSenha);
	}

	private void setPermissoes(Usuario usuario) {
		Role role_ouvinte, role_criador;
		role_ouvinte = manager.find(Role.class, "ROLE_OUVINTE");
		if (role_ouvinte == null)
			role_ouvinte = new Role("ROLE_OUVINTE");

		if (usuario.getPodcast().getAtivo()) {
			role_criador = manager.find(Role.class, "ROLE_CRIADOR");
			if (role_criador == null)
				role_criador = new Role("ROLE_CRIADOR");
			usuario.setRoles(Arrays.asList(role_ouvinte, role_criador));
		} else {
			usuario.setRoles(Arrays.asList(role_ouvinte));
		}
		usuario.getRoles().forEach(e -> System.out.println(e.getNome()));

	}

	public void removeConta(Usuario usuario) {
		usuario.getPodcast().getEpisodios().forEach(eps -> manager.remove(eps));
		manager.remove(usuario.getPodcast());
		manager.remove(usuario);
	}
}
