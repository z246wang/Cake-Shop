<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Shop</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/flexslider.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	    function goBack() {
	        window.history.back();
	    }
	</script>
</head>

<body>
	 
	<jsp:include page="/header.jsp"></jsp:include>
	<br>
	<!-- goods detail images -->	
	<div class="col-md-4 single-grid">		
		<div class="flexslider">		
			<ul class="slides">
				<li data-thumb="${pageContext.request.contextPath}${goods.cover}">
					<img src="${pageContext.request.contextPath}${goods.cover}" class="img-responsive">
				</li>
				<li data-thumb="${pageContext.request.contextPath}${goods.image1}">
					<img src="${pageContext.request.contextPath}${goods.image1}" class="img-responsive">
				</li>
				<li data-thumb="${pageContext.request.contextPath}${goods.image2}">
				    <img src="${pageContext.request.contextPath}${goods.image2}" class="img-responsive"> 
				</li> 
			</ul>
		</div>
	</div>	
	<!-- goods detail info -->
	<div class="col-md-4 single-grid simpleCart_shelfItem">		
		<h1>${goods.name}</h1>
		<p>${goods.intro}</p>
		<br>
		<h5>$ ${goods.price}</h5>
		<br>
		<div class="btn_form">
			<a href="javascript:;" onclick="goBack()">Go Back</a>		
		</div>
	</div>

</body>
</html>