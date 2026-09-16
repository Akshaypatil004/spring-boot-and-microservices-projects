<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Register</title>
</head>
<body>
<h2 style="color:red"> Student Registration Form</h2>
<hr>
<frm:form modelAttribute="stud">
	Student Number : <frm:input path="sno"/> <br>
	Student Name   : <frm:input path="sname"/> <br>
	Student Address : <frm:input path="saddr"/> <br>
	Student Avg     : <frm:input path="avg"/>
	
	<input type="submit" value="Register">
	<input type="reset" value="Cancle">
</frm:form>
</body>
</html>