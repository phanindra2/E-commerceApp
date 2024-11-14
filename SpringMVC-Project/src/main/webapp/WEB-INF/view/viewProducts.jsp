<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products List</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
</style>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<a href="<c:url value='/' />">Logout</a>
<br>
<a href="<c:url value='/admin/home' />">Home</a>
${message}
<h3>Products List</h3>
<c:if test="${!empty productList}">
	<table class="table table-bordered table-dark">
	<tr>
		<th width="80">PRODUCT ID</th>
		<th width="120">PRODUCT NAME</th>
		<th width="120">PRICE</th>
		<th width="120">QUANTITY</th>
		<th width="150">DESCRIPTION</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${productList}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.price}</td>
			<td>${product.quantity}</td>
			<td>${product.description}</td>
	     	<td><a href="<c:url value='/admin/edit_product/${product.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/admin/remove_product/${product.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>


</body>
</html>