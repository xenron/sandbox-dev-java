/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.concurrency.servlet;

import com.packt.ch02.concurrency.ReportGeneratorTask;
import com.packt.ch02.concurrency.ReportManagedThread;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@WebServlet(name = "ManagedThreadFactoryCreator", urlPatterns = {"/ManagedThreadFactoryCreator"})
public class ManagedThreadFactoryCreator extends HttpServlet {

     @Resource(name="concurrent/ReportManagedThreadGenerator")
    ManagedThreadFactory threadFactory;
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
            out.println("<title>Servlet ManagedThreadFactoryCreator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Conccurrency</h1>");
            
            out.println("Creation of a managed Thread");
            Thread myThread = threadFactory.newThread(new ReportManagedThread()); 
            myThread.start();
            
            while(true){                
                State state = myThread.getState();
                out.println("<br/>Thread state : "+state+" - time : "+new Date());
                if(state == state.TERMINATED)
                    break;
                Thread.sleep(1000);
            }            
            
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
