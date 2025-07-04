<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <style>
    *{
      background-color:rgba(255, 99, 71, 1);
    }
    
    body {
    margin-top: 200px; /* Corrected 'margintop' to 'margin-top' */
    display: flex;
    justify-content: center; /* Centers content horizontally */
    align-items: center; /* Centers content vertically */
   /* Ensures full viewport height */
}

    
        .user-count-box {
            border: 2px solid #4CAF50;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            background-color:rgba(255, 99, 71, 1);
            box-shadow: rgba(0, 0, 0, 0.25) 0px 54px 55px, rgba(0, 0, 0, 0.12) 0px -12px 30px, rgba(0, 0, 0, 0.12) 0px 4px 6px, rgba(0, 0, 0, 0.17) 0px 12px 13px, rgba(0, 0, 0, 0.09) 0px -3px 5px;;
            width: 250px;
            height: 250px;
            margin: 20px auto;
            font-size: 24px;
            color: white;
        }
    </style>
</head>
<body>
    <div class="user-count-box">
        <h1>Total Users Registered:</h1>
        <%
            int userCount = 0;
            try {
                // Load JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");

                // SQL Query to get user count
                String query = "SELECT COUNT(*) FROM userRegister";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    userCount = rs.getInt(1);
                }

                // Close Resources
                rs.close();
                pstmt.close();
                con.close();

            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }

            out.println(userCount);
        %>
    </div>
    
    
    
    
    
     <div class="user-count-box">
        <h1>Total Booking:</h1>
        <%
            int totalbooking = 0;
            try {
                // Load JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish Connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");

                // SQL Query to get user count
                String query = "SELECT COUNT(*) FROM RoomBooking";
                PreparedStatement pstmt = con.prepareStatement(query);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    userCount = rs.getInt(1);
                }

                // Close Resources
                rs.close();
                pstmt.close();
                con.close();

            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }

            out.println(userCount);
        %>
    </div>
    
    
      <div class="user-count-box">
        <h1>Chek Booking Details:</h1>
        <a href="AdminViewBookDetails.jsp">Click Here</a>

       

       
    </div>
    
    
    
    
    
    
    
    
    
    
   
    
</body>