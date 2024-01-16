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
	
	<!-- edit button send request to goodsEditShowServlet to show goods first, then goodsEditServlet to edit the info -->
	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/goods_edit" method="post" enctype="multipart/form-data">
	    <!-- keep info for back-end to update -->
		<input type="hidden" name="id" value="${g.id}"/>
		<input type="hidden" name="cover" value="${g.cover}"/>
		<input type="hidden" name="image1" value="${g.image1}"/>
		<input type="hidden" name="image2" value="${g.image2}"/>
		<input type="hidden" name="pageNo" value="${param.pageNo}"/>
		<input type="hidden" name="type" value="${param.type}"/>
		
		<label class="col-sm-1 control-label">Name</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="name" value="${g.name}" required="required">
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Price</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="price" value="${g.price}">
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Details</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="intro" value="${g.intro}">
		</div>
		<br>
		<br>
		<label class="col-sm-1 control-label">Stock</label>
		<div class="col-sm-6">
			<input type="text" class="form-control" name="stock" value="${g.stock}">
		</div>
		<br>
		<br>
		<div class="form-group">
			<label class="col-sm-1 control-label">Image</label> 
			<div class="col-sm-6"><img src="${pageContext.request.contextPath}${g.cover}" width="120" height="120"/>
				<input type="file" name="cover">Image Size: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label">Pic1</label> 
			<div class="col-sm-6"><img src="${pageContext.request.contextPath}${g.image1}" width="120" height="120"/>
				<input type="file" name="image1" >Pic1 Size: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-1 control-label">Pic2</label> 
			<div class="col-sm-6"><img src="${pageContext.request.contextPath}${g.image2}" width="120" height="120"/>
				<input type="file" name="image2">Pic2 Size: 500 * 500
			</div>
		</div>
		<label class="col-sm-1 control-label">Type</label>
		<div class="col-sm-6">
			<select class="form-control" name="typeid">
				<c:forEach items="${typeList}" var="t">
					<option <c:if test="${t.id==g.type.id}">selected="selected"</c:if> value="${t.id}">${t.name}</option>
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