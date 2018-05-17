<%-- 
    Document   : addS
    Created on : May 11, 2018, 5:25:40 PM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Student Page</title>
    </head>
    <body>
        <%
            String message = "";
            if(session.getAttribute("message")!= null)
                message = session.getAttribute("message").toString();
        %>

        <jsp:include page="header.jsp"></jsp:include>

        <h2 style="margin-left: 200px; ">Addition Student</h2>

        <form action="AddStudentServlet" method="POST" style="margin-left: 100px; margin-right: 800px">
            <div class="form-group">
                <label for="exampleInputEmail1">User Name</label>
                <input type="text" class="form-control" name="username" placeholder="UserName">
                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pass">

                <input type="radio" value="student" name="type">Student
                <input type="radio" value="teacher" name="type">Teacher
            </div>

            <div id="message"><%=message %></div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
