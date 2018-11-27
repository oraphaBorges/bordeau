package br.com.bordeau.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Episodio {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String audioPath;
	@Column(columnDefinition="TEXT")
	private String descricao;
	private String capa;
	@Column(columnDefinition="TEXT")
	private String htmlComplementar;
		
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAudio() {
		return audioPath;
	}
	public void setAudio(String path) {
		this.audioPath = path;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
	public String getHtmlComplementar() {
		return htmlComplementar;
	}
	public void setHtmlComplementar(String htmlComplementar) {
		this.htmlComplementar = htmlComplementar;
	}

}