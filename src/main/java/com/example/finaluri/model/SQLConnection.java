package com.example.finaluri.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {
    private static Connection connection = null;
    private String message = "connected to sql";
    String driver = "com.mysql.cj.jdbc.Driver";
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(driver);
            String password = "Just4Freedom.";
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(message);
        }
        return connection;
    }


}

