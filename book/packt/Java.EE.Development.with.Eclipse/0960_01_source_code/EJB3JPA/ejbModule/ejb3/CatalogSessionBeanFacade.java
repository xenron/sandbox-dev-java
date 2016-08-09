package ejb3;

import javax.ejb.*;
import javax.persistence.*;
import java.util.*;

@Stateless(name = "CatalogSessionBean", mappedName = "EJB3-SessionEJB")
public class CatalogSessionBeanFacade implements CatalogSessionBeanFacadeRemote {
	@PersistenceContext(unitName = "em")
	EntityManager em;

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
		ArrayList<Catalog> catalogList = new ArrayList<Catalog>(catalogs.size());
		for (Catalog catalog : catalogs) {
			catalogList.add(catalog);
		}
		return catalogList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Edition> getCatalogEditions(Catalog catalog) {
		em.merge(catalog);
		List<Edition> editions = catalog.getEditions();
		ArrayList<Edition> editionList = new ArrayList<Edition>(editions.size());
		for (Edition edition : editions) {
			editionList.add(edition);
		}
		return editionList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Section> getEditionSections(Edition edition) {
		em.merge(edition);
		List<Section> sections = edition.getSections();
		ArrayList<Section> sectionList = new ArrayList<Section>(sections.size());
		for (Section section : sections) {
			sectionList.add(section);
		}
		return sectionList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public List<Article> getSectionArticles(Section section) {
		em.merge(section);
		List<Article> articles = section.getArticles();
		ArrayList<Article> articleList = new ArrayList<Article>(articles.size());
		for (Article article : articles) {
			articleList.add(article);
		}
		return articleList;
	}

	public void createTestData() {
		// create catalog for Oracle Magazine
		Catalog catalog1 = new Catalog();
		// catalog1.setId(1);
		catalog1.setJournal("Oracle Magazine");
		em.persist(catalog1);
		em.flush();

		// Add an Edition
		Edition edition = new Edition();
		// edition.setId(2);
		edition.setEdition("January/February 2009");
		em.persist(edition);
		// em.refresh(edition);
		em.flush();
		em.merge(catalog1);
		catalog1.addEdition(edition);

		// Add a Features Section
		Section features = new Section();
		// features.setId(31);
		features.setSectionname("FEATURES");
		em.persist(features);
		em.merge(edition);
		edition.addSection(features);

		// add an article to Features section
		Article article = new Article();
		// article.setId(41);
		article.setTitle("Launching Performance");
		article.setSection(features);
		em.persist(article);
		em.merge(features);
		features.addArticle(article);
		em.flush();

		// add a Technology section
		Section technology = new Section();
		// technology.setId(32);
		technology.setSectionname("Technology");
		em.persist(technology);
		em.merge(edition);
		edition.addSection(technology);
		// add an article to Technology section
		article = new Article();
		// article.setId(42);
		article.setSection(technology);
		article.setTitle("On Dynamic Sampling");
		em.persist(article);
		em.merge(technology);
		technology.addArticle(article);
		em.flush();
	}

	public void deleteSomeData() {
		// remove an article
		Query q = em.createNamedQuery("findArticleByTitle");
		q.setParameter("title", "Launching Performance");
		List list = q.getResultList();
		for (Object article : list) {
			em.remove(article);
		}
	}

	public void removeEdition(Edition edition) {
		Catalog catalog = edition.getCatalog();
		catalog.removeEdition(edition);

		em.remove(edition);
	}

	public void removeSection(Section section) {
		Edition edition = section.getEdition();
		edition.removeSection(section);
		em.remove(section);
	}

	public void removeArticle(Article article) {
		Section section = article.getSection();
		section.removeArticle(article);
		em.remove(article);
	}
}
