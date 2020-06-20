<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>LogIn</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" href="img/favicon-img/logo-favicon.png">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="login/fonts/iconic/css/material-design-iconic-font.min.css">
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
<!--===============================================================================================-->
<script type="text/javascript">
function popup_id(){
    var url = "popup_id.jsp";
    var name = "popup_id";
    var option = "width = 496, height = 504, top = 100, left = 200, location = no"
    window.open(url, name, option);
}

function popup_pw(){
    var url = "popup_pw.jsp";
    var name = "popup_id";
    var option = "width = 496, height = 582, top = 100, left = 200, location = no"
    window.open(url, name, option);
}
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('login/images/bg-01.jpg');">
			<div class="wrap-login100">
				<form class="login100-form validate-form" name="login" action="momo.do?command=login-form" method="post">
					<span class="login100-form-logo">
						<img src = "img/header-img/logo_02.png" height="90" width="90"/>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Login
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Enter userId">
						<input class="input100" type="text" name="userId" placeholder="Id">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter userpassword">
						<input class="input100" type="password" name="userpwd" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div> 	

					<div class="text-center p-t-90">
						<a class="txt1" href="signup.jsp">
							&nbsp; &nbsp; &nbsp; 회원가입 &nbsp; &nbsp; 
						</a>
						<a class="txt1" id="find_id" href="javascript:popup_id();" >
							아이디 찾기 &nbsp; &nbsp; 
						</a>
						<a class="txt1" id="find_pw" href="javascript:popup_pw();" > <!-- 하이퍼링크 새창으로 열기 -->
							비밀번호 찾기 &nbsp; &nbsp; 
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	

	<div id="dropDownSelect1"></div>
	
	<!-- ****** Footer Area Start ****** -->
   		<jsp:include page="footer.jsp"/>
   	<!-- ****** Footer Area End ****** -->
		
<!--===============================================================================================-->
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
	<script src="js/active.js"></script>

</body>
</html>