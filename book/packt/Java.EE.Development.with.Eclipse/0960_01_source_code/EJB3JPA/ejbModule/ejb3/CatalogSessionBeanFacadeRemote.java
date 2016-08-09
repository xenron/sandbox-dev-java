package ejb3;

import javax.ejb.*;
import java.util.*;

@Remote
public interface CatalogSessionBeanFacadeRemote {
	public List<Edition> getAllEditions();

	public List<Section> getAllSections();

	public List<Article> getAllArticles();

	public List<Catalog> getAllCatalogs();

	public List<Edition> getCatalogEditions(Catalog catalog);

	public List<Section> getEditionSections(Edition edition);

	public List<Article> getSectionArticles(Section section);

	public void createTestData();

	public void deleteSomeData();

	public void removeEdition(Edition edition);

	public void removeSection(Section section);

	public void removeArticle(Article article);
}
