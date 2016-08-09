/*
 * Written by Osama Oransa
 * This project is written for the book
 * Java Enterprise Edition 7 Performance Tuning (EN6428)
 */

package osa.ora.cache;

import java.util.HashMap;
import javax.ejb.Stateful;
import osa.ora.beans.SearchCriteria;
import osa.ora.jpa.Product;

/**
 *
 * @author Osama Oransa
 */
@Stateful
public class CacheSessionBean {
    //caching collection
    //it shoulnd't be public, but we need it public to use it in memory lekage
    public final HashMap<String, Product[]> cachingCollection = new HashMap();
    /**
     * method to add to the cache
     * @param criteria
     * @param catalog 
     */
    public void addToCache(SearchCriteria criteria,Product[] catalog){
        cachingCollection.put(criteria.toString(), catalog);
    }
    /**
     * method to remove from the cache
     * @param criteria 
     */
    public void removeFromCache(SearchCriteria criteria){
        cachingCollection.remove(criteria.toString());
    }
    /**
     * method to get from the cache
     * @param criteria
     * @return 
     */
    public Product[] getFromCache(SearchCriteria criteria){
        return cachingCollection.get(criteria.toString());
    }
}
