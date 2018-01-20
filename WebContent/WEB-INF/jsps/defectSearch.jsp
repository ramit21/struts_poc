<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>

<html>
<body>
<html:form action="/searchAction">
	<table height="15%" width="100%" border="1" style="table-layout: fixed">
		<tr valign="top" height="40%">
			<th width="19%" align="center">Defect</th>
			<th width="8%" align="center">Rel detected</th>
			<th width="8%" align="center">Rel fixed</th>
			<th width="15%" align="center">Status</th>
			<th width="15%" align="center">Fixed By</th>
			<th width="17%" align="center">Date Opened</th>
			<th width="17%" align="center">Date Closed</th>
		</tr>

		<tr valign="top" height="30%">
			<td align="center"><html:text property="defect"></html:text></td>
			<td align="center"><html:text property="relOpened" size="10" ></html:text></td>
			<td align="center"><html:text property="relFixed" size= "10" ></html:text></td>
			<td align="center"><html:select property="status">
				<html:option value="">Please Select</html:option>
				<html:option value="Assigned">Assigned</html:option>
				<html:option value="Answered">Answered</html:option>
				<html:option value="Closed">Closed</html:option>
				<html:option value="Fixed">Fixed</html:option>
				<html:option value="Not reproducible">Not reproducible</html:option>
				<html:option value="Open">Open</html:option>
			</html:select></td>
			<td align="center"><html:text property="fixedBy"></html:text></td>
			<td align="center"><html:text property="dateOpened"></html:text></td>
			<td align="center"><html:text property="dateClosed"></html:text></td>
		</tr>

		<tr valign="top" height="30%">
			<td colspan="5"><html:submit value="Search" /></td>
			<td colspan="2" style="color:red"><bean:write name="searchForm" property="message"/> </td>
			<!-- add button for generating report  -->
		</tr>
	</table>
</html:form >
<div style="height: 80%; overflow: scroll">

<html:form action="/editSaveDefect.do?method=fetchDefect" styleId="linkForm">
	<html:hidden property="defectId"/>
</html:form>

<table id="searchGrid" height="10%" width="100%" style="table-layout: fixed">
	<logic:present name="searchForm" property="defects">
		<logic:iterate id="currentRow" name="searchForm" property="defects">
			<tr valign="top" height="10%">
				<td width="19%" id="currentColumn" align="center" onclick="javascript:openDefect(this)"><a href="javascript:dummy()"><bean:write
					name="currentRow" property="defectNo" /></a></td>
				<td width="8%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="releaseDetected" /></td>
				<td width="8%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="releaseFixed" /></td>
				<td width="15%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="status" /></td>
				<td width="15%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="fixedBy" /></td>
				<td width="17%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="dateOpened" /></td>
				<td width="17%" id="currentColumn" align="center"><bean:write
					name="currentRow" property="dateClosed" /></td>
			</tr>
		</logic:iterate>
	</logic:present>
</table>

</div>
</body>
<script>

function dummy(){
}
function validate(){
		alert("h1");
}
function openDefect(obj){
	var row=obj.parentNode;
    curRow= parseInt(row.rowIndex);
	var curDefect = document.getElementById("searchGrid").rows[curRow].cells[0].outerText;
	var form = document.defectForm;
	form.defectId.value=curDefect;
	//form.url="/editSaveDefect.do?method=fetchDefect";
	form.submit();
}
</script>
</html>