<html>
<head>
<script type="text/javascript">
	function validateCatalogId() {
		var xmlHttpRequest = init();
		function init() {

			if (window.XMLHttpRequest) {
				return new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				return new ActiveXObject("Microsoft.XMLHTTP");
			}

		}
		var catalogId = document.getElementById("catalogId");
		xmlHttpRequest.open("GET", "AjaxFormServlet?catalogId="
				+ encodeURIComponent(catalogId.value), true);
		xmlHttpRequest.onreadystatechange = processRequest;
		xmlHttpRequest.send(null);

		function processRequest() {
			if (xmlHttpRequest.readyState == 4) {
				if (xmlHttpRequest.status == 200) {
					processResponse();
				}
			}
		}
		function processResponse() {
			var xmlMessage = xmlHttpRequest.responseXML;
			var valid = xmlMessage.getElementsByTagName("valid")[0].firstChild.nodeValue;
			if (valid == "true") {
				var validationMessage = document
						.getElementById("validationMessage");
				validationMessage.innerHTML = "Catalog Id is Valid";
				document.getElementById("submitForm").disabled = false;
				var journalElement = document.getElementById("journal");
				journalElement.value = "";
				var publisherElement = document.getElementById("publisher");
				publisherElement.value = "";
				var editionElement = document.getElementById("edition");
				editionElement.value = "";
				var titleElement = document.getElementById("title");
				titleElement.value = "";
				var authorElement = document.getElementById("author");
				authorElement.value = "";
			}
			if (valid == "false") {
				var validationMessage = document
						.getElementById("validationMessage");
				validationMessage.innerHTML = "Catalog Id is not Valid";
				document.getElementById("submitForm").disabled = true;

				var journal = xmlMessage.getElementsByTagName("journal")[0].firstChild.nodeValue;
				var publisher = xmlMessage.getElementsByTagName("publisher")[0].firstChild.nodeValue;
				var edition = xmlMessage.getElementsByTagName("edition")[0].firstChild.nodeValue;
				var title = xmlMessage.getElementsByTagName("title")[0].firstChild.nodeValue;
				var author = xmlMessage.getElementsByTagName("author")[0].firstChild.nodeValue;

				var journalElement = document.getElementById("journal");
				journalElement.value = journal;

				var publisherElement = document.getElementById("publisher");
				publisherElement.value = publisher;

				var editionElement = document.getElementById("edition");
				editionElement.value = edition;

				var titleElement = document.getElementById("title");
				titleElement.value = title;

				var authorElement = document.getElementById("author");
				authorElement.value = author;
			}
		}
	}
</script>


</head>
<body>
	<h1>Form for Catalog Entry</h1>
	<form name="AjaxFormServlet" action="AjaxFormServlet" method="post">
		<table>
			<tr>
				<td>Catalog Id:</td>
				<td><input type="text" size="20" id="catalogId"
					name="catalogId" onkeyup="validateCatalogId()"></td>
				<td><div id="validationMessage"></div></td>
			</tr>


			<tr>
				<td>Journal:</td>
				<td><input type="text" size="20" id="journal" name="journal"></td>
			</tr>

			<tr>
				<td>Publisher:</td>
				<td><input type="text" size="20" id="publisher"
					name="publisher"></td>
			</tr>

			<tr>
				<td>Edition:</td>
				<td><input type="text" size="20" id="edition" name="edition"></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><input type="text" size="20" id="title" name="title"></td>
			</tr>

			<tr>
				<td>Author:</td>
				<td><input type="text" size="20" id="author" name="author"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create Catalog" id="submitForm"
					name="submitForm"></td>
			</tr>
		</table>
	</form>
</body>
</html>
