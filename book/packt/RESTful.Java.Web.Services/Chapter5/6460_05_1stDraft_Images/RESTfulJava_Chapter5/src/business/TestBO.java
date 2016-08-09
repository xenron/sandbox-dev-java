package business;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;
import exception.ItemNotFoundException;
import exception.UserNotFoundException;

public class TestBO {
	public static void main(String[] args) throws InvalidXMLException, ItemAlreadyExistsException, ItemNotFoundException, UserNotFoundException {
		String userXML = "<user><username>felix</username><password>felix</password></user>";		
		UserBO.create(userXML);
	
		/*
//		userXML = "<user><username>jose2</username><password>jose2</password></user>";
		// UserBO.create(userXML);	
		
//		System.out.println(UserBO.getXML("jose2"));
//		System.out.println(UserBO.getJSON("jose2"));
//		
		System.out.println(UserBO.getAllXML());
		System.out.println(UserBO.getAllJSON());
//		
		//UserBO.delete("jose2");
		System.out.println(UserBO.getXML("jose2"));
//		
		String messageXML = "<message>"
			+ "<messageID></messageID>"
			+ "<content>someting</content>"
			+ "<link></link>"
			+ "<user>"
			+ "<username>felix</username>"
			+ "<password>felix</password>"
			+ "<link></link>"
			+ "</user>"
			+ "</message>";
		MessageBO.create(messageXML);
		
		System.out.println("----------------");
		System.out.println(MessageBO.getAllXML());
		System.out.println("----------------");
		System.out.println("----------------");
		System.out.println(MessageBO.getAllJSON());
		System.out.println("----------------");
		
		// System.out.println(MessageBO.getAllXMLForUser("sando"));
		System.out.println(MessageBO.getAllXMLForUser("felix"));
		System.out.println(MessageBO.getAllJSONForUser("felix"));
		System.out.println("----------------");
		System.out.println("----------------");		
		System.out.println(MessageBO.searchAllXML("someting"));
		*/
	}
}
