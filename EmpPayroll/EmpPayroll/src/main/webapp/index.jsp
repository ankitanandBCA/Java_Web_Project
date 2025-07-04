<%@ page language="java" %>
<html>
<head>
    <title>Employee Payroll</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        
        .container {
            background-color: white;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            width: 90%;
            max-width: 500px;
        }
        
        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 1.5rem;
        }
        
        form {
            display: flex;
            flex-direction: column;
            gap: 1rem;
        }
        
        .input-group {
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
        }
        
        label {
            color: #34495e;
            font-weight: 500;
        }
        
        input[type="text"] {
            padding: 0.8rem;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1rem;
            transition: border-color 0.3s ease;
        }
        
        input[type="text"]:focus {
            outline: none;
            border-color: #3498db;
        }
        
        input[type="submit"] {
            background-color: #3498db;
            color: white;
            padding: 0.8rem;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        
        input[type="submit"]:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Enter Employee ID to Generate Payroll</h2>
        <form action="result.jsp" method="post">
            <div class="input-group">
                <label for="empId">Employee ID:</label>
                <input type="text" id="empId" name="empId" required />
            </div>
            <input type="submit" value="Generate Payroll" />
        </form>
    </div>
</body>
</html>
