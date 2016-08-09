/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class Main {

    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
            // To connect to mongodb server
            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");

            System.out.println("Collection created successfully");

            Customer c = new Customer("john", 22, "john@gmail.com",
                    "777-666-555");

            Gson gson = new Gson();
            String json = gson.toJson(c);

            DBObject dbObject = (DBObject) JSON.parse(json);

            coll.insert(dbObject);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
