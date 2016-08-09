/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428).
 */

package osa.ora.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import osa.ora.beans.SearchCriteria;
import osa.ora.cache.CacheSessionBean;
import osa.ora.dao.ProductCatalogSessionBean;
import osa.ora.jpa.Product;

/**
 *
 * @author Osama Oransa
 */
@WebServlet(name = "ImageRender", urlPatterns = {"/ImageRender"})
public class ImageRender extends HttpServlet {
    @EJB(beanName ="ProductCatalogSessionBean")
    ProductCatalogSessionBean catalogSessionBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String imageProductId=request.getParameter("imgProductId");
        if(imageProductId!=null){
            int productId=Integer.parseInt(imageProductId);
            ServletOutputStream outputStream=response.getOutputStream();
            Product[] allProducts=catalogSessionBean.loadAllActiveProductCatalogByCriteria(new SearchCriteria());
            for (Product allProduct : allProducts) {
                if(allProduct.getId()==productId){
                    outputStream.write(allProduct.getImage());
                    outputStream.close();
                    return;                    
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
