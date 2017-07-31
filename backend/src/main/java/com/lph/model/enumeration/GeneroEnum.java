package com.lph.model.enumeration;

public enum GeneroEnum {
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTRO("Outro");
	
	private String nome;

	private GeneroEnum(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
}
