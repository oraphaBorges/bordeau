package br.com.bordeau.model;

import javax.persistence.Entity;
import javax.persistence.Id;

//Classe provisória

@Entity
public class Endereco {
	@Id
	private Long id;
	private String descricao;
	
	//Getters e Setters
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
