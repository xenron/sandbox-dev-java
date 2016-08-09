/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.ch02.jsonprocessing.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ndjobo Armel Fabrice
 */
@WebServlet(name = "JsonProcessingStreamingAPI", urlPatterns = {"/JsonProcessingStreamingAPI"})
public class JsonProcessingStreamingAPI extends HttpServlet {

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
            out.println("<title>Servlet JsonProcessingStreamingAPI</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1> The contact of a student </h1>");
            String jsonData = "{\"student\": {\n"
                    + "	 \"id\":\"854963\", \n"
                    + "	 \"name\":\"Louis Poyer\", \n"
                    + "       \"weight\":78.6,\n"
                    + "	 \"gender\":\"M\",\n"
                    + "	 \"contact\":[\n"
                    + "	     {\"address\":\"Rue 632\"},\n"
                    + "	     {\"phone\":\"985-761-0\"} ]\n"
                    + "     }	  \n"
                    + " }";

            String contact = getStudentContact(jsonData);
            out.println("The contact of Louis Poyer is : " + contact + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    public String getStudentContact(String jsonData) {
        JsonParser parser = Json.createParser(new StringReader(jsonData));
        Event event = null;
        boolean found = false;
        String information = "";
       
        //Advance to the required information key
        while (parser.hasNext()) {
            event = parser.next();            
            if ((event == Event.KEY_NAME) && "contact".equals(parser.getString())) {
                found = true;
                event = parser.next();              
                break;
            }
        }

        if (!found) {
            return "contact information does not exist";
        }

        //get contact information 
        while (event != Event.END_ARRAY) {         
            switch (event) {
                case KEY_NAME:
                    information += parser.getString() + " = ";
                    break;
                case START_ARRAY:
                    break;
                case END_ARRAY:
                    break;
                case VALUE_FALSE:
                    information += " FALSE, ";
                    break;
                case VALUE_NULL:
                    information += " NULL, ";
                    break;
                case VALUE_NUMBER:
                    if (parser.isIntegralNumber()) {
                        information += parser.getLong()+", ";
                    } else {
                        information += parser.getBigDecimal()+", ";
                    }
                    break;
                case VALUE_STRING:
                    information += parser.getString()+", ";
                    break;
                case VALUE_TRUE:
                    information += " TRUE, ";
                    break;
            }
            event = parser.next();
        }

        return information;
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
