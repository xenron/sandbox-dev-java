package com.packtpub.mongo.chapter4.controller;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import com.packtpub.mongo.chapter4.bean.Book;

@Model
public class BookStore  {

    @Inject
    MongoClient mongoClient;

    List<Book> listBooks;

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    String filter;

    @PostConstruct
    private void init() {
        doQuery();
    }

    public void doQuery() {
        listBooks = query();
    }

    public List<Book> query() {
        Gson gson = new Gson();

        DB db = mongoClient.getDB("javaee7");

        DBCollection coll = db.getCollection("bookstore");
        DBCursor cursor = null;
        if (filter == null || filter.trim().length() == 0) {
            cursor = coll.find();
        } else {
            BasicDBObject q = new BasicDBObject();
            q.put("title", java.util.regex.Pattern.compile(filter));
            cursor = coll.find(q);
        }

        List<Book> list = new ArrayList();
        try {
            while (cursor.hasNext()) {
                DBObject obj = cursor.next();

                list.add(gson.fromJson(obj.toString(), Book.class));

            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public void buy(Book book) {

        Gson gson = new Gson();

        int copiesLeft = book.getCopies() - 1;
        DB db = mongoClient.getDB("javaee7");

        DBCollection coll = db.getCollection("bookstore");

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set",
                new BasicDBObject().append("copies", copiesLeft));

        DBObject searchQuery = (DBObject) JSON.parse(gson.toJson(book));
        coll.update(searchQuery, newDocument);

        listBooks = query();

    }

    public Book checkAvailability(Book book) {
        Gson gson = new Gson();

        DB db = mongoClient.getDB("javaee7");

        DBCollection coll = db.getCollection("bookstore");

        BasicDBObject query = new BasicDBObject("title", book.getTitle());
        query.append("author", book.getAuthor());

        DBObject obj = coll.findOne(query);

        if (obj == null) {
            return null;
        }

        return gson.fromJson(obj.toString(), Book.class);

    }
}
