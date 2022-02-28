package com.example.ratfoodapp.models;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {

     int age;
     String username,firstname,name,_id;

    public Users (String _id, int age, String username, String firstname,String name){
        this._id = _id;
        this.age = age;
        this.username = username;
        this.name = name;
        this.firstname = firstname;
    }


    public String getUsername(){
        return this.username;
    }

    public HashMap<String, String> getUser()
    {
        String ageStr = String.valueOf(this.age);
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("username", this.username);
        map.put("firstname", this.firstname);
        map.put("name", this.name);
        map.put("age", ageStr);
        map.put("id", this._id);

        return map;


    }

    public void putUser (Map<String,String> data){
        this._id = data.get("id");
        this.username = data.get("username");
        this.firstname = data.get("firstname");
        this.name = data.get("name");
        this.age = Integer.parseInt(data.get("age"));
    }


}
