package br.com.bordeau.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	@Id
	private int id;
	@ManyToOne
	private Usuario autor;
	private List<Comentario> respostas;
	
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
	
	public void setComentario(List<Comentario> respostas) {
		this.respostas = respostas;
	}
	
	public List<Comentario> getRepostas() {
		return respostas;
	}
}
