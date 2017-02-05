<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quest</title>
</head>
<body>

<h1>User Details</h1>

<c:if test="${not empty noPerson}">
	<p>${noPerson}</p>
</c:if>

<c:if test="${empty noPerson}">
	<table border="1">
		<thead>
				<tr>
					<th>Name</th>
					<th>PPSN</th>
					<th>DOB</th>
					<th>Mobile Phone</th>
				</tr>
		
		</thead>
		<c:forEach var="user" items="${persons}">
		<tr>
			<td>${user.name}</td>
			<td>${user.ppsNumber}</td>
			<td><fmt:formatDate pattern="dd/MM/yyyy" value="${user.dateOfBirth}" /></td>
			<td>
				<c:if test="${not empty user.mobileNumber}">
					<p>${user.mobileNumber}</p>
				</c:if>
				<c:if test="${empty user.mobileNumber}">
					<p>Not Available</p>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
</c:if>
<a href="welcome.html">Back to home</a>
</body>
</html>