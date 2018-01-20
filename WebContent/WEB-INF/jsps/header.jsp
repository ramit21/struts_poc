<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html"%>

<html>
<body>
	<table width="100%">
		<tr>
			<td align="left"><font size="+1"> Defect/Status tracker </font></td>
			<td align="right"><html:link action="/searchPage">Search</html:link>&nbsp;&nbsp;<html:link
					action="/editSaveDefect.do?method=clearDefect">Create</html:link>&nbsp;&nbsp;<html:link
					action="/homePage">Home</html:link><br></td>
		</tr>
	</table>
</body>
</html>