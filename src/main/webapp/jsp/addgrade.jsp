<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Add grade</title>
<style>
	body {
		align-content: center;
	}
</style>
</head>
<body>
	
<form action="/../OOP_Project/AddGrade" class="d-flex justify-content-center h-100">
	<div class="card">
		<h3>Add/modify grade</h3>
	</div>
	<div class="card-body">
		<label for="title">Title: </label>
		<input type="text" placeholder="Enter title:" name="title" required class="form-control"><br>
		<label for="id">Grade </label>
		<input type="number" placeholder="Enter grade:" name="grade" required class="form-control"><br>
		<label for="phone">Max grade </label>
		<input type="number" placeholder="Enter max grade:" name="maxGrade" required class="form-control"><br>
		<label for="scale">Enter scale: </label>
		<input type="number" placeholder="Enter scale" name="scale" required class="form-control"><br>
		<button type="submit">Submit</button><br>
	</div>
</form>

</body>
</html>