package jaxb;

import javax.xml.bind.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JavaToXML {
	public void marshalXMLDocument(File xmlDocument) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output",
					Boolean.valueOf(true));
			Catalog catalog = new Catalog();
			catalog.setJournal("Oracle Magazine");
			catalog.setPublisher("Oracle Publishing");
			catalog.setEdition("March-April 2008");
			catalog.setTitle("Declarative Data Filtering");
			catalog.setAuthor("Steve Muench");
			marshaller.marshal(catalog, new FileOutputStream(xmlDocument));
		} catch (IOException e) {
			System.err.println(e.toString());
		} catch (PropertyException e) {
			System.err.println(e.toString());
		} catch (JAXBException e) {
			System.err.println(e.toString());
		}
	}

	public static void main(String[] argv) {
		String xmlDocument = "src/catalog.xml";
		JavaToXML javaToXML = new JavaToXML();
		javaToXML.marshalXMLDocument(new File(xmlDocument));
	}
}
