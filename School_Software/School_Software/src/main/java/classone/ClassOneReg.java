package classone;

import jakarta.servlet.ServletConfig;
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

@WebServlet("/ClassOneReg")
public class ClassOneReg extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ClassOneReg() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the request character encoding to handle special characters
        request.setCharacterEncoding("UTF-8");

        // Collect form data
        int rollno = Integer.parseInt(request.getParameter("rolls"));
        String studentname = request.getParameter("sname");
        String fathername = request.getParameter("fname");
        String mothername = request.getParameter("mname");
        String DOB = request.getParameter("dob");
        String gender = request.getParameter("op");
        String address = request.getParameter("add");
        String mobnum = request.getParameter("mob");
        String email = request.getParameter("email");

        Connection con = null;
        PreparedStatement pst = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection (Ensure to update this with real credentials)
            String dbURL = "jdbc:mysql://localhost:3306/idal";
            String dbUsername = "root";  // Use secure handling for credentials
            String dbPassword = "W7301@jqir#";
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

            // Create SQL query
            String sql = "INSERT INTO onereg(roll, sname, fname, mname, dob, gender, address, mob, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(sql);

            // Set parameters for the prepared statement
            pst.setInt(1, rollno); // Corrected: rollno should be an int
            pst.setString(2, studentname);
            pst.setString(3, fathername);
            pst.setString(4, mothername);
            pst.setString(5, DOB);
            pst.setString(6, gender);
            pst.setString(7, address);
            pst.setString(8, mobnum);
            pst.setString(9, email);

            // Execute update
            int result = pst.executeUpdate();

            if (result > 0) {
                // Data inserted successfully, redirect to index.html
                response.sendRedirect("index.html");
            } else {
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
