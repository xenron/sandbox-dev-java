<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<html>
<head>
<title>AJAX DWR Product Manager</title>
<script src='dwr/interface/ProductManager.js'></script>
<script src='dwr/engine.js'></script>
<script src='dwr/util.js'></script>
<script src='scripts/oreillyProductManager.js'></script>


<!--  see http://www.oreillynet.com/pub/a/javascript/2003/05/06/dannygoodman.html?page=2 -->
   <style type="text/css">
.tableWrapper {text-align:center; width:80%; border:0; border-color:#000000}
.trh {background-color:#666666; color:#ffffff}
.tr0 {background-color:#cccccc; color:#000000}
.tr1 {background-color:#ffffff; color:#000000}
.col0 {width:25%}
.col1 {width:25%}
.col2 {width:25%}
.col3 {width:25%}
.productlist {border:1; border-color:#cccccc;}

</style>   

</head>
<body onload='populateData()'>
<div>
 <h1><center>Product Manager (Struts with DWR)</center></h1>
 <table>

  <tr>
    <td> <input type="button" value="Add A Product" name="name" onclick="newProduct()" /></td>
  </tr>


</table>
</div>
            <div id="products" class="productlist">
      
            </div>
 </body>
 </html>
