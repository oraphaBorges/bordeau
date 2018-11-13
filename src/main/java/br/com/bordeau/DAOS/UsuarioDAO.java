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
		List<Usuario> usuarios = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.email = :email",
				Usuario.class)
		.setParameter("email", email)
		.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException ("Usuário "+email+" não exite");
		}
		return usuarios.get(0);
	}
	
	public void adicionaUsuario(Usuario usuario){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hasSenha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(hasSenha);
        usuario.setRoles(Arrays.asList(new Role("ROLE_ADMIN")));
        manager.persist(usuario);
        }

    public List<Usuario> lista() {
        return manager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

}
