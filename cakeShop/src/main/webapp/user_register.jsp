<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Shop</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

	<jsp:include page="/header.jsp"></jsp:include>

	<div class="register">
		<c:if test="${!empty msg}">
			<div class="alert alert-danger">${msg}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/user_register" method="post"> 
			<div class="register-top-grid">
				<h3>Register</h3>
				Username <label style="color:red">*</label>
				<input type="text" name="username" required="required"> 
				Email <label style="color:red">*</label>
				<input type="text" name="email" required="required"> 
				Password <label style="color:red">*</label>
				<input type="text" name="password" required="required"> 
				Name
				<input type="text" name="name"> 
				Phone
				<input type="text" name="phone"> 
				Address
				<input type="text" name="address"> 
			</div>
			<br>
			<div class="register-but text-center">
			   <input type="submit" value="submit">
			</div>
		</form>
    </div>	
</body>
</html>