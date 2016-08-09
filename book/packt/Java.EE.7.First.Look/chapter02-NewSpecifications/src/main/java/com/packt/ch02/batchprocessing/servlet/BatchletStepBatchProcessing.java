/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.batchprocessing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.batch.runtime.Metric;
import javax.batch.runtime.StepExecution;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@WebServlet(name = "BatchletStepBatchProcessing", urlPatterns = {"/BatchletStepBatchProcessing"})
public class BatchletStepBatchProcessing extends HttpServlet {

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
            out.println("<title>SERVLET BATCHLET PROCESSING</title>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>BatchletStepBatchProcessing - Job information</h1>");
            
            JobOperator jobOperator = BatchRuntime.getJobOperator();
            long jobID = 0;     
            Properties props = new Properties();
            
            if (jobOperator != null) {
                jobID = jobOperator.start("informationJob", props);
            }
            
            JobExecution exec = jobOperator.getJobExecution(jobID);
            out.println("job name : "+exec.getJobName()+", status : "+exec.getBatchStatus().name()+","
                    + " start time : "+exec.getStartTime()+", last update : "+exec.getLastUpdatedTime()+""
                    + ", end time : "+exec.getEndTime());
            
            while(true){
                Thread.sleep(10*1000);
                
                if(exec.getBatchStatus().name() == exec.getBatchStatus().COMPLETED.name()){
                    List<StepExecution> steps = jobOperator.getStepExecutions(jobID);
                    out.println("<br/><h3>Processing performed successfully !!! </h3> exit status :"
                            + " "+exec.getExitStatus()+", date : "+exec.getEndTime());
                    
                    out.println("<br/><h3>METRICS</h3>");
                    
                    for(StepExecution step : steps){                       
                        out.println("STEP NAME : "+step.getStepName()+", exit status : "+step.getExitStatus());
                        
                        for(Metric metric : step.getMetrics())
                                out.println("<br/>     -"+metric.getType().name()+" : "+metric.getValue());
                    }
                    break;
                }
            }            
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex) {
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
