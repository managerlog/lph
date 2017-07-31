package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Compromisso;

public class CompromissoDAO extends GenericDAO<Compromisso, Long> {

	public CompromissoDAO(Class<Compromisso> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<Compromisso> getEntityKlass() {
		return Compromisso.class;
	}
	
	@Override
	public Compromisso save(Compromisso x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
