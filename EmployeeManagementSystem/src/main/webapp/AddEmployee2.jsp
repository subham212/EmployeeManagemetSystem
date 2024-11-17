<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Registration Form</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
  /* Reset some basic styling */
* {
    margin: auto;
    padding: 0;
    box-sizing: border-box;
}

/* Body styling */
body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #6a11cb, #2575fc); /* Gradient background */
    padding: 20px;
    height: 100vh; /* Full height for the gradient */
    display: flex;
    justify-content: center;
    align-items: center;
}

/* Main container styling */
.container {
    width: 60%;
    max-width: 800px; /* Maximum width for larger screens */
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
    opacity: 0; /* Start with opacity 0 for animation */
    transform: translateY(20px); /* Start slightly lower for animation */
    animation: fadeIn 0.5s forwards; /* Animation for fade-in effect */
}

/* Fade-in animation */
@keyframes fadeIn {
    to {
        opacity: 1;
        transform: translateY(0);
    }
}

/* Heading */
h1 {
    text-align: center;
    margin-bottom: 20px;
}

/* Fieldset styling */
fieldset {
    border: 2px solid #ddd;
    padding: 20px;
    margin-bottom: 20px;
    border-radius: 8px;
}

legend {
    font-weight: bold;
    font-size: 1.2em;
    padding: 0 10px;
}

/* Label styling */
label {
    display: block;
    margin: 10px 0 5px;
    font-size: 1em;
}

/* Input field styling */
input[type="text"],
input[type="email"],
input[type="tel"],
input[type="date"],
input[type="number"],
textarea,
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 1em;
    transition: border-color 0.3s; /* Smooth border color transition */
}

input[type="text"]:focus,
input[type="email"]:focus,
input[type="tel"]:focus,
input[type="date"]:focus,
input[type="number"]:focus,
textarea:focus,
select:focus {
    border-color: #4CAF50; /* Change border color on focus */
}

/* Button styling */
button {
    width: 100%;
    padding: 15px;
    background-color: #4CAF50;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 1.2em;
    cursor: pointer;
    transition: background-color 0.3s; /* Smooth background color transition */
}

button:hover {
    background-color: #45a049;
}

/* Responsive styling */
@media (max-width: 768px) {
    .container {
        width: 90%;
    }
}

</style>
<body>

<div class="container">
    <h1>Employee Registration Form</h1>
   <form action="<%= request.getContextPath()%>/employee" method="post">

        <!-- Personal Information -->
        <fieldset>
            <legend>Personal Information</legend>
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname" required>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>

            <label>Gender:</label>
            <div class="gender-options">
                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label>
                
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label>
                
                <input type="radio" id="other" name="gender" value="other">
                <label for="other">Other</label>
            </div>
            
            <label for="address">Home Address:</label>
            <textarea id="address" name="address" rows="4" required></textarea>

            <label for="phone">Phone Number:</label>
            <input type="tel" id="phone" name="phone" required>

            <label for="email">Email Address:</label>
            <input type="email" id="email" name="email" required>
        </fieldset>

        <!-- Employment Details -->
        <fieldset>
            <legend>Employment Details</legend>
            <label for="position">Position:</label>
            <input type="text" id="position" name="position" required>

            <label for="date-of-joining">Date of Joining:</label>
            <input type="date" id="date-of-joining" name="date-of-joining" required>

            <label for="employment-type">Employment Type:</label>
            <select id="employment-type" name="employment-type">
                <option value="full-time">Full-time</option>
                <option value="part-time">Part-time</option>
                <option value="contract">Contract</option>
                <option value="temporary">Temporary</option>
            </select>
        </fieldset>

        <!-- Bank Details -->
        <fieldset>
            <legend>Bank Details</legend>
            <label for="bank-name">Bank Name:</label>
            <input type="text" id="bank-name" name="bank-name" required>

            <label for="account-number">Account Number:</label>
            <input type="number" id="account-number" name="account-number" required>
        </fieldset>

        <!-- Emergency Contact -->
        <fieldset>
            <legend>Emergency Contact</legend>
            <label for="emergency-name">Full Name:</label>
            <input type="text" id="emergency-name" name="emergency-name" required>

            <label for="emergency-phone">Phone Number:</label>
            <input type="tel" id="emergency-phone" name="emergency-phone" required>

            <label for="relationship">Relationship:</label>
            <input type="text" id="relationship" name="relationship" required>
        </fieldset>

        <!-- Declaration -->
        <fieldset>
            <label for="declaration">I confirm the details provided are correct.</label>
            <input type="checkbox" id="declaration" name="declaration" required> Yes
        </fieldset>

        <button type="submit">Submit</button>
    </form>
</div>

</body>
</html>