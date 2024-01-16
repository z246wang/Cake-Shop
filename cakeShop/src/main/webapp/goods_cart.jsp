<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Shop</title>
	<meta name="viewport" content="width=device-width">
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
		<h2>My Cart</h2>
		<br>
		
		<c:forEach items="${order.itemMap}" var="item">
			<div class="cart-header col-md-6">
				<div class="cart-sec simpleCart_shelfItem">
					<!-- goods image -->
					<div class="cart-item cyc">
						<a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">
							<img src="${pageContext.request.contextPath}${item.value.goods.cover}" class="img-responsive">
						</a>
					</div>
					<!-- goods info -->
					<div class="cart-item-info">
						<h3><a href="${pageContext.request.contextPath}/goods_detail?id=${item.key}">${item.value.goods.name}</a></h3>
						<br>
						<h4>Price: $ ${item.value.price}</h4>
						<br>
						<h4>Quantity: ${item.value.amount}</h4>
						<br>
						<a class="btn btn-info" href="javascript:buy(${item.key});">Add</a>
						<a class="btn btn-warning" href="javascript:lessen(${item.key});">Sub</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>
		<!-- order price -->	
		<div class="cart-header col-md-12">
			<hr>
			<h3>Order Total: $ ${order.total}</h3>
			<a class="btn btn-success btn-lg" style="margin-left:75%" href="${pageContext.request.contextPath}/order_submit">Submit</a>
		</div>
	</div>

</body>
</html>