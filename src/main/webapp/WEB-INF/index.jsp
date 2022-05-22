<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<br/>
<center>
<form action="Login" method="post">
      Enter your username or email : <input type="text" name="username" placeholder="Username/Email">
    <br>
      Password : <input type="password" name="password" placeholder="Password">
    <input type="submit" value="Login">
    <br>
    ${error}
</form>


    <br>
    <center><a href="Registration.jsp">Register now</a></center>
</center>
</body>
</html>