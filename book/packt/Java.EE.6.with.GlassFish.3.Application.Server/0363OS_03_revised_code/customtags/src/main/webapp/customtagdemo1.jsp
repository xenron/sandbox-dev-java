<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib prefix="d" uri="DemoTagLibrary"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Tag Demo</title>
</head>
<body>
<form>
<table>
  <d:labeledTextField label="Line 1" name="line1" value="This is line 1"></d:labeledTextField>
  <d:labeledTextField label="Line 2" name="line2"></d:labeledTextField>
  <d:labeledTextField label="City" name="city"></d:labeledTextField>
  <d:labeledTextField label="State" name="state"></d:labeledTextField>
  <d:labeledTextField label="Zip" name="zip"></d:labeledTextField>
  <tr>
    <td></td>
    <td><input type="submit" value="Submit"></td>
  </tr>
</table>
</form>
</body>
</html>
