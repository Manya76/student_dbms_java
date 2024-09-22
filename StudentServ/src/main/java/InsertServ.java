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

public class InsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","manya");
			PreparedStatement ps = con.prepareStatement("Insert into mark values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, Integer.valueOf(request.getParameter("rollno")));
			ps.setString(2, request.getParameter("name"));
			ps.setString(3, request.getParameter("section"));
			ps.setInt(4, Integer.valueOf(request.getParameter("s1")));
			ps.setInt(5, Integer.valueOf(request.getParameter("s2")));
			ps.setInt(6, Integer.valueOf(request.getParameter("s3")));
			ps.setInt(7, Integer.valueOf(request.getParameter("s4")));
			ps.setInt(8, Integer.valueOf(request.getParameter("s5")));
			ps.setInt(9, Integer.valueOf(request.getParameter("s6")));
			ps.setInt(10, Integer.valueOf(request.getParameter("l1")));
			ps.setInt(11, Integer.valueOf(request.getParameter("l2")));
			ps.executeUpdate();
			PrintWriter pw = response.getWriter();
			pw.println("<html>\r\n"
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
					+ "    <p class=\"message\">Successfully Inserted</p>\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}