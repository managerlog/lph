package com.lph.datebase.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lph.model.Nutricionista;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
	private static SessionFactory configure(String xml) {
		Configuration configuration = new Configuration();
	    configuration.configure(xml);
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    
	    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	    metadataSources.addAnnotatedClass(Nutricionista.class);
	    Metadata metadata = metadataSources.buildMetadata();
	    
	    sessionFactory =  metadata.buildSessionFactory();
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			configure("hibernate.cfg.xml");
		}
		
		return sessionFactory;
	}
	
	public static SessionFactory getSessionFactory(String xml) {
		if(sessionFactory == null) {
			configure(xml);
		}
		
		return sessionFactory;
	}
	
	public static SessionFactory createSessionFactory(String xml) {
		configure(xml);
		
		return sessionFactory;
	}
}
