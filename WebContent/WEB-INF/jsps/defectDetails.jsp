<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<html>
<body onload="disableDefectId()">
	<html:form action="/editSaveDefect">
		<table width="100%" height="10%">
			<tr>
				<td width="35%">Defect ID: <html:text property="defectId"
						size="50"></html:text></td>
				<td width="15%"></td>
				<td width="15%"><button onclick="submitSave()">Save</button></td>
				<td align="right" width="35%">Email ID: <html:text
						property="email" value="" size="30"></html:text> <html:submit
						value="Email defect details" /></td>
			</tr>
		</table>
		<table width="100%" height="90%" border="1">
			<tr>
				<td width="45%">Defect Status: &nbsp;&nbsp;&nbsp;&nbsp; <html:select
						property="status">
						<html:option value="">Please Select</html:option>
						<html:option value="Assigned">Assigned</html:option>
						<html:option value="Answered">Answered</html:option>
						<html:option value="Closed">Closed</html:option>
						<html:option value="Fixed">Fixed</html:option>
						<html:option value="Not reproducible">Not reproducible</html:option>
						<html:option value="Open">Open</html:option>
					</html:select> <br> <br> Fixed by:
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<html:text property="fixedBy" size="40">
					</html:text> <br> <br> Release Opened: <html:text
						property="relOpened" size="40"></html:text> <br> <br>
					Release Fixed: &nbsp;&nbsp; <html:text property="relFixed"
						size="40"></html:text> <br> <br> Description: <br>
					<html:textarea property="description"
						style="WIDTH: 450px; HEIGHT:100px"></html:textarea> <br> <br>
					RCA: <br> <html:textarea property="rca"
						style="WIDTH: 450px; HEIGHT:100px"></html:textarea>
				</td>

				<td width="55%">
					<div style="height: 98%; overflow: scroll">
						Test Cases: (check to delete a test case)
						<br>
						<br>
						<logic:present name="defectForm" property="defect">
							<bean:define id="currentDefect" name="defectForm"
								property="defect" />
							<%
								int counter = 0;
							%>
							<logic:iterate id="currentTestCase" name="currentDefect"
								property="testCases">
								<table width="100%">
									<tr>
										<td>
										<input name="isDeleteCheckBox" type="checkbox" />
										<input id="b<%=counter%>" type="button"
											onclick="changeDisplay('tbody<%=counter%>','b<%=counter%>')"
											value="+" /> <bean:write name="currentTestCase"
												property="description" /> <br></td>
									</tr>
									<tbody id="tbody<%=counter%>" style="display: none">
										<tr>
											<td><html:textarea property="steps"
													name="currentTestCase" rows="10" cols="70"></html:textarea></td>
										</tr>
									</tbody>
								</table>
								<%
									counter++;
								%>
							</logic:iterate>
						</logic:present>

						<table width="100%">

							<tr>
								<td>
									<div id="newTestCases">

									</div>
								</td>
							</tr>


							<tr>
								<td><input type="button" onclick="createNewHtmlElement()"
									value="Create new test case" /></td>
							</tr>

						</table>

					</div>
				</td>
			</tr>
		</table>
	</html:form>
</body>
<script>
	/*
	 * disable the defect id if opened from search grid
	 */
	function disableDefectId() {
		var defectId = document.defectForm.defectId.value;
		if (defectId != "") {
			document.defectForm.defectId.disabled = true;
		} else {
			document.defectForm.defectId.disabled = false;
		}
	}

	/*
	 * function to display/hide test cases
	 */
	function changeDisplay(TR, BR) {
		if (document.getElementById(TR).style.display == "none") {
			document.getElementById(TR).style.display = "block";
			document.getElementById(BR).value = "-";
		} else {
			document.getElementById(TR).style.display = "none";
			document.getElementById(BR).value = "+";
		}
	}

	/*
	 * function to save the defect in DB
	 */
	function submitSave() {

		var form = document.defectForm;
		var curDefectId = form.defectId.value;

		if (curDefectId == "") {
			alert("Enter Defect ID");
			return false;
		}
		
		form.action = form.action + "?method=saveDefect";
		form.submit();
	}

	function createNewHtmlElement() {
		//debugger;
		var root=document.getElementById('newTestCases');
		var element = document.createElement('<br>');
		root.appendChild(element);
		element = document.createElement('<br>');
		root.appendChild(element);
		element = document.createElement('<input type="text" size="60" name="newTestCase" value="Test Case no. " />');
		root.appendChild(element);
		element = document.createElement('<br>');
		root.appendChild(element);
		element = document.createElement('<textarea name="newSteps" rows="10" cols="70">  </textarea>');
		root.appendChild(element);
	}
</script>

</html>