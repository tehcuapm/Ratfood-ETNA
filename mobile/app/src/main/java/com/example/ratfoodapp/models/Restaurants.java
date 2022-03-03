package com.example.ratfoodapp.models;

import java.util.HashMap;

public class Restaurants {
    float grade;
    String name,description,localization,phone_number,website,hours,_id;

    public Restaurants (String _id,String name,String description,String localization,String phone_number,String website,String hours,float grade){
        this._id = _id;
        this.name = name;
        this.description = description;
        this.localization = localization;
        this.phone_number = phone_number;
        this.hours = hours;
        this.website = website;
        this.grade = grade;
    }

    public HashMap<String,String> getRestaurant(){
        String gradeStr = String.valueOf(this.grade);
        HashMap<String,String> map = new HashMap<>();
        map.put("_id",this._id);
        map.put("name",this.name);
        map.put("description",this.description);
        map.put("localization",this.localization);
        map.put("phone_number",this.phone_number);
        map.put("hours",this.hours);
        map.put("website",this.website);
        map.put("grade",gradeStr);

        return map;


    }
}
