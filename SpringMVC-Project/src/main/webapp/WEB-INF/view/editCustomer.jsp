<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Customer Details</title>
</head>
<body>
 <form:form action="updateCustomer" method="post" modelAttribute="customer_details">
		<table>
			<tr>
				<td>MAIL :</td>
				<td><form:input path="username" readonly="true"/></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><form:input readonly="true" type="hidden" path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>FULL NAME :</td>
				<td><form:input path="mail" /></td>
				<td><form:errors path="mail" /></td>
			</tr>
			<tr>
				<td>AGE :</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" /></td>
			</tr>
			<tr>
				<td>ADDRESS :</td>
				<td><form:input path="adress" /></td>
				<td><form:errors path="adress" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>