/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter2;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
 

public class HelloMongo{
   public static void main( String args[] ){
      try{   
		 // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("test");
		  System.out.println("Connect to database successfully ");
 
      }catch(Exception e){
	     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	  }
   }
}