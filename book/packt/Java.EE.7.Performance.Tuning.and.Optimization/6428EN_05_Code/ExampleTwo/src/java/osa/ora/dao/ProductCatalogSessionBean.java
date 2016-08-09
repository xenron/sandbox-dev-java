/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */

package osa.ora.dao;
import osa.ora.jpa.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import osa.ora.beans.SearchCriteria;

/**
 *
 * @author Osama Oransa
 */
@Stateless
public class ProductCatalogSessionBean {

    @PersistenceContext(unitName = "ExampleTwoPU")
    EntityManager em;
    
     /**
     * method to load all active product catalog
     *
     * @return products[] array of user roles
     */
    public Product[] loadAllActiveProductCatalog() {
        //TODO: global caching is required for such collections
        Product[] products = new Product[0];
        Query query = em.createNamedQuery("Product.findByActive");
        //query.setParameter("active", Boolean.TRUE);
        products = (Product[]) query.getResultList().toArray(products);
        return products;
    }
    /**
     * method to load all active categories
     * @return 
     */
    public Category[] loadAllActiveCategories() {
        //TODO: global caching is required for such collections
        Category[] categories = new Category[0];
        Query query = em.createNamedQuery("Category.findAll");
        categories = (Category[]) query.getResultList().toArray(categories);
        return categories;
    }
    /**
     * method to construct all different tree child for search
     * @param id
     * @return 
     */
    private String constructAllChildCategories(int id) {
        StringBuilder result=new StringBuilder();
        result.append(id);
        Category[] categories = new Category[0];
        Query query = em.createNamedQuery("Category.findByParentCategory");
        query.setParameter("parentCategory", id);
        categories = (Category[]) query.getResultList().toArray(categories);
        for(Category category:categories){
            result.append(",");
            result.append(category.getId());
        }
        return result.toString();
    }
    /**
     * method to load all stocks
     * @return 
     */
    public ProductStock[] loadAllStocks() {
        //TODO: global caching is required for such collections
        ProductStock[] stocks = new ProductStock[0];
        Query query = em.createNamedQuery("ProductStock.findAll");
        stocks = (ProductStock[]) query.getResultList().toArray(stocks);
        return stocks;
    }
    /**
     * method to load product catalogs according to the search criteria
     * @param criteria
     * @return 
     */
    public Product[] loadAllActiveProductCatalogByCriteria(SearchCriteria criteria) {
        Product[] products = new Product[0];
        Query query = null;
        //missing category and desc queries
        //also category is wrong we should use all category child as well or it will be useless!
        //price should support also between x and x
        if(criteria.getProductCategory()==0 && criteria.getPrice()>0 && criteria.getSearchKeyword()==null) {
            query = em.createNamedQuery("Product.findByPrice");
            query.setParameter("price", criteria.getPrice());
        }else if(criteria.getProductCategory()>0 && criteria.getPrice()==0 && criteria.getSearchKeyword()==null) {
            query = em.createNamedQuery("Product.findByCategoryId");
            query.setParameter("categoryId", criteria.getProductCategory());
        }else if(criteria.getProductCategory()==0 && criteria.getPrice()==0 && criteria.getSearchKeyword()!=null) {
            query = em.createNamedQuery("Product.findByDesc");
            query.setParameter("description", "%"+criteria.getSearchKeyword()+"%");
        }else if(criteria.getProductCategory()==0 && criteria.getPrice()==0 && criteria.getSearchKeyword()==null) {
            query = em.createNamedQuery("Product.findByActive");
        }else {
            query = em.createNamedQuery("Product.findByPriceCategoryDesc");
            query.setParameter("categoryId", criteria.getProductCategory());
            query.setParameter("price", criteria.getPrice());
            query.setParameter("description", "%"+criteria.getSearchKeyword()+"%");
        }
        products = (Product[]) query.getResultList().toArray(products);
        return products;
    }
    /**
     * method to update the stock by a delta value
     * @param stock
     * @param delta
     * @return 
     */
    //wrong synchronizaiton in the whole method
    public synchronized boolean updateStock(ProductStock stock,int delta) {
        ProductStock currentStock = (ProductStock) em.find(ProductStock.class, stock.getId());
        if(currentStock.getStockSize()>0){
            System.out.println("Will update the stock "+currentStock.getStockSize()+" by "+delta);
            currentStock.setStockSize(currentStock.getStockSize()+delta);
            return true;
        }else{
            return false;
        }
    }
}
