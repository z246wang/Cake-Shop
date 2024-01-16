<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<nav class="navbar navbar-default">
	
	<a class="navbar-brand">Back-end</a>

	<ul class="nav navbar-nav">
		<li><a href="${pageContext.request.contextPath}/admin/order_list">Order</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/user_list">User</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/goods_list">Goods</a></li>
		<li><a href="${pageContext.request.contextPath}/user_logout">Log Out</a></li>
	</ul>
</nav>