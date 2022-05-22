<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<h1>Registration</h1>
<form ACTION="registration" method="post">
<p>
    Enter your username or email : <input type="text" name="regUsername" placeholder="Username/Email">
    <br>
    Enter your password : <input type="password" name="regPass" placeholder="Password">
    <br>
    Please, confirm password : <input type="password" name="regPassConfirm" placeholder="Repeat password">
    <br>
    Enter your name : <input type="text" name="name" placeholder="Name">
    <br>
    Enter your surname : <input type="text" name="surname" placeholder="Surname">
    <br>
    Enter Your Profession : <input type="text" name="profession" placeholder="Profession">
    <br>
    <input type="submit" value="Register">
    <input type="hidden" value="${error}" name="error">
    <input type="hidden" value="${error1}" name="error1">
    ${error}
    ${error1}
    ${error2}

</p>
</form>
</body>
</html>
