<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Title -->
<title>수업등록</title>

<!-- Favicon -->
<link rel="icon" href="img/header-img/logo_mini.png">
<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">
<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">

<style type="text/css">
.label-input101 {
	font-family: Poppins-Regular;
	font-size: 15px;
	color: #808080;
	line-height: 1.2;
	text-align: right;
	position: absolute;
	top: 14px;
	left: -120px;
	width: 110px;
}

.label-input102 {
	font-family: Poppins-Regular;
	font-size: 15px;
	color: #808080;
	line-height: 1.2px;
	text-align: right;
	position: absolute;
	top: 14px;
	left: -120px;
	width: 110px;
}

.wrap-input101 {
	width: 100%;
	position: relative;
	line-height: 40px;
	margin-bottom: 20px;
}

.wrap-input103 {
	width: 70%;
	position: relative;
	border-bottom: 1px solid #b2b2b2;
	line-height: 40px;
	margin-bottom: 20px;
}

.js-select2 {
	border-radius: 5px;
	outline: none;
}
.ptag{
	color: #808080;
}
.contact102-form-btn {
    display: -webkit-box;
    display: -webkit-flex;
    display: -moz-box;
    display: -ms-flexbox;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 0 20px;
    min-width: 100px;
    height: 30px;
    border-radius: 25px;
    font-family: Poppins-Regular;
    font-size: 16px;
    color: #fff;
    line-height: 1.2;
    -webkit-transition: all 0.4s;
    -o-transition: all 0.4s;
    -moz-transition: all 0.4s;
    transition: all 0.4s;
    background-color: #7643ea;
    outline:0;
}
.container-contact101-form-btn {
    display: -webkit-box;
    display: -webkit-flex;
    display: -moz-box;
    display: -ms-flexbox;
    display: flex;
    flex-wrap: wrap;
    padding-top: 8px;
}   

</style>

<script type="text/javascript">
function openClsNmCheck() {			//수업명 중복체크 함수
	
	window.name = "parentForm";
	window.open("nmCheckForm.jsp", "chkForm",
			"width=350, height=180, resizable=no, scrollbars=no, top = 200, left = 500, location = no");
}

function checkValue() {				
	var form = document.classInfo;
	
	var categorySelect = form.classCategoryNo.value;
	
	if (form.nmDuplication.value != "nmCheck") {		//수업명 중복체크 여부확인
		alert("수업명 중복체크를 해주세요.");
		return false;
		
	} else if(categorySelect == "카테고리"){				//카테고리 선택안했을시
		alert("카테고리를 선택해주세요.");
		return false;
	}
}

// 입력창에 값 입력시 hidden에 NmUncheck를 세팅. 중복체크 후 다시 새로운 수업명 입력했을 때 다시 중복체크.
function inputNmChk() {
	document.classInfo.nmDuplication.value = "NmUncheck";
}

</script>
</head>

