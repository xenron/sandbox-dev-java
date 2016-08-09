<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Save Customer</title>
</head>
<body>
<f:view>
  <h:form>
    <h:messages></h:messages>
    <table cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td align="right">First Name:</td>
        <td align="left"><h:inputText label="First Name"
          value="#{Customer.firstName}" required="true">
          <f:validateLength minimum="2" maximum="30"></f:validateLength>
        </h:inputText></td>
      </tr>
      <tr>
        <td align="right">Last Name:</td>
        <td align="left"><h:inputText label="Last Name"
          value="#{Customer.lastName}" required="true">
          <f:validateLength minimum="2" maximum="30"></f:validateLength>
        </h:inputText></td>
      </tr>
      <tr>
        <td align="right">Email:</td>
        <td align="left"><h:inputText label="Email"
          value="#{Customer.email}">
          <f:validateLength minimum="2" maximum="30"></f:validateLength>
        </h:inputText></td>
      </tr>
      <tr>
        <td></td>
        <td align="left"><h:commandButton
          action="#{CustomerController.saveCustomer}" value="Save"></h:commandButton>
        </td>
      </tr>
    </table>
  </h:form>
</f:view>
</body>
</html>
