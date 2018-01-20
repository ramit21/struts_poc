package com.amdocs.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TestCase implements Serializable,Comparable{

	private Long Id;
	private String description;
	private Defect defect;
	private String steps;
	

	Set testSteps = new HashSet();

	public void addTestStep(TestStep testStep) {
		testSteps.add(testStep);
	}

	public Set getTestSteps() {
		return testSteps;
	}

	public void setTestSteps(Set testSteps) {
		this.testSteps = testSteps;
	}
	public String getSteps() {
		return steps;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}
	public Long getId() {
		return Id;
	}

	public void setId(Long testId) {
		this.Id = testId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Defect getDefect() {
		return defect;
	}

	public void setDefect(Defect defect) {
		this.defect = defect;
	}

	public TestCase() {
		// TODO Auto-generated constructor stub
	}

	public TestCase(String description, String steps) {

		this.description = description;
		this.steps = steps;
	}
	@Override
	public String toString() {
		String value = "Test case ID = "+getId()+", description = "+getDescription()+", for defect = "+getDefect().getDefectNo()+", test cases count = "+getTestSteps().size();
		return value;
	}

	@Override
	public int compareTo(Object testCase) {
		TestCase tCase = (TestCase)testCase;
		return this.description.compareTo(tCase.description);
	}
}
