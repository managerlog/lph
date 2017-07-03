package com.lph.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.lph.model.Nutricionista;

public class NutricionistaDAO extends GenericDAO {

	public NutricionistaDAO(EntityManagerFactory factory, EntityManager manager) {
		super(factory, manager);
	}

	public void create(Nutricionista n) throws SQLException, ClassNotFoundException {
		super.criar(n);
	}

	public void update(Nutricionista n) throws SQLException, ClassNotFoundException {
		super.atualizar(n);
	}

	public void delete(Nutricionista n) throws SQLException, ClassNotFoundException {
		super.remover(n);
	}

	public List<Nutricionista> getNutricionistas() throws SQLException, ClassNotFoundException {
		super.iniciarTransacao();
		@SuppressWarnings("unchecked")
		List<Nutricionista> n = manager.createQuery("SELECT n FROM Nutricionista n").getResultList();
		return n;
	}

	public Nutricionista getNutricionistaPorId(Long id) throws SQLException, ClassNotFoundException {
		this.iniciarTransacao();
		String stringHql = "SELECT n FROM Nutricionista n WHERE n.id = :id";
		TypedQuery<Nutricionista> query = manager.createQuery(stringHql, Nutricionista.class);
		query.setParameter("id", id);
		Nutricionista n = query.getSingleResult();
		return n;
	}

}
