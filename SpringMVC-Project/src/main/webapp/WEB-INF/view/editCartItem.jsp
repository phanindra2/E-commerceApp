<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="editItem">
<input type="hidden"  readonly="readonly"  name="cartItemId" value="${cartItemId}">
<br>
UPDATE QUANTITY:
<input type="number" min="0" name="quantity">
<input type="submit" value="update">
</form>
</div>
</body>
</html>