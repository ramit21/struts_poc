package com.amdocs.FormBean;

import java.util.Enumeration;

import javax.persistence.Enumerated;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.amdocs.Entity.Defect;

public class DefectForm extends ActionForm{
	private static final long serialVersionUID = 7881796722361505751L;
	
	String defectId;
	String email;
	String relOpened;
	String relFixed;
	String status;
	String fixedBy;
	String dateOpened;
	String dateClosed;
	String description;
	String rca;
	Defect defect;
	
	public DefectForm()
	{
		
	}

	public String getDefectId() {
		return defectId;
	}
	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRelOpened() {
		return relOpened;
	}
	public void setRelOpened(String relOpened) {
		this.relOpened = relOpened;
	}
	public String getRelFixed() {
		return relFixed;
	}
	public void setRelFixed(String relFixed) {
		this.relFixed = relFixed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFixedBy() {
		return fixedBy;
	}
	public void setFixedBy(String fixedBy) {
		this.fixedBy = fixedBy;
	}
	public String getDateOpened() {
		return dateOpened;
	}
	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}
	public String getDateClosed() {
		return dateClosed;
	}
	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRca() {
		return rca;
	}
	public void setRca(String rca) {
		this.rca = rca;
	}
	public Defect getDefect() {
		return defect;
	}
	public void setDefect(Defect defect) {
		this.defect = defect;
	}
	
	/*@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		Enumeration<String> abc  =  request.getParameterNames();
		while(abc.hasMoreElements())
		{
			System.out.println(abc.nextElement());
		}
		super.reset(mapping, request);
	}*/
}
