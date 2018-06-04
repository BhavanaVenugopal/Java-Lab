import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class flight
 */
@WebServlet("/flight")
public class flight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public flight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement stmt;
		String query;
		String data;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			if(con!=null) {
				System.out.println("Connection successful");
				query="SELECT * FROM flight";
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				PrintWriter out = response.getWriter();
				out.println("Flight Details :");
				while(rs.next()) {
					out.println("Flight Number :"+rs.getString("flight_no"));
					out.println("Airline Name :"+rs.getString("airline_name"));
					out.println("Weekdays :"+rs.getString("weekdays"));
					out.println("_____________________________________________________________");
				}	
			}
			else {
				System.out.println("Unsuccessfull");
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
