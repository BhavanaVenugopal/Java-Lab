
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class service
 */
@WebServlet("/service")
public class service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		String query = "SELECT * FROM `telephone_directory` WHERE `name`='"+search+"' OR `phonenumber` ="+search+";";
		System.out.println(query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			if(con!=null) {
				System.out.println("Connection Successful");
				Statement stmt = (Statement)con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				if(!rs.next()) {
					System.out.println("No matches found");
				}
				while(rs.next()) {
					response.getWriter().append("Phone number :"+rs.getInt("phonenumber"));
					response.getWriter().append("\nName :"+rs.getString("name"));
					response.getWriter().append("\nAddress :"+rs.getString("address"));
					response.getWriter().append("\nCompany :"+rs.getString("company"));
					response.getWriter().append("\nPin code :"+rs.getString("pincode"));
					
				}
			}
			else {
				System.out.println("Connection unsuccessful");
			}
			
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println("Error :"+e);
		}
		response.getWriter().append("\nServed at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
