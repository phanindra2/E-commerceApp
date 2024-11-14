<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
	<marquee>
		<h4>WELCOME TO REGISTRATION PAGE</h4>
	</marquee>
<div align="center">	
	${message}
	<form:form action="registerval" method="post" modelAttribute="customer">
		<table>
			<tr>
				<td>MAIL :</td>
				<td><form:input path="username" required="required"/></td>
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>PASSWORD :</td>
				<td><form:input type="password" path="password" required="required"/></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td>FULLNAME :</td>
				<td><form:input path="mail" required="required"/></td>
				<td><form:errors path="mail" /></td>
			</tr>
			<tr>
				<td>AGE :</td>
				<td><form:input path="age" required="required"/></td>
				<td><form:errors path="age" /></td>
			</tr>
			<tr>
				<td>ADDRESS :</td>
				<td><form:input path="adress" required="required"/></td>
				<td><form:errors path="adress" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	Already have account ? <a href="login">Login</a>
</div>
</body>
</html>