<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body>
<h3>Season</h3>
<p>Current Season : <b>${season}</b>
<br>

<h3>Simple values come</h3>
<p>Name : <b>${name}</b></p>
<p>Age : <b>${age}</b></p>
<p>Address : <b>${address}</b></p>
<br>

<h3>Array,Collection Values</h3>
<p>NickNames : <b><%= Arrays.toString(((String[])request.getAttribute("arrNickNames"))) %></b></p>
<p>Friends : <b>${listOfFriends}</b></p>
<p>Phone Numbers : <b>${setOfPhonenumbers}</b></p>
<p>Id Details : <b>${mapOfIdDetails}</b></p>
<br>

<h3>Model data</h3>
<p>Customer data : <b> ${custData}</b></p>
<br>

<h3>List Of model Data</h3>
<p> List Of customers : <b>${listCustData}</b></p>
<br>
</body>
</html>