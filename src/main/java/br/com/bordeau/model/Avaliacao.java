package br.com.bordeau.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avaliacao {
	@Id
	private Long id;
	private Double avaliacao;
	private Usuario usuario;
	
	//Getters e Setters
	public Double getAvaliacao() {
		return avaliacao;
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
	
}
