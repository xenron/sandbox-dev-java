package org.cdibook.chapter10.rest;

import org.cdibook.chapter9.model.Category;
import org.cdibook.chapter9.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categories")
public class CategoryResource {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return bookService.getCategories();
    }
}