<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
</head>

<body>
	<h1>Hibernate with Struts 2 integration</h1>

	<h2>Add Film</h2>
	<s:form action="addFilmAction">
		<s:textfield name="name" label="Name" value="" />
		<s:textfield name="releaseYear" label="Release Year" value="" />
		<s:submit />
	</s:form>

	<h2>All Films</h2>
	<s:if test="films.size() > 0">
		<table border="1" cellpadding="3">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Release Year</th>
			</tr>
			<s:iterator value="films">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="releaseYear" /></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</body>
</html>