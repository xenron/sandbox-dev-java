package jaxbeclipse;

import javax.xml.bind.*;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Schema;
import org.xml.sax.SAXException;
import java.io.*;
import java.util.List;

public class JAXB2UnMarshaller {

	public void unMarshall(File xmlDocument) {
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("jaxbeclipse");
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(new File("src/catalog.xsd"));
			unMarshaller.setSchema(schema);
			CustomValidationEventHandler validationEventHandler = new CustomValidationEventHandler();
			unMarshaller.setEventHandler(validationEventHandler);

			JAXBElement<CatalogType> catalogElement = (JAXBElement<CatalogType>) unMarshaller
					.unmarshal(xmlDocument);
			CatalogType catalog = catalogElement.getValue();
			System.out.println("Catalog id: " + catalog.getCatalogid());
		
			System.out.println("Journal Title: " + catalog.getTitle());
			System.out.println("Publisher: " + catalog.getPublisher());
			List<JournalType> journalList = catalog.getJournal();
			for (int i = 0; i < journalList.size(); i++) {

				JournalType journal = journalList.get(i);
				System.out.println("Journal Date: " + journal.getDate());
				List<ArticleType> articleList = journal.getArticle();
				for (int j = 0; j < articleList.size(); j++) {
					ArticleType article = articleList.get(j);

					System.out.println("Section: " + article.getSection());
					System.out.println("Title: " + article.getTitle());
					System.out.println("Author: " + article.getAuthor());
				}
			}
		} catch (JAXBException e) {
			System.err.println(e.getMessage());
		} catch (SAXException e) {
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] argv) {
		File xmlDocument = new File("src/jaxbeclipse/catalog.xml");
		JAXB2UnMarshaller jaxbUnmarshaller = new JAXB2UnMarshaller();

		jaxbUnmarshaller.unMarshall(xmlDocument);

	}

	class CustomValidationEventHandler implements ValidationEventHandler {
		public boolean handleEvent(ValidationEvent event) {
			if (event.getSeverity() == ValidationEvent.WARNING) {
				return true;
			}
			if ((event.getSeverity() == ValidationEvent.ERROR)
					|| (event.getSeverity() == ValidationEvent.FATAL_ERROR)) {

				System.err.println("Validation Error:" + event.getMessage());

				ValidationEventLocator locator = event.getLocator();
				System.err.println("at line number:" + locator.getLineNumber());
				System.err.println("Unmarshalling Terminated");
				return false;
			}
			return true;
		}

	} 
}