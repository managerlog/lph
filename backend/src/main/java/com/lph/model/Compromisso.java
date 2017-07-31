package com.lph.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.lph.model.enumeration.TipoDeCompromissoEnum;

@Entity
public class Compromisso implements Serializable {
	
	/**
	 * author Alex J Costa
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@NotNull
	private Agenda agenda;
	
	@ManyToOne
	private Paciente paciente;
	
	@ManyToOne
	private Nutricionista nutricionista;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_compromisso")
	private Calendar dataDoCompromisso;
	
	@Temporal(TemporalType.DATE)
	@Column(name="horario_inicio_compromisso")
	private Calendar horarioInicioCompromisso;
	
	@Temporal(TemporalType.DATE)
	@Column(name="horario_fim_compromisso")
	private Calendar horarioFimCompromisso;
	
	@Column(name="tipo_consulta")
	@Enumerated(EnumType.STRING)
	private TipoDeCompromissoEnum tipoDeCompromisso;
	
	@Column
	private Double valor;
	
	@Column
	private String observações;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Nutricionista getNutricionista() {
		return nutricionista;
	}

	public void setNutricionista(Nutricionista nutricionista) {
		this.nutricionista = nutricionista;
	}

	public Calendar getDataDoCompromisso() {
		return dataDoCompromisso;
	}

	public void setDataDoCompromisso(Calendar dataDoCompromisso) {
		this.dataDoCompromisso = dataDoCompromisso;
	}

	public Calendar getHorarioInicioCompromisso() {
		return horarioInicioCompromisso;
	}

	public void setHorarioInicioCompromisso(Calendar horarioInicioCompromisso) {
		this.horarioInicioCompromisso = horarioInicioCompromisso;
	}

	public Calendar getHorarioFimCompromisso() {
		return horarioFimCompromisso;
	}

	public void setHorarioFimCompromisso(Calendar horarioFimCompromisso) {
		this.horarioFimCompromisso = horarioFimCompromisso;
	}

	public TipoDeCompromissoEnum getTipoDeCompromisso() {
		return tipoDeCompromisso;
	}

	public void setTipoDeCompromisso(TipoDeCompromissoEnum tipoDeCompromisso) {
		this.tipoDeCompromisso = tipoDeCompromisso;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservações() {
		return observações;
	}

	public void setObservações(String observações) {
		this.observações = observações;
	}

	
}
