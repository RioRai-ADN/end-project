<%-- 
    Document   : content
    Created on : May 10, 2018, 10:28:33 AM
    Author     : Rio.Rai
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.TaiKhoan"%>
<%@page import="dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Content Page</title>
    </head>
    <body>

        <%
            UserDao userDao = new UserDao();
            ArrayList<TaiKhoan> list = userDao.getUserList();

            if (request.getParameter("comment") != null) {

                list = userDao.getUserListAnswered();
            }
        %>
        <h2 style="margin-left: 550px">Students List</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">UserName</th>
                    <th scope="col">Password</th>
                    <th scope="col">Type</th>
                    <th scope="col">Feature</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < list.size(); i++) {%>
                <tr>

                    <th scope="row"><%=i + 1%></th>
                    <td><div id="username"><%=list.get(i).getUserName()%></div></td>
                    <td><%=list.get(i).getPassWord()%></td>
                    <td><%=list.get(i).getType()%></td>
                    <td>
                        <a href="detail.jsp?user=<%=list.get(i).getUserName() %>"><button type="button" class="btn btn-outline-info">Detail</button></a>
                    </td>
                </tr>
            <% }%>
        </tbody>
    </table>
    <script>
        $(document).click()(function () {

            var user = document.getElementById("username");
            $("tr").click(function () {
                document.location.href = "content.jsp?user="+user;
            });
        });
    </script>
</body>
</html>
