<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Register Details</title>
     <link rel="stylesheet" href="style.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  
    <style>
    
     * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
         background-color: #f0f2f5;
        }
        .navbar {
            background-color: white;
            padding: 1rem 2rem;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
            position: fixed;
            width: 100%;
            top: 0;
            z-index: 1000;
        }

        .logo-section {
            display: flex;
            align-items: center;
        }

        .school-logo {
            width: 50px;
            height: 50px;
            margin-right: 1rem;
        }

        .school-name {
            font-size: 1.5rem;
            color: #1a73e8;
        }

        .nav-links {
            display: flex;
            gap: 2rem;
        }

        .nav-link {
            text-decoration: none;
            color: #333;
            padding: 0.5rem 1rem;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .nav-link:hover {
            background-color: #e8f0fe;
            color: #1a73e8;
        }

        .main-content {
            margin-top: 100px;
            padding: 2rem;
        }

        .welcome-section {
            text-align: center;
            margin-bottom: 2rem;
        }

        .welcome-section h1 {
            color: #1a73e8;
            margin-bottom: 1rem;
        }

        @media (max-width: 768px) {
            .navbar {
                flex-direction: column;
                padding: 1rem;
            }

            .nav-links {
                margin-top: 1rem;
                flex-wrap: wrap;
                justify-content: center;
                gap: 1rem;
            }

            .main-content {
                margin-top: 150px;
            }
        }
    
    
    </style>
</head>
<body>
<nav>
        
     <nav class="navbar">
        <div class="logo-section">
            
            <span class="school-name">Class 1</span>
        </div>
        <div class="nav-links">
            <a href="class1info.html" class="nav-link">Register</a>
            <a href="view-register.jsp" class="nav-link">View Register</a>
            <a href="upload-marks.html" class="nav-link">Upload Marks</a>
            <a href="view-marks.jsp" class="nav-link">View Marks</a>
        </div>
    </nav>


<br> <br><br><br><br><br>


<table class="table table-striped">
    <thead>
        <tr>
            <th>Roll No</th>
            <th>Hindi</th>
            <th>English</th>
            <th>Math</th>
            <th>Social Science</th>
            <th>Science</th>
           
           
        </tr>
    </thead>
    <tbody>
        <%
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/idal", "root", "W7301@jqir#");
            String sql = "SELECT * FROM onemarks";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) { 
        %>
            <tr>
                <td><%= rs.getString("roll") %></td>
                <td><%= rs.getString("hindi") %></td>
                <td><%= rs.getString("english") %></td>
                <td><%= rs.getString("math") %></td>
                <td><%= rs.getString("social_science") %></td>
                <td><%= rs.getString("science") %></td>
    
               
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
 
</body>
</html>
