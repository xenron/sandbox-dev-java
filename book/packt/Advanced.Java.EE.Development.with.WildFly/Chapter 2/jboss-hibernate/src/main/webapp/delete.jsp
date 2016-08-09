<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
    import="org.jboss.hibernate.model.*,org.hibernate.*,java.util.List,org.hibernate.cfg.Configuration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>Delete</title>
</head>
<body>
    <%
        String hqlQuery = "from Catalog as catalog WHERE catalog.edition='March-April 2005'";
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sess = sessionFactory.openSession();
        Query query = sess.createQuery(hqlQuery);
        List list = query.list();
        Catalog catalog = (Catalog) list.get(0);
        Transaction tx = sess.beginTransaction();
        sess.delete(catalog);
        tx.commit();
        out.println("Deleted");
    %>
</body>
</html>
