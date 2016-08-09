package org.cdibook.chapter10.rest;

import org.cdibook.chapter9.exception.ServiceException;
import org.cdibook.chapter9.model.Book;
import org.cdibook.chapter9.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/book")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Path("/{bookId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getBook(@PathParam("bookId") Long bookId) {
        try {
            return bookService.get(bookId);
        } catch (ServiceException e) {
            return null;
        }
    }
}
