<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRUD-ldap Test Application</title>
	<link href="resources/css/screen.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div id=container>
	<div class="dualbrand">
		Email: ${sessionScope.userName}
		Role: ${sessionScope.role}
	</div>

	<h1>Welcome to your test!</h1>
    <h2>1. <a href="users.html">List of Users</a></h2>
    <h2>2. <a href="add.html">Add User</a></h2>
    <h2>3. <a href="addItemForm.html">List of Items</a></h2>
</div>

<p id="footer">
	<a href="${pageContext.request.contextPath}/home">Home page</a>
	<a href="j_spring_security_logout">Logout</a>
</p>
</body>
</html>