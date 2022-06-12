<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Login page</title>
<style>
	body {
		align-content: center;
	}
</style>
</head>
<body>
<%
	session.removeAttribute("modifyCourse");
	session.removeAttribute("modifyStudent");
	session.removeAttribute("modifyGrade");
	session.removeAttribute("course");
	session.removeAttribute("student");
	session.removeAttribute("user");
%>

<form action="Login" class="d-flex justify-content-center h-100">
	<div class="card">
		<h3>Sign in</h3>
	</div>
	<div class="card-body">
		<label for="user">Username</label>		
		<input type="text" placeholder="Enter Username" name="user" required class="form-control"><br>
		<label for="pass">Password</label>
		<input type="password" placeholder="Enter Password" name="pass" required class="form-control"><br>
		<button type="submit">Login</button><br>
		<label>
        	<input type="checkbox" checked="checked" name="remember"> Remember me
      	</label><br>
		<a href="jsp/register.jsp">Create new account?</a>	
	</div>
</form>
<c:choose>
    <c:when test="${notification=='Invalid username or password'}">
        <a style="color:red">${notification}</a>
    </c:when>    
    <c:otherwise>
        <a style="color:green">${notification}</a>
    </c:otherwise>
</c:choose>


</body>
</html>