<%-- 
    Document   : index
    Created on : May 17, 2018, 1:23:21 PM
    Author     : Rio.Rai
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index Page</title>
    </head>
    <body>

        <%
            CategoryDao cd = new CategoryDao();
            ArrayList<Category> l = cd.getCategoryList();
            
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">CategoryID</th>
                    <th scope="col">CategoryName</th>
                    
                </tr>
            </thead>
            <tbody>
                
                <% for(int i = 0; i < l.size(); i++) { %>
                <tr>
                    <th scope="row"><%=i%></th>
                    <td><%=l.get(i).getCatId() %></td>
                    <td><%=l.get(i).getCatName() %></td>
                    
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
