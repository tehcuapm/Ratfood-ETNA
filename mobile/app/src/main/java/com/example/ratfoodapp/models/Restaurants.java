package com.example.ratfoodapp.models;

import java.util.HashMap;

public class Restaurants {
    float grade;
    String name,description,localisation,phone_number,website,hour,_id, image;

    public Restaurants (String _id,String name,String description,String localization,
                        String phone_number,String website,String hours,float grade,
                        String image){
        this._id = _id;
        this.name = name;
        this.description = description;
        this.localisation = localization;
        this.phone_number = phone_number;
        this.hour = hour;
        this.website = website;
        this.grade = grade;
        this.image = image;

    }

    public HashMap<String,String> getRestaurant(){
        String gradeStr = String.valueOf(this.grade);
        HashMap<String,String> map = new HashMap<>();
        map.put("_id",this._id);
        map.put("name",this.name);
        map.put("description",this.description);
        map.put("localisation",this.localisation);
        map.put("phone_number",this.phone_number);
        map.put("hour",this.hour);
        map.put("image",this.image);
        map.put("website",this.website);
        map.put("grade",gradeStr);

        return map;
    }
}
