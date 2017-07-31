package com.lph.model.enumeration;

public enum EstadoCivilEnum {
	CASADO("Casado"),
	SOLTEIRO("Solteiro"),
	SEPARADO_JUDICIALMENTE("Separado judicialmente"),
	VIUVO("Viúvo"),
	DIVORCIADO("Divorciado");
	
	private String nome;

	private EstadoCivilEnum(String nome) {
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
