package br.com.bordeau.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Avaliacao {
	@Id
	private Long id;
	private Double avaliacao;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Episodio episodio;
	
	//Getters e Setters
	public Double getAvaliacao() {
		return avaliacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Episodio getEpisodio() {
		return episodio;
	}
	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}
	
}
