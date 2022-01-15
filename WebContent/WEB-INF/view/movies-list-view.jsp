
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

	You have selected the movie ${movieName}
	<br>Total available seats are : ${numberOfSeats}


	<br> Please select the number of seats


	<form:form action="confirmMovie" modelAttribute="numberOfSeats">

		<select name="sets">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select>
		<br>

		<select name="seatType">
			<option value="Gold">Gold</option>
			<option value="Silver">Silver</option>
			<option value="Platinum">Platinum</option>

		</select>
		
				<input type="hidden" name="email" value="${email}">
		

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>