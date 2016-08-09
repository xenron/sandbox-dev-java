package model;

import java.util.UUID;

public class MessageVO {
	private String messageID;
	private String content;
	private UserVO userVO;
	
	public MessageVO() {
		super();
		
		this.messageID = UUID.randomUUID().toString();
	}

	public MessageVO(String messageID) {
		super();
		this.messageID = messageID;
	}
	
	public MessageVO(String content, UserVO userVO) {
		super();
		this.content = content;
		this.userVO = userVO;
		
		// Generate a unique id
		this.messageID = UUID.randomUUID().toString();
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public UserVO getUserVO() {
		return userVO;
	}
	
	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	public String toXML() {
		StringBuilder xml = new StringBuilder();
		xml.append("<message>");
		xml.append("<messageID>").append(messageID).append("</messageID>");
		xml.append("<content>").append(content).append("</content>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append(userVO.toXML());
		xml.append("</message>");
		
		return xml.toString();
	}
	
	public String toJSON() {
		StringBuilder json = new StringBuilder();
		
		json.append("{\"message\":{\"messageID\":\"").append(messageID).append("\", \"content\":\"").append(content).append("\", \"link\":\"").append(getLink()).append("\", \"").append(userVO.toJSON()).append("}}");
		
		return json.toString();
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	
	private String getLink() {
		return "/messages/" + messageID;
	}	
}
