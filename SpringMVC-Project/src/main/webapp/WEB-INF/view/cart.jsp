<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
</style>
</head>
<body bgcolor="#708090">
<a href="<c:url value='/' />">Logout</a>
<br>
<a href="<c:url value='/Home' />">Home</a>
<div align="center">
<h3>YOUR CART</h3>
<c:if test="${!empty cartList}">
	<table class="tg">
	<tr>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRICE</th>
		<th width="120">QUANTITY</th>
		<th width="60">UPDATE</th>
		<th width="60">DELETE</th>
	</tr>
	<c:forEach items="${cartList}" var="cart">
		<tr>
			<td>${cart.product.name}</td>
			<td>${cart.totalPrice}</td>
			<td>${cart.quantity}</td>
			<td><a href="<c:url value='/cart/edit_item/${cart.cartItemId}' />" >update</a></td>
			<td><a href="<c:url value='/cart/remove_item/${cart.cartItemId}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
	
	<h2><a href="cart/checkout">Check Out</a></h2>
</c:if>
<h3><a href="<c:url value='/getAll' />">Continue Shopping</a></h3>
</div>
</body>
</html>