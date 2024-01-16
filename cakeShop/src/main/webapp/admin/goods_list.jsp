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
	<!-- add goods -->
	<div class="text-center">
		<a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/goods_add.jsp">Add Goods</a>
	</div>
	<!-- tabs -->
	<ul class="nav nav-tabs">
        <li <c:if test="${type==0}">class="active"</c:if>><a href="${pageContext.request.contextPath}/admin/goods_list">All Goods</a></li>
        <li <c:if test="${type==1}">class="active"</c:if>><a href="${pageContext.request.contextPath}/admin/goods_list?type=1">FP Goods</a></li>
    </ul>
	<br>

	<table class="table table-bordered table-hover">
		<tr>
			<th>ID</th>
			<th>Image</th>
			<th>Name</th>
			<th width="30%">Details</th>
			<th>Price</th>
			<th>Operations</th>
		</tr>
	
		<c:forEach items="${p.list}" var="goods">
	         <tr>
	         	<td>${goods.id}</td>
	         	<td><img src="${pageContext.request.contextPath}${goods.cover}" width="120" height="120"></td>
	         	<td>${goods.name}</td>
	         	<td>${goods.intro}</td>
	         	<td>${goods.price}</td>
	         	
	         	<!-- operations -->
				<td>
					<c:choose>
						<c:when test="${goods.isScroll}">
							<a class="btn btn-info" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${goods.id}&method=remove&typeTarget=1&pageNo=${p.pageNo}&type=${type}">Remove from FP</a>
						</c:when>
						<c:otherwise>
							<a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/goods_recommend?id=${goods.id}&method=add&typeTarget=1&pageNo=${p.pageNo}&type=${type}">Add to FP</a>
						</c:otherwise>
					</c:choose>
	
					<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/goods_editshow?id=${goods.id}&pageNo=${p.pageNo}&type=${type}">Edit</a>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/goods_delete?id=${goods.id}&pageNo=${p.pageNo}&type=${type}">Delete</a>
				</td>
	       	</tr>
	    </c:forEach> 
	</table>
	
	<jsp:include page="/page.jsp">
		<jsp:param value="/admin/goods_list" name="url"/>
		<jsp:param value="&type=${type}" name="param"/>
	</jsp:include>
</body>
</html>