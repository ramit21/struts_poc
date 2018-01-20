package com.amdocs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
 * Singleton class for holding hibernate session factory
 */
public class Database {

	private Database(){
		
	}
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getDbConnection(){
		if(sessionFactory == null){	
			sessionFactory = new Configuration().configure(
			"com/amdocs/hibernateResources/hibernate.cfg.xml").buildSessionFactory();
			System.out.println("## Creating DB connection");
			
		}
		return sessionFactory;
	}
}
