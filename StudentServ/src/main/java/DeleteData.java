

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

/**
 * Servlet implementation class DeleteData
 */
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException { 
	 // TODO Auto-generated method stub
	 response.setContentType("text/html"); 
	 PrintWriter out = response.getWriter(); 
	 try{ 
	 String rno=request.getParameter("rollno"); 
	 int rn=Integer.valueOf(rno); 
	 
	 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","manya"); 
	 
	 PreparedStatement ps=con.prepareStatement("delete from mark where rollno=?"); 
	 ps.setInt(1,rn); 
	 ps.executeUpdate(); 
	 out.println("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Success</title>\r\n"
				+ "<style>\r\n"
				+ "    body {\r\n"
				+ "        font-family: Arial, sans-serif;\r\n"
				+ "        margin: 0;\r\n"
				+ "        padding: 0;\r\n"
				+ "        background-color: #f0f8ff; /* Light blue background color */\r\n"
				+ "        display: flex;\r\n"
				+ "        justify-content: center;\r\n"
				+ "        align-items: center;\r\n"
				+ "        height: 100vh;\r\n"
				+ "    }\r\n"
				+ "    .message-container {\r\n"
				+ "        background-color: #ffffff; /* White background color */\r\n"
				+ "        padding: 50px;\r\n"
				+ "        border-radius: 15px;\r\n"
				+ "        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n"
				+ "        text-align: center;\r\n"
				+ "    }\r\n"
				+ "    .message {\r\n"
				+ "        font-size: 2.5em;\r\n"
				+ "        color: #4CAF50; /* Green text color */\r\n"
				+ "    }\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<div class=\"message-container\">\r\n"
				+ "    <p class=\"message\">Successfully Deleted</p>\r\n"
				+ "</div>\r\n"
				+ "</body>\r\n"
				+ "</html>"); 
	 }catch (Exception e2) {e2.printStackTrace();} 
	 
	 finally{out.close();} 
	 
	 } 

}
