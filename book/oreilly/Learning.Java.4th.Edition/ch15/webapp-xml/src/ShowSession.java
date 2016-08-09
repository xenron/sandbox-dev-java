//file: ShowSession.java
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.Enumeration;

public class ShowSession extends HttpServlet {

    public void doPost( 
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{ 
        doGet( request, response );
    }

    public void doGet(
		HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException 
	{
        HttpSession session = request.getSession(  );
        boolean clear = request.getParameter("clear") != null;
		if ( clear )
			session.invalidate();
		else {
			String name = request.getParameter("Name");
			String value = request.getParameter("Value");
			if ( name != null && value != null )
				session.setAttribute( name, value );
		}

        response.setContentType("text/html");
        PrintWriter out = response.getWriter(  );
        out.println(
          "<html><head><title>Show Session</title></head><body>");

		if ( clear )
        	out.println("<h1>Session Cleared:</h1>");
		else {
			out.println("<h1>In this session:</h1><ul>");
			Enumeration names = session.getAttributeNames();
			while ( names.hasMoreElements() ) {
				String name = (String)names.nextElement();
				out.println( "<li>"+name+" = " +session.getAttribute( name ) );
			}
		}

        out.println(
          "</ul><p><hr><h1>Add String</h1>"
          + "<form method=\"POST\" action=\""
          + request.getRequestURI(  ) +"\">"
          + "Name: <input name=\"Name\" size=20><br>"
          + "Value: <input name=\"Value\" size=20><br>"
          + "<br><input type=\"submit\" value=\"Submit\">"
          + "<input type=\"submit\" name=\"clear\" value=\"Clear\"></form>"
        );
    }
}
