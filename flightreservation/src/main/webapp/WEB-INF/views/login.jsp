<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2> Login page::</h2><br/><br/>
        ${errorMessage}
	<form action="/savelLogin" method="post">
	
		UserName:: <input type="text" name="email" /> 
		Password:: <input type="text"name="password" /> 
		 <input type = "submit" value = "Login"/>
		 
	</form>
</body>
</html>