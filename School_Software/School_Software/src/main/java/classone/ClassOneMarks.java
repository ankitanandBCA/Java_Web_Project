package classone;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class ClassOneMarks
 */
@WebServlet("/ClassOneMarks")
public class ClassOneMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ClassOneMarks() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
    	
    	int roll=Integer.parseInt(request.getParameter("rolls"));
    	int hindi=Integer.parseInt(request.getParameter("hindi"));
    	int english=Integer.parseInt(request.getParameter("eng"));
    	int math=Integer.parseInt(request.getParameter("math"));
    	int social_science=Integer.parseInt(request.getParameter("sst"));
    	int science=Integer.parseInt(request.getParameter("sc"));
    	
    	  Connection con = null;
          PreparedStatement pst = null;
          
          
          try {
        	  Class.forName("com.mysql.cj.jdbc.Driver");

              // Establish the connection (Ensure to update this with real credentials)
              String dbURL = "jdbc:mysql://localhost:3306/idal";
              String dbUsername = "root";  // Use secure handling for credentials
              String dbPassword = "W7301@jqir#";
              con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
              
              String sql="INSERT INTO onemarks(roll,hindi,english,math,social_science,science)VALUES(?,?,?,?,?,?)";
              pst=con.prepareStatement(sql);
              pst.setInt(1, roll);
              pst.setInt(2, hindi);
              pst.setInt(3, english);
              pst.setInt(4, math);
              pst.setInt(5, social_science);
              pst.setInt(6, science);
              
              int result=pst.executeUpdate();
              if(result>0)
              {
            	  response.sendRedirect("index.html");
              }

              else {
                  // Insertion failed, send an error response (or a message on the page)
                  response.getWriter().println("Error: Registration failed.");
              }
          } catch (SQLException | ClassNotFoundException e) {
              // Handle exceptions and provide error details
              e.printStackTrace();
              response.getWriter().println("Error: Unable to process registration.");
          } finally {
              // Ensure resources are released
              try {
                  if (pst != null) {
                      pst.close();
                  }
                  if (con != null) {
                      con.close();
                  }
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
    }
}
