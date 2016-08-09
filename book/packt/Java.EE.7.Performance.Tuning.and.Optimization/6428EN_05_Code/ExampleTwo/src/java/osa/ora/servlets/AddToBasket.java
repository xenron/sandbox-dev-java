/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */


package osa.ora.servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import osa.ora.beans.BasketBean;
import osa.ora.dao.ProductCatalogSessionBean;
import osa.ora.jpa.ProductStock;

/**
 *
 * @author Osama Oransa
 */
@WebServlet(name = "AddToBasket", urlPatterns = {"/AddToBasket"})
public class AddToBasket extends HttpServlet {
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
        BasketBean basketBean=(BasketBean)request.getSession().getAttribute("BASKET");
        if(basketBean==null){
            basketBean=new BasketBean();
            System.out.println("new Basket created");
        }else{
            System.out.println("Initial Basket size="+basketBean.basketSize());
        }
        String productId=request.getParameter("id");        
        System.out.println("Try to add "+productId);
        if(productId!=null && !"".equals(productId.trim())){
            int id=Integer.parseInt(productId);
            ProductStock[] stocks=catalogSessionBean.loadAllStocks();
            for (ProductStock stock : stocks) {
                if (stock.getProductId().getId()==id) {
                    if(catalogSessionBean.updateStock(stock,-1)){
                        basketBean.addToBasket(id);
                        System.out.println("Basket size="+basketBean.basketSize());
                        response.getWriter().write(""+basketBean.basketSize());
                        System.out.println("Added to Basket stock was "+stock.getStockSize());
                        request.getSession().setAttribute("BASKET", basketBean);
                        response.flushBuffer();
                    }else{
                        response.getWriter().write("0");
                        request.getSession().setAttribute("BASKET", basketBean);
                        response.flushBuffer();                        
                    }
                    break;
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
