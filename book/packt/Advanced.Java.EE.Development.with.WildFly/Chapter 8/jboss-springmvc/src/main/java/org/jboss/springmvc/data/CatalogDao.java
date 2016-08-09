package org.jboss.springmvc.data;

import java.util.List;
import javax.persistence.TypedQuery;
import org.jboss.springmvc.model.Catalog;

public interface CatalogDao {
	public void persist(Catalog catalog);

	public List<Catalog> getAllCatalogs();
}
