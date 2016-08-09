<%@page contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page	import="org.jboss.springmvc.model.Catalog,org.jboss.springmvc.data.CatalogDao,org.jboss.springmvc.controller.CatalogController"%>
<jsp:useBean id="catalogDao" type="org.jboss.springmvc.data.CatalogDao"
	scope="request" />
<!--scope should be request for the bean to be found  -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC-JPA Catalog</title>
</head>
<!-- action should be same as the mapping in the controller -->
<body>
	<h2>Catalog form</h2>
	<form method="POST" action="catalog">
		<table>
			<tr>
				Journal:
				<input type="text" name="journal" />
			</tr>
			<tr>
				Publisher:
				<input type="text" name="publisher" />
			</tr>
			<tr>
				Edition:
				<input type="text" name="edition" />
			</tr>
			<tr>
				Title:
				<input type="text" name="title" />
			</tr>
			<tr>
				Author:
				<input type="text" name="author" />
			</tr>
		</table>
		<p>
			<input type="submit" value="Add" />
		</p>
	</form>
	<table>
		<%
			for (Catalog catalog : catalogDao.getAllCatalogs()) {
		%>
		<tr>
			<td><%=catalog.getId()%></td>
			<td><%=catalog.getJournal()%></td>
			<td><%=catalog.getPublisher()%></td>
			<td><%=catalog.getEdition()%></td>
			<td><%=catalog.getTitle()%></td>
			<td><%=catalog.getAuthor()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>
