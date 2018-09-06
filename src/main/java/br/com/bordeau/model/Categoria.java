package br.com.bordeau.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Descricao;
	@OneToMany
	private List<Podcast> podcasts;
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public List<Podcast> getPodcasts() {
		return podcasts;
	}
	public void setPodcasts(List<Podcast> podcasts) {
		this.podcasts = podcasts;
	}
	
}
