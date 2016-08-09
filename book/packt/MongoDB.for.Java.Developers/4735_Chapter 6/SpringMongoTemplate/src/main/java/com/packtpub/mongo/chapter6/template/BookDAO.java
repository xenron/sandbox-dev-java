/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter6.template;

import org.springframework.stereotype.Repository;

 
public interface BookDAO {
 
    public void insert(Book p);
    public void insertAll(Book[] p); 
    public Book findByTitle(String id);
     
    public void update(Book p);
     
    public int deleteByTitle(String id);
    public void dropCollectionIfExist();
}