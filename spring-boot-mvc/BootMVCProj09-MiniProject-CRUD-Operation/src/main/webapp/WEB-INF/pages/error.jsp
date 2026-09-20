<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
<h1 style="color:red;text-align:center"> Some internal problem - incovience is regratted</h1>
<hr>
<center>
	<p>status : <b>${status}</b> </p> <br>
	<p>timestamp : <b>${timestamp}</b> </p> <br>
	<p>message : <b>${message}</b> </p> <br>
	<p>type : <b>${type}</b> </p> <br>
	<p>path : <b>${path}</b> </p> <br>
	<p>trace : <b>${trace}</b> </p> <br>
</center>
</body>
</html>