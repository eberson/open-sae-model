package br.org.open.sae.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbhabilitacao")
public class Habilitacao extends Entidade{

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
