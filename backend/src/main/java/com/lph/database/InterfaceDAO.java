package com.lph.database;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

public interface InterfaceDAO<T, PK extends Serializable> {

	/**
	 * Save object in the data base
	 * 
	 * @param object to be saved
	 * @return object saved.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 * @throws HibernateException
	 */
	T save(final T entity) throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * Update object in the data base
	 * 
	 * @param object to be updated
	 * @throws HibernateException
	 */
	 void update(final T object) throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * Refresh object of data base
	 * 
	 * @param object to be refreshed
	 * @throws HibernateException
	 */
	 void refresh(final T object) throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * Delete object of data base
	 * 
	 * @param object to be deleted
	 * @throws HibernateException
	 */
	 void delete(final T object) throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * Get object of data base
	 * 
	 * @param primary key of object
	 * @return object
	 * @throws HibernateException
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	 T get(final PK primaryKey) throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * List all objects of data base
	 * 
	 * @return {@link List} the objects
	 * @throws HibernateException
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	 List<T> listAll() throws HibernateException, SQLException, ClassNotFoundException;

	/**
	 * List all objects of data base, through the example
	 * 
	 * @param example of object to be listed
	 * @return {@link List} the objects
	 * @throws HibernateException
	 */
	 List<T> listAll(Object example) throws HibernateException;

	/**
	 * List all objects of data base, through the criterion
	 * 
	 * @param {@link Criteria} used to list the objects
	 * @return {@link List} the objects
	 * @throws HibernateException
	 */
	 List<T> listAll(Criteria criteria) throws HibernateException;
	 
	 void merge(T x) throws HibernateException;
}
