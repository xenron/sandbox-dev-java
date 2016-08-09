/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.servlet.appconnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/ConnexionServlet"})
public class ConnexionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Online pre-registration site</title>");            
            out.println("</head>");
            out.println("<body>");
            out.write("        <form method=\"post\">");
            out.write("            <h4>Your name</h4>");
            out.write("            <input type=\"text\" name=\"param1\" />");
            out.write("            <h4>Your password</h4>");
            out.write("            <input type=\"password\" name=\"param2\" />");
            out.write("            <br/> <br/> <br/>");
            out.write("            <input type=\"submit\"  value=\"Sign it\"/>");
            out.write("            <input type=\"reset\" value=\"Reset\" />");
            out.write("        </form>");
            out.println("</body>");
            out.println("</html>");
            
            String name = request.getParameter("param1");
            String password = request.getParameter("param2");
            
            String location = request.getContextPath();
            
            if("arnoldp".equals(name) && "123456".equals(password)){
                response.sendRedirect(location+"/WelcomeServlet?name="+name);
            }else if((name != null) && (password != null))
                 response.sendRedirect(location+"/ConnexionFailureServlet"); 
                           
        } catch(Exception ex){
            ex.printStackTrace();
        }finally {            
            out.close();
        }
    }    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
