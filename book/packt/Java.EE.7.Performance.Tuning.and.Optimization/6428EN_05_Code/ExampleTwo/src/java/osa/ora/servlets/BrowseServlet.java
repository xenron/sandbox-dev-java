/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */

package osa.ora.servlets;

import java.io.IOException;
import java.util.HashMap;
import osa.ora.jpa.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import osa.ora.beans.SearchCriteria;
import osa.ora.dao.ProductCatalogSessionBean;
import osa.ora.cache.*;

/**
 *
 * @author Osama Oransa
 */
@WebServlet(name = "BrowseServlet", urlPatterns = {"/Browse"})
public class BrowseServlet extends HttpServlet {
    private final HashMap<String, HashMap> cachingAllUsersCollection = new HashMap();
    @EJB(beanName ="ProductCatalogSessionBean")
    ProductCatalogSessionBean catalogSessionBean;
    @EJB(beanName ="CacheSessionBean")
    CacheSessionBean cacheSessionBean;
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
        String productCategory=request.getParameter("category");
        String price=request.getParameter("price");
        String keyword=request.getParameter("keyword");
        if(keyword!=null){
            if("".equals(keyword.trim())){
                keyword=null;
            }
        }
        System.err.println("Category="+productCategory);
        System.err.println("price="+price);
        System.err.println("keyword="+keyword);
        Product[] results = null;
        if(productCategory==null && price==null && keyword==null){
            //load defaults
            SearchCriteria criteria=new SearchCriteria();
            results=cacheSessionBean.getFromCache(criteria);
            if(results==null){
                results=catalogSessionBean.loadAllActiveProductCatalog();
                //memory leakage per session cache
                cacheSessionBean.addToCache(criteria, results);
                //another memory leakage global cache that will not be removed
                cachingAllUsersCollection.put(request.getSession().getId(),cacheSessionBean.cachingCollection);
            }
        }else{
            //load defaults
            SearchCriteria criteria=new SearchCriteria();
            criteria.setPrice(Integer.parseInt(price));
            criteria.setProductCategory(Integer.parseInt(productCategory));
            criteria.setSearchKeyword(keyword);
            results=cacheSessionBean.getFromCache(criteria);
            if(results==null){
                results=catalogSessionBean.loadAllActiveProductCatalogByCriteria(criteria);
                cacheSessionBean.addToCache(criteria, results);
            }            
        }
        if(results == null){
            request.getSession().setAttribute("reason", "Can't load any product catalog!");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }else{
            Category[] categories= catalogSessionBean.loadAllActiveCategories();
            //Do we really need the whole data in the session
            request.getSession().setAttribute("PRODUCTS", results);
            request.getSession().setAttribute("CATEGORIES", categories);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
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
