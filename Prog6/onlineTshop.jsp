<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amazon</title>
</head>
<body>
	<h1>Welcome to T-Shirt Shopping !!</h1><br>
	<form name="onlineshop" action="Service" method="GET">
	<h2>Please select your accessories :</h2><br>
	<input type="checkbox" name="acc" value="cap"/>Cap<br><input type="checkbox" name="acc" value="belt"/>Belt<br>
	<input type="checkbox" name="acc" value="hair-band"/>Hair-Band<br><br>
	<textarea rows="2" cols="20" name="tag-line">Enter your tag-line here</textarea>
	<h2>Do you like to have Chest pocket :</h2>
	<input type="radio" name="cpocket" value="yes"/>Yes<br><input type="radio" name="cpocket" value="no"/>No<br><br>
	<select name="colour">
		<option value="Red">Red<option/>
		<option value="Blue">Blue<option/>
		<option value="Green">Green<option/>
	</select><br>
	<input type="submit" value="Click Me"/>
	</form>
	<form action="display.jsp" method="POST">
		<input type="submit" value="View"/>
	</form>
</body>
</html>