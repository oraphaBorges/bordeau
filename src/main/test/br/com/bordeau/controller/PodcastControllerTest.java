package br.com.bordeau.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.bordeau.model.enums.TipoUsuario;
import br.com.bordeau.trash.Podcast;
import br.com.bordeau.trash.Usuario;
import br.com.bordeau.util.TestInstances;

public class PodcastControllerTest {

	private Usuario ouvinte;
	private Usuario criador;
	private Podcast podcastTeste;
	private Podcast podcastRetorno;

	@Before
	public void instanciarAtributos() {
		this.ouvinte = TestInstances.usuarioTeste(TipoUsuario.OUVINTE);
		this.criador = TestInstances.usuarioTeste(TipoUsuario.CRIADOR_DE_CONTEUDO);
		this.podcastTeste = new Podcast();
	}

	@Test
	public void deveCriarPodcastDoCriadorDeConteudo() {

	}

	@Test
	public void naoDeveCriarPodcastDoOuvinte() {

	}

	@Test
	public void deveRetornarOsDadosDoPodcastCorretos() {

	}
		
}