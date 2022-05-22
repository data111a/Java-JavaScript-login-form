package com.example.finaluri.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDatabase {

    SQLConnection con;

    public userDatabase(SQLConnection con) {
        this.con = con;
    }

    public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
        boolean set = false;
        if (user != null) {
            try {

                String query = "insert into project0 (name,surname,username,password,profession) values(?,?,?,?,?)";
                System.out.println("user database connected to mysql");
                PreparedStatement pt = con.getConnection().prepareStatement(query);
                pt.setString(1, user.getName());
                pt.setString(2, user.getSurName());
                pt.setString(4, user.getPassword());
                pt.setString(3, user.getUserName());
                pt.setString(5, user.getProfession());
                pt.executeUpdate();
                set = true;
                System.out.println("u added user");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return set;

    }

    public User login(String email, String pass) {
        User usr = null;
        try {
            String query = "select * from project0 where username=? and password=?";
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usr = new User();
                usr.setProfession(rs.getString("profession"));
                usr.setName(rs.getString("name"));
                usr.setUserName(rs.getString("username"));
                usr.setPassword(rs.getString("password"));
                usr.setSurName(rs.getString("surname"));
                System.out.println("logged in");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usr;

    }

    public boolean Update(User user, String passwordConf, String oldUsername) throws SQLException, ClassNotFoundException {
    boolean set = false;
    if (user != null){
        try {
            String query = "update project0 \n" +
                    "set project0.name = '" + user.getName() + " ',\n" +
                    "project0.surname = '" + user.getSurName() + "',\n" +
                    "project0.password = '" + user.getPassword() + "',\n" +
                    "project0.profession = '" + user.getProfession() + "',\n" +
                    "project0.username = '" + user.getUserName() + "'\n" +
                    "where username = '" + oldUsername + "'";
            PreparedStatement pt = con.getConnection().prepareStatement(query);
            System.out.println("setted all values");
            pt.executeUpdate();
            set = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
        return set;
    }

}

