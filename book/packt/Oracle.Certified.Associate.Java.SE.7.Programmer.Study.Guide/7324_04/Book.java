package packt;

public class Book {

    private String title;
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = new String(title);
        this.author = new String(author);
    }

    public Book(Book book) {
        this(book.title, book.author);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
