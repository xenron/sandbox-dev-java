/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.adapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.packtpub.mongo.chapter3.adapter.Customer;

public class CustomAdapter implements JsonDeserializer<Customer> {

    public Customer deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jObj = json.getAsJsonObject();
        
         
        String id = jObj.get("_id").toString().replaceAll(".*\"(\\w+)\"}", "$1");
 
        String name = jObj.get("name") != null ? jObj.get("name").getAsString() : "";
        String email = jObj.get("email")!= null ? jObj.get("email").getAsString() : "";
        String phone = jObj.get("phone")!= null ? jObj.get("phone").getAsString() : "";
        int age = jObj.get("age")!= null ? jObj.get("age").getAsInt() : 0;
 
 
        return new Customer(id,name,age,email,phone);
    }	 
}
