/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.index;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
 
import com.mongodb.MongoClient;

public class MainTextIndex {

    public static void main(String args[]) {
        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("textitems");

            coll.createIndex(new BasicDBObject("content", "text"));

            coll.insert(new BasicDBObject().append("content", "mytext other content"));

            BasicDBObject search = new BasicDBObject("$search", "mytext");

            BasicDBObject textSearch = new BasicDBObject("$text", search);

            int count = coll.find(textSearch).count();
            System.out.println("Found text search matches: " + count);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
