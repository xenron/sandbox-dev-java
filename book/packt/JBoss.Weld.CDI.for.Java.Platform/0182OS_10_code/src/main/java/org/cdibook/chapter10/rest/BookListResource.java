package org.cdibook.chapter10.rest;

import org.cdibook.chapter9.model.Book;
import org.cdibook.chapter9.service.BookService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/books")
public class BookListResource {

    @Inject
    BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAvailableBooks() {
        List<Book> results = bookService.getAvailableBooks();
        Collections.sort(results, new BookTitleSorter());
        return results;
    }

    @GET
    @Path("/{categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAvailableBooksByCategory(@PathParam("categoryId") long categoryId) {
        Map<String, String> params = new HashMap<>();
        params.put("available", "true");
        params.put("categoryId", Long.toString(categoryId));
        List<Book> results = bookService.getAll(params);
        Collections.sort(results, new BookTitleSorter());
        return results;
    }

    class BookTitleSorter implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Book book1 = (Book) o1;
            Book book2 = (Book) o2;

            return book1.getTitle().compareTo(book2.getTitle());
        }
    }
}
