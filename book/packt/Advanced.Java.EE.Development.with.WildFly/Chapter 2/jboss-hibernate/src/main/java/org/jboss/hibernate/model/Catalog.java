package org.jboss.hibernate.model;

import java.io.Serializable;

public class Catalog implements Serializable {
	/** identifier field */
	private Integer id;
	/** nullable persistent field */
	private String journal;
	/** nullable persistent field */
	private String publisher;
	/** nullable persistent field */
	private String edition;
	/** nullable persistent field */
	private String title;
	/** nullable persistent field */
	private String author;

	/** full constructor */
	public Catalog(String journal, String publisher, String edition,
			String title, String author) {
		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}

	/** default constructor */
	public Catalog() {
	}

public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getEdition() {
		return this.edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	} 
}
