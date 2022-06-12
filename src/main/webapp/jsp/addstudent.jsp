<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Add student</title>
<style>
	body {
		align-content: center;
	}
</style>
</head>
<body>
	
<form action="/../OOP_Project/AddStudent" class="d-flex justify-content-center h-100">
	<div class="card">
		<h3>Add/modify students</h3>
	</div>
	<div class="card-body">
		<label for="name">Student's name: </label>
		<input type="text" placeholder="Enter student's name" name="name" required class="form-control"><br>
		<label for="id">Student's id: </label>
		<input type="text" placeholder="Enter student's id" name="id" required class="form-control"><br>
		<label for="phone">Student's phone number: </label>
		<input type="text" placeholder="Enter student's phone number" name="phone" required class="form-control"><br>
		<label for="major">Student's major: </label>
		<input type="text" placeholder="Enter student's major" name="major" required class="form-control"><br>
		
		<button type="submit">Submit</button><br>
	</div>
</form>

</body>
</html>