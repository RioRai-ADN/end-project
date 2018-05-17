<%-- 
    Document   : welcome
    Created on : May 10, 2018, 7:25:35 AM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="login/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="login/css/util.css">
        <link rel="stylesheet" type="text/css" href="login/css/main.css">

    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-t-50 p-b-90">
                    <form class="login100-form validate-form flex-sb flex-w" action="LoadQuestToClientServlet" method="POST">
                        <span class="login100-form-title p-b-51">
                            WELCOME TO EXAM TEST
                        </span>

                        <div class="container-login100-form-btn m-t-17">
                            <button type="submit" class="login100-form-btn" value="ready">
                                Ready to Start!
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
