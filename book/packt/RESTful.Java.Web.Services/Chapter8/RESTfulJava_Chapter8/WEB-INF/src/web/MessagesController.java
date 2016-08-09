package web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import business.MessageBO;

import com.opensymphony.xwork2.ModelDriven;

import exception.InvalidXMLException;
import exception.ItemNotFoundException;
import exception.UserNotFoundException;

@Results( { @Result(name = "success", type = "redirectAction") })
public class MessagesController implements ModelDriven<Object>, ServletRequestAware {
	private String id;
	private String representation;
	private HttpServletRequest request;

	// GET /messages
	public HttpHeaders index() {
		String acceptHeader = request.getHeader("Accept");
		String type = "xml";
		if (acceptHeader == null || acceptHeader.isEmpty() || acceptHeader.equals("application/xml")) {
			representation = MessageBO.getAllXML();
		} else if (acceptHeader.equals("application/json")) {
			representation = MessageBO.getAllJSON();
			type = "json";
		}

		return new DefaultHttpHeaders(type).disableCaching();
	}

	// GET /messages/{messageID}
	public HttpHeaders show() {
		String acceptHeader = request.getHeader("Accept");
		String type = "xml";
		if (acceptHeader == null || acceptHeader.isEmpty() || acceptHeader.equals("application/xml")) {
			representation = MessageBO.getXML(id);
		} else if (acceptHeader.equals("application/json")) {
			representation = MessageBO.getJSON(id);
			type = "json";
		}

		return new DefaultHttpHeaders(type).disableCaching();
	}

	// POST /messages
	public HttpHeaders create() {
		try {
			representation = MessageBO.create(CommonUtil.convertInputStreamToString(request.getInputStream()));
		} catch (InvalidXMLException e) {
			throw new RuntimeException("Invalid XML.");
		} catch (UserNotFoundException e) {
			throw new RuntimeException("User not found.");
		} catch (IOException e) {
			throw new RuntimeException("Error reading input stream.");
		}

		return new DefaultHttpHeaders("xml").disableCaching();
	}

	// DELETE /messages/{id}
	public HttpHeaders destroy() {
		try {
			MessageBO.delete(id);
		} catch (ItemNotFoundException e) {
			throw new RuntimeException("Username not found.");
		}

		return null;
	}

	public String getRepresentation() {
		return representation;
	}

	public Object getModel() {
		return representation;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
