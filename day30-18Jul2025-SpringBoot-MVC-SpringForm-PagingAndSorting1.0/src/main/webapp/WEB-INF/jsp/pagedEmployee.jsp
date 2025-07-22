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
.myCss{
	color:red;
	font-family:sans-serif;
	font-style: italic;
	font-size: small;
}

</style>
</head>
<body>

<div align="center">


<table border="1">
<tr>
<td>Emp Id</td> <td>Name</td> <td>Designation</td> <td>Salary</td>
<td>dob</td><td>gender</td><td>Emp Type</td>
<td>Email</td><td>Mobile</td><td>Insured</td>
<td>Spoken Languages</td><td>Skills</td><td>Hobbies</td>

<td>City</td><td>State</td><td>Country</td>
<td colspan="2" align="center">Action</td>
</tr>
<c:forEach items="${employees}" var="e">

<tr>
<td>${e.getEmpId()}</td> 
<td>${e.getName()}</td> 
<td>${e.getDesignation()}</td> 
<td>${e.getSalary()}</td>

<td>${e.getDob()}</td><td>${e.getGender()}</td><td>${e.getEmployeeType()}</td>
<td>${e.getEmail()}</td><td>${e.getMobile()}</td><td>${e.isInsured()}</td>
<td>${e.getSpokenLanguages()}</td><td>${e.getSkills()}</td>
<td>
<%-- <c:set var="hobbies" value="${e.getHobbies()}" /> --%>
<c:forEach items="${e.getHobbies()}" var="h">
${h}
</c:forEach>
</td>

<td>${e.getAddress().getCity()}</td>
<td>${e.getAddress().getState()}</td>
<td>${e.getAddress().getCountry()}</td>
<td><a href="${pageContext.request.contextPath}/deleteEmployee/${e.getEmpId()}">delete</a></td>
<td><a href="${pageContext.request.contextPath}/updateEmployee/${e.getEmpId()}">update</a></td>
</tr>

</c:forEach>
</table>
<br/>Total Pages: ${totalPages}
<br/>Sorted By: ${sortedBy}

<c:set var="noOfPages" value="${totalPages}" />
<c:set var="sortKey" value="${sortedBy}" />
 <c:set var="pageSize" value="${pageSize}" />
 
<%
//localhost:8081/oscar/findEmployeePages?pageNo=0&pageSize=11&sortedBy=name
for (int i = 0; i < (int) pageContext.getAttribute("noOfPages"); i++){
	out.println("<a href=\"findEmployeePages2?pageNo="+i+
			"&pageSize="+request.getAttribute("pageSize")
			+"&sortBy="+request.getAttribute("sortKey")
			+"\">"
			+i+"</a>"
		);
}



%>


</div>

</body>
</html>