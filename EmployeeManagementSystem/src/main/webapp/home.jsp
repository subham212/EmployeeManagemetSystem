<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management System</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
    <link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            background-color: #f0f2f5;
        }

        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2c3e50;
            padding: 20px;
            color: #ecf0f1;
        }

        .logo {
            font-size: 24px;
            font-weight: 600;
            margin-bottom: 30px;
        }

        .menu-item {
            display: flex;
            align-items: center;
            padding: 10px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .menu-item:hover {
            background-color: #34495e;
        }

        .menu-item i {
            margin-right: 10px;
        }

        .content {
            flex: 1;
            padding: 20px;
        }

        h1 {
            font-size: 28px;
            margin-bottom: 20px;
            color: #2c3e50;
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
        }

        .card {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
        }

        .card i {
            font-size: 48px;
            margin-bottom: 15px;
            color: #3498db;
        }

        .card h2 {
            font-size: 18px;
            margin-bottom: 10px;
            color: #2c3e50;
        }

        .card p {
            font-size: 14px;
            color: #7f8c8d;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <div class="logo">EMS</div>
        <div class="menu-item"><i class='bx bxs-dashboard'></i> Dashboard</div>
        <div class="menu-item"><i class='bx bxs-user-detail'></i> Employees</div>
        <div class="menu-item"><i class='bx bx-money'></i> Payroll</div>
        <div class="menu-item"><i class='bx bx-calendar'></i> Attendance</div>
        <div class="menu-item"><i class='bx bx-cog'></i> Settings</div>
    </div>
    <div class="content">
        <h1>Employee Management System</h1>
        <div class="grid">
            <div class="card">
                <i class='bx bx-user'></i>
                <h2>View Employees</h2>
                <p>Browse and manage employee records</p>
            </div>
            <div class="card">
            <a href="AddEmp.jsp" style="text-decoration: none">
                <i class='bx bx-user-plus'></i>
                <h2>Add Employee</h2>
                <p>Create a new employee profile</p>
            </div>
            <div class="card">
                <i class='bx bx-user-minus'></i>
                <h2>Delete Employee</h2>
                <p>Remove an employee from the system</p>
            </div>
            <div class="card">
                <i class='bx bx-edit'></i>
                <h2>Update Employee</h2>
                <p>Modify existing employee information</p>
            </div>
            <div class="card">
                <a href="manageSalary.jsp" style="text-decoration: none">
                <i class='bx bx-money'></i>
                <h2>Salary Management</h2>
                <p>Set up salary for new employees</p>
            </div>
            <div class="card">
                <a href="attendance.jsp" style="text-decoration: none">
                <i class='bx bx-money'></i>
                <h2>Attendance Management</h2>
                <p>Set up salary for new employees</p>
            </div>
            <div class="card">
                <i class='bx bx-edit'></i>
                <h2>About Us</h2>
                <p>Modify existing employee information</p>
            </div>
        </div>
    </div>
</body>
</html>