package model;

public class UserVO {
	private String username;
	private String password;

	public UserVO() {
		super();
	}

	public UserVO(String username) {
		this.username = username;
	}
	
	public UserVO(String username, String password) {
		super();
		
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toXML() {
		StringBuilder xml = new StringBuilder();
		xml.append("<user>");
		xml.append("<username>").append(username).append("</username>");
		xml.append("<password>").append(password).append("</password>");
		xml.append("<link>").append(getLink()).append("</link>");
		xml.append("</user>");

		return xml.toString();
	}

	public String toJSON() {
		StringBuilder json = new StringBuilder();
		json.append("{\"user\":{\"username\":\"").append(username).append("\", \"password\":\"").append(password).append("\", \"link\":\"").append(getLink()).append("\"}}");
		
		return json.toString();
	}

	private String getLink() {
		return "/users/" + username;
	}
}
