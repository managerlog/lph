package com.lph.model.enumeration;

public enum TipoDeCompromissoEnum {
	CONSULTA("Consulta"), 
	RETORNO("Retorno"), 
	PREVISAO_DE_RETORNO("Previsão de retorno"), 
	OUTRO("Outro");
	
	private String nome;

	private TipoDeCompromissoEnum(String nome) {
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
