<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
    <%@ taglib uri="sun/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeForm</title>
</head>
<body>
<div align="center" >

<h2>Employee Form</h2>
<f:form action="saveEmployee" method="get"  modelAttribute="employee">
<table>
<%-- 
<tr>
	<td>Emp Id:</td>
	<td>
	<f:input	path="empId" value=""/>
	</td>
</tr>
 --%>
<tr>
	<td>Name:</td>
	<td>
	<f:input  path="name" value=""/>
	</td>
</tr>
<tr>
	<td>Designation:</td>
	<td>
	<f:input  path="designation" value=""/>
	</td>
</tr>
<tr>
	<td>Salary:</td>
	<td>
	<f:input name="salary" path="salary"  value=""/>
	</td>
</tr>
<tr >
	<td colspan="2" align="center"><input type="submit" value="submit"/></td>
</tr>
</table>
</f:form>
<br> No. of Employees: ${employees.size()}
</div>
</body>
</html>