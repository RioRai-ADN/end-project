<%-- 
    Document   : edit
    Created on : May 16, 2018, 3:07:34 PM
    Author     : Rio.Rai
--%>

<%@page import="model.CauHoi"%>
<%@page import="dao.QuestDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <%
            QuestDao qd = new QuestDao();
            int stt = 0;
            if(request.getParameter("edit")!=null)
                stt = Integer.parseInt(request.getParameter("edit"));
            
            CauHoi ch = qd.getQuestionBy(stt);
        %>
        
        <form style="padding-left: 125px; padding-right: 800px;" action="EditServlet?serial=<%=ch.getSttCauHoi() %>" method="POST">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Input Quest</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="question"><%=ch.getNoiDungCauHoi() %></textarea>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput1">Input Answer</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="answer" style="height: 40px"><%=ch.getCauTraLoiChinhXac() %></textarea>
            </div>

            <button type="submit" class="btn btn-success">Edit</button>

            <a href="manager.jsp"><button type="button" class="btn btn-secondary">Cancle</button></a>       


        </form>
    </body>
</html>
