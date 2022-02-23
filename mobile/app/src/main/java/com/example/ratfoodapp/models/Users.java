package com.example.ratfoodapp.models;

public class Users {

    int age;
    String username,firstname,name,id;

    public void userModels(String _id, int age, String username, String firstname,String name){
        this.id = _id;
        this.age = age;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
    }

    public String getUsername(){
        return this.id;
    }
}
