<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
	<h1 style="color: red">Display Page</h1>

	<h3>Wish Message</h3>
	<hr>
	<c:if test="${!empty msg}">
		<p>
			Result :: <b><c:out value="${msg}"></c:out></b>
		</p>
	</c:if>
	<br>
	<hr>

	<h3>Simple values</h3>
	<hr>
	<c:if test="${!empty heroName}">
		<p>
			Hero Name : <b>${heroName}</b>
		</p>
	</c:if>
	<br>

	<c:if test="${!empty nickName}">
		<p>
			Nick Name : <b>${nickName}</b>
		</p>
	</c:if>
	<br>

	<c:if test="${ !empty movieName}">
		<p>
			Movie Name : <b>${movieName}</b>
		</p>
	</c:if>
	<br>

	<c:if test="${ !empty budget}">
		<p>
			Budget : <b>${budget}</b>
		</p>
	</c:if>
	<br>
	<hr>

	<h3>Arrays,Collection values</h3>
	<hr>
	<c:if test="!${ empty arrAnimal}">
		<p>
			Animals :
			<c:forEach var="animal" items="${arrAnimal}">
				<b>${animal}</b>
				<br>
			</c:forEach>

		</p>
	</c:if>
	<br>

	<c:if test="${ !empty listOfFruits}">
		<p>
			Fruits :
			<c:forEach var="fruit" items="${listOfFruits}">
				<b>${fruit}</b>
				<br>
			</c:forEach>
		</p>
	</c:if>
	<br>

	<c:if test="${!empty setOfNumbers}">
		<p>
			Numbers :
			<c:forEach var="num" items="${setOfNumbers}">
				<b>${num}</b>
				<br>
			</c:forEach>
		</p>
	</c:if>
	<br>

	<c:if test="${ !empty mapOfID}">
		<p>
			ID's :
			<c:forEach var="id" items="${mapOfID}">
				<b>${id.key} : ${id.value}</b>
				<br>
			</c:forEach>
		</p>
	</c:if>
	<br>
	<hr>

	<h3>Model values</h3>
	<hr>
	<c:if test="${!empty person}">
		<p>
			Person Details: <br> IDNO : <b>${person.pno}</b> <br> Name
			: <b>${person.pname}</b> <br> Address : <b>${person.paddr}</b> <br>
		</p>
	</c:if>
	<br>
	<hr>

	<h3>Collection/List of model</h3>
	<hr>
	<c:choose>
		<c:when test="${ !empty listOfPerson}">
			<b>${listOfPerson.size()} no.of person are available</b>
			<table border="1" bgcolor="cyan">
				<tr>
					<th>pno</th>
					<th>pname</th>
					<th>paddr</th>
				</tr>
				<c:forEach var="person" items="${listOfPerson}">
					<tr>
						<td>${person.pno}</td>
						<td>${person.pname}</td>
						<td>${person.paddr}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<b>Person Data Not avaibale</b>
		</c:otherwise>
	</c:choose>
	<br>

</body>
</html>