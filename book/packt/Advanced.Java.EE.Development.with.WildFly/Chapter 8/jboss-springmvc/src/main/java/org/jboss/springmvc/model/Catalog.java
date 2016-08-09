package org.jboss.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;
 
/**
 * The persistent class for the CATALOG database table.
 * 
 */
@Entity
@Table(name = "CATALOG", uniqueConstraints = @UniqueConstraint(columnNames = "ID"))
public class Catalog implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String journal;
        	private String publisher;
        private String edition;
        private String title;
        private String author;
	public Catalog() {
	}
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
