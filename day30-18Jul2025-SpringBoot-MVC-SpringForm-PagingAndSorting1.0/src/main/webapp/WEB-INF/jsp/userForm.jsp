<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
<style>
.error{
	color:red;
	font-style:italic; 
	font-weight:bold;
	font-family:courior;
}
</style>
</head>
<body>
<div align="center">
<h1><a href="${pageContext.request.contextPath}/userForm">User Form</a></h1>
<f:form  action="${pageContext.request.contextPath}/saveUser" mathod="POST" modelAttribute="user">
<table>
<%-- <c:if test="${hasErrors}">
<tr>
<td>Errors:</td>
<td><f:errors path="*" cssClass="error" /></td>
</tr>
</c:if> --%>

<tr>
<td>User Id: ${pageContext.request.contextPath}</td>
<td><f:input path="userId" value="${user.getUserId()}" readOnly="true"/>
<f:errors path="userId" cssClass="error" /></td>
</tr>

<tr>
<td>User Name:</td>
<td><f:input path="username" value="${user.getUsername()}" />
<f:errors path="username" cssClass="error" /></td>
</tr>

<tr>
<td>Password:</td>
<td><f:password path="password" value="${user.getPassword()}" />
<f:errors path="password" cssClass="error" /></td>
</tr>

<tr>
<td>Email:</td>
<td><f:input path="email" value="${user.getEmail()}" />
<f:errors path="email" cssClass="error" /></td>
</tr>

<tr>
<td>Roles:</td>
<td>
<c:forEach items="${roles}" var = "role">
<c:if test="${retrievedRole.contains(role) }" >
	<f:checkbox path="roles" label="${role.rolename}" value="${role.roleId}" checked="true"/>
</c:if>

<c:if test="${!retrievedRole.contains(role) }" >
	<f:checkbox path="roles" label="${role.rolename}" value="${role.roleId}" />
</c:if>
</c:forEach>

<f:errors path="roles" cssClass="error" /></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Submit" /></td>

</tr>
</table>

</f:form>
</div>
<div align="center">
<table border="1">
<tr>
<th>User Id</th> <th>User Name</th> <th>Password</th> <th>Email</th> <th>Roles</th>
<th>Action</th>
</tr>

<c:forEach items="${users}" var="user">

<tr>
<td>${user.getUserId()}</td>
<td>${user.getUsername()}</td>
<td>${user.getPassword()}</td>
<td>${user.getEmail()}</td>

<td>
<c:forEach items="${user.getRoles()}" var="role">
${role.getRolename()}
</c:forEach>
</td>

<td>
<a href="${pageContext.request.contextPath}/update/${user.getUserId()}">Update</a>
|
<a href="${pageContext.request.contextPath}/delete/${user.getUserId()}">Delete</a>
</td>
</tr>



</c:forEach>




</table>



</div>
</body>
</html>