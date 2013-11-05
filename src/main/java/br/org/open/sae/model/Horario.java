package br.org.open.sae.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "segunda")),
			@AttributeOverride(name = "horario", column = @Column(name = "segunda_horario")) })
	@Embedded
	private HorarioDia segunda;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "terca")),
			@AttributeOverride(name = "horario", column = @Column(name = "terca_horario")) })
	@Embedded
	private HorarioDia terca;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "quarta")),
			@AttributeOverride(name = "horario", column = @Column(name = "quarta_horario")) })
	@Embedded
	private HorarioDia quarta;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "quinta")),
			@AttributeOverride(name = "horario", column = @Column(name = "quinta_horario")) })
	@Embedded
	private HorarioDia quinta;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "sexta")),
			@AttributeOverride(name = "horario", column = @Column(name = "sexta_horario")) })
	@Embedded
	private HorarioDia sexta;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "sabado")),
			@AttributeOverride(name = "horario", column = @Column(name = "sabado_horario")) })
	@Embedded
	private HorarioDia sabado;

	@AttributeOverrides({
			@AttributeOverride(name = "dia", column = @Column(name = "domingo")),
			@AttributeOverride(name = "horario", column = @Column(name = "domingo_horario")) })
	@Embedded
	private HorarioDia domingo;

	public HorarioDia getSegunda() {
		return segunda;
	}

	public void setSegunda(HorarioDia segunda) {
		this.segunda = segunda;
	}

	public HorarioDia getTerca() {
		return terca;
	}

	public void setTerca(HorarioDia terca) {
		this.terca = terca;
	}

	public HorarioDia getQuarta() {
		return quarta;
	}

	public void setQuarta(HorarioDia quarta) {
		this.quarta = quarta;
	}

	public HorarioDia getQuinta() {
		return quinta;
	}

	public void setQuinta(HorarioDia quinta) {
		this.quinta = quinta;
	}

	public HorarioDia getSexta() {
		return sexta;
	}

	public void setSexta(HorarioDia sexta) {
		this.sexta = sexta;
	}

	public HorarioDia getSabado() {
		return sabado;
	}

	public void setSabado(HorarioDia sabado) {
		this.sabado = sabado;
	}

	public HorarioDia getDomingo() {
		return domingo;
	}

	public void setDomingo(HorarioDia domingo) {
		this.domingo = domingo;
	}

}
