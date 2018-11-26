package br.com.bordeau.trash;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Usuario autor;
	private List<Comentario> respostas;
	
	//Getters e Setters
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
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
