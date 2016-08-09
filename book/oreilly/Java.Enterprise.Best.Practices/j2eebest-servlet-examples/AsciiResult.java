import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class AsciiResult extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    ServletOutputStream out = res.getOutputStream();

    // ServletOutputStream has println() methods for writing strings
    // The println() call only works for single-byte character encodings
    // If you need multibyte, make sure to set the charset in the Content-Type
    // and use for example out.write(str.getBytes("Shift_JIS")) for Japanese 
    out.println("Content current as of");
    out.println(new Date().toString());

    // ... retrieve a database ResultSet here ...
    ResultSet resultSet = null;

    try {
      InputStream ascii = resultSet.getAsciiStream(1);
      returnStream(ascii, out);
    }
    catch (SQLException e) {
      throw new ServletException(e);
    }
  }

  public static void returnStream(InputStream in, OutputStream out)
                             throws FileNotFoundException, IOException {
    byte[] buf = new byte[4 * 1024];  // 4K buffer
    int bytesRead;
    while ((bytesRead = in.read(buf)) != -1) {
      out.write(buf, 0, bytesRead);
    }
  }
}
