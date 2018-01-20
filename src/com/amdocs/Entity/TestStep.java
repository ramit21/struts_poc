package com.amdocs.Entity;

import java.io.Serializable;

public class TestStep implements Serializable{
	Long Id;
	String description;
	Integer seq;
	TestCase testCase;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long stepId) {
		this.Id = stepId;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public TestCase getTestCase() {
		return testCase;
	}
	public void setTestCase(TestCase testCase) {
		this.testCase = testCase;
	}
	
	public TestStep(){
		
	}
	public TestStep(String description,Integer seq ){
		this.description =  description;
		this.seq =  seq;	
	}
	@Override
	public String toString() {
		String value = " TEST STEP id = "+Id+", description = "+description+", sequence = "+seq+", for defect = "+getTestCase().getDefect().getDefectNo();
		return value;
	}
}
