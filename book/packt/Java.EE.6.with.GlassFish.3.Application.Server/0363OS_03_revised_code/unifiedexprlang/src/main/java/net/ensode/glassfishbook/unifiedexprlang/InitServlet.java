package net.ensode.glassfishbook.unifiedexprlang;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InitServlet extends HttpServlet
{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    CustomerBean customer1 = new CustomerBean("James", "Jones");
    CustomerBean customer2 = new CustomerBean("Carlos", "Perez");
    CustomerBean customer3 = new CustomerBean("Moesha", "Williams");
    CustomerBean customer4 = new CustomerBean("Satish", "Murthy");
    CustomerBean customer5 = new CustomerBean("Joanna", "Chan");
    
    HttpSession session = request.getSession();
    
    getServletContext().setAttribute("customer1", customer1);
    session.setAttribute("customer2", customer2);
    request.setAttribute("customer3", customer3);
    
    ArrayList customerList = new ArrayList();
    
    customerList.add(customer4);
    customerList.add(customer5);
    
    session.setAttribute("customerList", customerList);
    
    request.getRequestDispatcher("unifexprlangdemo.jsp").forward(request,
        response);
  }
}
