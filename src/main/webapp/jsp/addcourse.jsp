<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<form action="/../OOP_Project/AddCourse" class="d-flex justify-content-center h-100">
	<div class="card">
		<h3>Add/modify course</h3>
	</div>
	<div class="card-body">
		<label for="credit">Number of credit:</label>
		<input type="number" placeholder="Enter number of credit" name="credit" required class="form-control"><br>
		
		<label for="courseCode">Course code</label>		
		<input type="text" placeholder="Enter course code" name="courseCode" required class="form-control"><br>
		
		<label for="courseName">Course name</label>
		<input type="text" placeholder="Enter course name" name="courseName" required class="form-control"><br>
		
		<label for="description">Description</label>
		<input type="text" placeholder="Enter description" name="description" required class="form-control"><br>
		
		Choose the days: <br/>
		<input type="checkbox" name="day" value="2">Monday<br>
        <input type="checkbox" name="day" value="3">Tuesday<br>
        <input type="checkbox" name="day" value="4">Wednesday<br>
        <input type="checkbox" name="day" value="5">Thursday<br>
        <input type="checkbox" name="day" value="6">Friday<br>

		
		<label for="startHour">Choose start time</label>
		<input type="number" placeholder="Enter start hour" name="startHour" required class="form-control">
		<input type="number" placeholder="Enter start minute" name="startMin" required class="form-control"><br>
		
		<label for="endHour">Choose end time</label>
		<input type="number" placeholder="Enter end hour" name="endHour" required class="form-control">
		<input type="number" placeholder="Enter end minute" name="endMin" required class="form-control"><br>
		
		<button type="submit">Submit</button><br>

	</div>
</form>


</body>
</html>