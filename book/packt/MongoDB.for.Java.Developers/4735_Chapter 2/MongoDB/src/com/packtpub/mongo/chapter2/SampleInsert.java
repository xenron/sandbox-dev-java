/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter2;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class SampleInsert {

    private final static int PORT = 27017;
    private final static String HOST = "localhost";

    public static void main(String args[]) {
        try {

            MongoClient mongoClient = new MongoClient(HOST, PORT);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            DBObject doc = new BasicDBObject("name", "owen")
                    .append("age", 47)
                    .append("email", "owen@mail.com")
                    .append("phone", "111-222-333");

            coll.insert(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
