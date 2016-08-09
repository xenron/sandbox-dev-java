/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.embedded;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


 
public class MainEmbedded {

    public static void main(String args[]) {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // To connect to mongodb server
            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");

            Gson gson = new Gson();

            BasicDBObject doc = new BasicDBObject("name", "owen").append(
                    "info",
                    new BasicDBObject("age", 25).append("email",
                            "owen@gmail.com").append("phone", "321-456-778"));

            coll.insert(doc);

            DBObject obj = coll.findOne(doc);

            CustomerInfo c = gson.fromJson(obj.toString(), CustomerInfo.class);

            System.out.println("Found customer " + c);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
