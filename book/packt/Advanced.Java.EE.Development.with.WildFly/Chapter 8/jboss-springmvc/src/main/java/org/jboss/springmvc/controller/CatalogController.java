package org.jboss.springmvc.controller;

import org.jboss.springmvc.data.*;
import org.jboss.springmvc.model.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CatalogController {
	@Autowired
	private CatalogDao catalogDao;

	@RequestMapping(value = "/catalog")
	public ModelAndView createAndDisplayCatalog(HttpServletRequest request) {
		// Handle a new catalog (if any):
		String journal = request.getParameter("journal");
		String publisher = request.getParameter("publisher");
		String edition = request.getParameter("edition");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		if (journal != null && publisher != null && edition != null
				&& title != null && author != null) {
			Catalog catalog = new Catalog();
			catalog.setJournal(journal);
			catalog.setPublisher(publisher);
			catalog.setEdition(edition);
			catalog.setTitle(title);
			catalog.setAuthor(author);
			catalogDao.persist(catalog);
		}
		// Prepare the result view (catalog):
		return new ModelAndView("catalog", "catalogDao", catalogDao);
	}
}
