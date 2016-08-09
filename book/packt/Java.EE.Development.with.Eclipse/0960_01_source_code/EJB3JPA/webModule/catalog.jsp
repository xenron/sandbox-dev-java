<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ejb3.*,java.util.*,javax.naming.*"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1252" />
<title>EJB3 Client</title>
</head>
<body>
	<%
		InitialContext context = new InitialContext();

		CatalogSessionBeanFacadeRemote beanRemote = (CatalogSessionBeanFacadeRemote) context
				.lookup("EJB3-SessionEJB#ejb3.CatalogSessionBeanFacadeRemote");
		beanRemote.createTestData();
		List<Catalog> catalogs = beanRemote.getAllCatalogs();

		out.println("<br/>" + "List of Catalogs" + "<br/>");
		for (Catalog catalog : catalogs) {
			out.println("Catalog Id:");
			out.println("<br/>" + catalog.getId() + "<br/>");
			out.println("Catalog Journal:");
			out.println(catalog.getJournal() + "<br/>");
		}

		out.println("<br/>" + "List of Editions" + "<br/>");
		List<Edition> editions = beanRemote.getAllEditions();
		for (Edition edition : editions) {
			out.println("Edition Id:");
			out.println(edition.getId() + "<br/>");
			out.println("Edition Date:");
			out.println(edition.getEdition() + "<br/>");

		}
		out.println("<br/>" + "List of Sections" + "<br/>");
		List<Section> sections = beanRemote.getAllSections();
		for (Section section : sections) {
			out.println("Section Id:");
			out.println(section.getId() + "<br/>");
			out.println("Section Name:");
			out.println(section.getSectionname() + "<br/>");

		}

		out.println("<br/>" + "List of Articles" + "<br/>");
		List<Article> articles = beanRemote.getAllArticles();
		for (Article article : articles) {
			out.println("Article Id:");
			out.println(article.getId() + "<br/>");
			out.println("Article Title:");
			out.println(article.getTitle() + "<br/>");

		}
		out.println("Delete some Data" + "<br/>");
		beanRemote.deleteSomeData();

		catalogs = beanRemote.getAllCatalogs();
		out.println("<br/>" + "List of Catalogs" + "<br/>");
		for (Catalog catalog : catalogs) {
			out.println("Catalog Id:");
			out.println(catalog.getId() + "<br/>");
			out.println("Catalog Journal:");
			out.println(catalog.getJournal() + "<br/>");
		}

		out.println("<br/>" + "List of Editions" + "<br/>");
		editions = beanRemote.getAllEditions();
		for (Edition edition : editions) {
			out.println("Edition Id:");
			out.println(edition.getId() + "<br/>");
			out.println("Edition Date:");
			out.println(edition.getEdition() + "<br/>");

		}
		out.println("<br/>" + "List of Sections" + "<br/>");
		sections = beanRemote.getAllSections();
		for (Section section : sections) {
			out.println("Section Id:");
			out.println(section.getId() + "<br/>");
			out.println("Section Name:");
			out.println(section.getSectionname() + "<br/>");

		}
		out.println("<br/>" + "List of Articles" + "<br/>");
		articles = beanRemote.getAllArticles();
		for (Article article : articles) {
			out.println("Article Id:");
			out.println(article.getId() + "<br/>");
			out.println("Article Title:");
			out.println(article.getTitle() + "<br/>");
		}
	%>
</body>
</html>
