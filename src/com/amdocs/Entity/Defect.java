package com.amdocs.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Defect implements Serializable{
	private String defectNo;
	private String releaseDetected;
	private String releaseFixed;
	private Date dateOpened;
	private Date dateClosed;
	private String fixedBy;
	private String description;
	private String rca;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	private Set testCases = new TreeSet();

	public void addTestCases(TestCase testCase) {
		testCases.add(testCase);
	}

	public Set getTestCases() {
		return testCases;
	}

	public void setTestCases(Set testCases) {
		this.testCases = testCases;
	}

	public String getDefectNo() {
		return defectNo;
	}

	public void setDefectNo(String defectNo) {
		this.defectNo = defectNo;
	}

	public String getReleaseDetected() {
		return releaseDetected;
	}

	public void setReleaseDetected(String releaseDetected) {
		this.releaseDetected = releaseDetected;
	}

	public String getReleaseFixed() {
		return releaseFixed;
	}

	public void setReleaseFixed(String releaseFixed) {
		this.releaseFixed = releaseFixed;
	}

	public Date getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(Date dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Date getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(Date dateClosed) {
		this.dateClosed = dateClosed;
	}

	public String getFixedBy() {
		return fixedBy;
	}

	public void setFixedBy(String fixedBy) {
		this.fixedBy = fixedBy;
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

	public Defect() {

	}

	public Defect(String defectNo, String releaseDetected, String releaseFixed,
			String fixedBy, String description, String rca, Date dateOpened, Date dateClosed,String status) {
		this.defectNo = defectNo;
		this.releaseDetected = releaseDetected;
		this.releaseFixed = releaseFixed;
		this.fixedBy = fixedBy;
		this.description = description;
		this.rca = rca;
		this.dateOpened = dateOpened;
		this.dateClosed = dateClosed;
		this.status = status;
	}
	@Override
	public String toString() {
		String value= "DEFECT defect id = "+defectNo+", release deteced/fixed = " +releaseDetected+ "/"+ releaseFixed + ", status = "+status+", test cases count = "+testCases.size();
		return value;
	}
}
