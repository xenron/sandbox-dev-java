/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.expressionlanguage;

import com.packt.ch02.beans.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.el.ELManager;
import javax.el.ELProcessor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "StandAloneAPIServlet", urlPatterns = {"/StandAloneAPIServlet"})
public class StandAloneAPIServlet extends HttpServlet {

    private ELProcessor el = new ELProcessor();
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StandAloneAPIServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            //Simple EL evaluation
            out.println("<h1>'Welcome to the site!' : " + el.eval("'Welcome to the site!'") + "</h1>");
            //Definition of local repository bean
            el.defineBean("student", new StudentBean());
            //Direct evaluation of EL expression 
            out.println("<h1>" + el.eval("'The id of : '+=student.lastName+=' is : '+=student.identity") + "</h1>");
            //Function definition
            el.defineFunction("doub", "hex", "java.lang.Double","toHexString");
            out.println("<h1> The hexadecimal of 29 is : " + el.eval("doub:hex(29)") + "</h1>");
            //static variable access
            out.println("<h1> The value of Integer.MIN_VALUE : " + el.eval("Integer.MIN_VALUE") + "</h1>");
            //static method access
            out.println("<h1> The value of Integer.parseInt('2') : " + el.eval("Integer.parseInt('2')") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex){
            ex.printStackTrace();
        } finally {            
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
