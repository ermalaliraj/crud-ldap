<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>CRUD-ldap Login</title>
	<link href="resources/css/screen.css" rel="stylesheet" type="text/css"/>
</head>

<body>
	<div id=container>
		<h1>Welcome, Please Login</h1>
	
		<form action="<c:url value='j_spring_security_check' />" method="POST">
			<table>
				<c:if test="${!error}">
					<tr>
						<td></td>
						<td>
							<label class="error">${error}</label>							
						</td>
					</tr>
				</c:if>
			
				<tr>
					<td>User:</td>
					<td><input type='text' name='j_username' value=''>
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='j_password' />
					</td>
				</tr>
				<tr>
					<td><input name="submit" type="submit"
						value="Login" />
					</td>
				
					<td><input name="reset" type="reset" />
					</td>
				</tr>
				<tr>
					<td colspan='2'>
						<a href="register"> Register yourself</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>