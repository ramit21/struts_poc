<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-tiles.tld" prefix="tiles" %>
<html>
<head>
<title><tiles:getAsString name="title"/></title>
</head>

<body>
<table border="1" height = "100%" width ="100%">
<tr height = "6%">
<td> <tiles:insert attribute="header"/> </td>
</tr>

<tr height = "86%" valign="top">
<td width="100%" ><tiles:insert attribute="body"/></td>
</tr>

<tr height = "6%">
<td> <tiles:insert attribute="footer"/> </td>
</tr>

</table>
</body>
</html>