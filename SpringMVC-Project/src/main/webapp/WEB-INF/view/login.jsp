<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
<div align="center">
<marquee><h4>WELCOME TO LOGIN PAGE</h4></marquee>
${message}
<form:form action="loginval" method="post" modelAttribute="user">
<table >    
         <tr>    
          <td> <b> MAIL : </b></td>   
          <td><form:input  path="username"  placeholder="Enter Your Mail" required="required" /></td>  
          <td><form:errors path="username"  /></td>  
         </tr>    
         <tr>    
          <td> <b>PASSWORD : </b></td>    
          <td><form:input  type="password" path="password" placeholder="Enter Your Password" required="required"/></td>  
          <td><form:errors path="password" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Login" /></td>    
         </tr>    
        </table>    
</form:form>
new User ? <a href="register"> register</a>
</div>
</body>
</html>