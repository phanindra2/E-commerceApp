<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>

<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
<a href="<c:url value='/' />">Logout</a>
<div align="center">
<h4>Helloo  ${sessionScope.user}</h4>
<br>
<a href="getAll">getAllProducts</a><br>
<a href="cart">go to Cart</a><br>
<a href="getOrders">My Orders</a>
<form action="searchRes">
<input type="text"  name="product_name"> 
<input type="submit" value="SEARCH">
</form>
</div>
</body>
</html>