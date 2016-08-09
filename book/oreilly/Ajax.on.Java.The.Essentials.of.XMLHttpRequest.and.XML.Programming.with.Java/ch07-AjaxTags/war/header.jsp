<%-- 
 * Copyright 2005 Darren L. Spurgeon
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <title>AJAX JSP Tag Library Examples</title>

  <script type="text/javascript" src="<%=request.getContextPath()%>/js/prototype-1.3.1.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/ajaxtags-1.1.5.js"></script>
  <link rel="stylesheet" type="text/css" href="css/ajaxtags.css" />
  <link rel="stylesheet" type="text/css" href="css/displaytag.css" />
      
</head>

<body>
<c:set var="contextPath" scope="request">${pageContext.request.contextPath}</c:set>

<div id="header">AJAX JSP Tag Library Examples</div>
<div id="subheader">
  <a href="http://ajaxtags.sourceforge.net/" style="background: url(./img/external.png) right center no-repeat; padding-right: 15px;">Project website</a>
  | <a href="http://sourceforge.net/projects/ajaxtags/" style="background: url(./img/external.png) right center no-repeat; padding-right: 15px;">AjaxTags@SourceForge</a>
</div>
<div id="buildVersion">Using Project Version 1.1</div>

<div id="content">

<% if (!request.getServletPath().matches(".*index\\.jsp.*")) { %>
<div style="margin-top: 0px; padding-top: 0px; font-size: 70%">
  <a href="${contextPath}/index.jsp">&lt;&lt; Back to Index</a>
</div>
<% } %>
