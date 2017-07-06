package com.lph.database.imp;

import java.sql.SQLException;

import org.hibernate.HibernateException;

import com.lph.model.Nutricionista;

public class NutricionistaDAO extends GenericDAO<Nutricionista, Long> {

	public NutricionistaDAO(Class<Nutricionista> nclass) {
		super(nclass);
	}
	
	@Override
	protected Class<Nutricionista> getEntityKlass() {
		return Nutricionista.class;
	}
	
	@Override
	public Nutricionista save(Nutricionista x) throws SQLException, ClassNotFoundException, HibernateException {
		return super.save(x);
	}

//	public NutricionistaDAO(EntityManagerFactory factory, EntityManager manager) {
//	}
//
//	public NutricionistaDAO(Class<Nutricionista> class1) {
//		// TODO Auto-generated constructor stub
//	}
//
//	public void create(Nutricionista n) throws SQLException, ClassNotFoundException {
//		super.criar(n);
//	}
//
//	public void update(Nutricionista n) throws SQLException, ClassNotFoundException {
//		super.atualizar(n);
//	}
//
//	public void delete(Nutricionista n) throws SQLException, ClassNotFoundException {
//		super.remover(n);
//	}
//
//	public List<Nutricionista> getNutricionistas() throws SQLException, ClassNotFoundException {
//		super.iniciarTransacao();
//		@SuppressWarnings("unchecked")
//		List<Nutricionista> n = manager.createQuery("SELECT n FROM Nutricionista n").getResultList();
//		return n;
//	}
//
//	public Nutricionista getNutricionistaPorId(Long id) throws SQLException, ClassNotFoundException {
//		this.iniciarTransacao();
//		String stringHql = "SELECT n FROM Nutricionista n WHERE n.id = :id";
//		TypedQuery<Nutricionista> query = manager.createQuery(stringHql, Nutricionista.class);
//		query.setParameter("id", id);
//		Nutricionista n = query.getSingleResult();
//		return n;
//	}


}