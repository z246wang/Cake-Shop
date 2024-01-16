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
	<script>
		function dopay(paytype){
			$("#paytype").val(paytype);
			$("#payform").submit();
		}
	</script>
</head>

<body>
	
	<jsp:include page="/header.jsp"></jsp:include>
	<br>

	<div class="container">
		<h2>Checking Shipment</h2>
		<br>
		
		<form action="${pageContext.request.contextPath}/order_success" method="post">
		<!-- shipment info -->
			<h3>Name</h3>
			<input type="text" class="form-control" name="name" value="${user.name}" required="required">
			<br>
			<h3>Phone</h3>
			<input type="text" class="form-control" name="phone" value="${user.phone}" required="required">
			<br>
			<h3>Address</h3>
			<input type="text" class="form-control" name="address" value="${user.address}" required="required">
			<br>
	
			<hr>
		<!-- payment info -->
			<h2>Choose Payment</h2>
			<br>
			<h3>Payment: $ ${order.total}</h3>
			<br>
		
			<div class="col-sm-6 col-md-4 col-lg-3 ">
			    <div class="thumbnail">
			        <img src="picture/paypal.png">
			        <input type="radio" name="paytype" value="1" checked="checked" />
			    </div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
			    <div class="thumbnail">
			        <img src="picture/card.jpg">
			        <input type="radio" name="paytype" value="2"/>
			    </div>
			</div>
		<!-- payment submit -->
			<div class="clearfix"> </div>
			<div class="register-but text-center">
			   <input type="submit" value="Submit">
			</div>
		</form>
	</div>

</body>
</html>