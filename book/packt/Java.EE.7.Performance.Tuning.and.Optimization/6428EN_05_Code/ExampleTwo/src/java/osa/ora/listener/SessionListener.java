/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */

package osa.ora.listener;

import javax.ejb.EJB;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import osa.ora.beans.BasketBean;
import osa.ora.beans.BasketElement;
import osa.ora.dao.ProductCatalogSessionBean;
import osa.ora.jpa.ProductStock;

/**
 * Web application lifecycle listener.
 *
 * @author Osama Oransa
 */
public class SessionListener implements HttpSessionListener {

    @EJB(beanName = "ProductCatalogSessionBean")
    ProductCatalogSessionBean catalogSessionBean;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        BasketBean basketBean = (BasketBean) se.getSession().getAttribute("BASKET");
        if (basketBean != null) {
            ProductStock[] stocks = catalogSessionBean.loadAllStocks();
            System.out.println("Will remove basket content:" + basketBean.basketSize());
            for (BasketElement basketElement : basketBean.getBasketElements()) {
                ProductStock currentStock = null;
                for (ProductStock stock : stocks) {
                    if (stock.getProductId().getId() == basketElement.getProductId()) {
                        currentStock = stock;
                        break;
                    }
                }
                catalogSessionBean.updateStock(currentStock, basketElement.getCount());
            }
        }
    }
}
