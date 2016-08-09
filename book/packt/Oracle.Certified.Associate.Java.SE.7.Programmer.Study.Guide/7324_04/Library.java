package packt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    private ArrayList<Book> books = new ArrayList<Book>();

    public Book getBook(int index) {
        return new Book(books.get(index));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List getBooks() {
        ArrayList list = new ArrayList(books.size());
        for(Book book : books) {
            list.add(new Book(book));
        }
        return list;
    }
}

