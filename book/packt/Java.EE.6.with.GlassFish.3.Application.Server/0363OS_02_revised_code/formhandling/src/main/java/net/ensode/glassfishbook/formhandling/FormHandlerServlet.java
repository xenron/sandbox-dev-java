package net.ensode.glassfishbook.formhandling;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormHandlerServlet extends HttpServlet
{

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {
    String enteredValue;
    
    enteredValue = request.getParameter("enteredValue");

    response.setContentType("text/html");

    PrintWriter printWriter;
    try
    {
      printWriter = response.getWriter();

      printWriter.println("<p>");
      printWriter.print("You entered: ");
      printWriter.print(enteredValue);
      printWriter.print("</p>");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
