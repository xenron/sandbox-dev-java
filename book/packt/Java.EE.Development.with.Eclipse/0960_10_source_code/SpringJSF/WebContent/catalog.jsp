<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" version="2.0">
    <jsp:output omit-xml-declaration="true" doctype-root-element="HTML" doctype-system="http://www.w3.org/TR/html4/loose.dtd" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN"/>
    <jsp:directive.page language="java"
        contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" />
  
<f:view>
    <html>
      <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=ISO-8859-1"/>
        <title>Catalog</title>
      </head>
      <body>
        <h:form><table>
        
          <tr><td> <h:outputText value="#{catalogBean.journal}"/></td></tr>
           <tr><td><h:outputText value="#{catalogBean.publisher}"/></td></tr>
          <tr><td> <h:outputText value="#{catalogBean.edition}"/></td></tr>
           <tr><td><h:outputText value="#{catalogBean.title}"/></td></tr>
           <tr><td><h:outputText value="#{catalogBean.author}"/></td></tr>
        
        </table></h:form>
      </body>
    </html>
  </f:view>

</jsp:root>
