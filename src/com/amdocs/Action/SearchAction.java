package com.amdocs.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amdocs.FormBean.SearchForm;
import com.amdocs.dao.DataBaseUtil;

public class SearchAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//query DB and return a list of defects
		SearchForm searchForm = (SearchForm) form;
		String defect = searchForm.getDefect();
		String relOpened =  searchForm.getRelOpened();
		String relFixed = searchForm.getRelFixed();
		String status = searchForm.getStatus();
		String fixedBy = searchForm.getFixedBy();
		System.out.println("## Search criteria: defect = "+defect+", relOpened = "+relOpened+", relFixed = "+relFixed+", status = "+status+", fixedBy = "+fixedBy);
	//	searchForm.setDefects(CreateDummyData.getDummyData());
		//check if all the fields are blank, then set message to 'no search criteria entered
		List searchResult = DataBaseUtil.searchDefects(defect, relOpened, relFixed, fixedBy, status);
		System.out.println("## Results found = "+searchResult.size());
		if(searchResult.size()==0){
			searchForm.setMessage("No defect found");
		}
		else{
		  searchForm.setDefects(searchResult);
		  searchForm.setMessage("");
		}
		
		return mapping.getInputForward();
	}
}
