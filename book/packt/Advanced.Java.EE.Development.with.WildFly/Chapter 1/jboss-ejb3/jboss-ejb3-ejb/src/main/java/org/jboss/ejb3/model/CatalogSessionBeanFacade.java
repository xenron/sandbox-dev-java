package org.jboss.ejb3.model;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless
public class CatalogSessionBeanFacade {
	@PersistenceContext(unitName = "em")
	private EntityManager em;
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Edition> getAllEditions() {
		ArrayList<Edition> editions = new ArrayList<Edition>();
		Query q = em.createNamedQuery("findEditionAll");
		for (Object ed : q.getResultList()) {
			editions.add((Edition) ed);
		}
		return editions;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Section> getAllSections() {
		ArrayList<Section> sections = new ArrayList<Section>();
		Query q = em.createNamedQuery("findSectionAll");
		for (Object ed : q.getResultList()) {
			sections.add((Section) ed);
		}
		return sections;
	}
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Article> getAllArticles() {
		ArrayList<Article> articles = new ArrayList<Article>();
		Query q = em.createNamedQuery("findArticleAll");
		for (Object ed : q.getResultList()) {
			articles.add((Article) ed);
		}
		return articles;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Catalog> getAllCatalogs() {
		Query q = em.createNamedQuery("findCatalogAll");
		List<Catalog> catalogs = q.getResultList();
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		for (Catalog catalog : catalogs) {
			catalogList.add(catalog);
		}
		return catalogList;
	}

	public void createTestData() {
		// create catalog for Oracle Magazine
		Catalog catalog1 = new Catalog();
		catalog1.setJournal("Oracle Magazine");
		em.persist(catalog1);
	//	em.flush();

		// Add an Edition
		Edition edition = new Edition();
		edition.setEdition("January/February 2009");
		edition.setCatalog(catalog1);
		em.persist(edition);
		//em.flush();
		// Add a Features Section
		Section features = new Section();
		features.setSectionname("FEATURES");
		features.setEdition(edition);
		em.persist(features);
		 
		// add an article to Features section
		Article article = new Article();
		 
		article.setTitle("Launching Performance");
		article.setSection(features);
		em.persist(article);
		//em.flush();

		// add a Technology section
		Section technology = new Section();
		technology.setSectionname("Technology");
		technology.setEdition(edition);
		em.persist(technology);
		 
		// add an article to Technology section
		article = new Article();
		article.setSection(technology);
		article.setTitle("On Dynamic Sampling");
		em.persist(article);
		 
	//	em.flush();
		Catalog catalog2 = new Catalog();
		catalog2.setJournal("Linux Magazine");
		em.persist(catalog2);
	//	em.flush();
	}

	public void deleteSomeData() {
		// remove a catalog
		Query q = em.createNamedQuery("findCatalogByJournal");
		//q.setParameter("journal", "Linux Magazine");
		q.setParameter("journal", "Oracle Magazine");
		List<Catalog> catalogs = q.getResultList();
		//ArrayList<Catalog> catalogList = new ArrayList<Catalog>();
		for (Catalog catalog : catalogs) {
			 
			em.remove(catalog);
		//	em.flush();
		}
	}
}