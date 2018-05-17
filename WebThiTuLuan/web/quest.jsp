<%-- 
    Document   : quest
    Created on : May 11, 2018, 6:29:50 PM
    Author     : Rio.Rai
--%>

<%@page import="model.TraLoi"%>
<%@page import="model.CauHoi"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question Page</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </head>
    <body>
        <%
            ArrayList<CauHoi> list = null;

            ArrayList<TraLoi> aw = null;

            String name = "";
            if (session.getAttribute("userName") != null) {
                name = session.getAttribute("userName").toString();
            }

            int i = 0;
            if (session.getAttribute("i") != null) {
                i = (int) session.getAttribute("i");
            }

            if (session.getAttribute("question") != null) {
                list = (ArrayList<CauHoi>) session.getAttribute("question");
            }

            if (session.getAttribute("answer") != null) {
                aw = (ArrayList<TraLoi>) session.getAttribute("answer");
            }

        %>

        <form style="padding-left: 200px; padding-right: 200px " action="NextBackServlet?iq=<%=i%>" method="POST">
            <h3><%=name%></h3>
            <h4>Question <%=i + 1%></h4>
            <div class="alert alert-primary" role="alert">
                <%=list.get(i).getNoiDungCauHoi()%>
            </div>
            <div class="form-group">
                <label for="exampleFormControlTextarea1">Your Answers</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="answer"><%=aw.get(i).getCauTraLoi()%></textarea>
            </div>

            <button type="submit" class="btn btn-outline-primary" name="btn_click" value="previous">Previous</button>
            <button type="submit" class="btn btn-outline-primary" name="btn_click" value="next">Next</button>

            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                Finished
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">DANGER!</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure to finish the exam!
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="btn_click" value="finish">Yes</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
