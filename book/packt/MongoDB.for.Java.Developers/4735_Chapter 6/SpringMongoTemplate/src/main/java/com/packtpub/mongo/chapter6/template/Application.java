/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

@SpringBootApplication
public class Application implements CommandLineRunner {

 
    @Autowired
    BookDAO bookDAO;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        bookDAO.dropCollectionIfExist();
        Book b = new Book("A Tale Of Two Cities", "Charles Dickens", "Novel", 10);

        bookDAO.insert(b);

        Book[] books = new Book[]{
            new Book("The Da Vinci Code", "Dan Brown", "thriller", 12),
            new Book("Think and Grow Rich", "Napoleon Hill", "Motivational", 10),
            new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8),
            new Book("Le Petit Prince", "Antoine de Saint-Exupery","Novel", 8)
        };

        bookDAO.insertAll(books);

        Book b1 = bookDAO.findByTitle("The Hobbit");
        System.out.println("Retrieved Book:" + b1);
        b1.setPrice(6);

        bookDAO.update(b1);
        Book b2 = bookDAO.findByTitle("The Hobbit");
        System.out.println("Retrieved Book after update:" + b2);

        int count = bookDAO.deleteByTitle("Think and Grow Rich");
        System.out.println("Number of records deleted:" + count);
    
    }

}
