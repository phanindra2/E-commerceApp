<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Order Details</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<a href="<c:url value='/' />">Logout</a>
<br>
<a href="<c:url value='/Home' />">Home</a>
<h3 align="center">Hello this order Confirmation page</h3>
<c:if test="${!empty cartList}">
<h4> selected Quantity for these items selected is unavailable </h4>
	<table class="table table-bordered table-dark">
	<tr>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRODUCT DESCRIPTION</th>
		<th width="120">PRICE</th>
		<th width="120">QUANTITY</th>
	</tr>
	<c:forEach items="${cartList}" var="cart">
		<tr>
			<td>${cart.product.name}</td>
			<td>${cart.product.description}</td>
			<td>${cart.totalPrice}</td>
			<td>${cart.quantity}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<br>
<br>

<c:if test="${!empty orderList}">

<h3 align="center">This is your Bill</h3>

<table class="table table-bordered table-dark">
	<tr>
		<th width="120">EMAIL</th>
		<th width="120">FULL NAME</th>
		<th width="120">DATE</th>
		<th width="120">ADRESS</th>
	</tr>
		<tr>
			<td>${userDetails.username}</td>
			<td>${userDetails.mail}</td>
			<td><%= new java.util.Date() %></td>
			<td>${userDetails.adress}</td>
		</tr>
	</table> 


<c:set var="totalValue" value="${0}"/>
<h4>Order Items</h4>
	<table class="table table-bordered table-dark">
	<tr>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRODUCT ID</th>
		<th width="120">TOTAL PRICE</th>
		<th width="120">QUANTITY</th>
	</tr>
	<c:forEach items="${orderList}" var="order">
		<tr>
			<td>${order.productName}</td>
			<td>${order.productId}</td>
			<td>${order.amount}</td>
			<td>${order.quantity}</td>
			<c:set var="totalValue" value="${totalValue + order.amount}" />
		</tr>
	</c:forEach>
	</table> 
	
	<h4>Total Order Value : ${totalValue}</h4>
</c:if>


<h3><a href="<c:url value='/getAll' />">Continue Shopping</a></h3>

</body>
</html>