<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    String adminID = (String) session.getAttribute("adminID");
    if (adminID == null || adminID.isEmpty()) {
        response.sendRedirect("loginPage.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Parking Slots</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->  
    <link rel="icon" type="image/png" href="CSS/images/icons/favicon.ico"/>
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/vendor/animate/animate.css">
<!--===============================================================================================-->  
    <link rel="stylesheet" type="text/css" href="CSS/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/vendor/select2/select2.min.css">
<!--===============================================================================================-->  
    <link rel="stylesheet" type="text/css" href="CSS/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="CSS/css/util.css">
    <link rel="stylesheet" type="text/css" href="CSS/css/main.css">
<!--===============================================================================================-->
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body>
    <div class="container-logout30-form-btn">
        <form class="adminLogout" method="get" action="LogOutServlet">
            <button class="logOut10-form-btn">LogOut</button>
        </form>
    </div>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100 p-t-50 p-b-90">
                <form class="adminLogin" method="post" action = "SlotsServlet">
                    <span class="login100-form-title p-b-51">
                        Parking Slots
                    </span>
                    
                    
                    <div class="wrap-input100 validate-input m-b-16" data-validate = "Positive Integer is required">
                        <input class="input100" type="number" name="noOfSlots" placeholder="Enter No Of Slots">
                        <span class="focus-input100"></span>
                    </div>

                    <div class="submitButton">
                        <button class="login100-form-btn">
                            Submit
                        </button>
                    </div>
                    <%
                    String message = (String)request.getAttribute("message");
                    if(message!=null) {
                        out.println(message);
                    }
                    %>

                </form>
            </div>
        </div>
    </div>
    

    <div id="dropDownSelect1"></div>
    
<!--===============================================================================================-->
    <script src="CSS/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
    <script src="CSS/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
    <script src="CSS/vendor/bootstrap/js/popper.js"></script>
    <script src="CSS/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
    <script src="CSS/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
    <script src="CSS/vendor/daterangepicker/moment.min.js"></script>
    <script src="CSS/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
    <script src="CSS/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
    <script src="CSS/js/main.js"></script>

</body>
</html>