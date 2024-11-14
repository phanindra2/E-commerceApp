<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>ADD PRODUCT</title>
</head>
<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
<marquee>
		<h4>ADD A PRODUCT</h4>
	</marquee>
	<div align="center">
	${message}
	<form:form action="addProductVal" method="post" modelAttribute="product">
		<table>
			<tr>
				<td>Product ID:</td>
				<td><form:input path="id" required="required"/></td>
				<td><form:errors path="id" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="name" required="required" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" required="required"/></td>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><form:input path="quantity" required="required" /></td>
				<td><form:errors path="quantity" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="ADD" /></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>