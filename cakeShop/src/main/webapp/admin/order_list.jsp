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
			<th>Total</th>
			<th width="20%">Details</th>
			<th width="20%">Shipment</th>
			<th>Order status</th>
			<th>PayType</th>
			<th>Username</th>
			<th>Order Time</th>
			<th>Operation</th>
		</tr>
		<!-- order info -->
		<c:forEach items="${p.list}" var="order">
	         <tr>
	         	<td>${order.id}</td>
	         	<td>${order.total}</td>
	         	<td>
	         		<c:forEach items="${order.itemList}" var="item">
			         	<p>${item.goodsName}($${item.price}) x ${item.amount}</p>
		         	</c:forEach>
	         	</td>
	         	<td>
	         		<p>${order.name}</p>
	         		<p>${order.phone}</p>
	         		<p>${order.address}</p>
	         	</td>
				<td>
					<c:if test="${order.status==2}"><span style="color:red;">Paid</span></c:if>
					<c:if test="${order.status==3}"><span style="color:green;">Shipped</span></c:if>
					<c:if test="${order.status==4}"><span style="color:black;">Done</span></c:if>			
				</td>
				<td>
					<c:if test="${order.paytype==1}">Paypal</c:if>
					<c:if test="${order.paytype==2}">Credit Card</c:if>				
				</td>
				<td>${order.user.username}</td>
				<td>${order.datetime}</td>
				<!-- shift order status -->
				<td>
					<c:if test="${order.status==2}">
						<a class="btn btn-success" href="${pageContext.request.contextPath}/admin/order_status?id=${order.id}&status=3">Shipped</a>
					</c:if>
					<c:if test="${order.status==3}">
						<a class="btn btn-warning" href="${pageContext.request.contextPath}/admin/order_status?id=${order.id}&status=4">Done</a>
					</c:if>
					<a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/order_delete?id=${order.id}&pageNo=${p.pageNo}&status=${status}">Delete</a>
				</td>
	       	</tr>
		</c:forEach>    
	</table>
	
	<jsp:include page="/page.jsp">
		<jsp:param value="/admin/order_list" name="url"/>
		<jsp:param value="&status=${status}" name="param"/>
	</jsp:include>
	
</body>
</html>