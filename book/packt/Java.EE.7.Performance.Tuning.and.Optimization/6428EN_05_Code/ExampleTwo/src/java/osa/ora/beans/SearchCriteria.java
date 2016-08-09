/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */
package osa.ora.beans;

/**
 *
 * @author Osama Oransa
 */
public class SearchCriteria {
    private int productCategory;
    private int price;
    private String searchKeyword;

    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        builder=builder.append(getProductCategory()).append("#").append(getPrice()).append("#").append(getSearchKeyword());
        return builder.toString();
    }

    /**
     * @return the productCategory
     */
    public int getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(int productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price*50;
    }

    /**
     * @return the searchKeyword
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * @param searchKeyword the searchKeyword to set
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }
    
}
