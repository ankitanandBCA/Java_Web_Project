package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminloginServlet
 */
@WebServlet("/adminloginServlet")
public class adminloginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public adminloginServlet() {
        // Default constructor
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    	
    	String email=request.getParameter("email");
    	String pass=request.getParameter("password");
    	 Connection con = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
    	
    	try {
    		
    	        
    	       
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");
    	            String sql = "SELECT * FROM admin WHERE email = ? AND password = ?";
    	            pst = con.prepareStatement(sql);
    	            pst.setString(1,email);
    	            pst.setString(2, pass);
    	            rs = pst.executeQuery();
    	            if (rs.next()) {
    	                // User authenticated, create session
    	               // HttpSession session = request.getSession();
    	               // session.setAttribute("username", rs.getString("username"));
    	            	System.out.println("login successfully.....");
    	                response.sendRedirect("admin.jsp");
    	            } else {
    	                // Invalid login
    	               System.out.println("invalid details...");
    	            }
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }
}
