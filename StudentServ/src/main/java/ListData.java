

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

import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Servlet implementation class ListData
 */
public class ListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, IOException { 
     // TODO Auto-generated method stub
     response.setContentType("text/html"); 
     PrintWriter out = response.getWriter(); 
     try{ 
     Class.forName("com.mysql.jdbc.Driver"); 
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","manya"); 
     
     PreparedStatement ps=con.prepareStatement("select * from mark"); 
     out.print("<table width=50% border=1>"); 
     out.print("<caption>Result:</caption>"); 
     
     ResultSet rs=ps.executeQuery(); 
     /* Printing column names */ 
     java.sql.ResultSetMetaData rsmd=rs.getMetaData(); 
     int total=rsmd.getColumnCount(); 
     out.print("<!DOCTYPE html>");
     out.print("<html>");
     out.print("<head>");
     out.print("<meta charset=\"ISO-8859-1\">");
     out.print("<title>Student Data</title>");
     out.print("<style>");
     out.print("    body {");
     out.print("        font-family: Arial, sans-serif;");
     out.print("        background-image: url('https://media.istockphoto.com/id/1278507736/vector/vector-frame-back-to-school-with-education-doodle-icon-symbols-on-green-chalkboard-eps10.jpg?s=612x612&w=0&k=20&c=tJfcltxqhsRJnl5ig7tMpM7UhrFJyu_Rg-J52Hv0Mis='); ");
     out.print("        background-size: cover;");
     out.print("        background-repeat: no-repeat;");
     out.print("        text-align: center;");
     out.print("        color: #fff;");
     out.print("    }");
     out.print("    .container {");
     out.print("        background-color: rgba(0, 0, 0, 0.6);");
     out.print("        padding: 20px;");
     out.print("        border-radius: 10px;");
     out.print("        display: inline-block;");
     out.print("        margin-top: 50px;");
     out.print("    }");
     out.print("    table {");
     out.print("        margin: 0 auto;");
     out.print("        border-collapse: collapse;");
     out.print("        width: 80%;");
     out.print("        background-color: #fff;");
     out.print("        color: #000;");
     out.print("    }");
     out.print("    caption {");
     out.print("        font-size: 1.5em;");
     out.print("        margin-bottom: 10px;");
     out.print("    }");
     out.print("    th, td {");
     out.print("        padding: 10px;");
     out.print("        text-align: center;");
     out.print("        border: 1px solid #ddd;");
     out.print("    }");
     out.print("    th {");
     out.print("        background-color: #4CAF50;");
     out.print("        color: white;");
     out.print("    }");
     out.print("    tr:nth-child(even) {");
     out.print("        background-color: #f2f2f2;");
     out.print("    }");
     out.print("    tr:nth-child(odd) {");
     out.print("        background-color: #ffffff;");
     out.print("    }");
     out.print("    tr:hover {");
     out.print("        background-color: #ddd;");
     out.print("    }");
     out.print("</style>");
     out.print("</head>");
     out.print("<body>");
     out.print("<div class=\"container\">");
     out.print("<h1>Student Data</h1>");
     out.print("<table>");


     // Get the result set metadata
     ResultSet rs1 = ps.executeQuery();
     java.sql.ResultSetMetaData rsmd1 = rs1.getMetaData();
     int total1 = rsmd1.getColumnCount();

     // Print column names
     out.print("<tr>");
     for (int i = 1; i <= total1; i++) {
         out.print("<th>" + rsmd1.getColumnName(i) + "</th>");
     }
     out.print("<th>Status</th></tr>");

     // Print result rows
     while (rs1.next()) {
         out.print("<tr>");
         for (int i = 1; i <= total1; i++) {
             out.print("<td>" + rs1.getObject(i) + "</td>");
         }
         
         // Calculate and print the status
         boolean isPass = true;
         for (int i = 4; i <= 11; i++) {
             if (rs1.getInt(i) < 40) {
                 isPass = false;
                 break;
             }
         }
         out.print("<td>" + (isPass ? "Pass" : "Fail") + "</td></tr>");
     }

     out.print("</table>");
     out.print("</div>");
     out.print("</body>");
     out.print("</html>");

     }catch (Exception e2) {e2.printStackTrace();} 
     
     } 
     } 
