package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.AvaliacaoLaboratorial;

public class AvaliacaoLaboratorialDAO extends GenericDAO<AvaliacaoLaboratorial, Long> {

	public AvaliacaoLaboratorialDAO(Class<AvaliacaoLaboratorial> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<AvaliacaoLaboratorial> getEntityKlass() {
		return AvaliacaoLaboratorial.class;
	}
	
	@Override
	public AvaliacaoLaboratorial save(AvaliacaoLaboratorial x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
