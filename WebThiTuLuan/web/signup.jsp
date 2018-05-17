<%-- 
    Document   : signup
    Created on : May 9, 2018, 9:30:25 AM
    Author     : Rio.Rai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp Page</title>

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

        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var x_timer;
                $("#username").keyup(function (e) {
                    clearTimeout(x_timer);
                    var user_name = $(this).val();
                    x_timer = setTimeout(function () {
                        check_username_ajax(user_name);
                    }, 1000);
                });

                function check_username_ajax(username) {
                    $("#user-result").html('<img src="login/img/ajax-loader.gif" />');
                    $.post('CheckUserNameServlet', {'username': username}, function (data) {
                        $("#user-result").html(data);
                    });
                }
            });
        </script>

        <script type="text/javascript">
            $(document).ready(function ()
            {
                $('#form').submit(function () {

                    // BƯỚC 1: Lấy dữ liệu từ form
                    var password = $.trim($('#pass').val());
                    var re_password = $.trim($('#cfpass').val());

                    // BƯỚC 2: Validate dữ liệu
                    // Biến cờ hiệu
                    var flag = true;


                    // Re password
                    if (password !== re_password) {
                        $('#re_password_error').text("Your password don't math");
                        flag = false;
                    } else {
                        $('#re_password_error').text('');
                    }

                    return flag;
                });
            });
        </script>
        <!-------------------------------->
    </head>
    <body>

        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100 p-t-50 p-b-90">
                    <form class="login100-form validate-form flex-sb flex-w" action="SignupServlet" method="POST" id="form">
                        <span class="login100-form-title p-b-51">
                            SIGN UP
                        </span>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
                            <input class="input100" type="text" name="username" placeholder="Username" id="username"><span id="user-result"></span>
                            <span class="focus-input100"></span>
                        </div>


                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="pass" id="pass" placeholder="Password">
                            <span class="focus-input100"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input class="input100" type="password" name="cfpass" id="cfpass" placeholder="Confirm Password">
                            <span class="focus-input100"></span>
                            <span id="re_password_error" style="color: red"></span>
                        </div>

                        <div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
                            <input type="radio" name="type" value="student"> Student  
                            <input type="radio" name="type" value="teacher"> Teacher
                        </div>

                        <div class="container-login100-form-btn m-t-17">
                            <button type="submit" class="login100-form-btn" value="signup">
                                Sign Up
                            </button>
                        </div>

                    </form>
                </div>
            </div>
        </div>



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
