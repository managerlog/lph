package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.UnidadeFederativa;

public class UnidadeFederativaDAO extends GenericDAO<UnidadeFederativa, Long> {

	public UnidadeFederativaDAO(Class<UnidadeFederativa> nclass) {
		super(nclass);
	}
	
	@Override
	protected Class<UnidadeFederativa> getEntityKlass() {
		return UnidadeFederativa.class;
	}
	
	@Override
	public UnidadeFederativa save(UnidadeFederativa u) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(u);
	}

}
