<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	String driver="com.mysql.jdbc.Driver";
    	String user="root";
    	String pass="";
    	String url = "jdbc:mysql://localhost:3306/java";
    	Connection conn = null;
    	try{
    		Class.forName(driver);
    		conn = DriverManager.getConnection(url,user,pass);
    	}
    	catch (Exception e){
    		System.out.println("Error :"+e);
    	}
    	String query = "SELECT * FROM tshirt;";
    	Statement s = conn.createStatement();
    	ResultSet rs = s.executeQuery(query);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=2>
		<thead>
			<th>Order Number</th>
			<th>Color</th>
			<th>Tag Line</th>
			<th>Chest Pocket</th>
			<th>Accessories</th>
		</thead>
		<tbody>
			<%while(rs.next()){ %>
			<tr>
				<td><%=rs.getInt("order_num")%></td>
				<td><%=rs.getString("colour")%></td>
				<td><%=rs.getString("chest_pocket")%></td>
				<td><%=rs.getString("tag_line")%></td>
				<td><%=rs.getString("accessories")%></td>
			</tr>
			<%} %>
		</tbody>
			
	
		
</body>
</html>