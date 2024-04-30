<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image: url('background-image.jpg');
	/* Replace 'background-image.jpg' with the path to your background image */
	background-size: cover;
	/* This ensures the background image covers the entire body */
	background-repeat: no-repeat;
	/* Prevent the background image from repeating */
	background-position: center; /* Center the background image */
	padding: 0;
	margin: 0;
}

.container {
	width: 50%; /* Adjusted width to make the form larger */
	margin: auto;
	padding: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	/* Added a semi-transparent white background */
	border-radius: 10px; /* Increased border radius for a softer look */
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
	/* Added a larger shadow for depth */
}

h2 {
	text-align: center; /* Centered the heading */
	margin-bottom: 20px; /* Added some space below the heading */
}

label {
	font-weight: bold;
	margin-bottom: 5px; /* Added space between labels */
}

input[type="text"], input[type="password"] {
	width: calc(100% - 20px); /* Adjusted input width */
	padding: 10px;
	margin: 5px 0 20px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin-top: 10px; /* Adjusted margin */
	border: none;
	border-radius: 5px;
	cursor: pointer;
	width: 100%;
	display: block; /* Ensures the button takes full width */
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Update Student</h2>
		<form action="UpdateServlet" method="post">
			<label for="studentName">Student Name:</label> <input type="text"
				id="studentName" name="studentName" value="${param.studentName}"
				required><br> <label for="fatherName">Father's
				Name:</label> <input type="text" id="fatherName" name="fatherName"
				value="${param.fatherName}" required><br> <label
				for="motherName">Mother's Name:</label> <input type="text"
				id="motherName" name="motherName" value="${param.motherName}"
				required><br> <label for="studentGroup">Group:</label>
			<input type="text" id="studentGroup" name="studentGroup"
				value="${param.studentGroup}" required><br> <label
				for="studentSection">Section:</label> <input type="text"
				id="studentSection" name="studentSection"
				value="${param.studentSection}" required><br> <label
				for="studentPhoneNumber">Phone Number:</label> <input type="text"
				id="studentPhoneNumber" name="studentPhoneNumber"
				value="${param.studentPhoneNumber}" required><br> <label
				for="parentPhoneNumber">Parent's Phone Number:</label> <input
				type="text" id="parentPhoneNumber" name="parentPhoneNumber"
				value="${param.parentPhoneNumber}" required><br> <label
				for="email">Email:</label> <input type="text" id="email"
				name="email" value="${param.email}" required><br> <label
				for="username">Username:</label> <input type="text" id="username"
				name="username" value="${param.username}" required><br>
			<label for="password">Password:</label> <input type="password"
				id="password" name="password" value="${param.password}" required><br>
			<input type="submit" value="Update">
		</form>
	</div>
</body>
</html>
