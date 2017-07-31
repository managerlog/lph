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

import com.lph.model.enumeration.EstadoCivilEnum;
import com.lph.model.enumeration.GeneroEnum;

@Entity
public class Paciente implements Serializable {

	/**
	 * author Alex J Costa
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Calendar dataNascimento;
	
	@ManyToOne
	private Profissao profissao;
	
	@Column(name="estado_civil")
	@Enumerated(EnumType.STRING)
	private EstadoCivilEnum estadoCivil;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToOne
	private NivelSocioEconomico nivelSocioEconomico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Profissao getProfissao() {
		return profissao;
	}

	public void setProfissao(Profissao profissao) {
		this.profissao = profissao;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public NivelSocioEconomico getNivelSocioEconomico() {
		return nivelSocioEconomico;
	}

	public void setNivelSocioEconomico(NivelSocioEconomico nivelSocioEconomico) {
		this.nivelSocioEconomico = nivelSocioEconomico;
	}
	
	
}
