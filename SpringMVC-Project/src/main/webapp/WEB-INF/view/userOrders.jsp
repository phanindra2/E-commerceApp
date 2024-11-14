<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body bgcolor="#708090">
<h4>Your Orders</h4>
<c:if test="${!empty ordersList}">
	<c:set var="cnt" value="${1}"/>
	<table class="table table-bordered table-dark">
	<tr>
		<th width="80">NUM</th>
		<th width="120">DATE & TIME</th>
		<th width="120">TOTAL</th>
		<th width="120">DETAILS</th>
	</tr>
	<c:forEach items="${ordersList}" var="orders">
		<tr>
			<td>${cnt}</td>
			<td>${orders.orderedDate}</td>
			<td>${orders.total}</td>
		<td><a href="<c:url value='/orderDetails/${orders.orderId}' />" >get Details</a></td>
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