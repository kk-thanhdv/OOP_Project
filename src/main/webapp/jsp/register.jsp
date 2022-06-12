<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/../OOP_Project/css/bootstrap.css">
<title>Login page</title>
<style>
	body {
		align-content: center;
	}
</style>
</head>
<body>

<form action="/../OOP_Project/Register" class="d-flex justify-content-center h-100">
	<div class="card">
		<h3>Register</h3>
	</div>
	<div class="card-body">
		<label for="name">Name</label>
		<input type="text" placeholder="Enter Name" name="name" required class="form-control"><br>
		<label for="user">Username</label>		
		<input type="text" placeholder="Enter Username" name="user" required class="form-control"><br>
		<label for="pass">Password</label>
		<input type="password" placeholder="Enter Password" name="pass" required class="form-control"><br>
		<label for="pass1">Enter password again</label>
		<input type="password" placeholder="Enter Password Again" name="pass1" required class="form-control"><br>
		<button type="submit">Register</button><br>
	</div>
</form>


</body>
</html>