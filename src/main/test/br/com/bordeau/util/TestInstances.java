package br.com.bordeau.util;

import java.util.Random;

import br.com.bordeau.model.enums.TipoUsuario;
import br.com.bordeau.trash.Endereco;
import br.com.bordeau.trash.Usuario;

public class TestInstances {
	
	private static Random random = new Random();
	
	public static Usuario usuarioTeste(TipoUsuario tipoUsuario) {
		Usuario usuarioTeste = new Usuario();
		usuarioTeste.setId(random.nextLong());
		usuarioTeste.setNome("Fulanxs");
		usuarioTeste.setEndereco(new Endereco("rua da miliancia"));
		usuarioTeste.setEmail("militei@telao.io");
		usuarioTeste.setSenha("lacrei1124");
		usuarioTeste.setTipoUsuario(tipoUsuario);
		return usuarioTeste;
	}
}
