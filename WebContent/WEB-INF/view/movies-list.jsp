
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

	${email}
	<form:form action="getmoviename">

		<select name="category">
			<c:forEach items="${moviesList}" var="module">
				<option value="${module.mname}">${module.mname}</option>

			</c:forEach>
		</select>

		<input type="hidden" name="email" value="${email}">
		<input type="submit" value="Submit" />
	</form:form>


</body>
</html>