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
<h2>Employee Form</h2>
<f:form action="saveEmployee" method="post"  modelAttribute="employee">

<table>
<tr>
 <td colspan="2">
	<f:errors path="*" cssClass="myCss"/>
	</td>
 </tr>
<tr>
	<td>Emp Id:</td>
	<td>
	<f:input  path="empId" value="${e.getEmpId()}" readOnly="true"/>
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
<td>DOB</td>
<td><f:input type="date" path="dob" value="${e.getDob()}"/></td>
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
</tr>

<tr>
<td>Email</td>
<td><f:input path="email" value="${e.getEmail()}"/></td>
</tr>

<tr>
<td>Mobile</td>
<td><f:input path="mobile" value="${e.getMobile()}"/></td>
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
</tr>


<tr>
    <td>Hobbies</td>
    <td>
        <c:forEach items="${hobbies}" var="h">
            <c:if test="${rHobbies.contains(h)}">
                <f:checkbox path="hobbies" value="${h}" label="${h}" checked="true"/>
            </c:if>
            <c:if test="${!rHobbies.contains(h)}">
                <f:checkbox path="hobbies" value="${h}" label="${h}"/>
            </c:if>
        </c:forEach>
    </td>
</tr>

<tr>
    <td colspan="2" align="center">Address</td>
</tr>

<tr>
    <td>Line1</td>
    <td><f:input path="address.addressLine1" value="${e.getAddress().getAddressLine1()}"/>
</td>
</tr>

<tr>
    <td>Line2</td>
    <td><f:input path="address.addressLine2" value="${e.address.addressLine2}"/></td>
</tr>

<tr>
    <td>City</td>
    <td><f:input path="address.city" value="${e.getAddress().getAddressCity()}"/></td>
</tr>

<tr>
    <td>State</td>
    <td><f:input path="address.state" value="${e.getAddress().getAddressState()}"/></td>
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
<td>Birth</td><td>Gender</td><td>Emp Type</td> <td>Email</td>
<td>Mobile</td><td>Insured</td><td>Languages</td><td>Skills</td>
</tr>
<c:forEach items="${employees}" var="e">

<tr>
<td>${e.getEmpId()}</td> 
<td>${e.getName()}</td> 
<td>${e.getDesignation()}</td> 
<td>${e.getSalary()}</td>
<td>${e.getDob()}</td>
<td>${e.getGender()}</td>
<td>${e.getEmployeeType()}</td>
<td>${e.getEmail()}</td>
<td>${e.getMobile()}</td>
<td>${e.isInsured()}</td>
<td>${e.spokenLanguages}</td>
<td>${e.getSkills()}</td>
<td>

<c:forEach items="${e.getHobbies()}" var="h">
${h}
</c:forEach>


</td>	








<td><a href="deleteEmployee?empId=${e.getEmpId()}">delete</a></td>
<td><a href="updateEmployee?empId=${e.getEmpId()}">update</a></td>
</tr>

</c:forEach>
</table>
</c:if>


</div>

</body>
</html>