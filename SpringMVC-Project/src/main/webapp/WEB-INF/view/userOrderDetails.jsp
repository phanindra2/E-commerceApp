<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body bgcolor="#708090">
<c:if test="${!empty orderItems}">
	<c:set var="cnt" value="${1}"/>
	<table class="table table-bordered table-dark">
	<tr>
		<th width="80">NUM</th>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRODUCT ID</th>
		<th width="120">QUANTITY</th>
		<th width="120">PRICE</th>
	</tr>
	<c:forEach items="${orderItems}" var="items">
		<tr>
			<td>${cnt}</td>
			<td>${items.productName}</td>
			<td>${items.productId}</td>
			<td>${items.quantity}</td>
			<td>${items.amount}</td>
		</tr>
		<c:set var="cnt" value="${cnt + 1}" />
	</c:forEach>
	</table>
</c:if>
<a href="<c:url value='/' />">Logout</a>
<br>
<a href="<c:url value='/Home' />">Home</a>
</body>
</html>