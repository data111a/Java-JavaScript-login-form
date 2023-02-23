package com.example.finaluri.controller;

import com.example.finaluri.model.SQLConnection;
import com.example.finaluri.model.User;
import com.example.finaluri.model.userDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class registration extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passConfirm = request.getParameter("regPassConfirm");
        String pass = request.getParameter("regPass");
        String regUsername = request.getParameter("regUsername");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String profession = request.getParameter("profession");
        SQLConnection con = new SQLConnection();
        String error2 = "user already exist";
        User user = new User(name, surname, pass, profession, regUsername);
        try {
            userDatabase regUser = new userDatabase(con);
            if (regUser.saveUser(user)) {
                request.setAttribute("username", user.getUserName());
                request.setAttribute("userName", name);
                request.setAttribute("surname", surname);
                getServletContext().getRequestDispatcher("../../../../../webapp/Welcome/html/index.jsp").forward(request, response);
            } else {
                request.setAttribute("error2", error2);
                getServletContext().getRequestDispatcher("../../../../../webapp/Registration/html/index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}



