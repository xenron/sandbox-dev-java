<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="/WEB-INF/oreillyAjax.tld" prefix="ajax" %>
<html>
<HEAD>
<H1> O'Reilly Ajax with Custom Tags</H1>
</HEAD>
<body>
Enter the zip code, then TAB.<br />
The State and City fields will automatically populate.<br />
<ajax:zipCode zipcodeId="zipcode" stateId="state" cityId="city" url="zipcodes" />
<table>
  <tr>
    <td> Zipcode:  </td>
    <td> <input type="text" id="zipcode" onblur="retrieveCityState()"/> </td>
  </tr>
  <tr>
    <td> City: </td>
    <td> <input type="text" id="city" /> </td>
  </tr> 
  <tr>
    <td> State:  </td>
    <td> <input type="text" id="state" /><br /> </td>
  </tr>
 </table>
</body>
</html>