


<%@page import="java.sql.*" %>

<%

try{
	
	  Connection con = null;
      PreparedStatement pst = null;
	
	
	String roll=request.getParameter("rollNo");
	Class.forName("com.mysql.cj.jdbc.Driver");
	String dbURL = "jdbc:mysql://localhost:3306/idal";
    String dbUsername = "root";  // Use secure handling for credentials
    String dbPassword = "W7301@jqir#";
    con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
    		
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("SELECT *FROM onereg INNER JOIN onemarks ON onereg.roll = onemarks.roll WHERE onereg.roll='"+roll+"'");
    	
    if(rs.next())
    {
    	
    
    
    
    
    




%>














<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Marksheet</title>
    <style>
       

        body {
            background: linear-gradient(to right, #25c481, #25b7c4);
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        /* Header Styles */
        .header-img {
            width: 150px;
            height: 150px;
        }
         
        .header {
            text-align: center;
            border-bottom: 2px solid #1a237e;
            padding-bottom: 20px;
            margin-bottom: 20px;
        }
   

        /* Table Styles */
        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 15px;
            border: 2px solid #726E6D;
            text-align: center;
        }

        thead {
            background: #625D5D;
            color: white;
            text-transform: uppercase;
        }

        tbody tr:nth-child(odd) {
            background: #D1D0CE;
        }

        .footer {
            background-color: #625D5D;
            color: white;
            font-weight: bold;
        }

        .print-btn img {
            width: 30px;
            height: 30px;
            cursor: pointer;
        }

        hr.new1 {
            border: 1px solid #726E6D;
            margin: 20px 0;
        }

        h6 {
            font-size: 14px;
            color: #333;
        }
    </style>
</head>

<body>
    <!-- Header Section -->
    <div class="header">
        <h1 class="school-name">ABC Higher Secondary School</h1>
        <p>Annual Examination 2023-24</p>
        <h2>Academic Marksheet</h2>
    </div>

    <!-- Marksheet Table -->
    <div class="tbl-header">
        <table>
            <thead>
                <tr>
                    <th>Institution Name: DGI</th>
                    <th>Course Name: B.Tech</th>
                    <th>Branch Name: Computer Science</th>
                    <th>Roll No: <%=rs.getString(1) %></th>
                </tr>
                <tr>
                    <th>Name: <%=rs.getString(2) %></th>
                    <th>Father Name:<%=rs.getString(3) %></th>
                    <th>Gender: <%=rs.getString(6) %></th>
                    <th class="print-btn" onclick="window.print();">
                        <img src="print.png" alt="Print">
                    </th>
                </tr>
            </thead>

            <thead>
                <tr>
                    <th>Course Code</th>
                    <th colspan="2">Course Name</th>
                    <th>Type</th>
                    <th>Full Marks</th>
                    <th>Passing Marks</th>
                    <th>Obtained Marks</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>NAS101</td>
                    <td colspan="2">HINDI</td>
                    <td>Theory</td>
                    <td>100</td>
                    <td>30</td>
                    <td><%=rs.getString(11) %></td>
                </tr>
                <tr>
                    <td>NAS102</td>
                    <td colspan="2">ENGLISH</td>
                    <td>Theory</td>
                    <td>100</td>
                    <td>30</td>
                    <td><%=rs.getString(12) %></td>
                </tr>
                <tr>
                    <td>NAS103</td>
                    <td colspan="2">Mathematics</td>
                    <td>Theory</td>
                    <td>100</td>
                    <td>30</td>
                    <td><%=rs.getString(13) %></td>
                </tr>
                <tr>
                    <td>NEE101</td>
                    <td colspan="2">SOCIAL SCIENCE</td>
                    <td>Theory</td>
                    <td>100</td>
                    <td>30</td>
                    <td><%=rs.getString(14) %></td>
                </tr>
                <tr>
                    <td>NEC101</td>
                    <td colspan="2">SCIENCE</td>
                    <td>Theory</td>
                    <td>100</td>
                    <td>30</td>
                    <td><%=rs.getString(15) %></td>
                </tr>
                
            </tbody>

            <!-- Footer Section -->
            <tfoot>
                <tr class="footer">
                    <td colspan="4">Total Marks</td>
                    <td>500</td>
                    <td>150</td>
                    <td><%int sum=rs.getInt(11)+rs.getInt(12)+rs.getInt(13)+rs.getInt(14)+rs.getInt(15); out.println(sum); %></td>
                </tr>
                <tr class="footer">
                    <td colspan="4">Percentage</td>
                    <td colspan="3"><%out.println((sum*100)/500); %></td>
                </tr>
            </tfoot>
        </table>
    </div>

    <hr class="new1">

    <!-- Footer Notes -->
    <h6>Note: Institution doesn't own responsibility for any errors or omissions in this statement.</h6>
    <h6>Designed & Developed by WebService Team</h6>
    <hr class="new1">
    <h6>All Rights Reserved @ WebService:: 2024-2025</h6>
    <hr class="new1">
</body>
</html>

<%}
    else{
    	response.sendRedirect("index.html");
    }
}catch(Exception e)
{
	
}
    %>
