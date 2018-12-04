package br.com.bordeau.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id private String nome;
	
	public Role(){
	}
	
	public Role(String permissao) {
		this.nome = permissao;
	}

	@Override
	public String getAuthority() {
		return this.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
