<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
</head>
<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
<div align="center">
<marquee><h4>Welcome to Admin page</h4></marquee>
<a href="getAll">Customers List</a>
<br>
<a href="addProduct">Add Product</a> 
<br>
<a href="getAllProducts">Products List</a>

<form action="searchRes">
<input type="text"  name="product_name"> 
<input type="submit" value="SEARCH">
</form>

</div>
<a href="<c:url value='/' />">Logout</a>
</body>
</html>