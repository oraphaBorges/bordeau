package br.com.bordeau.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.bordeau.model.Podcast;
import br.com.bordeau.model.Usuario;
import br.com.bordeau.util.TestInstances;

public class PodcastControllerTest {

	private Usuario ouvinte;
	private Usuario criador;
	private Podcast podcastTeste;
	private Podcast podcastRetorno;

	@Before
	public void instanciarAtributos() {
		this.ouvinte = TestInstances.usuarioTeste();
		this.criador = new Usuario();
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