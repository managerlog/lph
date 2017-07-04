package com.lph.dao;

import javax.persistence.EntityManager;

public interface DaoFactory {

	void deleteTables();
	EntityManager getEntityManager();

	EnderecoDAO getEnderecoDAO();
	UnidadeFederativaDAO getUnidadeFederativaDAO();
	MunicipioDAO getMunicipioDAO();
	NutricionistaDAO getNutricionistaDAO();

}
