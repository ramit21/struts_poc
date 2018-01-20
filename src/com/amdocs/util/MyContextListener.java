package com.amdocs.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.amdocs.Entity.Defect;




public class MyContextListener  implements ServletContextListener{


	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		System.out.println("Context destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		//initalise db connection
		Database.getDbConnection();

		System.out.println("Context created");
	}


}