<body>
<%
String userId = (String)request.getAttribute("userId");
System.out.println("넘어온userId: "+userId);
String tutorYN = (String)request.getAttribute("tutorYN");
System.out.println("넘어온tutorYN: "+tutorYN);
	if(tutorYN.equals("Y")){
%>	
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Preloader -->
	<div class="container-contact100" style="background-color: lavender">
		<!-- 중앙정렬 -->

		<div class="wrap-contact100">
			<div class="contact100-form-title" style="background-image: url(form/images/bg-01.jpg);">
				<span class="contact100-form-title-1"> 수업 등록 </span> 
				<span class="contact100-form-title-2"> 등록할 수업에 대한 정보를 입력해주세요. </span>
			</div>
			<!-- 폼 시작 -->														
			<form class="contact100-form validate-form" action="momo.do?command=classRegister&" method="post" enctype="multipart/form-data" name="classInfo" id="join-form" onsubmit="return checkValue()">	
				<!-- <input type="hidden" name="command" value="classRegister"> -->
				
				<div class="wrap-input103 validate-input" data-validate="수업 제목을 입력해주세요.">
					<span class="label-input101">수업명:</span> 
					<input class="input100" type="text" name="className" id="className" onkeydown="inputNmChk()">
					<span class="focus-input100"></span>
				</div>
					<input type="button" class="contact102-form-btn" style="background-color: #7643ea" id="clssNmChk" value="중복확인" onclick="openClsNmCheck()">
					<input type="hidden" name="nmDuplication" value="NmUncheck">
				
				
				<div class="wrap-input101 validate-input" data-validate="수업 카테고리를 입력해주세요.">
					<span class="label-input101">수업 카테고리:</span> 
					<select class="custom-select" name="classCategoryNo" id="classCategoryNo">
						<option selected="selected">카테고리</option>
						<option value="C1">스포츠/아웃도어</option>
						<option value="C2">요리/먹방</option>
						<option value="C3">게임/오락</option>
						<option value="C4">반려동물</option>
						<option value="C5">음악/댄스</option>
						<option value="C6">공예/만들기</option>
						<option value="C7">문화/공연/축제</option>
						<option value="C8">스터디</option>
						<option value="C9">독서</option>
						<option value="C10">자유주제</option>
					</select> <span class="focus-input100"></span>
				</div>

				<div class="wrap-input101 validate-input" data-validate="선호하는 모임 연령대를 선택해주세요.">	<!-- 라디오버튼!! -->
					<span class="label-input101">선호 연령대:</span> 
					<input type="radio" name="classAge" id="20" value="20" required="required"/> <span class="ptag"><label for="20">20대 &nbsp;</label></span>
					<input type="radio" name="classAge" id="30" value="30" required="required"/> <span class="ptag"><label for="30">30대 &nbsp;</label></span>
					<input type="radio" name="classAge" id="40" value="40" required="required"/> <span class="ptag"><label for="40">40대 &nbsp;</label></span>
					<input type="radio" name="classAge" id="50" value="50" required="required"/> <span class="ptag"><label for="50">50대 &nbsp;</label></span>
					<input type="radio" name="classAge" id="60" value="60" required="required"/> <span class="ptag"><label for="60">60대 이상</label></span>
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="수업장소를 입력해주세요.">
					<span class="label-input101">수업 장소:</span> 
					<input class="input100" type="text" name="classAddress" id="classAddress"> 
					<span class="focus-input100"></span>
				</div>
				
				<div class="wrap-input101 validate-input" data-validate="수업 사진을 등록해주세요.">
					<span class="label-input102">수업 사진:</span> 
					<input class="input100" type="file" name="classPicture" id="file_chk" onchange="fileChk(this.value);"> 
					
<!-- 				파일찾기 버튼 변경	 
				<input type="text" id="fileName" class="file_input_textbox" readonly >
					<div class="file_input_div">
   					<img src="open.jpg" class="file_input_img_btn" alt="파일찾기" />
  					<input type="file" name="classPicture" class="file_input_hidden" onchange="javascript: document.getElementById('fileName').value = this.value"/>
					</div>
-->
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="수업 커리큘럼을 작성해주세요.">
					<span class="label-input101">수업 내용:</span>
					<textarea class="input100" name="classContent" id="classContent" placeholder="수업시간, 커리큘럼 등 수업 내용을 작성해주세요."></textarea>
					<span class="focus-input100"></span>
				</div>
				
				<div class="container-contact101-form-btn" style="left:">
					<div class="text-center">
						<input type="submit" value="등록하기" class="contact100-form-btn" style="background-color: #7643ea; float: left;">&emsp;&emsp;&emsp;
						<input type="button" value="취소하기" class="contact100-form-btn" style="background-color: #7643ea; float: right;" onclick="location.href='javascript:history.back();'">
					</div>
				</div>

			</form>
			
		</div>
	</div>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ****** Footer Area End ****** -->

<%
} else {
%>
<script type="text/javascript">
alert("강사 계정이 아닙니다. 강사 등록부터 해주세요. \n강사 등록은 마이페이지에서 가능합니다.");
location.href='javascript:history.back();'
</script>	
<% } %>


</body>
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="form/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="form/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="form/css/util.css">
<link rel="stylesheet" type="text/css" href="form/css/main.css">
<!--===============================================================================================-->

<!--===============================================================================================-->
<script src="form/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="form/vendor/bootstrap/js/popper.js"></script>
<script src="form/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="form/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="form/vendor/daterangepicker/moment.min.js"></script>
<script src="form/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="form/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAKFWBqlKAGCeS1rMVoaNlwyayu0e0YRes"></script>
<script src="form/js/map-custom.js"></script>
<!--===============================================================================================-->
<script src="form/js/main.js"></script>

<!-- Popper js -->
<script src="js/bootstrap/popper.min.js"></script>
<!-- Bootstrap-4 js -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins js -->
<script src="js/others/plugins.js"></script>
<!-- Google Maps js -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDk9KNSL1jTv4MY9Pza6w8DJkpI_nHyCnk"></script>
<script src="js/google-map/explore-map-active.js"></script>
<!-- Active JS -->
<script src="js/active.js"></script>
<script src="imgjs/imgChk_js"></script> <!-- 이미지체크 함수 -->

</html>