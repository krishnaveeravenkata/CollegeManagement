<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <%= request.getAttribute("username") %>!</h1>
    <p>You have successfully logged in.</p>
    <a href="Login.html">Logout</a>
</body>
</html>
