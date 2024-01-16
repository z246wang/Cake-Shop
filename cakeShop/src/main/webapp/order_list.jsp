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
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>

<body>
	
	<jsp:include page="/header.jsp"></jsp:include>
	<br>

	<div class="container">	
		<h2>My Order</h2>
		<br>
		
		<table class="table table-bordered table-hover">
			<tr>
				<th width="5%">ID</th>
				<th width="10%">Total Price</th>
				<th width="15%">Details</th>
				<th width="20%">Shipment Info</th>
				<th width="10%">Order Status</th>
				<th width="10%">Payment Type</th>
				<th width="10%">Order Time</th>
			</tr>
			
			<c:forEach items="${orderList}" var="order">			
		         <tr>
		         	<td><p>${order.id}</p></td>
		         	<td><p>${order.total}</p></td>
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
						<p>
							<c:if test="${order.status==2}"><span style="color:red;">Paid</span></c:if>
							<c:if test="${order.status==3}"><span style="color:green;">Shipped</span></c:if>
							<c:if test="${order.status==4}"><span style="color:black;">Finished</span></c:if>						
						</p>
					</td>
					<td>
						<p>							
							<c:if test="${order.paytype==1}">Paypal</c:if>
							<c:if test="${order.paytype==2}">Credit Card</c:if>							
						</p>
					</td>
					<td><p>${order.datetime}</p></td>
		       	</tr>			
		    </c:forEach>			     
		</table>		
	</div>

</body>
</html>