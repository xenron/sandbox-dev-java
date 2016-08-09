package org.jboss.springmvc.data;
import org.jboss.springmvc.model.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CatalogDaoImpl implements CatalogDao 
{
    // Injected database connection:
  @PersistenceContext private EntityManager em;
    // Stores a new catalog:
    @Transactional
    
public void persist(Catalog catalog) {
        em.persist(catalog);
    }
 
   
 // Retrieves all the catalogs:
   public List<Catalog> getAllCatalogs() {
        TypedQuery<Catalog> query = em.createQuery(
"SELECT c FROM Catalog c ORDER BY c.id", Catalog.class);
        return query.getResultList();
  
  }
}
