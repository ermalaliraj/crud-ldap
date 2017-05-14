<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRUD-ldap</title>
	<link href="resources/css/screen.css" rel="stylesheet" type="text/css"/>
</head>

<body>	
	<div id=container>
		<div class="dualbrand">
			Email: ${sessionScope.userName}
			Role: ${sessionScope.role}
		</div>
		<h1>Add User Data</h1>
		
		<form:form method="POST" action="save.html">
	   		<table>
			    <tr>
			        <td><form:label path="email">Email:</form:label></td>
			        <td><form:input path="email" value="${user.email}"/></td>
			    	<td>&nbsp;</td>
			        <td><form:label path="password">Password:</form:label></td>
			        <td><form:input path="password" value="${user.password}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Add new user"/></td>
		      	</tr>
			</table> 
		</form:form>
	</div>
			
	<div id=container>
		<c:if test="${!empty users}">
			<h2>List Users</h2>
			<table class="simpletablestyle">
				<tr>
					<th>ID</th>
					<th>Email</th>
					<th>Password</th>
				</tr>
			
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.id}"/></td>
						<td><c:out value="${user.email}"/></td>
						<td><c:out value="${user.password}"/></td>
						<td align="center"><a href="edit.html?id=${user.id}">Edit</a> | <a href="delete.html?id=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
	
	<p id="footer">
		<a href="${pageContext.request.contextPath}/home">Home page</a>
		<a href="j_spring_security_logout">Logout</a>
	</p>
</body>
</html>