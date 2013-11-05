package br.org.open.sae.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="tbdeficiencia")
public class NecessidadeEspecial extends Entidade{
	
	private static final long serialVersionUID = 1L;

	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoNecessidade tipo;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoNecessidade getTipoNecessidade() {
		return tipo;
	}
	
	public void setTipoNecessidade(TipoNecessidade tipo) {
		this.tipo = tipo;
		this.tipo.configure(this);
	}

}
