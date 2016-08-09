function newProduct() 
{
  ProductManager.addProduct(populateData)
}
function populateData()
{
  ProductManager.getJSONProducts(updateProductList);
}
function updateProductList(jsonData){
  var myJSONObject = eval('(' + jsonData + ')');
  productsdiv = document.getElementById('products');
  var output = "<table id='myTable' class='tableWrapper'>"+
                  "<tbody id='myTbody'><tr><td class='trh'>&nbsp;</td>"+
                    "<td class='trh'>Product Name</td>"+
                    "<td class='trh'>Description</td>"+
                    "<td class='trh'>Price</td>"+
                    "<td class='trh'>Image</td>"+
                    "<td class='trh'>Change Image</td></tr>";

  for(i=0;i<myJSONObject.products.length;i++)
  {
    output += "<tr class='tr" + (i%2) + "'>";
    output += "<td class='col2'>"+
                 "<input type='image' width='50' height='50' src='images/garbagecan.png'"+
                      " value=\""+myJSONObject.products[i].id +
                      "\" onclick='deleteRow(this.value);'/></td>";
    output += "<td class='col0'><input type=\"text\" value=\""+ myJSONObject.products[i].name +
                    "\" id=\"name_"+myJSONObject.products[i].id +
                    "\" onchange=\"updateProductById("+myJSONObject.products[i].id+
                    ",\'PRODUCT_NAME\',this.value)\" /> </td>";
    output += "<td class='col1'><input type=\"text\" value=\"" 
                    + myJSONObject.products[i].description + 
                    "\" id=\"description_"+myJSONObject.products[i].id +
                    "\" onchange=\"updateProductById("+myJSONObject.products[i].id
                    +",\'DESCRIPTION\',this.value)\" /> </td>";
     output += "<td class='col2'><input type=\"text\" value=\"" + myJSONObject.products[i].price + 
                    "\" id=\"price_"+myJSONObject.products[i].id +
                    "\" onchange=\"updateProductById("+myJSONObject.products[i].id
                    +",\'PRICE\',this.value)\" /> </td>";
    output += "<td class='col2'><img width='50' height='50' src='"
                    +myJSONObject.products[i].imagepath+"' /></td>";
    output += "<td class='col3'><form name='theuploadform' method='post' action = 'uploadAction.do'" 
                    +" enctype='multipart/form-data' >"
                    +"<input id='uploadFile' type='file' name='uploadFile' value='change'"
                    +" onchange='submit()'></input>"
                    +"<input type='hidden' value='"+myJSONObject.products[i].id
                    +"' name='productId' /></form></td>";
            
  }
  output += "</tbody></table>";
  productsdiv.innerHTML = output;

}
function isNumber(allegedNumber)
{
  var numberRegExp = /(^\d+$)|(^\d+\.\d+$)/
  if(numberRegExp.test(allegedNumber)) 
  {
  	return true
  }
  else
  {
  	return false;
  }
}
function deleteRow(rowId)
{
	ProductManager.deleteRow(rowId,populateData);
}
function updateProductById(id,column,newValue) {
  if(column == 'PRICE')
  {
    if(isNumber(newValue))
      {
        ProductManager.updateProductById(id,column,newValue,populateData);
      }
      else
      {
        alert(newValue+' is not a number. Price must be a number.');
      }
   }
   else
   {
   	 ProductManager.updateProductById(id,column,newValue,populateData);
   }
}
function uploadFile(formdata)
{
  filename = formdata.form.filename.value;
  alert('uploading file'+filename);
  formdata.form.submit();
}
