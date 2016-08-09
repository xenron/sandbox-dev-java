/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Osama Oransa
 */
public class BasketBean {
    //basket content
    private List<BasketElement> basketElements = new ArrayList<>();
    /**
     * method to get basket content size
     * @return 
     */
    public synchronized int basketSize(){
        return getBasketElements().size();
    }
    /**
     * method to add a new product into the basket
     * @param product_id
     * @return 
     */
    public synchronized boolean addToBasket(int product_id){
        boolean added=false;
        for(BasketElement basketElement:getBasketElements()){
            //if the product already exist, just increase its count
            if(basketElement.getProductId()==product_id){
                basketElement.setCount(basketElement.getCount()+1);
                added=true;
                break;
            }
        }
        //new product, add it
        if(!added){
            BasketElement newElement=new BasketElement();
            newElement.setProductId(product_id);
            newElement.setCount(1);
            getBasketElements().add(newElement);
            added=true;
        }
        return added;
    }
    /**
     * method to retrieve product from the basket
     * @param product_id
     * @return 
     */
    public synchronized boolean removeFromBasket(int product_id){
        boolean removed=false;
        for(BasketElement basketElement:getBasketElements()){
            if(basketElement.getProductId()==product_id){
                getBasketElements().remove(basketElement);
                removed=true;
                break;
            }
        }
        return removed;
    }

    /**
     * @return the basketElements
     */
    public List<BasketElement> getBasketElements() {
        return basketElements;
    }
}
