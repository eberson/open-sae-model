package br.org.open.sae.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HorarioDia implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dia;
	private String horario;

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
