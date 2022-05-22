package com.example.finaluri.model;



public class User {
    private String userName;
    private String name;
    private String surName;
    private String password;
    private String profession;


    public User(){
    }
    public User(String name, String surName, String password, String profession,String userName){
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.profession = profession;
        this.userName = userName;
    }
    public User(String name, String surName, String password, String profession){
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.profession = profession;
    }

    public User(String name, String surName, String password){
        this.name = name;
        this.surName = surName;
        this.password = password;
    }
    public User(String name, String surName){
        this.name = name;
        this.surName = surName;
    }
    public User(String name){
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
}
