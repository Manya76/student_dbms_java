

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Servlet implementation class DispData
 */
public class DispData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException { 
		response.setContentType("text/html"); 
		 PrintWriter out = response.getWriter(); 
		 try{ 
		 String rno=request.getParameter("rollno"); 
		 int rn=Integer.valueOf(rno); 
		 Class.forName("com.mysql.jdbc.Driver"); 
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","manya"); 
		 PreparedStatement ps=con.prepareStatement("select * from mark where rollno=?"); 
		 ps.setInt(1,rn); 
		 out.print("<!DOCTYPE html>");
		 out.print("<html><head>");
		 out.print("<title>Student Data</title>");
		 out.print("<style>");
		 out.print("body { font-family: Arial, sans-serif; background-color: #f0f8ff; text-align: center; }");
		 out.print("table { margin: 0 auto; border-collapse: collapse; width: 50%; }");
		 out.print("caption { font-size: 1.5em; margin-bottom: 10px; }");
		 out.print("th, td { padding: 10px; text-align: center; border: 1px solid #ddd; }");
		 out.print("th { background-color: #4CAF50; color: white; }");
		 out.print("tr:nth-child(even) { background-color: #f2f2f2; }");
		 out.print("tr:nth-child(odd) { background-color: #ffffff; }");
		 out.print("tr:hover { background-color: #ddd; }");
		 out.print("</style>");
		 out.print("</head><body>");

		 out.print("<h1>Student Data</h1>");
		 out.print("<table>");
		 out.print("<caption>Result:</caption>");

		 // Get the result set metadata
		 ResultSet rs = ps.executeQuery();
		 ResultSetMetaData rsmd = rs.getMetaData();
		 int total = rsmd.getColumnCount();

		 // Print column names
		 out.print("<tr>");
		 for (int i = 1; i <= total; i++) {
		     out.print("<th>" + rsmd.getColumnName(i) + "</th>");
		 }
		 out.print("<th>Status</th></tr>");

		 // Print result rows
		 while (rs.next()) {
		     out.print("<tr>");
		     for (int i = 1; i <= total; i++) {
		         out.print("<td>" + rs.getObject(i) + "</td>");
		     }
		     
		     // Calculate and print the status
		     boolean isPass = true;
		     for (int i = 4; i <= 11; i++) {
		         if (rs.getInt(i) < 40) {
		             isPass = false;
		             break;
		         }
		     }
		     out.print("<td>" + (isPass ? "Pass" : "Fail") + "</td></tr>");
		 }

		 out.print("</table>");
		 out.print("</body></html>");

		}catch (Exception e2) {e2.printStackTrace();} 
		finally{out.close();} 
		
	}

}
