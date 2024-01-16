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
		<!-- pop up messages -->	
		<c:if test="${!empty msg}">
			<div class="alert alert-success">${msg}</div>
		</c:if>
		<c:if test="${!empty failMsg}">
			<div class="alert alert-danger">${failMsg}</div>
		</c:if>
		<!-- User info -->	
		<div class="register-top-grid">
			<h3>Account Info</h3>
			
			<form action="${pageContext.request.contextPath}/user_changeAddress" method="post"> 
			<h4>Shippment Info</h4>
			<br>
			Name
			<input type="text" name="name" value="${user.name}"> 
			Phone
			<input type="text" name="phone" value="${user.phone}"> 
			Address
			<input type="text" name="address" value="${user.address}"> 
			<br>
			<div class="register-but text-center">
			   <input type="submit" value="Submit">
			</div>	
			</form>
			
			<hr>
			<form action="${pageContext.request.contextPath}/user_changePwd" method="post"> 
			<h4>Change Password</h4>
			<br>
			Old<br>
			<input type="text" name="password"> 
			<br>
			New<br>
			<input type="text" name="newPassword">
			<br>
			<div class="register-but text-center">
			   <input type="submit" value="Submit">
			</div>	
			</form>
		</div>
	</div>
</body>
</html>