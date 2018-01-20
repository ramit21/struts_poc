package com.amdocs.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.amdocs.Entity.Defect;
import com.amdocs.Entity.TestCase;
import com.amdocs.FormBean.DefectForm;
import com.amdocs.dao.DataBaseUtil;

public class DefectPageAction extends DispatchAction implements Servlet {

	public ActionForward fetchDefect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String curDefectId = request.getParameter("defectId");

		if (curDefectId != null) {
			DefectForm df = (DefectForm) form;
			System.out.println(df.getDefectId() + "hello1 curDefectId = "
					+ curDefectId);
			// fetch THE defect details from the DB
			Defect curDefect = DataBaseUtil.getDefect(curDefectId);
			df.setDefect(curDefect);
			// df.setDateClosed(curDefect.getDateClosed());
			// df.setDateOpened(curDefect.getDateOpened());
			df.setDescription(curDefect.getDescription());
			df.setFixedBy(curDefect.getFixedBy());
			df.setRca(curDefect.getRca());
			df.setRelFixed(curDefect.getReleaseFixed());
			df.setRelOpened(curDefect.getReleaseDetected());
			df.setStatus(curDefect.getStatus());
		}
		return mapping.findForward("next");
	}

	public ActionForward saveDefect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DefectForm df = (DefectForm) form;
		Defect defect = df.getDefect();

		// When creating a defect for the first time, the defect is null
		if (defect == null) {
			defect = new Defect();
		}
		defect.setDescription(df.getDescription());
		defect.setFixedBy(df.getFixedBy());
		defect.setRca(df.getRca());
		defect.setReleaseDetected(df.getRelOpened());
		defect.setReleaseFixed(df.getRelFixed());
		defect.setStatus(df.getStatus());
		defect.setDefectNo(df.getDefectId());
		List <String> testCasesList = new ArrayList<String>();
		int testCaseCounter = 0;
		
		if (request.getParameterValues("steps") != null) {
			for (String curStep : request.getParameterValues("steps")) {
			//	System.out.println("test step : " + curStep);
				testCasesList.add(curStep);
			}
		} 
		
		Set testCases = defect.getTestCases(); 
		TestCase curCase = null;
		//String [] isDeleteCheckBoxArr = request.getParameterValues("isDeleteCheckBox");  
		
		for (Object tc : (Set) testCases) { 
		 curCase = (TestCase) tc;
		 System.out.println(curCase.getDescription() + ":::" +
		 curCase.getSteps()); 
		// System.out.println(" -->> isDeleteCheckBox = "+isDeleteCheckBoxArr[testCaseCounter]);
		 curCase.setSteps(testCasesList.get(testCaseCounter));
		 testCaseCounter++;
       }
		 
		//now add the newly added test cases
		TestCase newTestCase = null;
		String [] newTestCasesArr = request.getParameterValues("newTestCase");
		String [] newStepsArr = request.getParameterValues("newSteps");

		if(newTestCasesArr!=null){
			
			for(int i=0; i < newTestCasesArr.length; i++){
				newTestCase = new TestCase(newTestCasesArr[i], newStepsArr[i]);
				defect.addTestCases(newTestCase);
			}
		}
		
		DataBaseUtil.saveDefect(defect);
		//save the defect in DB
		
		return mapping.findForward("next");
	}

	/*
	 * function that gets called when create defect is called All the fields
	 * must be cleared, otherwise they will persist for the session scope.
	 */
	public ActionForward clearDefect(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DefectForm df = (DefectForm) form;
		df.setDefect(null);
		df.setDefectId("");
		df.setDescription("");
		df.setEmail("");
		df.setFixedBy("");
		df.setRca("");
		df.setRelOpened("");
		df.setRelFixed("");
		df.setStatus("");
		return mapping.findForward("next");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}

class temp extends HttpServlet{



	
}
