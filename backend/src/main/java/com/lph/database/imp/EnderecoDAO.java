package com.lph.database.imp;

import com.lph.model.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco, Long> {

	public EnderecoDAO(Class<Endereco> eclass){
		super(eclass);
	}

	@Override
	protected Class<Endereco> getEntityKlass() {
		return Endereco.class;
	}

}
