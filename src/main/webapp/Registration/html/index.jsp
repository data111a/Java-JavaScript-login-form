<%--
  Created by IntelliJ IDEA.
  User: lolo
  Date: 24/02/2023
  Time: 02:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../style/RegistrationStyle.css">
  <title>Registration</title>
</head>
<body>
<main>
  <div class="videoDiv">
    <video class="backgroundVideo" loop autoplay muted>
      <source src="../videos/background.mp4" type="video/mp4">
    </video>
  </div>
  <form action="/registration" method="post">
    <div class="mainContent mainContentRegistration">
      <div class="inputsField registerInputField">
        <div class="RegistrationInputDiv mailInput">
          <span>Enter Email : </span> <input type="email"  class="input inputReq inputEmail" name="regUsername" placeholder="Example@mail.com *" required>
        </div>
        <div class="passwordInputs">
          <div class="RegistrationInputDiv passwordInputFirst">
            <span>Enter Password : </span><input type="password" class="input inputPassword" name="regPass" placeholder="Password *" required>
          </div>
          <p class="passwordError"></p>
          <div class="passwordConfirmDiv">
            <div class="RegistrationInputDiv confirmPasswordInput">
              <span>Confirm Password :</span> <input type="password" name="regPassConfirm" class="input inputPasswordConfirm" placeholder="Repeat password *" required>
            </div>
            <p class="passwordConfirmError"></p>
          </div>
        </div>
        <div class="RegistrationInputDiv nameInput">
          <span>Enter Name :</span> <input type="text" name="name" class="input inputName" placeholder="Name *" required>
        </div>
        <div class="RegistrationInputDiv surnameInput">
          <span>Enter Surname : </span><input type="text" name="surname" class="input inputSurname" placeholder="Surname *" required>
        </div>
        <div class="RegistrationInputDiv proffesionInput">
          <span>Enter Profession : </span><input type="text" name="profession" class="input inputProffesion" placeholder="Profession (optional)">
        </div>
      </div>
      <div class="registrationDiv">
        <input type="submit" value="Register" class="registerBtn">
      </div>
      <div class="notificationDiv">
        <p>Already have one? <a href="../../Login/html/Login.jsp">Login here</a></p>
      </div>
    </div>
  </form>

</main>

<script src="../app/app.js"></script>
</body>
</html>
