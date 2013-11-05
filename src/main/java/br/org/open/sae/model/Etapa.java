package br.org.open.sae.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "tbetapa")
public class Etapa extends Entidade {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private int ano;

	@ManyToOne
	@JoinColumn(name="turma")
	private Turma turma;
	
	private boolean encerrada = false;

	@ManyToOne
	@JoinColumn(name="modulo")
	private Modulo modulo;

	@JsonIgnore
	@OneToMany(mappedBy="etapa", fetch=FetchType.LAZY, cascade={CascadeType.ALL})
	private List<Aula> items;
	
	public boolean isEncerrada() {
		return encerrada;
	}
	
	public void setEncerrada(boolean encerrada) {
		this.encerrada = encerrada;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public List<Aula> getItems() {
		if(items == null){
			items = new ArrayList<Aula>();
		}
		
		return items;
	}

	public void setItems(List<Aula> items) {
		this.items = items;
	}
	
	public void addItem(Aula item){
		getItems().add(item);
		item.setEtapa(this);
	}
}
