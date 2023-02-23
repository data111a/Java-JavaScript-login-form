package com.example.finaluri.controller;

import com.example.finaluri.model.SQLConnection;
import com.example.finaluri.model.User;
import com.example.finaluri.model.userDatabase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/Login")
public class Login extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mail = req.getParameter("username");
        String password = req.getParameter("password");
        SQLConnection con = new SQLConnection();
        userDatabase db =  new userDatabase(con);
        User user = db.login(mail,password);
        System.out.println("data");
        String error = "incorrect username or password";
        if(user!=null) {
            req.setAttribute("username", user.getUserName());
            req.setAttribute("userName", user.getName());
            req.setAttribute("surname", user.getSurName());
            System.out.println(user.getUserName());
            getServletContext().getRequestDispatcher("../../../../../webapp/Welcome/html/index.jsp").forward(req, resp);
//        }
        }else{
            req.setAttribute("error",error);
            getServletContext().getRequestDispatcher("../../../../../webapp/Login/html/Login.jsp").forward(req, resp);
        }


    }
}
