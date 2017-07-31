package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Profissao;

public class ProfissaoDAO extends GenericDAO<Profissao, Long> {

	public ProfissaoDAO(Class<Profissao> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<Profissao> getEntityKlass() {
		return Profissao.class;
	}
	
	@Override
	public Profissao save(Profissao x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
