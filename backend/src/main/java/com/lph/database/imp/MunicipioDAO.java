package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Municipio;

public class MunicipioDAO extends GenericDAO<Municipio, Long> {

	public MunicipioDAO(Class<Municipio> nclass) {
		super(nclass);
	}
	
	@Override
	protected Class<Municipio> getEntityKlass() {
		return Municipio.class;
	}
	
	@Override
	public Municipio save(Municipio n) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(n);
	}

}
