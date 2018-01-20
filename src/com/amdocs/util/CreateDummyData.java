package com.amdocs.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.amdocs.Entity.Defect;
import com.amdocs.Entity.TestCase;
import com.amdocs.Entity.TestStep;

public class CreateDummyData {

	public static List <Defect> getDummyData(){
	Defect defect1 = new Defect("UAT 1","R10.5","R11.5","Ramit Sharma","rate code not getting set properly","var not set in CreateORderSubmitSaveXB.java",new Date(),new Date(),"Fixed");
	Defect defect2 = new Defect("UAT 2","R10.5","R11.5","Ramit Sharma","rate code not getting set properly","var not set in CreateORderSubmitSaveXB.java",new Date(),new Date(),"Fixed");

	TestCase case1 = new TestCase("Test case 1","Open active account \nclick on modify services \n submit order");
	TestCase case2 = new TestCase("Test case 2","Open disconnected account\n click on modify services \n submit order");
	TestCase case3 = new TestCase("Test case 3","Open commercial account \nclick on modify services \n submit order");
	
	
	
	
	defect1.addTestCases(case1);
	defect1.addTestCases(case2);
	defect1.addTestCases(case3);
	
	defect2.addTestCases(case1);
	System.out.println("save 1");
	//remove below code
	Session session = Database.getDbConnection().openSession();
	Transaction tx = session.beginTransaction();
	session.saveOrUpdate(defect1);
	session.saveOrUpdate(defect2);
	tx.commit();
	session.close();
	System.out.println("save 2");
	List <Defect> defects = new ArrayList<Defect>();
	defects.add(defect1);
	defects.add(defect2);
	return defects;
	}
	public static Defect getDefect(){
		Defect defect1 = new Defect("UAT 1","R10.5","R11.5","Ramit Sharma","rate code not getting set properly","var not set in CreateORderSubmitSaveXB.java",new Date(),new Date(),"Fixed");
		
		TestCase case1 = new TestCase("Test case 1","Open active account \n click on modify services \n submit order");
		TestCase case2 = new TestCase("Test case 2","Open disconnected account \n click on modify services \n submit order");
		TestCase case3 = new TestCase("Test case 3","Open commercial account \n click on modify services \n submit order");
		
		
		defect1.addTestCases(case1);
		defect1.addTestCases(case2);
		defect1.addTestCases(case3);
		
		return defect1;
		
	}
	public static void main(String[] args) {
		new CreateDummyData().getDummyData();
	}
}

