/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class MainAdapter {

    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // To connect to mongodb server
            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");

            Gson gson = new GsonBuilder().registerTypeAdapter(Customer.class, new CustomAdapter()).create();

            BasicDBObject doc = new BasicDBObject("name", "owen");

            DBObject obj = coll.findOne(doc);

            Customer c = gson.fromJson(obj.toString(), Customer.class);
            System.out.println("Found customer " + c);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
