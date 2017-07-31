package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.NivelSocioEconomico;

public class NivelSocioEconomicoDAO extends GenericDAO<NivelSocioEconomico, Long> {

	public NivelSocioEconomicoDAO(Class<NivelSocioEconomico> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<NivelSocioEconomico> getEntityKlass() {
		return NivelSocioEconomico.class;
	}
	
	@Override
	public NivelSocioEconomico save(NivelSocioEconomico x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
