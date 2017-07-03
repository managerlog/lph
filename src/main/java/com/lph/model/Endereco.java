package com.lph.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco implements Serializable{

	/**
	 * author Alex J Costa
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@ManyToOne
	private Municipio municipio;
	
	@Column
	@NotNull
	//@Size(max = 8, min = 8)
	private String cep;

	@Column
	@Size(max = 50, min = 3)
	@NotNull
	private String bairro;

	@Column
	@Size(max = 150)
	private String logradouro;

	@Column
	@Size(max = 10)
	private String numero;
	
	public Endereco() {
		this.municipio = new Municipio();
	}
	
	public Endereco(Municipio municipio, String cep, String bairro, String logradouro,
			String numero) {
		super();
		this.municipio = municipio;
		this.municipio = municipio;
		this.cep = cep;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}
}
