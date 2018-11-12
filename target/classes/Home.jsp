<%@page import="com.epam.rdtraining.parkingservices.Parking"%>
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
<link rel="icon" type="image/png" href="CSS/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="CSS/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="CSS/css/util.css">
<link rel="stylesheet" type="text/css" href="CSS/css/main.css">
<!--===============================================================================================-->
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

table#table01 tr:nth-child(even) {
	background-color: #eee;
}

table#table01 tr:nth-child(odd) {
	background-color: #fff;
}

table#table01 th {
	background-color: black;
	color: white;
}
</style>
<script src="//code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#submit').click(function() {
        $.ajax({
            type : 'POST',
            url : 'ParkingServlet',
            data : {
		           choice : $("[name=choice]:checked").val(),
		           vehicleNo : $('#vehicleNo').val()
            },
            success : function(responseText) {
            	if ($("[name=choice]:checked").val() == 4) {
            		window.location="/AutoParkingApp/SlotsPage.jsp";
            	} else {
	               $('#displayMessage').html(responseText);
	               $('#vehicleNo').val('');
	               $("#tableDisplay").load("Home.jsp #tableDisplay"); 
            	}
            	return false;
            }
     });
      }),
      $("#search").on("keyup", function() {
          var value = $(this).val().toLowerCase();
          $("#tableBody tr").filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
          });
        }) ;
});

</script>
</head>
</head>
<body>
	<div class="container-logout30-form-btn">
		<form class="adminLogout" method="get" action="LogOutServlet">
			<button class="logOut10-form-btn">LogOut</button>
		</form>
	</div>
	<div class="limiter"></div>
	<div class="container-left">
		<div class="wrap-login100 p-t-50 p-b-90">
			<form>
				<span class="login100-form-title p-b-51"> Parking </span>

				<div class="wrap-input100 validate-input m-b-16">
					<input type="radio" name="choice" value=1 required> Park<br>
					<input type="radio" name="choice" value=2> UnPark<br>
					<input type="radio" name="choice" value=4> Reset Data<br>
				</div>

				<div class="wrap-input100 validate-input m-b-16" data-validate = "Vehicle Number is required">
					<input class="input100" type="text" name="vehicleNo" id="vehicleNo"
						placeholder="TS 01 ES 1234" required> <span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn m-t-17">
					<input type="button" class="login100-form-btn" id="submit"
						value="Submit" />
				</div>
				<div id="displayMessage"></div>

			</form>
		</div>
	</div>
	<div class="container-right">

		<div class="submitButton">
			<div class="wrap-input100 validate-input m-b-16">
				<input class="input100" type="text" name="search" id="search"
					placeholder="Search"> <span class="focus-input100"></span>
			</div>
			<div id="tableDisplay">
				<table id="table01">
				<thead>
					<tr>
						<th>Slot Number</th>
						<th>Vehicle Number</th>
						<th>In Time</th>
					</tr>
					</thead>
					<tbody id = "tableBody">
					<%
					    String displayslots = Parking.displaySlots().replaceAll("\n", ";").replaceAll("\t", ",");
					    if (displayslots != null) {
					        for (String row : displayslots.split(";")) {
					            if (row.length() > 0 && row.charAt(0) != 'S') {
					                String[] column = row.split(",");
					                out.print("<tr><td>" + column[0] + "</td><td>" + column[1] + "</td><td>" + column[2].replace("T", "&nbsp&nbsp&nbsp&nbsp") + "</td></tr>");
					            }
					        }
					    }
					%>
					</tbody>
				</table>
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