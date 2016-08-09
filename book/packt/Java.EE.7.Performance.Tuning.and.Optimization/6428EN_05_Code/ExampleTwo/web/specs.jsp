<%-- 
    Document   : specs
    Author     : Osama Oransa
    Create For : Java Enterprise Edition 7 Performance Tuning (EN6428)
--%>

<%@page import="osa.ora.jpa.ProductReviews"%>
<%@page import="java.util.List"%>
<%@page import="osa.ora.jpa.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Specifications</title>
    </head>
    <body>
        <h1>Product Specifications</h1>
        <% Product[] products=(Product[])session.getAttribute("PRODUCTS");%>
        <% int productId=Integer.parseInt(request.getParameter("id")); %>
        <table style="border:1px solid green;">
            <% for(int i=0;i<products.length;i++){ 
               if(products[i].getId()==productId){
            %>
            <tr>
                <td style="vertical-align: top"><image src="ImageRender?imgProductId=<%= products[i].getId()%>"/></td>
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
                        <tr><td>Product Specifications: <br>
                        <%     
                            for(int n=0;n<products[i].getProductSpecificationsList().size();n++){
                               out.println("<li>"+products[i].getProductSpecificationsList().get(n).getSpecifications().getName()+
                                       " : "+ products[i].getProductSpecificationsList().get(n).getValue());
                            }
                            %>
                        <hr>
                         </td></tr>
                        <tr><td>User Reviews: <br><hr>
                        <%  if(reviews.size()==0){
                                out.println("<div>Be the first to review this product.</div>");
                            }   
                            for(int n=0;n<reviews.size();n++){
                                switch(((ProductReviews)reviews.get(n)).getStars()){
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
                               out.println("<img src='"+imageName+"'/> "+((ProductReviews)reviews.get(n)).getName()+
                                       " : <br><div>"+ ((ProductReviews)reviews.get(n)).getComment() +
                                       "</div><br>On "+((ProductReviews)reviews.get(n)).getDate()+"<hr>");
                            }
                            %>
                        <hr>
                         </td></tr>
                    </table>
                </td>
            <%}
            } %>                
            </tr>
        </table>
    </body>
</html>
