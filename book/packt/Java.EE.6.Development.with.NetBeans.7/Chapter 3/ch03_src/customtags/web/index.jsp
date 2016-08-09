<%-- 
    Document   : index
    Created on : Aug 30, 2010, 8:05:40 PM
    Author     : heffel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="ct" tagdir="/WEB-INF/tags/" %>
<%@ page import="com.ensode.netbeansbook.AddressBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
            AddressBean addressBean = new AddressBean();

            addressBean.setAddressType("home");
            addressBean.setLine1("123 Tennis Ct");
            addressBean.setCity("Phoenix");
            addressBean.setState("AZ");
            addressBean.setZip("85001");

            session.setAttribute("addressBean", addressBean);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form>
            <ct:address addressType="home"/>
            <table cellpadding="0" cellspacing="0" border="0">
                <tr>
                    <td style="width:65px;"></td>
                    <td>
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
