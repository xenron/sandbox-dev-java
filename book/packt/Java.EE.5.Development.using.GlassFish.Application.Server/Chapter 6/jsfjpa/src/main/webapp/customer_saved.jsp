<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Saved Successfully</title>
</head>
<body>
<p>The following data was saved to the database:</p>
<f:view>
  <table cellpadding="0" cellspacing="0" border="0">
    <tr>
      <td align="left">Customer Id:&nbsp;</td>
      <td align="left"><h:outputText value="#{Customer.customerId}"></h:outputText></td>
    </tr>
    <tr>
      <td align="left">First Name:&nbsp;</td>
      <td align="left"><h:outputText value="#{Customer.firstName}"></h:outputText>
      </td>
    </tr>
    <tr>
      <td align="left">Last Name:&nbsp;</td>
      <td align="left"><h:outputText value="#{Customer.lastName}"></h:outputText>
      </td>
    </tr>
    <tr>
      <td align="left">Email:&nbsp;</td>
      <td align="left"><h:outputText value="#{Customer.email}"></h:outputText>
      </td>
    </tr>
  </table>
</f:view>
</body>
</html>
