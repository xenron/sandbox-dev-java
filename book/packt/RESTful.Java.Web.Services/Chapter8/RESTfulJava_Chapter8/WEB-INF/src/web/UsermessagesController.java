package web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import business.MessageBO;

import com.opensymphony.xwork2.ModelDriven;

@Results( { @Result(name = "success", type = "redirectAction") })
public class UsermessagesController implements ModelDriven<Object>, ServletRequestAware {
	private String id;
	private String representation;
	private HttpServletRequest request;

	// GET /usermessages/{username}
	public HttpHeaders show() {
		String acceptHeader = request.getHeader("Accept");
		String type = "xml";
		if (acceptHeader == null || acceptHeader.isEmpty() || acceptHeader.equals("application/xml")) {
			representation = MessageBO.getAllXMLForUser(id);
		} else if (acceptHeader.equals("application/json")) {
			representation = MessageBO.getAllJSONForUser(id);
			type = "json";
		}

		return new DefaultHttpHeaders(type).disableCaching();
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
