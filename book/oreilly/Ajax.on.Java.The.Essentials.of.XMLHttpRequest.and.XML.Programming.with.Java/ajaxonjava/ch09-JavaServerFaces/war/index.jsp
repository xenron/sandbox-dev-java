
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://ajax.oreilly.com/jsf/ajax" prefix="ajax" %>
<html>
  <f:view>
    <head>
      <title>JSF Page</title>
    </head>
    <body>
      <h:form>
        <h3>JavaServer Faces: State and City Lookup with Ajax</h3>
        <ajax:zipCode zipcodeId="zipcode" stateId="state" cityId="city" url="zipcodes" />
      </h:form>
    </body>
  </f:view>
</html>         
                                