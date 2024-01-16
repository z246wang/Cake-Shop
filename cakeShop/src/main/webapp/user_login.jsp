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
		<c:if test="${!empty failMsg}">
			<div class="alert alert-danger">${failMsg}</div>
		</c:if>
		
		<form action="${pageContext.request.contextPath}/user_login" method="post"> 
			<div class="register-top-grid">
				<h3>Log In</h3>
					Username/Email <label style="color:red;">*</label>
					<input type="text" name="ue" required="required"> 
					Password <label style="color:red;">*</label>
					<input type="text" name="password"  required="required"> 
			</div>
			<br>
			<div class="register-but text-center">
			   <input type="submit" value="Submit">  
			</div>
		</form>
	
	</div>
</body>
</html>