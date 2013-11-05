package br.org.open.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "tbcurso")
public class Curso extends Entidade implements Comparable<Curso> {

	private static final long serialVersionUID = 1L;

	public static final String DEFAULT_ICON = "/cursos/curso.png";

	@ManyToOne
	@JoinColumn(name = "habilitacao")
	private Habilitacao habilitacao;

	private String titulo;

	@Column(columnDefinition = "text")
	private String descricao;

	private String matriz;
	private String plano;

	private String icone;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_curso_tem_professores", joinColumns = { @JoinColumn(name = "codigo_curso") }, inverseJoinColumns = { @JoinColumn(name = "codigo_professor") })
	private List<Professor> docentes;

	@JsonIgnore
	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Modulo> modulos;

	@Embedded
	private Horario horario;

	@Column(columnDefinition = "text")
	private String perfilProfissional;

	private int maximoAlunos;
	private String fundamentacaoLegal;

	private boolean ativado = true;

	public Curso() {
		this("", "", DEFAULT_ICON);
	}

	public Curso(String titulo, String descricao, String icone) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.icone = icone != null ? icone : DEFAULT_ICON;
	}

	public Curso(String titulo, String descricao, String icone, String plano) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.plano = plano;
		this.icone = icone != null ? icone : DEFAULT_ICON;
	}

	public int getMaximoAlunos() {
		return maximoAlunos;
	}

	public void setMaximoAlunos(int maximoAlunos) {
		this.maximoAlunos = maximoAlunos;
	}

	public String getFundamentacaoLegal() {
		return fundamentacaoLegal;
	}

	public void setFundamentacaoLegal(String fundamentacaoLegal) {
		this.fundamentacaoLegal = fundamentacaoLegal;
	}

	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
	}

	public Habilitacao getHabilitacao() {
		return habilitacao;
	}

	public void setHabilitacao(Habilitacao habilitacao) {
		this.habilitacao = habilitacao;
	}

	public List<Modulo> getModulos() {
		if (modulos == null) {
			modulos = new ArrayList<Modulo>();
		}

		return modulos;
	}

	public void addModulo(Modulo modulo) {
		getModulos().add(modulo);
		modulo.setCurso(this);
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getMatriz() {
		return matriz;
	}

	public void setMatriz(String matriz) {
		this.matriz = matriz;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public List<Professor> getDocentes() {
		if (docentes == null) {
			docentes = new ArrayList<Professor>();
		}

		return docentes;
	}

	public void addDocente(Professor docente) {
		getDocentes().add(docente);
	}

	public void setDocentes(List<Professor> docentes) {
		this.docentes = docentes;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public String getPerfilProfissional() {
		return perfilProfissional;
	}

	public void setPerfilProfissional(String perfilProfissional) {
		this.perfilProfissional = perfilProfissional;
	}

	@Override
	public int compareTo(Curso o) {
		return titulo.compareTo(o.titulo);
	}

}
