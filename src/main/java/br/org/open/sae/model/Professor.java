package br.org.open.sae.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tbprofessor")
public class Professor extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String titulo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
