<%--
  Created by IntelliJ IDEA.
  User: lolo
  Date: 23/02/2023
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../style/loginStyle.css">
  <title>Login</title>
</head>
<body>
<main>
  <div class="videoDiv">
    <video class="backgroundVideo" loop autoplay muted>
      <source src="../videos/background.mp4" type="video/mp4">
    </video>
  </div>
  <form action="/Login" method="post">
    <div class="mainContent mainContentLogin">
      <div class="inputsField inputsFieldLogin">
        <div class="LoginInputDiv mailInputDiv">
          <span class="text textUsername">Email : </span><input class="input inputUsername" type="email" id="inputUsername" name="username" placeholder="Email/Username"required>
        </div>
        <div class="LoginInputDiv passwordInputDiv">
          <span class="text textPassword">Password : </span><input class="input inputPassword" type="password" name="password" id="inputPassword" placeholder="Password" required>
        </div>
      </div>
      <div class="checkMarkDiv">
        <input type="checkbox" id="keepLoggedIn" name="keepLoggedIn" value="keep">
        <label for="keepLoggedIn">Keep me Logged in</label>
      </div>
      <div class="loginDiv">
        <input type="submit" value="login" id="LoginBtn">
      </div>
      <link href="../sounds/Error%20sound%20effect.mp3">
      <p>${error}</p>
      <div class="notificationDiv">
        <p>Don't have one? <a href="../../Registration/html/index.jsp">Create here</a></p>
      </div>
    </div>
  </form>
</main>
<script src="../app/app.js"></script>
</body>
</html>