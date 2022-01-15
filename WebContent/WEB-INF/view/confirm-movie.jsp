
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login User</title>
</head>
<body>
	You have Selected Total Number of seats are ${selectedSeats}
	<br> You have selected seat of type ${seatType}
	<br> You have to pay amount if Rs${TotalAmount}
	<br>
	<a href="showMoviesList">Book another movie</a>	<a href="loginPage">LogOut</a>
	
</body>
</html>