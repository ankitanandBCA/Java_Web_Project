package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserLogin() {
        super();
    }

    /**
     * Handles POST request for user login
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
       

        // Get user inputs
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");

            // Query to check user credentials
            String query = "SELECT * FROM userRegister WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // User authenticated, create session
               // HttpSession session = request.getSession();
               // session.setAttribute("username", rs.getString("username"));
            	System.out.println("login successfully.....");
                response.sendRedirect("roomBook.html");
            } else {
                // Invalid login
               System.out.println("invalid details...");
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
