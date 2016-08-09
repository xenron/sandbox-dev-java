 
package com.packtpub.mongo.chapter4.bean;

public class Book {
 
	String title;
	String author;
	String type;
	int price;
	int copies;

	public Book() { }

	public Book(String title, String author, String type, int price) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.price = price;
		this.copies = 10;
	}
 
// Getter and Setters omitted for brevity

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}