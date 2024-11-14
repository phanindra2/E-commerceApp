<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>
<marquee>
		<h4>UPDATE A PRODUCT</h4>
	</marquee>
	<div align="center">
	${message}
	<form:form action="updateProduct" method="post" modelAttribute="product_details">
		<table>
			<tr>
				<td>Product ID:</td>
				<td><form:input path="id"  readonly="true"/></td>
				<td><form:errors path="id" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="price" /></td>
				<td><form:errors path="price" /></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><form:input path="quantity" /></td>
				<td><form:errors path="quantity" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
				<td><form:errors path="description" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="UPDATE" /></td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>