<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        /* Your CSS styles */
    </style>
</head>
<body>
    <h1>Student Details</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Father's Name</th>
            <th>Mother's Name</th>
            <th>Group</th>
            <th>Section</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Username</th>
            <th>Password</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.studentName}</td>
                <td>${student.fatherName}</td>
                <td>${student.motherName}</td>
                <td>${student.studentGroup}</td>
                <td>${student.studentSection}</td>
                <td>${student.studentPhoneNumber}</td>
                <td>${student.email}</td>
                <td>${student.username}</td>
                <td>${student.password}</td>
            </tr>
        </c:forEach>
    </table>
    <div class="back-button-container">
        <button class="back-button" onclick="goBack()">Back</button>
    </div>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
