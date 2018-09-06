package br.com.bordeau.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comentario {
	@Id
	private int id;
	private Usuario autor;
	private Comentario respostas;
	
	//Getters e Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setUsuario(Usuario autor) {
		this.autor = autor;
	}
	
	public Usuario getUsuario() {
		return autor;
	}
	
	public void setComentario(Comentario resposta) {
		this.respostas = resposta;
	}
	
	public Comentario getRepostas() {
		return respostas;
	}
}
