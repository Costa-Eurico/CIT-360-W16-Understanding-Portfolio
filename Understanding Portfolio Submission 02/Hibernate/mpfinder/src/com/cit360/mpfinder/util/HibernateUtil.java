package com.cit360.mpfinder.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

//Singleton pattern for handling an hibernate session

public class HibernateUtil {

	private static HibernateUtil instance = null;
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry serviceRegistry; 
	
	private HibernateUtil(){
		
		//creating configuration object  
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		//setup session factory object  
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static HibernateUtil getInstance(){
		if(instance == null){
			instance = new HibernateUtil();
		}
		return instance;
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
