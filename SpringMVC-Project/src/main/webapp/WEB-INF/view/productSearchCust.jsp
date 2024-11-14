<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div align="center">
</div>
<a href="<c:url value='/' />">Logout</a>
<br>
<a href="<c:url value='/Home' />">Home</a>
${message}
<c:if test="${!empty productList}">

    <h3>Products List</h3>
	<table class="table table-bordered table-dark">
	<tr>
		<th width="80">PRODUCT ID</th>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRICE</th>
		<th width="120">QUANTITY</th>
		<th width="150">DESCRIPTION</th>
		<th width="60">Add to Cart</th>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.description}</td>
			<td><a href="<c:url value='/cart/add_item/${product.id}' />" >Add Cart</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${empty productList}"><h4>Not Found</h4></c:if>

</body>
</html>