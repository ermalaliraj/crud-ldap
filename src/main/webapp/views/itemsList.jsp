<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<h1>Add Items</h1>
		
		<form:form method="POST" action="saveItem.html">
	   		<table>
			    <tr>
			        <td><form:label path="name">Name:</form:label></td>
			        <td><form:input path="name" value="${item.name}"/></td>
			    	<td>&nbsp;</td>
			        <td><form:label path="description">Description:</form:label></td>
			        <td><form:input path="description" value="${item.description}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Add new item"/></td>
		      	</tr>
			</table> 
		</form:form>
	</div>
			
	<div id=container>
		<c:if test="${!empty items}">
			<h2>List Users</h2>
			<table class="simpletablestyle">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Description</th>
				</tr>
			
				<c:forEach items="${items}" var="item">
					<tr>
						<td><c:out value="${item.id}"/></td>
						<td><c:out value="${item.name}"/></td>
						<td><c:out value="${item.description}"/></td>
						<td><a href="deleteItem.html?id=${item.id}">Delete</a></td>
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