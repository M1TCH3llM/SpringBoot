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
<h2><a href="${pageContext.request.contextPath}/employeeForm">Employee Form</a></h2>
<f:form action="${pageContext.request.contextPath}/saveEmployee" method="post"  modelAttribute="employee">

<table>
<%-- <tr>
 <td colspan="2">
	<f:errors path="*" cssClass="myCss"/>
	</td>
 </tr> --%>
<tr>
	<td>Emp Id:</td>
	<td>
	<f:input  path="empId" value="${e.getEmpId()}" readOnly="true"/>
	</td>
	<td>
		<f:errors path="empId" cssClass="myCss"/>
	</td>
	
</tr>


<tr>
	<td>Name:</td>
	<td>
	<f:input  path="name" value="${e.getName()}"/>
	</td>
	<td>
		<f:errors path="name" cssClass="myCss"/>
	</td>
</tr>


<tr>
	<td>Designation:</td>
	<td>
	<f:input  path="designation" value="${e.getDesignation()}"/>
	</td>
	<td>
		<f:errors path="designation" cssClass="myCss"/>
	</td>
</tr>

<tr>
	<td>Salary:</td>
	<td>
	<f:input  path="salary" value="${e.getSalary()}"/>
	</td>
	<td>
		<f:errors path="salary" cssClass="myCss"/>
	</td>
	
</tr>

<tr>
<td>DOB</td>
<td><f:input type="date" path="dob" value="${e.getDob()}"/></td>
<td><f:errors path="dob" cssClass="myCss"/></td>
</tr>

<tr>
<td>Gender</td>
<td>
<c:forEach items="${genders}"  var="g">
     <c:if test="${rGender.equals(g.toString())}" >
		<f:radiobutton path="gender" label="${g.toString()}" value="${g}" checked="checked"/>
	</c:if>
	<c:if test="${!rGender.equals(g.toString())}" >
		<f:radiobutton path="gender" label="${g.toString()}" value="${g}" />
	</c:if>
</c:forEach>
</td>
<td><f:errors path="gender" cssClass="myCss"/></td>
</tr>

<tr>
<td>Employee Type:</td>
<td>
<c:forEach items="${employeeType}"  var="et">
     <c:if test="${rEmployeeType.equals(et.toString())}" >
		<f:radiobutton path="employeeType" label="${et.toString()}" value="${et}" checked="checked"/>
	</c:if>
	<c:if test="${!rEmployeeType.equals(et.toString())}" >
		<f:radiobutton path="employeeType" label="${et.toString()}" value="${et}" />
	</c:if>
</c:forEach>
</td>
<td><f:errors path="employeeType" cssClass="myCss"/></td>
</tr>

<tr>
<td>Email</td>
<td><f:input path="email" value="${e.getEmail()}"/></td>
<td><f:errors path="email" cssClass="myCss"/></td>
</tr>

<tr>
<td>Mobile</td>
<td><f:input path="mobile" value="${e.getMobile()}"/></td>
<td><f:errors path="mobile" cssClass="myCss"/></td>
</tr>

<tr>
<td>Insured: ${isInsured}</td>
<td>
<c:if test="${isInsured}">
	<f:checkbox path="insured" checked="checked"/>
</c:if>

<c:if test="${! isInsured}">
	<f:checkbox path="insured" />
</c:if>
</td>
<td><f:errors path="insured" cssClass="myCss"/></td>
</tr>



<tr>
<td>Spoken Languages</td>
<td>
<c:forEach items="${spokenLanguages}" var="sl">
	<c:if test="${rSpokenLanguage.contains(sl)}">
		<f:checkbox path="spokenLanguages" value="${sl}"  label="${sl}" checked="true"/>
	</c:if>

	<c:if test="${!rSpokenLanguage.contains(sl)}">
		<f:checkbox path="spokenLanguages" value="${sl}"  label="${sl}" />
	</c:if>
</c:forEach>
</td>
<td><f:errors path="spokenLanguages" cssClass="myCss"/></td>
</tr>

<tr>
<td>Skills</td>
<td>
<c:forEach items="${skills}" var="sk">
	<c:if test="${rSkills.contains(sk)}">
		<f:checkbox path="skills" value="${sk}"  label="${sk}" checked="true"/>
	</c:if>

	<c:if test="${!rSkills.contains(sk)}">
		<f:checkbox path="skills" value="${sk}"  label="${sk}" />
	</c:if>
</c:forEach>
</td>
<td><f:errors path="skills" cssClass="myCss"/></td>
</tr>

<tr>
<td>Hobbies</td>
<td>
<c:forEach items="${hobbies}" var="h" >
	<c:if test="${rHobbies.contains(h)}">
	 	<f:checkbox path="hobbies" value="${h}" label="${h}" checked="true"/>
	</c:if>
	<c:if test="${!rHobbies.contains(h)}">
	 	<f:checkbox path="hobbies" value="${h}" label="${h}" />
	</c:if>
</c:forEach>
</td>
<td><f:errors path="hobbies" cssClass="myCss"/></td>
</tr>

<tr>
<td></td>
<td align="left"><strong>-------------Address-------------</strong></td>
</tr>

<tr>
<td>Line1</td> <td><f:input path="address.addressLine1" value="${e.getAddress().getAddressLine1()}" /></td>
<td><f:errors path="address.addressLine1" cssClass="myCss"/></td>
</tr>

<tr>
<td>Line2</td> <td><f:input path="address.addressLine2" value="${e.getAddress().getAddressLine2()}" /></td>
<td><f:errors path="address.addressLine2" cssClass="myCss"/></td>
</tr>

<tr>
<td>City</td> <td><f:input path="address.city" value="${e.getAddress().getCity()}" /></td>
<td><f:errors path="address.city" cssClass="myCss"/></td>
</tr>

<tr>
<td>State</td> <td><f:input path="address.state" value="${e.getAddress().getState()}" /></td>
<td><f:errors path="address.state" cssClass="myCss"/></td>
</tr>

<tr>
<td>Country</td> <td><f:input path="address.country" value="${e.getAddress().getCountry()}" /></td>
<td><f:errors path="address.country" cssClass="myCss"/></td>
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
</c:if>


</div>

</body>
</html>