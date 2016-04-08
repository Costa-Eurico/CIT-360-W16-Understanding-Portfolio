package com.cit360.mpfinder.server.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//Lazy instantiation singleton pattern for handling an hibernate session

public final class HibernateUtil {

	private static SessionFactory factory;
	
	private HibernateUtil(){	
		//exists only to defeat instantiation
	}
	
	public static SessionFactory getSessionFactory() throws HibernateException{
		if(factory == null){
			synchronized(HibernateUtil.class){
				try{
					StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		            factory = metadata.getSessionFactoryBuilder().build();
				}
				catch(HibernateException e){
					throw new HibernateException ("Error creating SessionFactory: " + e.getMessage());
				}
			}
		}
		return factory;
	}
}
