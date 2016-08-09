/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter3.index;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MainTextIndexLanguage {

    public static void main(String args[]) {
        try {

            MongoClient mongoClient = new MongoClient("localhost", 27017);

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("textitems");

            coll.createIndex(new BasicDBObject("textcontent", "text"));
               
            coll.insert(new BasicDBObject("_id", 0).append("textcontent", "Some data"));
            coll.insert(new BasicDBObject("_id", 1).append("textcontent", "Other data"));
            coll.insert(new BasicDBObject("_id", 2).append("textcontent", "Not important"));

            BasicDBObject search = new BasicDBObject("$search", "data");

 
            DBObject textSearch = new BasicDBObject("$text", search.append("$language", "english"));
            int matchCount = coll.find(textSearch).count();
            System.out.println("Text search matches: " + matchCount);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
