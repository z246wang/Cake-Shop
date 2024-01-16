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
	<br>
	
	<form action="${pageContext.request.contextPath}/admin/user_edit" method="post" class="form-horizontal">
		<label class="col-sm-1 control-label">Username</label>
		${u.username}
		<br>
		<br>
		<label class="col-sm-1 control-label">Email</label>
		${u.email}
		<br>
		<br>
		<label class="col-sm-1 control-label">Name</label>
		<input type="text" name="name" value="${u.name}">
		<br>
		<br>
		<label class="col-sm-1 control-label">Phone</label>
		<input type="text" name="phone" value="${u.phone}">
		<br>
		<br>
		<label class="col-sm-1 control-label">Address</label>
		<input type="text" name="address" value="${u.address}">
		<br>
		<br>
		<div class="col-sm-offset-1 col-sm-10">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</form>
</body>
</html>