<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
    import="org.jboss.hibernate.model.*,org.hibernate.*,java.util.List,org.hibernate.cfg.Configuration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>Find</title>
</head>
<body>
    <%
        String hqlQuery = "from Catalog";
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sess = sessionFactory.openSession();
        Query query = sess.createQuery(hqlQuery);
        List list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Catalog catalog = (Catalog) list.get(i);
            out.println("<br>");
            out.println("CatalogId " + catalog.getId() + " Journal: "+ catalog.getJournal());
            out.println("<br>");
            out.println("CatalogId " + catalog.getId() + " Publisher: " + catalog.getPublisher());
            out.println("<br>");
            out.println("CatalogId " + catalog.getId() + " Edition: "+ catalog.getEdition());
            out.println("<br>");
            out.println("CatalogId " + catalog.getId() + " Title "+ catalog.getTitle());
            out.println("<br>");
            out.println("CatalogId " + catalog.getId() + " Author: "+ catalog.getAuthor());
        }
        sess.close();
    %>
</body>
</html>
