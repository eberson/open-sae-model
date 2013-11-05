package br.org.open.sae.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name="porlogin", query="select u from Usuario u where u.login = :login")})
@Table(name = "tbusuario")
@Entity
public class Usuario extends Entidade {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank
	private String nome;

	@Column(unique = true, nullable = false)
	@NotNull
	@NotBlank
	private String login;

	@NotNull
	@NotBlank
	@Length(min = 6, max = 20)
	private String senha;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String login, String senha) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
