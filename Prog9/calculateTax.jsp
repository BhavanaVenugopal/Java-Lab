<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Tax</title>
</head>
<body>
	<%
		String username = (String)session.getAttribute("login");
		double income = Double.parseDouble(request.getParameter("income"));
		String name=request.getParameter("name");
		String org = request.getParameter("org");
		String gender = request.getParameter("gender");
		double tax=0;
		if(income>100001 && income<=500000){
			tax = 0.15*income;
		}
		else if(income>500000){
			tax=0.2*income;
		}
		else{
			tax=0;
		}
		username = username+"\nName :"+name+"\nGender :"+gender+"\nOrganization :"+org+"\nAnnual income :"+income+"\nTax :"+tax;
		System.out.println(username);
		response.getWriter().append(""+username);
		session.setAttribute("login",username);
	%>
		<a href="logout.jsp">Logout</a>
	
</body>
</html>