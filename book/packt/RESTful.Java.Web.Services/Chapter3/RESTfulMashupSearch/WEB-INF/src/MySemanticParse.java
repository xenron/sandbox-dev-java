import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class MySemanticParse extends HttpServlet {
	// Format: http://api.semantichacker.com/YOUR_API_KEY/concept
	private static final String URI = "http://api.semantichacker.com/srkqq0id/concept?format=tagcloud";
	private static final String CONTENT_TYPE = "text/plain";
	private static final String CHAR_ENCODING = "UTF-8";
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		PostMethod postMethod = null;
		try {
			String entry = URLEncoder.encode(request.getParameter("entry"), CHAR_ENCODING);
			postMethod = new PostMethod(URI);
			postMethod.setRequestEntity(new StringRequestEntity(entry, CONTENT_TYPE, CHAR_ENCODING));
			
			HttpClient httpClient = new HttpClient();
			int statusCode = httpClient.executeMethod(postMethod);
			
			if (statusCode == HttpStatus.SC_OK) {
				String semanticResponse = new String(postMethod.getResponseBody());
				
				// Set top cloud value				
				String tmp1 = semanticResponse.substring(semanticResponse.indexOf("title=\"") + 7);
				String topCloud = tmp1.substring(0, tmp1.indexOf('(')).trim();							
				request.getSession(true).setAttribute("TOP_CLOUD", topCloud);
				
				// Sent to out stream
				out.print(semanticResponse);
			} else {
				out.print("HTTP error with code: " + statusCode);
			}
		} catch (Exception e) {
			// Send any errors to the view
			out.print(e.getMessage());
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}		
	}
}
