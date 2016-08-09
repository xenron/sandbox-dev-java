/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.jsonprocessing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@WebServlet(name = "JsonProcessingObjectModelAPI", urlPatterns = {"/JsonProcessingObjectModelAPI"})
public class JsonProcessingObjectModelAPI extends HttpServlet {

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
            out.println("<title>Servlet JsonProcessingObjectModelAPI</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> The contact of a student </h1>");
            JsonObject jsonObject = createJsonObjectModel();
            JsonObject student = jsonObject.getJsonObject("student");
            String name = student.getString("name");
            JsonArray contact = student.getJsonArray("contact");
            out.println("The contact of "+name+" is  "
                    + " address : " + contact.getJsonObject(0).getString("address")+""
                    + " phone : "+ contact.getJsonObject(1).getString("phone"));
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }
    
    public JsonObject createJsonObjectModel(){
        JsonObject objModel = Json.createObjectBuilder()
              .add("student",Json.createObjectBuilder()
                   .add("id", "854963")
                   .add("name", "Louis Poyer")
                   .add("weight", 78.6)
                   .add("gender","M")
                   .add("contact",Json.createArrayBuilder()
                        .add(Json.createObjectBuilder()
                               .add("address","Rue 632"))
                        .add(Json.createObjectBuilder()
                                .add("phone","985-761-0")))                        
              ).build();
                
        return objModel;
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
