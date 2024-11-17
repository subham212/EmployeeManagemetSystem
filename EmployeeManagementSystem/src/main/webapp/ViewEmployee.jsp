<%@ page import="Employee.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Details</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fc;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 100%;
            max-width: 600px;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        table th, table td {
            text-align: left;
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }

        table th {
            background-color: #3498db;
            color: #fff;
            font-weight: bold;
            text-transform: capitalize;
        }

        table td {
            color: #555;
        }

        table tr:last-child td {
            border-bottom: none;
        }

        .no-data {
            text-align: center;
            color: #666;
            font-size: 16px;
            margin: 20px 0;
        }

        @media screen and (max-width: 480px) {
            .container {
                padding: 15px;
            }

            h1 {
                font-size: 20px;
            }

            table th, table td {
                padding: 8px;
                font-size: 14px;
            }
        }
    </style>
</head>
<body>

<%
    Employee employee = (Employee) request.getAttribute("employee");
%>

<div class="container">
    <h1>Employee Details</h1>
    <% if (employee != null) { %>
        <table>
            <tr>
                <th>ID</th>
                <td><%= employee.getId() %></td>
            </tr>
            <tr>
                <th>Full Name</th>
                <td><%= employee.getFullName() %></td>
            </tr>
            <tr>
                <th>Position</th>
                <td><%= employee.getPosition() %></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td><%= employee.getGender() %></td>
            </tr>
            <tr>
                <th>Date of Birth</th>
                <td><%= employee.getDob() %></td>
            </tr>
            <tr>
                <th>Phone</th>
                <td><%= employee.getPhone() %></td>
            </tr>
        </table>
    <% } else { %>
        <p class="no-data">Employee not found.</p>
    <% } %>
</div>

</body>
</html>
