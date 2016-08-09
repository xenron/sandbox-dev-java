<%@ page language="java" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>Ajax on Java Chapter 7, Ajax Tags</title>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.2/prototype-1.4.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.2/scriptaculous.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.2/overlibmws.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.2/ajaxtags.js"></script>

  <link rel="stylesheet" type="text/css" href="css/ajaxtags-sample.css" />
  <style>
  Table.Product {border: solid 2px; border-color:#CCFF66;}
  TD.Product{background-color:#CCCCFF;border: solid 2px; color:#000099}
  TH.Product{background-color:#000099; color:#CCCCFF}

  Table.User {border: solid 2px; border-color:#CCFF66;}
  TR.UserDark {background-color:#CCCCFF;border: solid 2px; color:#6666CC}
  TR.UserLight {background-color:#CCFFFF;border: solid 2px; color:#6666CC}
  TH.User {background-color:#6666CC; color:#CCCCFF}

  Table.Cart {border: solid 2px; border-color:#339966;}
  TR.CartLight {background-color:#CCCCFF;border: solid 2px; color:#336666}
  TR.CartDark {background-color:#33FF99;border: solid 2px; color:#336666}
  TH.Cart {background-color:#336666; color:#CCCCFF}
  </style>
</head>

<body>
<h1>AjaxTags Tab Panel Tag Demo</h1>

<div>


<ajax:tabPanel
    panelStyleId="tabPanel"
    contentStyleId="tabContent"
    panelStyleClass="tabPanel"
    contentStyleClass="tabContent"
    currentStyleClass="ajaxCurrentTab">
  <ajax:tab caption="Users"
    baseUrl="${pageContext.request.contextPath}/tabcontent?tab=Users"
    defaultTab="true"/>
  <ajax:tab caption="Shopping Carts"
    baseUrl="${pageContext.request.contextPath}/tabcontent"
    parameters="tab=Carts"/>
  <ajax:tab caption="Products"
    baseUrl="${pageContext.request.contextPath}/tabcontent"
    parameters="tab=Products"/>
</ajax:tabPanel>

</div>
</body>
</html>

