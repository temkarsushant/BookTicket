<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Registration Page</title>
</head>

<body>

	<form:form action="confirmRegistration" modelAttribute="user">

		First name: <form:input path="firstname" />
		<br>
		Last name: <form:input path="lastname" />
		<br>
		email: <form:input path="email" />
		<br>
		password: <form:input path="password" />
		<br>
		phone: <form:input path="phone" />
		<br>



		<input type="submit" value="Submit" />
		
		<a href="loginPage">Already a user....Plase Login Here</a>

	</form:form>

</body>
</html>