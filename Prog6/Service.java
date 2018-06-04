import java.util.ArrayList;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Service
 */
@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement stmt;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Service() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String[] acc = request.getParameterValues("acc");
		
		String a="";
		for(int i=0;i<acc.length;i++) {
			a = a+"-"+(String)acc[i];
	
		}
		
		System.out.println(a);
		String tagline=request.getParameter("tag-line");
		String cpoc = request.getParameter("cpocket");
		String colour = request.getParameter("colour");
		int ono=99;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			if(con!=null) {
				System.out.println("Connection Successful");
				String q1 = "SELECT * FROM tshirt;";
				PreparedStatement ps = con.prepareStatement(q1);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ono = rs.getInt("order_num");
				}
				String query = "INSERT INTO tshirt values ("+(ono+1)+",'"+colour+"','"+cpoc+"','"+tagline+"','"+a+"');" ;
				System.out.println(query);
				stmt=(Statement)con.createStatement();
				int r=stmt.executeUpdate(query);
			}
			
		}
		catch(SQLException | ClassNotFoundException ex) {
			System.out.println("Error :"+ ex);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
