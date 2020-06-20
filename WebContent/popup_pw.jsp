<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("UTF-8");
%>
<%
   response.setContentType("text/html; charset=UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>비밀번호 찾기 </title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" href="img/favicon-img/logo-favicon.png">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<!-- <link rel="stylesheet" type="text/css"
   href="login/fonts/font-awesome-4.7.0/css/font-awesome.min.css"> -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
   href="login/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="login/css/util.css">
<link rel="stylesheet" type="text/css" href="login/css/main.css">
<!--===============================================================================================-->

<script type="text/javascript">
   var httpRequest = null;

   function searchPwd() {
      var memberName = document.getElementsByName("memberName")[0].value;
      var memberId = document.getElementsByName("memberId")[0].value;
      var email = document.getElementsByName("email")[0].value;
      
      if (!memberName) {
         alert("이름을 입력하세요.");
         return false;
      
      } else if (!memberId) {
         alert("아이디를 입력하세요.");
         return false;
         
      } else if (!email) {
         alert("이메일을 입력하세요.");
         return false;
         
      }else {
         var param = "memberName=" + memberName + "&memberId=" + memberId +"&email=" + email;
         
         httpRequest = new window.XMLHttpRequest();
         if (httpRequest == null) {
            alert('XMLHTTP 인스턴스를 만들 수가 없어요 ㅠㅠ');
             return false;
         }
         
         httpRequest.onreadystatechange = callback;
         httpRequest.open("POST", "momo.do?command=searchPwd", true);
         httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
         httpRequest.send(param);
      }
   }
   
   function callback() {
      if (httpRequest.readyState === XMLHttpRequest.DONE) {
         if (httpRequest.status === 200) {
             var resultText = httpRequest.responseText;
             if (resultText == 1) {
                alert("해당하는 계정이 없습니다.");
             } else {
               alert("임시 비밀번호 : " +resultText+ "\n 임시 비밀번호가 발급되었습니다. 마이페이지에서 새로운 비밀번호로 변경이 가능합니다.");
               
               opener.document.login.userpwd.value = resultText;
               
               self.close();
             }
         } else {
              alert('비밀번호 찾기에 문제가 있어요.');
         }
      }
   }
</script>
</head>
<body>
   <div class="wrap-login100">
      <form class="login100-form validate-form">
         <span class="login100-form-logo">
         <img src = "img/header-img/logo_02.png" height="90" width="90"/>
         </span> <span class="login100-form-title p-b-34 p-t-27"> PW 찾기 </span>

         <div class="wrap-input100 validate-input"
            data-validate="Enter username">
            <input class="input100" type="text" name="memberName" placeholder="Username"> 
            <span class="focus-input100" data-placeholder="&#xf205;"></span>
         </div>
         <div class="wrap-input100 validate-input"
            data-validate="Enter memberId">
            <input class="input100" type="text" name="memberId" placeholder="UserID"> 
            <span class="focus-input100" data-placeholder="&#xf207;"></span>
         </div>

         <div class="wrap-input100 validate-input" data-validate="Enter Email">
            <input class="input100" type="email" name="email" placeholder="a1234@naver.com">
            <span class="focus-input100" data-placeholder="&#xf200"></span>
         </div>
         <div class="container-login100-form-btn">
            <button type="button" class="login100-form-btn" onclick="searchPwd()">찾기</button>
         </div>
      </form>
   </div>



   <div id="dropDownSelect1"></div>

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

</body>
</html>