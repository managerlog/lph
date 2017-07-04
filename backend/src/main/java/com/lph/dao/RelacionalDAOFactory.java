package com.lph.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RelacionalDAOFactory implements DaoFactory {

	private static final String MYSQL_JPA_PU = "MY_SQL_JPA_PU";

	private EnderecoDAO enderecoDAO;
	private UnidadeFederativaDAO unidadeFederativaDAO;
	private MunicipioDAO municipioDAO;
	private NutricionistaDAO nutricionistaDAO;

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public RelacionalDAOFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory(
				MYSQL_JPA_PU, getIpServidor());
		entityManager = entityManagerFactory.createEntityManager();
	}

	private Map<String, Object> getIpServidor() {
		Map<String, Object> propiedades = new HashMap<String, Object>();
		String enderecoIP = "";
		propiedades.put("hibernate.connection.url", "jdbc:mysql://"
				+ enderecoIP + ":3306/ellosgestor");
		return propiedades;
	}

	public EnderecoDAO getEnderecoDAO() {
		if (this.enderecoDAO == null) {
			this.enderecoDAO = new EnderecoDAO(entityManagerFactory,
					entityManager);
		}
		return this.enderecoDAO;
	}

	public UnidadeFederativaDAO getUnidadeFederativaDAO() {
		if (this.unidadeFederativaDAO == null) {
			this.unidadeFederativaDAO = new UnidadeFederativaDAO(
					entityManagerFactory, entityManager);
		}
		return this.unidadeFederativaDAO;
	}

	public MunicipioDAO getMunicipioDAO() {
		if (this.municipioDAO == null) {
			this.municipioDAO = new MunicipioDAO(entityManagerFactory,
					entityManager);
		}
		return this.municipioDAO;
	}
	
	public NutricionistaDAO getNutricionistaDAO() {
		if (this.nutricionistaDAO == null) {
			this.nutricionistaDAO = new NutricionistaDAO(entityManagerFactory,
					entityManager);
		}
		return this.nutricionistaDAO;
	}
	

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void deleteTables() {
		// TODO Auto-generated method stub
		
	}


}