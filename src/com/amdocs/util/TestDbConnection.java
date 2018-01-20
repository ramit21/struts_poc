package com.amdocs.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * stand alone class with a main() to test connectivity with DB
 */
public class TestDbConnection {

	public static SessionFactory sessionFactory = new Configuration().configure(
	"com/amdocs/hibernateResources/hibernate.cfg.xml").buildSessionFactory();
	
	public static void main(String[] args) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		
		
		tx.commit();
		session.close();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		
		
		tx.commit();
		session.close();
		System.out.println("yahoo");
		sessionFactory.close();
		
	}
}
