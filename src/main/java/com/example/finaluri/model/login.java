package com.example.finaluri.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login {
    SQLConnection con;

    public login (SQLConnection con){
        this.con = con;
    }
    public User logUser(String UserName, String pass){
        User usr = null;
        try {
            String query ="select * from finallproject1 where username=? and password=?";
            PreparedStatement pst = con.getConnection().prepareStatement(query);
            pst.setString(1, UserName);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()){
                query = "select profession from finallproject1 where username = ? ;";
                PreparedStatement getprof = con.getConnection().prepareStatement(query);
                pst.setString(1, UserName);
                ResultSet prof = pst.executeQuery();
                usr.setProfession(getprof.toString());
                System.out.println(usr.getProfession());
                usr = new User();
                usr.setName(rs.getString(2));
                usr.setUserName(rs.getString(3));
                usr.setPassword(rs.getString(4));
                usr.setUserName(rs.getString(5));
                usr.setPassword(rs.getString(6));

                System.out.println(rs.getString(2));
                System.out.println(usr.getSurName());
            }

            query = "select profession from finallproject1 where username = ? ;";
            PreparedStatement getprof = con.getConnection().prepareStatement(query);
            pst.setString(1, UserName);
            ResultSet prof = pst.executeQuery();
            usr.setProfession(getprof.toString());
            System.out.println(usr.getProfession());
//
        } catch (Exception e){
            e.printStackTrace();
        }return usr;

    }

}
