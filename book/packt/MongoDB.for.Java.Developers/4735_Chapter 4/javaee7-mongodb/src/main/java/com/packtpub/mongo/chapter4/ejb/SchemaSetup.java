package com.packtpub.mongo.chapter4.ejb;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import com.packtpub.mongo.chapter4.bean.Book;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;

@Singleton
@Startup

public class SchemaSetup {

    private static final Logger LOGGER = Logger.getLogger(SchemaSetup.class.getName());
    @Inject
    MongoClient mongoClient;

    @PostConstruct
    public void createSchema() {
        try {
            DB db = mongoClient.getDB("javaee7");

            DBCollection coll = db.getCollection("bookstore");
            coll.drop();
            coll = db.getCollection("bookstore");

            Book[] book = new Book[5];
            book[0] = new Book("A Tale Of Two Cities", "Charles Dickens", "Novel", 10);
            book[1] = new Book("Le Petit Prince", "Antoine de Saint-Exupery", "Novel", 8);
            book[2] = new Book("The Da Vinci Code", "Dan Brown", "thriller", 12);
            book[3] = new Book("Think and Grow Rich", "Napoleon Hill", "Motivational", 10);
            book[4] = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8);
            Gson gson = new Gson();

            for (Book b : book) {
                DBObject obj = (DBObject) JSON.parse(gson.toJson(b));
                coll.insert(obj);
                LOGGER.info("Inserted " + obj);
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
