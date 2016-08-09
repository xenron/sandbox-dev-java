<%-- 
    Document   : address
    Created on : Aug 30, 2010, 8:09:33 PM
    Author     : heffel
--%>

<%@tag description="Address Input Field" pageEncoding="UTF-8"%>
<jsp:useBean id="addressBean" scope="session" 
             class="com.ensode.netbeansbook.AddressBean"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="addressType" required="true" %>

<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td>Line 1:&nbsp;</td>
        <td> 
            <input type="text" size="20" 
                   name="${addressType}_line1" 
                   id="${addressType}_line1" 
                   value="${addressBean.line1}"/> 
        </td>
    </tr>
    <tr>
        <td>Line 2:&nbsp;</td>
        <td>
            <input type="text" size="20" 
                   name="${addressType}_line2" 
                   id="${addressType}_line2" 
                   value="${addressBean.line2}"/>
        </td>
    </tr>
    <tr>
        <td>City:&nbsp;</td>
        <td>
            <input type="text" size="20" 
                   name="${addressType}_city" 
                   id="${addressType}_city" 
                   value="${addressBean.city}"/>
        </td>
    </tr>
    <tr>
        <td>State:&nbsp;</td>
        <td>
            <select name="${addressType}_state" 
                    id="${addressType}.state">
                <option value=""></option>
                <option value="AL"
                        <c:if test="${addressBean.state == 'AL'}">
                            selected</c:if>>Alabama
                        </option>
                        <option value="AK" 
                        <c:if test="${addressBean.state == 'AK'}">
                            selected</c:if>>Alaska
                        </option>
                        <option value="AZ"
                        <c:if test="${addressBean.state == 'AZ'}">
                            selected</c:if>>Arizona
                        </option>
                        <option value="AR"
                        <c:if test="${addressBean.state == 'AR'}">
                            selected</c:if>>Arkansas</option>
                        <option value="CA"
                        <c:if test="${addressBean.state == 'CA'}">
                            selected</c:if>>California
                        </option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Zip:&nbsp;</td>
            <td><input type="text" 
                       name="${addressType}_zip" 
                id="${addressType}.zip" 
                value="${addressBean.zip}" />    
        </td>
    </tr>
</table>