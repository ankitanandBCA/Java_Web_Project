<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View RoomBooking Details</title>
     <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav>
        <div class="logo">
            <img src="images/logo.png" alt="">
            <h1>Hotel Royal Palace</h1>
        </div>
        
    </nav>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Number</th>
            <th>Room Type</th>
            <th>Price Per Night</th>
            <th>Check-in Date</th>
            <th>Check-out Date</th>
            <th>Total Nights</th>
            <th>Total Guests</th>
            <th>Total Price</th>
        </tr>
    </thead>
    <tbody>
        <%
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_Project_full_stack", "root", "W7301@jqir#");
            String sql = "SELECT * FROM RoomBooking";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) { 
        %>
            <tr>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("number") %></td>
                <td><%= rs.getString("roomtype") %></td>
                <td><%= rs.getString("price_per_night") %></td>
                <td><%= rs.getString("checkindate") %></td>
                <td><%= rs.getString("chekoutdate") %></td>
                <td><%= rs.getString("total_night") %></td>
                <td><%= rs.getString("guest") %></td>
                <td><%= rs.getString("total_price") %></td>
            </tr>
        <%
            }
        } catch (Exception e) {
            out.print("<tr><td colspan='10' class='text-danger'>Error: " + e.getMessage() + "</td></tr>");
        } finally {
            if (rs != null) try { rs.close(); } catch (Exception e) {}
            if (pst != null) try { pst.close(); } catch (Exception e) {}
            if (con != null) try { con.close(); } catch (Exception e) {}
        }
        %>
    </tbody>
</table>

<br>
<br>
<br>
<br>
<br>
<br>
 <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>Contact Us</h3>
                <p>Phone: +91 1234567890</p>
                <p>Email: info@hotelroyalpalace.com</p>
            </div>
            <div class="footer-section">
                <h3>Address</h3>
                <p>123, Main Road, City - 123456</p>
            </div>
            <div class="footer-section">
                <h3>Social Media</h3>
                <div class="social-links">
                    <a href="#">Facebook</a>
                    <a href="#">Instagram</a>
                    <a href="#">Twitter</a>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>
