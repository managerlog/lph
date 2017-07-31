package com.lph.datebase.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.lph.model.Agenda;
import com.lph.model.Anamnese;
import com.lph.model.Antropometria;
import com.lph.model.AvaliacaoLaboratorial;
import com.lph.model.Compromisso;
import com.lph.model.Credencial;
import com.lph.model.Endereco;
import com.lph.model.Municipio;
import com.lph.model.NivelSocioEconomico;
import com.lph.model.Nutricionista;
import com.lph.model.Paciente;
import com.lph.model.Profissao;
import com.lph.model.UnidadeFederativa;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
	private static SessionFactory configure(String xml) {
		Configuration configuration = new Configuration();
	    configuration.configure(xml);
	    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	    
	    MetadataSources metadataSources = new MetadataSources(serviceRegistry);
	    metadataSources.addAnnotatedClass(Nutricionista.class);
	    metadataSources.addAnnotatedClass(Endereco.class);
	    metadataSources.addAnnotatedClass(Municipio.class);
	    metadataSources.addAnnotatedClass(UnidadeFederativa.class);
	    metadataSources.addAnnotatedClass(Credencial.class);
	    metadataSources.addAnnotatedClass(Paciente.class);
	    metadataSources.addAnnotatedClass(Agenda.class);
	    metadataSources.addAnnotatedClass(Anamnese.class);
	    metadataSources.addAnnotatedClass(Antropometria.class);
	    metadataSources.addAnnotatedClass(AvaliacaoLaboratorial.class);
	    metadataSources.addAnnotatedClass(Compromisso.class);
	    metadataSources.addAnnotatedClass(NivelSocioEconomico.class);
	    metadataSources.addAnnotatedClass(Profissao.class);
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
