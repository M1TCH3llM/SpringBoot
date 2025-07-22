<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Role Form</title>
</head>
<body>
<div align="center">
<f:form action="saveRole" method="post"  modelAttribute="role">
<table>

<tr>
<td>Role Name: </td>
<td><f:input path="rolename"/></td>
</tr>

<tr><td colspan="2" align="center"><input type="submit" value="submit"/> </td>
</table>
</f:form>
</div>
</body>
</html>