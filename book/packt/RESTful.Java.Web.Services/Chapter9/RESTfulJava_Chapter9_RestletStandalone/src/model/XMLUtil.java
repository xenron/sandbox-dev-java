package model;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLUtil {
	private XMLUtil() {
	}

	private static Document getDocument(String xml) {
		try {
			// Create a builder factory
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			
			return factory.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			return null;
		} catch (ParserConfigurationException e) {
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	private static boolean validateUserXML(Document doc) {
		NodeList nodeList = null;
		
		// Check the elements and values exist
		nodeList = doc.getElementsByTagName("user");
		if (nodeList.getLength() != 1) {
			return false;
		}

		// Check that email element exists
		nodeList = doc.getElementsByTagName("username");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that value is not null or empty
		String username = getValue((Element) doc.getElementsByTagName("user").item(0), "username");
		if (username == null || username.isEmpty()) {
			return false;
		}

		// Check that email element exists
		nodeList = doc.getElementsByTagName("password");
		if (nodeList.getLength() != 1) {
			return false;
		}

		// Check that value is not null or empty
		String password = getValue((Element) doc.getElementsByTagName("user").item(0), "password");
		if (password == null || password.isEmpty()) {
			return false;
		}

		return true;
	}
	
	private static String getValue(Element ele, String tagName) {
		String value = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			value = el.getFirstChild().getNodeValue();
		}

		return value;
	}

	private static boolean validateMessageXML(Document doc, String xml) {
		NodeList nodeList = null;
		
		// Check the elements and values exist
		nodeList = doc.getElementsByTagName("message");
		if (nodeList.getLength() != 1) {
			return false;
		}

		// Check that email element exists
		nodeList = doc.getElementsByTagName("content");
		if (nodeList.getLength() != 1) {
			return false;
		}
		
		// Check that value is not null or empty
		String content = getValue((Element) doc.getElementsByTagName("message").item(0), "content");
		if (content == null || content.isEmpty()) {
			return false;
		}

		// Validate that user is part of the message XML
		return validateUserXML(doc);
	}

	public static UserVO getUserVOFromXML(String xml) {
		Document doc = getDocument(xml);
		if (doc != null) {
			if(validateUserXML(doc)) {
				// XML is valid, just get the values from the DOM
				return new UserVO(getValue((Element) doc.getElementsByTagName("user").item(0), "username"), getValue((Element) doc.getElementsByTagName("user").item(0), "password"));
			}
		
		}		

		return null;
	}

	public static MessageVO getMessageVOFromXML(String xml) {
		Document doc = getDocument(xml);
		if (doc != null) {
			if (validateMessageXML(doc, xml)) {
				// XML is valid, just get the values from the DOM
				UserVO userVO = new UserVO(getValue((Element) doc.getElementsByTagName("user").item(0), "username"), getValue((Element) doc.getElementsByTagName("user").item(0), "password"));
				return new MessageVO(getValue((Element) doc.getElementsByTagName("message").item(0), "content"), userVO);
			}
		}

		return null;
	}
}
