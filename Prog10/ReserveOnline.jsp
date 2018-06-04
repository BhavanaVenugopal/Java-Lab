<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Air Ticket Reservation</title>
</head>
<body>
	<h2>Enter Flight Details :</h2><br>
	<form action="reserve" method="GET">
		Flight Number :<input type = "text" name="fno"/><br>
		Date :<input type = "date" name="date"/><br>
		Customer Name :<input type = "text" name="name"/><br>
		Customer Phone Number :<input type="text" name="phone"/><br>
		<input type="submit" value="Submit"/><br><br>
	</form>
	<a href="flight">Link to view flight details</a>
	
</body>
</html>