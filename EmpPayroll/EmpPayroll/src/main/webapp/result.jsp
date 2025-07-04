<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    String empId = request.getParameter("empId");
    String empName = "";
    String empEmail="";
    String empNumber="";
    double basicSalary = 0.0;
    double hra = 0.0;
    double da = 0.0;
    double ta=0.0;
    double pf = 0.0;
    double mic=0.0;
    double esi=0.0;
    double netSalary = 0.0;
    String error = null;

    if (empId == null || empId.trim().isEmpty()) {
        error = "Employee ID is required!";
    } else {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EMS", "root", "W7301@jqir#");

            String query = "SELECT * FROM emp WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                empName = rs.getString("name");
                empEmail=rs.getString("email");
                empNumber=rs.getString("mobile");
                basicSalary = Double.parseDouble(rs.getString("salary")); // converted from varchar
                hra = basicSalary * 0.40;
                da = basicSalary * 0.20;
                ta=basicSalary*0.10;
                pf = basicSalary * 0.12;
                mic=basicSalary*0.10;
                esi=basicSalary*0.15;
                netSalary = basicSalary + hra + da+mic - pf-esi;
            } else {
                error = "Employee not found!";
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            error = "Error: " + e.getMessage();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Payroll Result</title>
    
     <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            background-color: white;
            padding: 2.5rem;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            width: 95%;
            max-width: 1200px;
        }

        .header {
            text-align: center;
            margin-bottom: 2.5rem;
            padding-bottom: 1.5rem;
            border-bottom: 2px solid #eef2f7;
        }

        .company-logo {
            text-align: center;
            margin-bottom: 1.5rem;
        }

        .company-logo h2 {
            color: #2c3e50;
            font-size: 2.2rem;
            font-weight: 600;
            letter-spacing: 2px;
        }

        h1 {
            color: #2c3e50;
            margin-bottom: 0.8rem;
            font-size: 1.8rem;
            font-weight: 600;
        }

        .date {
            color: #7f8c8d;
            font-size: 1rem;
            font-weight: 500;
        }

        .payroll-details {
            background-color: #f8fafc;
            padding: 2rem;
            border-radius: 12px;
            margin-bottom: 2rem;
            border: 1px solid #e2e8f0;
        }

        /* Employee Info in Two Columns */
        .employee-info {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 2rem;
            margin-bottom: 2rem;
            padding: 1.5rem;
            background-color: #f8fafc;
            border-radius: 8px;
            border: 1px solid #e2e8f0;
        }

        .employee-info-item {
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
            padding: 1rem;
            background-color: white;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
        }

        .employee-info-item label {
            color: #718096;
            font-size: 0.9rem;
            font-weight: 500;
        }

        .employee-info-item span {
            color: #2d3748;
            font-size: 1.1rem;
            font-weight: 600;
        }

        /* Salary Sections Side by Side */
        .salary-sections {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 2rem;
            margin-bottom: 2rem;
        }

        .earnings-section {
            background-color: #f0f9ff;
            padding: 1.5rem;
            border-radius: 8px;
            border: 1px solid #e2e8f0;
        }

        .deductions-section {
            background-color: #fff5f5;
            padding: 1.5rem;
            border-radius: 8px;
            border: 1px solid #fed7d7;
        }

        .section-title {
            color: #2d3748;
            font-size: 1.2rem;
            margin-bottom: 1rem;
            padding-bottom: 0.5rem;
            border-bottom: 2px solid #e2e8f0;
        }

        .salary-item {
            display: flex;
            justify-content: space-between;
            padding: 0.8rem 0;
            font-size: 1.1rem;
            color: #4a5568;
        }

        .salary-item span:first-child {
            font-weight: 500;
        }

        .salary-item span:last-child {
            font-family: 'Courier New', monospace;
            font-weight: 600;
        }

        /* Total Section at Bottom */
        .total-section {
            margin-top: 2rem;
            padding: 1.5rem;
            background-color: #edf2f7;
            border-radius: 8px;
            border: 1px solid #e2e8f0;
        }

        .salary-item.total {
            font-size: 1.3rem;
            color: #2c3e50;
            font-weight: 600;
            padding: 1rem;
            background-color: white;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
        }

        .payroll-number {
            text-align: right;
            color: #718096;
            font-size: 0.9rem;
            margin-bottom: 1rem;
        }

        .footer {
            text-align: center;
            margin-top: 2rem;
            padding-top: 1.5rem;
            border-top: 1px solid #e2e8f0;
            color: #718096;
            font-size: 0.9rem;
        }

        /* Print Styles */
        @media print {
            body {
                background: white;
                padding: 0;
            }

            .container {
                box-shadow: none;
                width: 100%;
                max-width: none;
                padding: 1rem;
            }

            .back-button {
                display: none;
            }

            @page {
                size: A4;
                margin: 1cm;
            }
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .employee-info {
                grid-template-columns: 1fr;
                gap: 1rem;
            }

            .salary-sections {
                grid-template-columns: 1fr;
            }

            .container {
                padding: 1.5rem;
            }
        }

        .action-buttons {
            display: flex;
            gap: 1rem;
            margin-top: 2rem;
        }

        .download-button {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            background: linear-gradient(135deg, #4CAF50 0%, #45a049 100%);
            color: white;
            padding: 1rem 2rem;
            text-decoration: none;
            border-radius: 8px;
            transition: all 0.3s ease;
            text-align: center;
            width: 100%;
            font-weight: 500;
            font-size: 1.1rem;
            border: none;
            cursor: pointer;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.11);
        }

        .download-button:hover {
            transform: translateY(-2px);
            box-shadow: 0 7px 14px rgba(50, 50, 93, 0.1);
            background: linear-gradient(135deg, #45a049 0%, #3d8b40 100%);
        }

        .download-button i {
            font-size: 1.2rem;
        }

        .back-button {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            gap: 0.5rem;
            background: linear-gradient(135deg, #3498db 0%, #2980b9 100%);
            color: white;
            padding: 1rem 2rem;
            text-decoration: none;
            border-radius: 8px;
            transition: all 0.3s ease;
            text-align: center;
            width: 100%;
            font-weight: 500;
            font-size: 1.1rem;
            border: none;
            cursor: pointer;
            box-shadow: 0 4px 6px rgba(50, 50, 93, 0.11);
        }

        .back-button:hover {
            transform: translateY(-2px);
            box-shadow: 0 7px 14px rgba(50, 50, 93, 0.1);
            background: linear-gradient(135deg, #2980b9 0%, #2573a7 100%);
        }

        @media print {
            .action-buttons {
                display: none;
            }
        }
    </style>
 
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Employee Payroll System</h1>
        <div class="date"><%= new SimpleDateFormat("MMMM dd, yyyy").format(new Date()) %></div>
    </div>

    <% if (error != null) { %>
        <div class="error">
            <%= error %>
        </div>
    <% } else { %>
        <div class="payroll-details">
            <div class="employee-info">
                <div class="salary-item">
                    <span>Employee ID:</span>
                    <span><%= empId %></span>
                </div>
                <div class="salary-item">
                    <span>Employee Name:</span>
                    <span><%= empName %></span>
                </div>
                <div class="salary-item">
                    <span>Email:</span> <br>
                    <span><%= empEmail %></span>
                </div>
                <div class="salary-item">
                    <span>Number:</span>
                    <span><%= empNumber %></span>
                </div>
            </div>

            <div class="salary-breakdown">
                <div class="salary-item">
                    <span>Basic Salary:</span>
                    <span><%= String.format("%.2f", basicSalary) %></span>
                </div>
                <div class="salary-item">
                    <span>HRA (40%):</span>
                    <span><%= String.format("%.2f", hra) %></span>
                </div>
                <div class="salary-item">
                    <span>DA (20%):</span>
                    <span><%= String.format("%.2f", da) %></span>
                </div>
                
                <div class="salary-item">
                    <span>TA (10%):</span>
                    <span><%= String.format("%.2f", ta) %></span>
                </div>
                
                
                
                <div class="salary-item">
                    <span>MIC (10%):</span>
                    <span><%= String.format("%.2f", mic) %></span>
                </div>
                  <div class="salary-item">
        <span><strong>Total Salary:</strong></span>
        <span><%= String.format("%.2f", (basicSalary + hra + da+ta+mic)) %></span>
    </div>
                
                <h3>Dedaction Amount</h3>
                <div class="salary-item">
                    <span>PF (12%):</span>
                    <span><%= String.format("%.2f", pf) %></span>
                    

                </div>
                <div class="salary-item">
                    <span>ESI (15%):</span>
                    <span><%= String.format("%.2f", esi) %></span>
                </div>
                <div class="salary-item total">
                    <span>Net Salary:</span>
                    <span><%= String.format("%.2f", netSalary) %></span>
                </div>
            </div>
        </div>
    <% } %>

    <a href="index.jsp" class="back-button">Back to Home</a>
    <div class="action-buttons">
    <button class="download-button" onclick="downloadPDF()">
        Download PDF
    </button>
</div>
    
</div>



<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
<script>
function downloadPDF() {
    const element = document.querySelector('.container');
    const actionButtons = document.querySelector('.action-buttons');
    const backButton = document.querySelector('.back-button');

    // Hide buttons before generating PDF
    actionButtons.style.display = 'none';
    backButton.style.display = 'none';

    // Wait a short moment to allow DOM update
    setTimeout(() => {
        html2pdf().set({
            margin:       [0.5, 0.5, 0.5, 0.5],
            filename:     'Payroll_<%= empId %>.pdf',
            image:        { type: 'jpeg', quality: 0.98 },
            html2canvas:  {
                scale: 2,
                useCORS: true,
                allowTaint: false,
                scrollX: 0,
                scrollY: 0,
                windowWidth: document.body.scrollWidth,
                windowHeight: document.body.scrollHeight
            },
            jsPDF: {
                unit: 'in',
                format: 'a4',
                orientation: 'portrait'
            }
        }).from(element).save().then(() => {
            // Show buttons again after PDF is generated
            actionButtons.style.display = 'flex';
            backButton.style.display = 'inline-flex';
        });
    }, 300);
}


</script>


</body>
</html>
