package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Paciente;

public class PacienteDAO extends GenericDAO<Paciente, Long> {

	public PacienteDAO(Class<Paciente> objectClass) {
		super(objectClass);
	}

	@Override
	protected Class<Paciente> getEntityKlass() {
		return Paciente.class;
	}
	
	@Override
	public Paciente save(Paciente x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

}
