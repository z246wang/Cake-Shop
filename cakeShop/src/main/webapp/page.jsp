<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="text-align:center">
	<a class='btn btn-info' 
		<c:if test="${p.pageNo==1}">disabled</c:if>
		<c:if test="${p.pageNo!=1}">href="${pageContext.request.contextPath}${param.url}?pageNo=1${param.param}"</c:if>>
		First
		</a>
	<a class='btn btn-info' 
	    <c:if test="${p.pageNo==1}">disabled</c:if> 
		<c:if test="${p.pageNo!=1}">href="${pageContext.request.contextPath }${param.url}?pageNo=${p.pageNo-1}${param.param}"</c:if>>
		Forward
	    </a>
	<h3 style='display:inline;'>[${p.pageNo}/${p.totalPage}]</h3>

	<a class='btn btn-info' 
		<c:if test="${p.totalPage==0 || p.pageNo==p.totalPage}">disabled</c:if>
		<c:if test="${p.pageNo!=p.totalPage}">href="${pageContext.request.contextPath}${param.url}?pageNo=${p.pageNo+1}${param.param}"</c:if>>
		Next
		</a>
	<a class='btn btn-info'
	    <c:if test="${p.totalPage==0 || p.pageNo==p.totalPage}">disabled</c:if> 
		<c:if test="${p.pageNo!=p.totalPage}">href="${pageContext.request.contextPath}${param.url}?pageNo=${p.totalPage}${param.param}"</c:if>>
	    Last
		</a>
</div>