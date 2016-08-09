/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packtpub.mongo.chapter4.ws;

import com.packtpub.mongo.chapter4.bean.Book;
import com.packtpub.mongo.chapter4.controller.BookStore;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bookstore")
public class BookService {

	@Inject
	BookStore bookstore;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> query() {
		 
		return bookstore.query();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response buyBook(Book b) {
		
		Book book = bookstore.checkAvailability(b);
		
		if (book == null) {
			return Response.ok("Book not found sorry!").build();
		}
		
		if (book.getCopies() > 0) {
			bookstore.buy(book);
			return Response.ok("Book purchased!").build();
		}
		else {
			return Response.ok("No more copies available sorry!").build();
		}
	 
	   
	}
 
}