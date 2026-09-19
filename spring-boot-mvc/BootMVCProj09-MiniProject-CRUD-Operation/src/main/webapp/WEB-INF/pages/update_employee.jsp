<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<h1 style="color:red;text-align:center">Update Employee</h1>
<frm:form modelAttribute="emp">
	<table align="center" bgcolor="yellow">
		<tr>
			<td>Employee Id:</td>
			<td> <frm:input path="id" readonly="true"/></td>
		</tr>
		<tr>
			<td>Employee Name:</td>
			<td> <frm:input path="name"/></td>
		</tr>
		<tr>
			<td>Employee Job:</td>
			<td> <frm:input path="job"/></td>
		</tr>
		<tr>
			<td>Employee Salary:</td>
			<td> <frm:input path="salary"/></td>
		</tr>
		<tr>
			<td>Employee Department No:</td>
			<td> <frm:input path="departmentNo"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Update Employee"/></td>
			<td><input type="reset" value="cancel"/></td>
		</tr>
	</table>
</frm:form>
</body>
</html>