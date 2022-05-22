<%--
  Created by IntelliJ IDEA.
  User: KILLGATES
  Date: 5/13/2022
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<center>
<h1>Welcome ${userName} ${surname}</h1>

</center>
<%--UPDATE--%>
<center>
<h2>If you want you can update your data you can do it from here ${userName}</h2>
<br>
<form action="Update" method="post">
    <input type="hidden" value="${userName}" name="userName">
    <input type="hidden" value="${surname}" name="surname">
    <input type="hidden" name="username" value="${username}">
    Enter your username or email : <input type="text" name="uptUsername" placeholder="Username/Email">
    <br>
    Enter your password : <input type="password" name="uptPass" placeholder="Password">
    <br>
    Please, confirm password : <input type="password" name="uptPassConfirm" placeholder="Repeat password">
    <br>
    Enter your name : <input type="text" name="uptName" placeholder="Name">
    <br>
    Enter your surname : <input type="text" name="uptSurname" placeholder="Surname">
    <br>
    Enter Your Profession : <input type="text" name="uptProfession" placeholder="Profession">
    <br>
    ${error}
    <br>
    <input type="submit" value="Update">
</form>
    <form action="logout" method="post">
        <input type="submit" value="Log out">
    </form>
</center>
</body>
</html>
