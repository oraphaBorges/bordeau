package br.com.bordeau.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import br.com.bordeau.model.Usuario;

public class PodcastControllerTest {

	private Usuario ouvinte;
	private Usuario criador;
	private Podcast podcastTeste;
	private Podcast podcastRetorno;

	@Before
	public void criarUsuarios() {
		this.ouvinte = new Usuario();
		this.criador = new Usuario();
		this.podcastTeste = new Podcast();
	}

	@Test
	public void deveCriarPodCastDoUsuarioCriadorDeConteudo() {

	}

	@Test
	public void naoDeveCriarPodCastDoUsuarioOuvinte() {

	}

	@Test
	public void deveRetornarOsDadosDoPodcastCorretos() {

	}
	
	
}