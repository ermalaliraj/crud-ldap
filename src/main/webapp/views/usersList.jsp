<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
	<title>All Users</title>
	<link href="resources/css/screen.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id=container>
		<div class="dualbrand">
			Email: ${sessionScope.userName}
			Role: ${sessionScope.role}
		</div>
		
		<h1>List Users</h1>
		<h3><a href="add.html">Add More users</a></h3>
	</div>

	<div id=container>
	<c:if test="${!empty users}">
		<table class="simpletablestyle">
			<tr>
				<th>User ID</th>
				<th>Email</th>
				<th>password</th>
			</tr>
	
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.id}"/></td>
					<td><c:out value="${user.email}"/></td>
					<td><c:out value="${user.password}"/></td>
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


