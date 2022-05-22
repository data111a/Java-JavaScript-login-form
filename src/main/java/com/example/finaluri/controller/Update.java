package com.example.finaluri.controller;

import com.example.finaluri.model.SQLConnection;
import com.example.finaluri.model.User;
import com.example.finaluri.model.userDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uptName");
        String surname = req.getParameter("uptSurname");
        String username = req.getParameter("uptUsername");
        String password = req.getParameter("uptPass");
        String profession = req.getParameter("uptProfession");
        String oldUsername = req.getParameter("username");
        String passConf = req.getParameter("uptPassConfirm");
        String error = "check passwords";
        String extName = req.getParameter("userName");
        String extSurname = req.getParameter("surname");
        String error2 = "user already exist";
        String error1 = "enter your information";
        System.out.println(oldUsername);
        SQLConnection con = new SQLConnection();
        if (name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()){
            req.setAttribute("error",  error1);
            req.setAttribute("username", oldUsername);
            req.setAttribute("userName", extName);
            req.setAttribute("surname", extSurname);
            getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);

        }

       if(password.equals(passConf)){
           User user = new User(name,surname,password,profession,username);
           if (name.isEmpty() || surname.isEmpty() || password.isEmpty() || username.isEmpty()) {
               req.setAttribute("username", oldUsername);
               req.setAttribute("userName", extName);
               req.setAttribute("surname", extSurname);
               req.setAttribute("error", error1);
               getServletContext().getRequestDispatcher("/Registration.jsp").forward(req, resp);
           }else{
               try {
                   userDatabase upt = new userDatabase(con);
                   if(upt.Update(user,passConf,oldUsername)){
                       req.setAttribute("username", user.getUserName());
                       req.setAttribute("userName", name);
                       req.setAttribute("surname", surname);
                       getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
                   }else{
                       req.setAttribute("username", oldUsername);
                       req.setAttribute("userName", extName);
                       req.setAttribute("surname", extSurname);
                       req.setAttribute("error",error2);
                       getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);

                   }
               } catch (SQLException | ClassNotFoundException e) {
                   throw new RuntimeException(e);
               }
           }
       }else{
           req.setAttribute("username", oldUsername);
           req.setAttribute("userName", extName);
           req.setAttribute("surname", extSurname);
           req.setAttribute("error",error);
           getServletContext().getRequestDispatcher("/welcome.jsp").forward(req, resp);
       }
    }

}

