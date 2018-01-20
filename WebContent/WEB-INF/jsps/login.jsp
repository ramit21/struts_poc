<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>

<html>

<body>
<br></br>
<br></br>
<br></br>
<br></br>
<html:form action="/login">
<table align = "center" width = "40%" border="1">
<tr height = "10%">
<td colspan =2 align="center"> Login Page </td>
</tr>

<tr height = "20%">
<td>Name: </td>
<td><html:text property="name" value=""/></td>
</tr>

<tr height = "20%">
<td>Password: </td>
<td><html:password property="password" value=""/></td>
</tr>

<tr height = "40%">
<td>Role: </td>
<td><html:select property="role" value="user" >
<html:option value="admin">Admin</html:option>
<html:option value="mgr">Manager</html:option>
<html:option value="user">User</html:option>
</html:select>
</td>
</tr>

<tr height = "10%">
<td colspan =2 align="center"><html:submit value="Log in"/></td>
</tr>
</table>
</html:form>
</body>
</html>