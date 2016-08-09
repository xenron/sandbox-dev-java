/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.repository;

 

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private  BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      
        repository.deleteAll();
        System.out.println("Collection deleted");
 
        repository.save(new  Book("A Tale Of Two Cities", "Charles Dickens","Novel", 10));
        repository.save(new  Book("The Da Vinci Code", "Dan Brown", "thriller", 12));
        repository.save(new  Book("Think and Grow Rich", "Napoleon Hill","Motivational", 10));
        repository.save(new  Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8));
        repository.save(new Book("Le Petit Prince", "Antoine de Saint-Exupery","Novel", 8));
 
        System.out.println("Book found with findAll():");
        System.out.println("-------------------------------");
        for ( Book bstore : repository.findAll()) {
            System.out.println(bstore);
        }
        System.out.println();

     
        System.out.println("Book found with findByTitle('The Da Vinci Code'):");
        System.out.println("--------------------------------");
        Book book1 = repository.findByTitle("The Da Vinci Code");
        book1.setPrice(5);
        // Update Book
        repository.save(book1);
        
        book1 = repository.findByTitle("The Da Vinci Code");
        System.out.println(book1);
        
        // Delete Book
        repository.delete(book1);
        
         System.out.println("Book found with findByType('Novel'):");
         System.out.println("--------------------------------");
         for ( Book book : repository.findByType("Novel")) {
         System.out.println(book);
         }
 
    }

}