<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page
    import="org.hibernate.*,org.hibernate.cfg.Configuration,org.hibernate.tool.hbm2ddl.SchemaExport"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/xml; charset=windows-1252" />
<title>Export Schema</title>
</head>
<body>
    <%
            Configuration cfg=new Configuration();
            cfg.configure("hibernate.cfg.xml"); 
             
            SchemaExport schemaExport =new  SchemaExport(cfg);
            
            schemaExport.setOutputFile("hbd2ddl.sql");
            schemaExport.create(true, true);
            out.println("Schema Exported");
    %>
     
</body>
</html>
