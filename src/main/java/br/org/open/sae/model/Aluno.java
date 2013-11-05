package br.org.open.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@NamedQueries({@NamedQuery(name="AlunoPorUsuario", query="select a from Aluno a where a.usuario = :usuario"),
	           @NamedQuery(name="AlunoPorNome", query="select a from Aluno a where a.nome like :nome")})
@Entity
@Table(name="tbaluno")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private RacaCor raca;
	
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private PessoasFamilia pessoas;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private FamiliaRemunerada remunerada;

	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private FamiliaRenda renda;
	
	@JsonIgnore
	@ManyToMany(mappedBy="alunos", fetch=FetchType.LAZY)
	private List<Turma> turmas;

	@JsonIgnore
	private boolean bolsaFamilia;
	@JsonIgnore
	private boolean gemeo;
	private String rm;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name="tb_aluno_tem_necessidade", 
	           joinColumns={@JoinColumn(name="codigo_aluno")},
	           inverseJoinColumns={@JoinColumn(name="codigo_necessidade")})
	private List<NecessidadeEspecial> necessidades;
	
	public List<Turma> getTurmas() {
		if(turmas == null){
			turmas =  new  ArrayList<Turma>();
		}
		
		return turmas;
	}
	
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void setRm(String rm) {
		this.rm = rm;
	}
	
	public String getRm() {
		return rm;
	}
	
	public void createUsuario(){
		String[] split = getNome().split(" ");
		String login = split[0] + "_" + split[split.length - 1];
		setUsuario(new Usuario(getNome(), login.toLowerCase(), "102030"));
	}
	
	public List<NecessidadeEspecial> getNecessidades() {
		if(necessidades == null){
			necessidades = new ArrayList<NecessidadeEspecial>();
		}
		
		return necessidades;
	}
	
	public void addNecessidade(NecessidadeEspecial necessidade){
		getNecessidades().add(necessidade);
	}
	
	public void setNecessidades(List<NecessidadeEspecial> necessidades) {
		this.necessidades = necessidades;
	}

	public RacaCor getRaca() {
		return raca;
	}

	public void setRaca(RacaCor raca) {
		this.raca = raca;
	}

	public PessoasFamilia getPessoas() {
		return pessoas;
	}

	public void setPessoas(PessoasFamilia pessoas) {
		this.pessoas = pessoas;
	}

	public FamiliaRemunerada getRemunerada() {
		return remunerada;
	}

	public void setRemunerada(FamiliaRemunerada remunerada) {
		this.remunerada = remunerada;
	}

	public FamiliaRenda getRenda() {
		return renda;
	}

	public void setRenda(FamiliaRenda renda) {
		this.renda = renda;
	}

	public boolean isBolsaFamilia() {
		return bolsaFamilia;
	}

	public void setBolsaFamilia(boolean bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
	}

	public boolean isGemeo() {
		return gemeo;
	}

	public void setGemeo(boolean gemeo) {
		this.gemeo = gemeo;
	}
}
