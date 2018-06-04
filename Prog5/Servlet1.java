import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File.*;
/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		Double salary = Double.parseDouble(request.getParameter("salary"));
		Double deduction = Double.parseDouble(request.getParameter("deduction"));
		Double it = salary*20/100;
		it = it - (it*deduction/100);
		response.getWriter().append("Name : "+name).append("\nGender :"+gender).append("\nSalary :"+salary).append("\nDeduction :"+deduction).append("\nIncome tax :"+it);
		PrintWriter pw = new PrintWriter("C:/Users/Sony/eclipse-workspace/ITFiling/details.txt", "UTF-8");
		pw.println("Name :"+name);
		pw.println("Gender :"+gender);
		pw.println("Salary :"+salary);
		pw.println("Deduction :"+deduction);
		pw.println("Income tax :"+it);
		String path = new File("details.txt").getAbsolutePath();
		System.out.println(path);
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
