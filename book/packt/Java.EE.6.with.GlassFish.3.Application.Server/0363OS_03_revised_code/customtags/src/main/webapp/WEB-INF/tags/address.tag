<%@ tag language="java"%>
<%@attribute name="addressType" required="true" %>
<jsp:useBean id="address" scope="request"
  class="net.ensode.glassfishbook.customtags.AddressBean" />
<table cellpadding="0" cellspacing="0" border="0">
  <tr>
    <td align="right" width="70"><b>Line 1</b>&nbsp;</td>
    <td><input type="text" name="${addressType}_line1" size="30"
      maxlength="100" value="${address.line1}"></td>
  </tr>
  <tr>
    <td align="right"><b>Line 2</b>&nbsp;</td>
    <td><input type="text" name="${addressType}_line2" size="30"
      maxlength="100" value="${address.line2}"></td>
  </tr>
  <tr>
    <td align="right"><b>City</b>&nbsp;</td>
    <td><input type="text" name="${addressType}_city" size="30"
      value="${address.city}"></td>
  </tr>
  <tr>
    <td align="right"><b>State</b>&nbsp;</td>
    <td><select name="${addressType}_state">
      <option value=""></option>
      <option value="AL"
        <% if(address.getState().equals("AL")) out.print (" selected "); %>>Alabama</option>
      <option value="AK"
        <% if(address.getState().equals("AK")) out.print (" selected "); %>>Alaska</option>
      <option value="AZ"
        <% if(address.getState().equals("AZ")) out.print (" selected "); %>>Arizona</option>
      <option value="AR"
        <% if(address.getState().equals("AR")) out.print (" selected "); %>>Arkansas</option>
      <option value="CA"
        <% if(address.getState().equals("CA")) out.print (" selected "); %>>California</option>
      <option value="CO"
        <% if(address.getState().equals("CO")) out.print (" selected "); %>>Colorado</option>
      <option value="CT"
        <% if(address.getState().equals("CT")) out.print (" selected "); %>>Conneticut</option>
      <option value="DC"
        <% if(address.getState().equals("DC")) out.print (" selected "); %>>District
      of Columbia</option>
      <option value="FL"
        <% if(address.getState().equals("FL")) out.print (" selected "); %>>Florida</option>
    </select></td>
  </tr>
  <tr>
    <td align="right"><b>Zip</b>&nbsp;</td>
    <td><input type="text" name="${addressType}_zip" size="5"
      value="${address.zip}"></td>
  </tr>
</table>
