package com.lph.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "avaliacao_laboratorial")
public class AvaliacaoLaboratorial implements Serializable {
	
	/**
	 * author Alex J Costa
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Calendar data;

	@Column
	private Float hemoglobina;

	@Column
	private Float tiglicerideos;

	@Column
	private Float colesterolTotal;

	@Column
	private Float ldl;

	@Column
	private Float hdl;

	@Column
	private Float vldl;

	@Column
	private Float glicemiaDeJejum;

	@Column
	private Float glicemiaPosPrandial;

	@Column
	private Float pressaoArterial;

	@ManyToOne
	private Paciente paciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Float getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Float hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Float getTiglicerideos() {
		return tiglicerideos;
	}

	public void setTiglicerideos(Float tiglicerideos) {
		this.tiglicerideos = tiglicerideos;
	}

	public Float getColesterolTotal() {
		return colesterolTotal;
	}

	public void setColesterolTotal(Float colesterolTotal) {
		this.colesterolTotal = colesterolTotal;
	}

	public Float getLdl() {
		return ldl;
	}

	public void setLdl(Float ldl) {
		this.ldl = ldl;
	}

	public Float getHdl() {
		return hdl;
	}

	public void setHdl(Float hdl) {
		this.hdl = hdl;
	}

	public Float getVldl() {
		return vldl;
	}

	public void setVldl(Float vldl) {
		this.vldl = vldl;
	}

	public Float getGlicemiaDeJejum() {
		return glicemiaDeJejum;
	}

	public void setGlicemiaDeJejum(Float glicemiaDeJejum) {
		this.glicemiaDeJejum = glicemiaDeJejum;
	}

	public Float getGlicemiaPosPrandial() {
		return glicemiaPosPrandial;
	}

	public void setGlicemiaPosPrandial(Float glicemiaPosPrandial) {
		this.glicemiaPosPrandial = glicemiaPosPrandial;
	}

	public Float getPressaoArterial() {
		return pressaoArterial;
	}

	public void setPressaoArterial(Float pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
