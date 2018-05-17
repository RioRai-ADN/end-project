<%-- 
    Document   : addQ
    Created on : May 10, 2018, 11:11:28 AM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Addition Quest Page</title>

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

        <h2 style="margin-left: 250px"> New Question</h2>
        <form style="padding-left: 125px; padding-right: 800px;" action="AddQuestionServlet" method="POST">
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Input Quest</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="question"></textarea>
            </div>

            <div class="form-group">
                <label for="exampleFormControlInput1">Input Answer</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" name="answer">
            </div>

            <p id="demo"></p>
            
            <button type="submit" class="btn btn-success">ADD</button>

            <a href="manager.jsp"><button type="button" class="btn btn-secondary">Cancle</button></a>       

            
        </form>
        
        <script>
            function demo() {
                document.getElementById("demo").innerHTML = '<div class="alert alert-success" role="alert" id="demo">Add a quest Success!</div>';
            }
        </script>
    </body>
</html>
