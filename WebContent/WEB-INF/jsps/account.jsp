<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic"%>
<html>
<LINK REL=StyleSheet HREF="csat.css" TYPE="text/css" MEDIA=screen>
<body>
<html:form action="/findStatus">
	<table width="300px" border="1" />
		<tr>
			<td>
			<table width="300px">
				<tr>
					<td width="40%"><bean:message key="label.search.corp" />:</td>
					<td width="60%"><html:text property="corp" maxlength="5"
						value="07817" /></td>
				</tr>
				<tr>
					<td><bean:message key="label.search.house" />:</td>
					<td><html:text property="house" maxlength="6" /></td>
				</tr>
				<tr>
					<td colspan="2"><html:submit onclick="enableResponse()" /></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td><html:errors /></td>
		</tr>
		<tr>
			<td><br />
			<table id="responseTable">
				<tr>
					<td width="40%"><bean:message
						key="label.response.accountStatus" />:</td>
					<td width="60%"><html:text property="status" readonly="true" />
					</td>
				</tr>
				<tr>
					<td><bean:message key="label.response.customerType" />:</td>
					<td><html:text property="type" readonly="true" /></td>
				</tr>
				<tr>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</html:form>

<hr width="100%" noshade="true">
<br></br>
<hr width="100%" noshade="true">

<html:form action="/services">
<% int counter = 0; %>
	<html:submit value="Get Services"></html:submit>
	<!-- <bean:write  name="rateCodeForm" property="message"/> -->
	<table border="1">
		<logic:present name="rateCodeForm" property="rateCodeDesc">
			<logic:iterate id="currentRow" name="rateCodeForm"
				property="rateCodeDesc">
				<tr align="center" <%if(counter == 0) {%> class="cellhead"<%} %>  >
					<logic:iterate id="currentColumn" name="currentRow"
						property="rateCode">
					<td><bean:write name="currentColumn" /></td>
					</logic:iterate>
				</tr>
				<% counter++; %>
			</logic:iterate>
		</logic:present>
	</table>
</html:form>


</body>
<script>
	function enableResponse() {
		if (document.accountForm.status.value != "") {
			document.getElementById("responseTable").style.display = "block";
		}
	}
</script>
</html>