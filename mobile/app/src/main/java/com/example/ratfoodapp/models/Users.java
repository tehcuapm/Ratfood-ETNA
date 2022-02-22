package com.example.ratfoodapp.models;

public class Users {

    int id,age;
    String username,firstname,name;

    public void userModel(int id, int age, String username, String firstname,String name){
        this.id = id;
        this.age = age;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
    }

    public String getUsername(){
        return this.username;
    }
}
