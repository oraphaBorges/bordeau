package br.com.bordeau.util;

import br.com.bordeau.model.Endereco;
import br.com.bordeau.model.Usuario;
import br.com.bordeau.model.enums.TipoUsuario;

public class TestInstances {
	public static Usuario usuarioTeste() {
		Usuario usuarioTeste = new Usuario();
		usuarioTeste.setId(55L);
		usuarioTeste.setNome("Fulanxs");
		usuarioTeste.setEndereco(new Endereco("rua da miliancia"));
		usuarioTeste.setEmail("militei@telao.io");
		usuarioTeste.setSenha("lacrei1124");
		usuarioTeste.setTipoUsuario(TipoUsuario.OUVINTE);
		return usuarioTeste;
	}
}
