<%-- 
    Document   : home
    Author     : Osama Oransa
    Create For : Java Enterprise Edition 7 Performance Tuning (EN6428)
--%>

<%@page import="osa.ora.jpa.ProductReviews"%>
<%@page import="java.util.List"%>
<%@page import="osa.ora.jpa.Category"%>
<%@page import="osa.ora.jpa.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Catalog</title>
        <script language="JavaScript" src="js/ajax_call.js"></script>
    </head>
    <% Product[] products=(Product[])session.getAttribute("PRODUCTS");%>
    <% Category[] categories=(Category[])session.getAttribute("CATEGORIES");%>
    <body>
        <h1>Product Catalog</h1>
        <form action="Browse" method="post">
        <table>
            <tr>
                <td style="background-color: ">                    
                    Product Categories
                </td>
                <td>
                    <select id="category" name="category">                        
                        <option value="0">All</option>
                        <% for(int i=0;i<categories.length;i++){ %>
                        <option value="<%= categories[i].getId() %>"><%= categories[i].getName() %></option>
                        <% } %>
                    </select>
                </td>
                <td>                    
                    Price
                </td>
                <td>
                    <select id="price" name="price">
                        <option value="0">All</option>
                        <option value="1">Less than 50</option>
                        <option value="2">Less than 100</option>
                        <option value="3">Less than 150</option>
                        <option value="4">Less than 200</option>
                        <option value="5">Less than 1000</option>
                      </select>
                </td>
                <td>                    
                    Search
                </td>
                <td>
                    <input id="keyword" name="keyword"/>
                </td>
                <td>
                    <input type="submit" value="Refresh">
                </td>
                <td>
                    <image style="vertical-align: middle" src="images/basket.png"/> <label id="counter" name="counter">(0)</label>
                </td>
            </tr>
        </table>
        <table style="border:1px solid green;">
            <% for(int i=0;i<products.length;i+=2){ %>
            <tr>
                <td><image src="ImageRender?imgProductId=<%= products[i].getId()%>"/></td>
                <td colspan="2">
                    <table>
                        <tr><td><%= products[i].getName()%></td></tr>
                        <% 
                          int rate=0;
                          List reviews=products[i].getProductReviewsList();
                          if(reviews!=null && reviews.size()>0){
                              for(int l=0;l<reviews.size();l++){
                                rate+=((ProductReviews)reviews.get(l)).getStars();
                              }
                              rate=rate/reviews.size();
                          }
                          String imageName="";
                          switch(rate){
                              case 5:
                                  imageName="images/5stars.png";
                                  break;
                              case 4:
                                  imageName="images/4stars.png";
                                  break;
                              case 3:
                                  imageName="images/3stars.png";
                                  break;
                              case 2:
                                  imageName="images/2stars.png";
                                  break;
                              case 1:
                                  imageName="images/1stars.png";
                                  break;
                              default:
                                  imageName="images/0stars.png";
                                  break;
                          }
                        %>
                        <tr><td><img style="vertical-align: middle" src="<%= imageName %>"/> (<%= reviews.size()%>)</td></tr>
                        <tr><td>Price : <%= products[i].getPrice()%> &nbsp;&nbsp;<img src="images/cart_add.gif" style="cursor: pointer;" onclick="addToBasket(<%= products[i].getId() %>)"/></td></tr>
                        <tr><td>Delivered in <%= products[i].getShippingDays()%> day(s)</td></tr>
                        <tr><td>This product since: <%= products[i].getStartDate()%></td></tr>
                        <tr><td><%= products[i].getDescription()%></td></tr>
                        <tr><td><a href="specs.jsp?id=<%= products[i].getId() %>" target="_blank">Product Specifications</a></td></tr>
                    </table>
                </td>
                <% if(i+1<products.length) { %>
                <td><image src="ImageRender?imgProductId=<%= products[i+1].getId()%>"/></td>
                <td colspan="2">
                    <table>
                        <tr><td><%= products[i+1].getName()%></td></tr>
                        <% 
                          rate=0;
                          reviews=products[i+1].getProductReviewsList();
                          if(reviews!=null && reviews.size()>0){
                              for(int l=0;l<reviews.size();l++){
                                rate+=((ProductReviews)reviews.get(l)).getStars();
                              }
                              rate=rate/reviews.size();
                          }
                          imageName="";
                          switch(rate){
                              case 5:
                                  imageName="images/5stars.png";
                                  break;
                              case 4:
                                  imageName="images/4stars.png";
                                  break;
                              case 3:
                                  imageName="images/3stars.png";
                                  break;
                              case 2:
                                  imageName="images/2stars.png";
                                  break;
                              case 1:
                                  imageName="images/1stars.png";
                                  break;
                              default:
                                  imageName="images/0stars.png";
                                  break;
                          }
                        %>
                        <tr><td><img style="vertical-align: middle" src="<%= imageName %>"/> (<%= reviews.size()%>)</td></tr>
                        <tr><td>Price : <%= products[i+1].getPrice()%> &nbsp;&nbsp;<img src="images/cart_add.gif" style="cursor: pointer;" onclick="addToBasket(<%= products[i+1].getId() %>)"/></td></tr>
                        <tr><td>Delivered in <%= products[i+1].getShippingDays()%> day(s)</td></tr>
                        <tr><td>This product since: <%= products[i+1].getStartDate()%></td></tr>
                        <tr><td><%= products[i+1].getDescription()%></td></tr>
                        <tr><td><a href="specs.jsp?id=<%= products[i+1].getId() %>" target="_blank">Product Specifications</a></td></tr>
                    </table>                    
                </td>
                <% } %>
            </tr>
            <tr>
                <td colspan="6"><hr></td>
            </tr>
            <%   if(i>=products.length) break; %>
            <% } %>
        </table>
        </form>
    </body>
</html>
