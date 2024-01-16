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

	<div class="banner">
		<div class="container">
			<h2 class="hdng">${bestGoods.name}</h2>
			<p>Best Sell!</p>
			<button onclick="buy(${bestGoods.id})" class="banner_a">Buy It!</button>
			<div class="banner-text">		
				<a href="${pageContext.request.contextPath}/goods_detail?id=${bestGoods.id}">
					<img src="${pageContext.request.contextPath}${bestGoods.cover}" width="350" height="350">
				</a>	
			</div>
		</div>
	</div>

</body>
</html>