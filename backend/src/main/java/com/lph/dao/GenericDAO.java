package com.lph.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class GenericDAO {

	protected EntityManagerFactory factory;
	protected EntityManager manager;

	public GenericDAO(EntityManagerFactory factory, EntityManager manager) {
		this.factory = factory;
		this.manager = manager;
	}

	protected void criar(Object objeto) throws SQLException, ClassNotFoundException {
		this.iniciarTransacao();
		manager.persist(objeto);
		this.finalizarTransacao();
	}

	protected void atualizar(Object objeto) throws SQLException, ClassNotFoundException {
		this.iniciarTransacao();
		manager.merge(objeto);
		this.finalizarTransacao();
	}
	
	protected void remover(Object objeto) throws SQLException, ClassNotFoundException {
		this.iniciarTransacao();
		manager.remove(objeto);
		this.finalizarTransacao();
	}

	protected void iniciarTransacao() {
		if (!manager.getTransaction().isActive()) {
			manager.getTransaction().begin();
		}
	}

	protected void finalizarTransacao() {
		manager.getTransaction().commit();
		manager.clear();
	}

}
