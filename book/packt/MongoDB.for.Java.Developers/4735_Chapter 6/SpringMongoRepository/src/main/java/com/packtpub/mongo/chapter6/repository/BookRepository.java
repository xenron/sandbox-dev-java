/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.repository;

 
 
import java.util.List;
 

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
 
 
@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRepository extends MongoRepository<Book, String> {

    public Book findByTitle(@Param("title") String title);
    public List<Book> findByType(@Param("type") String type);
    public List<Book> findByAuthor(@Param("author") String author);

}