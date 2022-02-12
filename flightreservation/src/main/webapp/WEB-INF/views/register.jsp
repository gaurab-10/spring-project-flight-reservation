<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<h2> Registration page::</h2><br/><br/>

      ${errorMessage}
	<form action="/registerUser" method="post">
	
		FirstName:: <input type="text" name="firstName" /> 
		LastName:: <input type="text"name="lastName" /> 
		 UserName:: <input	type="text" name="email" />
		 Password:: <input	type="text" name="password" />
		 Confirm Password:  <input	type="text" name="cpassword" />
		 <input type = "submit" value = "Register"/>
		 
	</form>
</body>
</html>