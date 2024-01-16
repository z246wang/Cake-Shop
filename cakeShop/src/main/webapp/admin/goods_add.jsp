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
	
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/goods_add" method="post" enctype="multipart/form-data">
		<label class="col-sm-1 control-label">Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="name" required="required">
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Price</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="price" >
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Details</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="intro" >
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Stock</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="stock" >
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Pic1</label> 
		<div class="col-sm-6">
			<input type="file" name="cover" required="required">pic size: 500 * 500
		</div>
		<br>	
		<br>
		<br>
		<label class="col-sm-1 control-label">Pic2</label> 
		<div class="col-sm-6">
			<input type="file" name="image1" required="required">pic size: 500 * 500
		</div>
		<br>	
		<br>
		<br>
		<label class="col-sm-1 control-label">Pic3</label> 
		<div class="col-sm-6">
			<input type="file" name="image2" required="required">pic size: 500 * 500
		</div>
		<br>
		<br>
		<br>
		<label class="col-sm-1 control-label">Type</label>
		<div class="col-sm-6">
			<select class="form-control" name="typeid">
				<c:forEach items="${typeList}" var="type">
					<option value="${type.id}">${type.name}</option>
				</c:forEach>	
			</select>
		</div>
		<br>
		<br>
		<div class="col-sm-offset-1 col-sm-10">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</form>

</body>
</html>