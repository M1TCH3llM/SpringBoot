<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeForm</title>
</head>
<body>

<div align="center">
<h2>Employee Form</h2>
<f:form action="saveEmployee" method="post"  modelAttribute="employee">
<table>
<!--  
<tr>
	<td>Emp Id:</td>
	<td>
	<f:input  path="empId" value=""/>
	</td>
</tr>
-->

<tr>
	<td>Name:</td>
	<td>
	<f:input  path="name" value="${e.getName() }"/>
	</td>
</tr>


<tr>
	<td>Designation:</td>
	<td>
	<f:input  path="designation" value="${e.getDesignation() }"/>
	</td>
</tr>

<tr>
	<td>Salary:</td>
	<td>
	<f:input  path="salary" value="${e.getSalary() }"/>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
	<input type="submit"  value="submit"/>
	</td>
</tr>

</table>
</f:form>
<br> 
<%-- <c:if test="${!employees.isEmpty()}"> --%>
<c:if test="${not empty employees}">
No. of Employees: ${employees.size()}
<br>

<table border="1">
<tr>
<td>Emp Id</td><td>Name</td><td>Designation</td><td>Salary</td>
<td colspan="2" align="center" >Action</td>
</tr>
<c:forEach items="${employees}" var="e">

<tr>
<td>${e.getEmpId()}</td>
<td>${e.getName()}</td>
<td>${e.getDesignation()}</td>
<td>${e.getSalary()}</td>
<td><a href="deleteEmployee?empId=${e.getEmpId()}">Delete</a></td>
<td><a href="upDateEmployee?empId=${e.getEmpId()}">Update</a></td>

</tr>
		

</c:forEach>
</table>
</c:if>

</div>

</body>
</html>