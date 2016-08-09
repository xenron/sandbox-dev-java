package spring.catalog;

public class CatalogAOP {

	private String journal;
	private String publisher;
	private String edition;
	private String title;
	private String author;

	public CatalogAOP() {
	}

	public CatalogAOP(String journal, String publisher, String edition,
			String title, String author) {

		this.journal = journal;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.author = author;
	}

	public String getAuthor() {

		return author;
	}

	public String getEdition() {

		return edition;
	}

	public String getJournal() {

		return journal;
	}

	public String getPublisher() {

		return publisher;
	}

	public String getTitle() {

		return title;
	}

	

	public void setEdition(StringBuffer edition) {
		System.out.println("setEdition method invoked" + edition);
		//edition.insert(0, "Edition: ");

	}

	public void setJournal(StringBuffer journal) {
		System.out.println("setJournal method invoked" + journal);
		//journal.insert(0, "Journal: ");
	}

	public void setPublisher(StringBuffer publisher) {
		System.out.println("setPublisher method invoked" + publisher);
	//	publisher.insert(0, "Publisher: ");
		

	}

	public void setTitle(StringBuffer title) {
		System.out.println("setTitle method invoked" + title);
	//	title.insert(0, "Title: ");
		

	}
	public void setAuthor(StringBuffer author) {
		System.out.println("setAuthor method invoked" + author);
		//author.insert(0, "Author: ");
	}
}
