<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeForm</title>
<style type="text/css">
.myCss {
    color: red; 
    font-family: sans-serif; /* Sets the font family */
    font-style: italic; /* Makes the font italic */
    font-size: medium; /* You can use more precise values like '16px' or '1.2em' */
}
</style>
</head>
<body>

<div align="center">
<h2>Employee Form</h2>
<f:form action="saveEmployee" method="post"  modelAttribute="employee">


 <table border="1">
 <tr>
 <td>Errors:</td>
 <td><f:errors path="*"  cssClass="myCss"/></td>
 </tr>
 </table>
 

<table>

<tr>
	<td>Emp Id:</td>
	<td>
	<f:input  path="empId" value="${e.getEmpId()}" readOnly="true" />
	</td>
	<td>
	</td>
</tr>


<tr>
	<td>Name:</td>
	<td>
	<f:input  path="name" value="${e.getName()}"/>
	</td>
</tr>


<tr>
	<td>Designation:</td>
	<td>
	<f:input  path="designation" value="${e.getDesignation()}"/>
	</td>
</tr>

<tr>
	<td>Salary:</td>
	<td>
	<f:input  path="salary" value="${e.getSalary()}"/>
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
<table border="1">
<tr>
<td>Emp Id</td> <td>Name</td> <td>Designation</td> <td>Salary</td>
<td colspan="2" align="center">Action</td>
</tr>
<c:forEach items="${employees}" var="e">

<tr>
<td>${e.getEmpId()}</td> 
<td>${e.getName()}</td> 
<td>${e.getDesignation()}</td> 
<td>${e.getSalary()}</td>
<td><a href="deleteEmployee?empId=${e.getEmpId()}">delete</a></td>
<td><a href="updateEmployee?empId=${e.getEmpId()}">update</a></td>
</tr>

</c:forEach>
</table>
</c:if>


</div>

</body>
</html>