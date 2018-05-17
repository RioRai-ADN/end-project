<%-- 
    Document   : login
    Created on : May 9, 2018, 9:08:35 AM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!-- login css -->
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

        <!-------------------------------->

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-t-50 p-b-90">
                    <form class="login100-form validate-form flex-sb flex-w" action="LoginServlet" method="POST">
                        <span class="login100-form-title p-b-51">
                            Login
                        </span>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
                            <input class="input100" type="text" name="username" placeholder="Username">
                            <span class="focus-input100"></span>
                        </div>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="pass" placeholder="Password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="flex-sb-m w-full p-t-3 p-b-24">
                            <div class="contact100-form-checkbox">
                                <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                                <label class="label-checkbox100" for="ckb1">
                                    Remember me
                                </label>
                            </div>

                            <div>
                                <a href="signup.jsp" class="txt1">
                                    SignUp?
                                </a>
                            </div>
                            
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <button class="login100-form-btn">
                                Login
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <!--Login Script-->
        <div id="dropDownSelect1"></div>

        <!--===============================================================================================-->
        <script src="login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/bootstrap/js/popper.js"></script>
        <script src="login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/daterangepicker/moment.min.js"></script>
        <script src="login/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="login/vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="login/js/main.js"></script>

        <!---------------------------->
    </body>
</html>
