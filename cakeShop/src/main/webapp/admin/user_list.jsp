<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>back-end</title>
	<link rel="stylesheet" href="css/bootstrap.css"/> 
</head>

<body>

	<jsp:include page="/admin/header.jsp"></jsp:include>
	
	<table class="table table-bordered table-hover">
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Email</th>
			<th>Operation</th>
		</tr>
		
		<c:forEach items="${p.list}" var="user">
			<tr>
	         	<td>${user.id}</td>
	         	<td>${user.username}</td>
	         	<td>${user.email}</td>
				<td>
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/user_editshow?id=${user.id}">Edit</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/user_delete?id=${user.id}">Delete</a>
				</td>
	       	</tr>
	    </c:forEach>       
	</table>
</body>
</html>