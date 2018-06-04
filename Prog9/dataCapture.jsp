<%@ page language="java" import="java.util.HashMap" import="java.util.Date" import="java.io.PrintWriter" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%!HashMap<String,String> x = new HashMap<String,String>();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Capture</title>
</head>
<body>
	<%x.put("Zubin","12345");
	x.put("Kraine","34566");
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	if(x.containsKey(user) && pass.equals(x.get(user))){
	session.setAttribute("login",user);
	response.getWriter().append("Welcome "+user);
	PrintWriter p = response.getWriter();
	p.println("\nDate :"+java.time.LocalDate.now());
	}
	else{
	//System.out.println("Invalid user login");
	response.getWriter().append("Invalid Login");
	return;
	}%>
	
	<form action="calculateTax.jsp" method = "GET">
	Name :<input type="text" name="name"/><br>
	Organization :<select name="org">
					<option value="IBM">IBM</option>
					<option value="Google">Google</option>
					<option value="Cisco">Cisco</option>
				</select><br>
	Gender :<input type="radio" name="gender" value="male"/>Male <input type="radio" name="gender" value="female"/>Female<br>
	Annual income :<input type="text" name="income"/>
	<input type="submit" value="submit"/>
	</form>
</body>
</html>