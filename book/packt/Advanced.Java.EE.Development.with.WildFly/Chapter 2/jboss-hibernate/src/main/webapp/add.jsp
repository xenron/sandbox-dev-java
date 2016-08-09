<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
    import="org.jboss.hibernate.model.*,org.hibernate.*,java.util.List,org.hibernate.cfg.Configuration"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>Add</title>
</head>
<body>
    <%
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        Catalog catalog = new Catalog();
        catalog.setId(1);
        catalog.setJournal("Oracle Magazine");
        catalog.setPublisher("Oracle Publishing");
        catalog.setEdition("Jan-Feb 2004");
        catalog.setTitle("Understanding Optimization");
        catalog.setAuthor("Kimberly Floss");

        Catalog catalog2 = new Catalog();
        catalog2.setId(2);
        catalog2.setJournal("Oracle Magazine");
        catalog2.setPublisher("Oracle Publishing");
        catalog2.setEdition("March-April 2005");
        catalog2.setTitle("Starting with Oracle ADF");
        catalog2.setAuthor("Steve Muench");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session sess = sessionFactory.openSession();
        Transaction tx = sess.beginTransaction();
        sess.save(catalog);
        sess.save(catalog2);
        tx.commit();
        out.println("Added");
    %>

</body>
</html>