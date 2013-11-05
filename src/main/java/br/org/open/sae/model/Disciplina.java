package br.org.open.sae.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "tbdisciplina")
public class Disciplina extends Entidade implements Comparable<Disciplina> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sigla;
	private double cargaSemanal;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="modulo")
	private Modulo modulo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public double getCargaSemanal() {
		return cargaSemanal;
	}

	public void setCargaSemanal(double cargaSemanal) {
		this.cargaSemanal = cargaSemanal;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Override
	public int compareTo(Disciplina o) {
		return nome.compareTo(o.nome);
	}
}
