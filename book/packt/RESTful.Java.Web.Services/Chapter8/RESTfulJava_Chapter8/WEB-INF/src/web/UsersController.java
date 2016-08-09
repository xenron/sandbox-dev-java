package web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import business.UserBO;

import com.opensymphony.xwork2.ModelDriven;

import exception.InvalidXMLException;
import exception.ItemAlreadyExistsException;
import exception.ItemNotFoundException;

@Results( { @Result(name = "success", type = "redirectAction") })
public class UsersController implements ModelDriven<Object>, ServletRequestAware {
	private String username;
	private String representation;
	private HttpServletRequest request;

	// GET /users
	public HttpHeaders index() {
		// Get Accept header here...
		String acceptHeader = request.getHeader("Accept");
		String type = "xml";
		if (acceptHeader == null || acceptHeader.isEmpty() || acceptHeader.equals("application/xml")) {
			representation = UserBO.getAllXML();
		} else if (acceptHeader.equals("application/json")) {
			representation = UserBO.getAllJSON();
			type = "json";
		}

		return new DefaultHttpHeaders(type).disableCaching();
	}

	// GET /users/{username} 
	public HttpHeaders show() {
		String acceptHeader = request.getHeader("Accept");
		String type = "xml";
		if (acceptHeader == null || acceptHeader.isEmpty() || acceptHeader.equals("application/xml")) {
			representation = UserBO.getXML(username);
		} else if (acceptHeader.equals("application/json")) {
			representation = UserBO.getJSON(username);
			type = "json";
		}

		return new DefaultHttpHeaders(type).disableCaching();
	}

	// POST /users
	public HttpHeaders create() {
		try {
			representation = UserBO.create(CommonUtil.convertInputStreamToString(request.getInputStream()));
		} catch (InvalidXMLException e) {
			throw new RuntimeException("Invalid XML.");
		} catch (ItemAlreadyExistsException e) {
			throw new RuntimeException("Item Exists.");

		} catch (IOException e) {
			throw new RuntimeException("Error reading input stream.");
		}

		return new DefaultHttpHeaders("xml").disableCaching();
	}

	// PUT /users/{username}
	public HttpHeaders update() {
		// If we needed the id, we would get here...
		try {
			representation = UserBO.update(CommonUtil.convertInputStreamToString(request.getInputStream()));
		} catch (InvalidXMLException e) {
			throw new RuntimeException("Invalid XML.");
		} catch (ItemNotFoundException e) {
			throw new RuntimeException("Username not found.");
		} catch (IOException e) {
			throw new RuntimeException("Error reading input stream.");
		}

		return new DefaultHttpHeaders("xml").disableCaching();
	}

	// DELETE /users/{username} 
	public HttpHeaders destroy() {
		try {
			UserBO.delete(username);
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
		this.username = id;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
