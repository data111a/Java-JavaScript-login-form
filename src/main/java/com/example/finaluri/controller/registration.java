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
        String error = "check passwords";
        String error1 = "enter your information";
        String error2 = "user already exist";
        if (pass.equals(passConfirm)) {
            User user = new User(name, surname, pass, profession, regUsername);
            if (name.isEmpty() || surname.isEmpty() || pass.isEmpty() || regUsername.isEmpty()) {
                request.setAttribute("error1", error1);
                getServletContext().getRequestDispatcher("/Registration.jsp").forward(request, response);

            } else {
                try {
                    userDatabase regUser = new userDatabase(con);
                    if (regUser.saveUser(user)) {
                        request.setAttribute("username", user.getUserName());
                        request.setAttribute("userName", name);
                        request.setAttribute("surname", surname);
                        getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error2", error2);
                        getServletContext().getRequestDispatcher("/Registration.jsp").forward(request, response);
                    }
                } catch (ClassNotFoundException | SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        } else {
            request.setAttribute("error", error);
            getServletContext().getRequestDispatcher("/Registration.jsp").forward(request, response);

        }
    }
}


