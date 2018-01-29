<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee data form</title>
</head>
<body>
	<!-- 
	<form method="post">
		<br/>
		ID : <input type="text" name="empId" /><br/>
		FirstName : <input type="text" name="fname" /><br/>
		LastName : <input type="text" name="lname" /><br/>
		<input type="submit" value="save">
	</form>
	 -->

	<a href="changelocale.htm?lang=en">English</a>
	<br />
	<a href="changelocale.htm?lang=es">Hindi</a>

	<form:form method="post" modelAttribute="emp">
		<br />
		ID : <form:input path="empId" />
		<form:errors path="empId" />
		<br />
		FirstName : <form:input path="fname" />
		<form:errors path="fname" />
		<br />
		LastName : <form:input path="lname" />
		<form:errors path="lname" />
		<br />
		<input type="submit" value="save">
	</form:form>
</body>
</html>