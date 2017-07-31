package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Credencial;

public class CredencialDAO extends GenericDAO<Credencial, Long> {

	public CredencialDAO(Class<Credencial> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<Credencial> getEntityKlass() {
		return Credencial.class;
	}
	
	@Override
	public Credencial save(Credencial x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
