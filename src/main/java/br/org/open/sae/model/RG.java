package br.org.open.sae.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RG implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;
	private String uf;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
