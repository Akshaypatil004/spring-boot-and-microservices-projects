<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Report</title>
</head>
<body>

<c:choose>
	<c:when test="${not empty empList}">
		<h1 style="color:red;text-align:center">Employee Report</h1>
		
		<table border="1" align="center",bgcolor="grey">
			<thead>
				<tr style="color:red">
					<td>Id</td>
					<td>Name</td>
					<td>Job</td>
					<td>Salary</td>
					<td>Department No</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach  var="emp" items="${empList}">
					<tr>
						<td>${emp.id}</td>
						<td>${emp.name}</td>
						<td>${emp.job}</td>
						<td>${emp.salary}</td>
						<td>${emp.departmentNo}</td>
						<td>
							<a href="emp_edit?id=${emp.id}"><img src="images/edit.jpg" width="30px" height="30px"/></a>
							<a href="emp_delete?id=${emp.id}" onclick="return confirm('Do you want to delete the employee');">
								<img src="images/delete.jpg" width="30px" height="30px"/>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center"> Employee Not Found</h1>
	</c:otherwise>
</c:choose>

<c:if test="${not empty newEmp}">
	<h1 style="color:red;">
		${newEmp} 
	</h1>
</c:if>
<c:if test="${not empty updateEmp}">
	<script>
		alert("${updateEmp}")
	</script>	
</c:if>
<c:if test="${not empty deleteEmpMsg}">
	<script>
		alert("${deleteEmpMsg}")
	</script>
</c:if>
<center>
	<a href="emp_add"><img src="images/add.jpg" width="40px" height="50px"/>Add Employee</a> &nbsp;&nbsp;&nbsp;
	<a href="./"><img src="images/home.jpg" width="40px" height="50px"/>Home</a>
</center>
</body>
</html>