<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">	
			<!-- show in a button when zoom in -->	
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<!-- left-side tabs -->	
			<h1 class="navbar-brand"><a href="${pageContext.request.contextPath}">Shop</a></h1>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav"> 
					<li><a href="${pageContext.request.contextPath}">Front Page</a></li>
					
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories<b class="caret"></b></a>
						<ul class="dropdown-menu multi-column columns-2">
							<li>	
								<div class="col-sm-12">
									<ul class="multi-column-dropdown">	
										<li><a href="${pageContext.request.contextPath}/goods_list">ALL</a></li>
										<c:forEach items="${typeList}" var="type">
											<li>
												<a href="${pageContext.request.contextPath}/goods_list?id=${type.id}">${type.name}</a>
											</li>
										</c:forEach>
									</ul>
								</div>			
							</li>
						</ul>
					</li>
					<!-- hidden tabs -->	
					<c:choose><c:when test="${empty user}">
						<li><a href="${pageContext.request.contextPath}/user_register.jsp" >Register</a></li>
						<li><a href="${pageContext.request.contextPath}/user_login.jsp" >Login</a></li>
					</c:when><c:otherwise>
						<li><a href="${pageContext.request.contextPath}/order_list">My Order</a></li>
						<li><a href="${pageContext.request.contextPath}/user_center.jsp">Account Info</a></li>
						<li><a href="${pageContext.request.contextPath}/user_logout" >Log Out</a></li>
					</c:otherwise>
					</c:choose>
						
					<c:if test="${!empty user && user.isadmin}">
						<li><a href="${pageContext.request.contextPath}/admin/admin_index.jsp">Management</a></li>
					</c:if>
				</ul> 
			</div>
		</nav>
		<!-- right-side icons -->	
		<div class="header-info">
			<div class="header-right search-box">
				<span class="glyphicon glyphicon-search" aria-hidden="true"></span>			
				<div class="search">
					<form class="navbar-form" action="${pageContext.request.contextPath}/goods_search">
						<input type="text" name="keyword" />
						<button type="submit" class="btn btn-default">Search</button>
					</form>
				</div>	
			</div>
			
			<div class="header-right cart">
				<a href="${pageContext.request.contextPath}/goods_cart.jsp">
					<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true">${order.amount}</span>
				</a>
			</div>
			
			<div class="header-right login">
				<a href="my.action"><span class="glyphicon" aria-hidden="true"></span></a>
			</div>
		</div>
	</div>
</div>
