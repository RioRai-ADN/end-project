<%-- 
    Document   : viewQ
    Created on : May 10, 2018, 10:45:21 AM
    Author     : Rio.Rai
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.CauHoi"%>
<%@page import="dao.QuestDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Quest Page</title>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
        
        <%
            QuestDao qd = new QuestDao();
            
            ArrayList<CauHoi> list = qd.getQuestionList();
            
            if(request.getParameter("delete")!=null)
            {
                qd.deleteQuestionBy(Integer.parseInt(request.getParameter("delete")));
                list = qd.getQuestionList();
            }
        %>

        <h2 style="margin-left: 550px">Questions List</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Serial</th>
                    <th scope="col" style="width: 400px">Quest</th>
                    <th scope="col" style="width: 180px">Answer</th>
                    <th scope="col">Feature</th>
                </tr>
            </thead>
            <tbody>
                <% for(int i = 0; i < list.size(); i++) { %>
                <tr>
                    <th scope="row"><%=i %></th>
                    <td><%=list.get(i).getSttCauHoi() %></td>
                    <td><%=list.get(i).getNoiDungCauHoi() %></td>
                    <td><%=list.get(i).getCauTraLoiChinhXac() %></td>
                    <td>
                        <a href="viewQ.jsp?delete=<%=list.get(i).getSttCauHoi() %>"><button type="button" class="btn btn-danger">Delete</button></a>
                        <a href="edit.jsp?edit=<%=list.get(i).getSttCauHoi() %>"><button type="button" class="btn btn-info">Edit</button></a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
