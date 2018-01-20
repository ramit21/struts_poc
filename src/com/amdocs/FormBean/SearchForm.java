package com.amdocs.FormBean;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.amdocs.Entity.Defect;

public class SearchForm extends ActionForm   {

	private static final long serialVersionUID = -8767600140150773986L;
	String defect;
	String relOpened;
	String relFixed;
	String status;
	String fixedBy;
	String dateOpened;
	String dateClosed;
	String message;
	
	/*
	 * Result returned by DB:
	 */
	List <Defect>defects = new ArrayList<Defect>();
	
	public List<Defect> getDefects() {
		return defects;
	}
	public void setDefects(List<Defect> defects) {
		this.defects = defects;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDefect() {
		return defect;
	}
	public void setDefect(String defect) {
		this.defect = defect;
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
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		message = "";
		defects.removeAll(defects);
		defect = "";
		relOpened = "";
		relFixed = "";
		status = "";
		fixedBy = "";
		dateOpened = "";
		dateClosed = "";
		message = "";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
