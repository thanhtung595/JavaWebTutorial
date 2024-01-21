<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gia tri random</title>
</head>
<body>
	<% Random random = new Random(); 
		int randomInt = random.nextInt(3);
		if(randomInt == 0){
	%>
		<h1>Random value = <%= randomInt %></h1>
	<%} 
		else if(randomInt == 1){
	%>
		<h2>Random value = <%= randomInt %></h2>
	<%} 
		else{
	%>
		<h3>Random value = <%= randomInt %></h3>
	<%} %>
	<a href="<%= request.getRequestURI() %>">Try Again</a>
</body>
</html>