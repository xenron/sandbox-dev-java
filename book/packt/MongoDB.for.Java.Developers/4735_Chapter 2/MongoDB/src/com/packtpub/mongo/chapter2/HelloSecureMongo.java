/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter2;

import java.util.Arrays;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class HelloSecureMongo{

    private final static String HOST = "localhost";
 
	public static void main( String args[] ){
	   try{   
       
			
		 MongoCredential credential = MongoCredential.createCredential("administrator", "admin", "mypassword".toCharArray());
			 
		 MongoClient mongoClient = new MongoClient(new ServerAddress(HOST), Arrays.asList(credential));

		 DB db = mongoClient.getDB( "test" );

		 System.out.println("Connect to secure database successfully");
      }catch(Exception e){
		     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		  }
	   }
}