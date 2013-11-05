package br.org.open.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbaula")
public class Aula extends Entidade {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="etapa")
	private Etapa etapa;

	@ManyToMany
	@JoinTable(name="tb_aula_tem_professores", 
	           joinColumns={@JoinColumn(name="codigo_aula")},
	           inverseJoinColumns={@JoinColumn(name="codigo_professor")})
	private List<Professor> professores;
	
	@ManyToOne
	@JoinColumn(name="disciplina")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name="turma")
	private Turma turma;

	public Etapa getEtapa() {
		return etapa;
	}
	
	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public List<Professor> getProfessores() {
		if(professores == null){
			professores = new ArrayList<Professor>();
		}
		
		return professores;
	}
	
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	
	public void addProfessor(Professor professor){
		getProfessores().add(professor);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
