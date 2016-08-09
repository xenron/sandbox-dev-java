/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter2;

 

import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 

public class InsertMongo {
	public static void main(String args[]) {
		try {
			 
			MongoClient mongoClient = new MongoClient("localhost", 28017);
			 
			MongoDatabase db = mongoClient.getDatabase("sampledb");
			MongoCollection<Document> coll = db.getCollection("users");

			Document doc = new Document("name", "john").append("age", 25)	.append("phone", "321-654-987");
			coll.insertOne(doc);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}