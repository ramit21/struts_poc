package com.amdocs.util;

import javax.servlet.Servlet;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amdocs.Entity.Defect;




public class MySessionListener  implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
/*		SessionFactory sessionFactory = Database.getDbConnection();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Defect defect = (Defect) session.get(Defect.class, "UAT 1");
		System.out.println("hello = "+defect.getDescription());
		
		tx.commit();
		session.close();
		
		System.out.println("## Session created");
		*/
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}




}