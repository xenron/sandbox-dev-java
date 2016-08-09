package net.ensode.glassfishbook.responseredirection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseRedirectionServlet extends HttpServlet
{
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException
  {
    String url = request.getParameter("searchEngine");

    if (url != null)
    {
      response.sendRedirect(url);
    }
    else
    {
      PrintWriter printWriter = response.getWriter();

      printWriter.println("No search engine was selected.");
    }
  }
}
