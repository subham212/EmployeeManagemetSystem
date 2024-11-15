<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Salary Added Successfully</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(135deg, #f6d365 0%, #fda085 100%);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        h1 {
            margin-bottom: 30px;
            font-size: 24px;
            color: #333;
        }
        .button {
            display: inline-block;
            background: #007bff;
            color: #fff;
            padding: 15px 30px;
            margin: 10px;
            text-decoration: none;
            font-size: 16px;
            border-radius: 8px;
            transition: background 0.3s ease;
        }
        .button:hover {
            background: #0056b3;
        }
        p a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        p a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Salary Added Successfully</h1>
        <p><a href="AddSalary.jsp" class="button">Add Another Salary</a></p>
        <p><a href="index.jsp" class="button">Go to the index page</a></p>
    </div>
</body>
</html>