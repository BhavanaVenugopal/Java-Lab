import java.sql.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * Servlet implementation class reserve
 */
@WebServlet("/reserve")
public class reserve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flno = request.getParameter("fno");
		String date = (String)request.getParameter("date");
		String name = request.getParameter("name");
		String pno = request.getParameter("phone");
		Random r = new Random();
		int n = r.nextInt(500);
		String sno = Integer.toString(n);
		//System.out.println(flno+date+name+pno+sno+n);
		Statement stmt;
		String farray[] = new String[10];
		String query;
		int flag=0,i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			if(conn!=null) {
				System.out.println("Successfull");
				stmt=(Statement)conn.createStatement();
				query="INSERT INTO seatreservation values('"+flno+"','"+date+"','"+sno+"','"+name+"','"+pno+"');";
				System.out.println(query);
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM flight;");
				ResultSet r1 = ps.executeQuery();
				while(r1.next()) {
					String f = r1.getString("flight_no");
					farray[i] = f;
					i++;
				}
				for(int j =0;j<farray.length;j++) {
					if(flno.equals(farray[j])){
						flag = 1;
						break;
					}
					else {
						flag = 0;
					}
				}
				if(flag==1) {
					int rs = stmt.executeUpdate(query);
					request.setAttribute("flight_no", flno);
					request.setAttribute("date", date);
					request.setAttribute("seat_no", sno);
					request.setAttribute("customer_name", name);
					request.setAttribute("phone_no", pno);
					request.getRequestDispatcher("viewDetails.jsp").forward(request, response);;
					//response.sendRedirect("viewDetails.jsp");
				}
				else {
					response.getWriter().append("Flight Number Mismatch");
				}
				
			}
			else {
				System.out.println("Unsuccessful");
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error :"+e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
