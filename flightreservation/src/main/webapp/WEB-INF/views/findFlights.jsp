<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title> 
</head>
<body>
	Welcome to find the flights.............

	<form action="/searchFlights" method="post">

		From:: <input type="text" name="departureCity" /> To:: <input
			type="text" name="arrivalCity" /> Departure Date <input type="text"
			name="dateOfDeparture" /> <input type="submit" value="search" />
	</form>
	<h2> Available flights..</h2>
	<table>
		<tr>
			<th>Departure City</th>
			<th>Arrival City</th>
			<th> Airlines </th>
			<th> Departure Time </th>
		</tr>
		<c:forEach items="${flights}" var="flight">
			<tr>
				<td>${flight.departureCity}</td>
				<td>${flight.arrivalCity}</td>
				<td>${flight.operatingAirlines}</td>
				<td>${flight.dateOfDeparture}</td>
				<td><a href = "/showReservation?flightID=${flight.id}"> select </a> </td>	
			</tr>
		</c:forEach>
	</table>
</body>
</html>