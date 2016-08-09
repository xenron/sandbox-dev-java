package spring.catalog;

public class Catalog implements CatalogInterface {

	private String journal;
	private String publisher;
	private String edition;
	private String title;
	private String author;

	
public Catalog(){}
	public Catalog(String journal, String publisher, String edition,
			String title, String author) {

		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() {
		// TODO Auto-generated method stub
		return author;
	}

	public String getEdition() {
		// TODO Auto-generated method stub
		return edition;
	}

	public String getJournal() {
		// TODO Auto-generated method stub
		return journal;
	}

	public String getPublisher() {
		// TODO Auto-generated method stub
		return publisher;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public void setAuthor(String author) {
		// TODO Auto-generated method stub
		this.author = author;

	}

	public void setEdition(String edition) {
		// TODO Auto-generated method stub
		this.edition = edition;

	}

	public void setJournal(String journal) {
		// TODO Auto-generated method stub
		this.journal = journal;

	}

	public void setPublisher(String publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;

	}

	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;

	}

	public String getTestMessage() {
		return "Spring Bean Test";
	}

}

