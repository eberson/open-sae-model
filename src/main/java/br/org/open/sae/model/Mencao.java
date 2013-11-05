package br.org.open.sae.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Embeddable
public class Mencao implements Serializable {

	private static final long serialVersionUID = 1L;

	private String mencao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
	public Mencao(String mencao, Aluno aluno, Disciplina disciplina) {
		super();
		this.mencao = mencao;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}

	public Mencao() {
		super();
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String getMencao() {
		return mencao;
	}
	
	public void setMencao(String mencao) {
		this.mencao = mencao;
	}
}
