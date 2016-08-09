/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.template;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository
public class BookDAOImpl  implements BookDAO {

    @Autowired
    private MongoOperations mongoOps;
    private static final String BOOK_COLLECTION = "Book";

    public BookDAOImpl(MongoOperations mongoOps) {
        this.mongoOps = mongoOps;
    }

    public BookDAOImpl() {

    }

    public void dropCollectionIfExist() {
        
        if (mongoOps.collectionExists(BOOK_COLLECTION)) {
            mongoOps.dropCollection(BOOK_COLLECTION);
            System.out.println("dropped collection");
        }
    }

  
    public void insert(Book p) {
        this.mongoOps.insert(p, BOOK_COLLECTION);
    }

    public void insertAll(Book[] books) {
        mongoOps.insert(Arrays.asList(books), BOOK_COLLECTION);
    }

   
    public Book findByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        return this.mongoOps.findOne(query, Book.class, BOOK_COLLECTION);

    }

 
    public void update(Book p) {
        this.mongoOps.save(p, BOOK_COLLECTION);
    }

    
    public int deleteByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        WriteResult result = this.mongoOps.remove(query, Book.class, BOOK_COLLECTION);
        return result.getN();
    }

}

