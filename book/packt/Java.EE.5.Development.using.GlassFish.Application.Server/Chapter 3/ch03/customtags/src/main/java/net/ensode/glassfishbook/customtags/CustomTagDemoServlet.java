package net.ensode.glassfishbook.customtags;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomTagDemoServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  {
    AddressBean addressBean = new AddressBean();

    addressBean.setLine1("43623 Park Ridge Ct");
    addressBean.setCity("Orlando");
    addressBean.setState("FL");
    addressBean.setZip("00303");

    request.setAttribute("address", addressBean);

    try
    {
      request.getRequestDispatcher("customtagdemo2.jsp").forward(request,
          response);
    }
    catch (ServletException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
  {
    AddressBean addressBean = (AddressBean) request.getSession().getAttribute(
        "address");
    PrintWriter printWriter;

    response.setContentType("text/html");
    try
    {
      printWriter = response.getWriter();
      printWriter.println("line1 = " + addressBean.getLine1() + "<br/>");
      printWriter.println("line2 = " + addressBean.getLine2() + "<br/>");
      printWriter.println("city = " + addressBean.getCity() + "<br/>");
      printWriter.println("state = " + addressBean.getState() + "<br/>");
      printWriter.println("state = " + addressBean.getState() + "<br/>");
      printWriter.println("zip = " + addressBean.getZip() + "<br/>");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
