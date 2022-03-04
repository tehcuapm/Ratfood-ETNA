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

    }
}
