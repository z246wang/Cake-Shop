<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<h2>Search ‘${param.keyword}’</h2>
		<!-- Searched goods -->	
		<div class="col-md-12 product-model-sec">
			<c:forEach items="${p.list}" var="goods">
				<div class="product-grid">
					<!-- goods image -->	
					<a href="${pageContext.request.contextPath }/goods_detail?id=${goods.id}">								
						<div class="product-img b-link-stripe b-animate-go  thickbox">
							<img src="${pageContext.request.contextPath}${goods.cover}" class="img-responsive" width="220" height="220">
							<div class="b-wrapper">
								<h4 class="b-animate b-from-left  b-delay03">							
									<button>Details</button>
								</h4>
							</div>
						</div>
					</a>
					<!-- goods info -->			
					<div class="product-info simpleCart_shelfItem">
						<div class="product-info-cust prt_name">
							${goods.name}								
							<span class="item_price">$ ${goods.price}</span>
							<input type="button" class="item_add items" value="Add to Cart" onclick="buy(${goods.id})">
						</div>												
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</body>
</html>