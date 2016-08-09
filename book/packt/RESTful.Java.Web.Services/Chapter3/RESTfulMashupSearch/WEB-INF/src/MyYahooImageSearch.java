import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

public class MyYahooImageSearch extends HttpServlet {
	// Note that 'appid=YahooDemo' should be your own appid 	
	private static final String URI = "http://search.yahooapis.com/ImageSearchService/V1/imageSearch?output=json&appid=YahooDemo&query=";
	private static final String CONTENT_TYPE = "text/plain";
	private static final String CHAR_ENCODING = "UTF-8";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/javascript");
		PrintWriter out = response.getWriter();		
		GetMethod getMethod = null;
		try {
			String query = URLEncoder.encode(request.getParameter("query"), CHAR_ENCODING);
			getMethod = new GetMethod(URI + query);		
			
			HttpClient httpClient = new HttpClient();
			int statusCode = httpClient.executeMethod(getMethod);
			
			if (statusCode == HttpStatus.SC_OK) {
				out.print(new String(getMethod.getResponseBody()));
			} else {
				out.print("HTTP error with code: " + statusCode);
			}
		} catch (Exception e) {
			// Send any errors to the view
			out.print(e.getMessage());
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
			}
		}		
	}
}
