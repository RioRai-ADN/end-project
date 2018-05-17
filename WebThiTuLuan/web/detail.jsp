<%-- 
    Document   : detail
    Created on : May 15, 2018, 8:21:23 PM
    Author     : Rio.Rai
--%>

<%@page import="model.CauHoi"%>
<%@page import="model.TraLoi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.AnswerDao"%>
<%@page import="dao.QuestDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <%
            QuestDao questDao = new QuestDao();
            AnswerDao answerDao = new AnswerDao();
            
            String userName = "";
            
            if (request.getParameter("user")!= null)
                userName = request.getParameter("user");
            
            ArrayList<TraLoi> list = answerDao.getAnswerListOf(userName);
        %>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col" style="width: 500px">Question</th>
                    <th scope="col">Answer</th>
                    <th scope="col">Correct Answer</th>
                </tr>
            </thead>
            <tbody>
                <%
                    String answer = "", question = "";
                    int stt;
                    for(int i = 0; i < list.size(); i++) {
                        stt = list.get(i).getSttCauHoi();
                        CauHoi ch = questDao.getQuestionBy(stt);
                    
                %>
                <tr>
                    <th scope="row"><%=i+1 %></th>
                    <td><%=ch.getNoiDungCauHoi() %></td>
                    <td><%=list.get(i).getCauTraLoi() %></td>
                    <td><%=ch.getCauTraLoiChinhXac() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
