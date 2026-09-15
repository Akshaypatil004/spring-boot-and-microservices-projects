<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register</title>
</head>
<body>
<h2>Student registration</h2>
<hr>
<form action="register" method="POST">
	Student Number  : <input type="text" name="sno"><br>
	Student Name    : <input type="text" name="sname"><br>
	Student Address : <input type="text" name="saddr"><br>
	Student Avg     : <input type="text" name="avg"><br>
	
	<input type="submit" value="Register">
</form>

</body>
</html>