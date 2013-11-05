package br.org.open.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="tbturma")
public class Turma extends Entidade{

	private static final long serialVersionUID = 1L;
	
	private String nome;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;
	
	@JsonIgnore
	@ManyToMany(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	@JoinTable(name = "tb_curso_tem_alunos", 
	           joinColumns = { @JoinColumn(name = "codigo_turma") }, 
	           inverseJoinColumns = { @JoinColumn(name = "codigo_curso") })
	private List<Aluno> alunos;
	
	private boolean encerrada = false;
	
	public boolean isEncerrada() {
		return encerrada;
	}
	
	public void setEncerrada(boolean encerrada) {
		this.encerrada = encerrada;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Aluno> getAlunos() {
		if(alunos == null){
			alunos = new ArrayList<Aluno>();
		}
		
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void addAluno(Aluno aluno){
		if(aluno == null){
			throw new IllegalArgumentException("Um aluno inválido foi informado (null)");
		}
		
		aluno.getTurmas().add(this);
		getAlunos().add(aluno);
	}
}
