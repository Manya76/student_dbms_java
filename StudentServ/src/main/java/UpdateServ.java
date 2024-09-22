

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
 * Servlet implementation class UpdateServ
 */
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException { 
	 // TODO Auto-generated method stub
	 response.setContentType("text/html"); 
	 PrintWriter out = response.getWriter(); 
	 try{ 
	 String rno=request.getParameter("rollno"); 
	 int rn=Integer.valueOf(rno); 
	 
	 Class.forName("com.mysql.cj.jdbc.Driver"); 
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","manya"); 
	 
	 PreparedStatement st=con.prepareStatement("update mark set name=?,section=?,s1=?,s2=?,s3=?,s4=?,s5=?,s6=?,l1=?,l2=? where rollno=?"); 
			st.setString(1, request.getParameter("name")); 
	 st.setString(2, request.getParameter("section")); 
	 st.setInt(3, Integer.valueOf(request.getParameter("s1"))); 
	 st.setInt(4, Integer.valueOf(request.getParameter("s2"))); 
	 st.setInt(5, Integer.valueOf(request.getParameter("s3"))); 
	 st.setInt(6, Integer.valueOf(request.getParameter("s4"))); 
	 st.setInt(7, Integer.valueOf(request.getParameter("s5"))); 
	 st.setInt(8, Integer.valueOf(request.getParameter("s6"))); 
	 st.setInt(9, Integer.valueOf(request.getParameter("l1"))); 
	 st.setInt(10, Integer.valueOf(request.getParameter("l2"))); 
	 st.setInt(11, Integer.valueOf(request.getParameter("rollno"))); 
	 st.executeUpdate(); 
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
				+ "    <p class=\"message\">Successfully Updated</p>\r\n"
				+ "</div>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	 st.close(); 
	 con.close(); 
	 }catch(Exception e){ System.out.println(e);} 
	} 
	}