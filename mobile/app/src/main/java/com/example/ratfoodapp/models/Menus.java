package com.example.ratfoodapp.models;

import java.util.HashMap;

public class Menus {
    float price;
    String name, description, id_rest, _id;

    public Menus (String _id, String name, String description, float price, String id_rest){
        this._id = _id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.id_rest = id_rest;
    }

    public HashMap<String, String> getMenus(){
    String priceStr = String.valueOf(this.price);
    HashMap<String,String> map = new HashMap<>();
    map.put("_id", this._id);
    map.put("name", this.name);
    map.put("description", this.description);
    map.put("price", priceStr);
    map.put("id_rest", this.id_rest);
    return map;
    }
}
