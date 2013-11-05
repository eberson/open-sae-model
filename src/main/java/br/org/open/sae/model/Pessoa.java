package br.org.open.sae.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa extends Entidade {

	private static final long serialVersionUID = 1L;

	private String nome;
	
	@AttributeOverrides({
		@AttributeOverride(name="numero", column = @Column(name="rg_numero")),
		@AttributeOverride(name="uf", column = @Column(name="rg_uf")),
	})
	@Embedded
	private RG rg;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@AttributeOverrides({
		@AttributeOverride(name="cidade", column = @Column(name="cidade_natal")),
		@AttributeOverride(name="uf", column = @Column(name="uf_natal")),
	})
	@Embedded
	private Nascimento nascimento;

	@AttributeOverrides({
		@AttributeOverride(name="ddd", column = @Column(name="pddd")),
		@AttributeOverride(name="numero", column = @Column(name="pnumero")),
		@AttributeOverride(name="tipo", column = @Column(name="ptipo"))
	})
	@Embedded
	private Telefone fonePrincipal;
	
	@AttributeOverrides({
		@AttributeOverride(name="ddd", column = @Column(name="oddd")),
		@AttributeOverride(name="numero", column = @Column(name="onumero")),
		@AttributeOverride(name="tipo", column = @Column(name="otipo"))
	})
	@Embedded
	private Telefone foneOpcional;
	
	@Embedded
	private Endereco endereco;
	
	private String email;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="usuario")
	private Usuario usuario;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Nascimento getNascimento() {
		return nascimento;
	}

	public void setNascimento(Nascimento nascimento) {
		this.nascimento = nascimento;
	}

	public Telefone getFonePrincipal() {
		return fonePrincipal;
	}

	public void setFonePrincipal(Telefone fonePrincipal) {
		this.fonePrincipal = fonePrincipal;
	}

	public Telefone getFoneOpcional() {
		return foneOpcional;
	}

	public void setFoneOpcional(Telefone foneOpcional) {
		this.foneOpcional = foneOpcional;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
