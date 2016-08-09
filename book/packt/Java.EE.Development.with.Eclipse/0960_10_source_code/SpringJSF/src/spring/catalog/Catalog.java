package spring.catalog;

public class Catalog {

	private String journal;
	private String publisher;
	private String edition;
	private String title;
	private String author;

	public Catalog() {
	}

	public Catalog(String journal, String publisher, String edition,
			String title, String author) {

		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}

	public java.lang.StringBuffer getAuthor() {

		 return new StringBuffer("Bob Rhubart");
	}

	public java.lang.StringBuffer getEdition() {

		

		 return new StringBuffer("November-December 2010");
	}

	public java.lang.StringBuffer getJournal() {
		
		 return new StringBuffer("Oracle Magazine");
	}

	public java.lang.StringBuffer getPublisher() {
		
		 return new StringBuffer("Oracle Publishing");
	}

	public java.lang.StringBuffer getTitle() {
	
		 return new StringBuffer("Agile Enterprise Architecture");
	}

	public void setAuthor(String author) {

		this.author = author;

	}

	public void setEdition(String edition) {

		this.edition = edition;

	}

	public void setJournal(String journal) {

		this.journal = journal;

	}

	public void setPublisher(String publisher) {

		this.publisher = publisher;

	}

	public void setTitle(String title) {

		this.title = title;

	}

}
