/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.concurrency.servlet;

import com.packt.ch02.concurrency.ReportGeneratorTask;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@WebServlet(name = "ManagedScheduledExecutorServiceSubmiter", urlPatterns = {"/ManagedScheduledExecutorServiceSubmiter"})
public class ManagedScheduledExecutorServiceSubmiter extends HttpServlet {

    @Resource(name="concurrent/ReportScheduledGenerator")
    ManagedScheduledExecutorService reportGenerator;
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
            out.println("<title>Servlet ManagedScheduledExecutorServiceSubmiter</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Conccurrency</h1>");
            out.println("<br/>The task will be executed in 5 seconds - time before "+new Date());
            Future<String> monitor = reportGenerator.schedule(new ReportGeneratorTask(), 10, TimeUnit.SECONDS);
            String result = monitor.get();            
            out.println("<br/>Report task status : " + result + "- time after "+new Date());
            out.println("</body>");
            out.println("</html>");
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
