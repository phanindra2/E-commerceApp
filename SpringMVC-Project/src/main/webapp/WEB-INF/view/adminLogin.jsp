<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN LOGIN PAGE</title>
</head>
<body background="<c:url value='/resources/images/img2.jpg' />" style="background-size: cover;">
<marquee><h4>WELCOME TO ADMIN LOGIN PAGE</h4></marquee>
<div align="center" >
${message}
<form:form action="loginval" method="post" modelAttribute="user">
<table >    
         <tr>    
          <td> <b>USER NAME :</b> </td>   
          <td><form:input path="username" required="required" /></td>  
          <td><form:errors path="username"  /></td>  
         </tr>    
         <tr>    
          <td> <b>PASSWORD :</b></td>    
          <td><form:input type="password" path="password" required="required"/></td>  
          <td><form:errors path="password" /></td>  
         </tr>  
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Login" /></td>    
         </tr>    
        </table>    
</form:form>

</div>
</body>
</html>