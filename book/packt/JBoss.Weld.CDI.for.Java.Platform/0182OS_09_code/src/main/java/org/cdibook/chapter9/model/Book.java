package org.cdibook.chapter9.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
public class Book extends ParentObject {

    @Column(length = 150, nullable = false)
    @NotNull
    @Size(min = 5, max = 150)
    @Pattern(regexp = "[A-Za-z ]*")
    private String title;

    @Lob
    private String description;

    @Column(name = "isbn", length = 13, nullable = false, unique = true)
    @NotNull
    @Size(min = 9, max = 13)
    @Pattern(regexp = "[0-9]*")
    private String isbnNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date published;

    @Column(length = 150)
    @Size(min = 3, max = 150)
    @Pattern(regexp = "[A-Za-z ]*")
    private String publisher;

    @NotNull
    private BigDecimal price;

    private Boolean available = Boolean.TRUE;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
    )
    private Set<Author> authors = new HashSet<>();

    protected Book() {
    }

    public Book(String title, String description, String isbn, Date published, String publisher, BigDecimal price, Category category) {
        this.title = title;
        this.description = description;
        this.isbnNumber = isbn;
        this.published = published;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        if (null != author && !authors.contains(author)) {
            authors.add(author);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (null == obj || !(obj instanceof Book)) {
            return false;
        }

        if (!super.equals(obj)) {
            return false;
        } else {
            Book book = (Book) obj;

            if (null != title ? !title.equals(book.title) : null != book.title) {
                return false;
            }
            if (null != isbnNumber ? !isbnNumber.equals(book.isbnNumber) : null != book.isbnNumber) {
                return false;
            }
            if (null != published ? !published.equals(book.published) : null != book.published) {
                return false;
            }
            if (null != available ? !available.equals(book.available) : null != book.available) {
                return false;
            }
            if (null != authors ? !authors.equals(book.authors) : null != book.authors) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + (null != title ? title.hashCode() : 0);
        hash = 31 * hash + (null != isbnNumber ? isbnNumber.hashCode() : 0);
        hash = 31 * hash + (null != published ? published.hashCode() : 0);
        hash = 31 * hash + (null != available ? available.hashCode() : 0);
        hash = 31 * hash + (null != authors ? authors.hashCode() : 0);
        return hash;
    }
}
