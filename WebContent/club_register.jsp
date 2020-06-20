<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>모임등록</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">
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

.js-select2 {
	border-radius: 5px;
	outline: none;
}
.ptag{
	color: #808080;
}
</style>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<!-- Preloader -->
	<div class="container-contact100" style="background-color: lavender">
		<!-- 중앙정렬 -->

		<div class="wrap-contact100">
			<div class="contact100-form-title" style="background-image: url(form/images/bg-01.jpg);">
				<span class="contact100-form-title-1"> 모임 등록 </span> <span
					class="contact100-form-title-2"> 등록할 모임에 대한 정보를 입력해주세요. </span>
			</div>
		
	
			<form id="frm" class="contact100-form validate-form" action="momo.do?command=club_insert" method="post" enctype="multipart/form-data">
				<div class="wrap-input100 validate-input" data-validate="모임의 이름을 입력해주세요." style="margin-bottom: 2px;">
					<span class="label-input101">모임명:</span> 
					<input class="input100" type="text" name="club_name" id="clubName">
					<span class="focus-input100"></span>
				</div>
				<div id="clubNameChk"></div>

				<div class="wrap-input101 validate-input" data-validate="모임 카테고리를 입력해주세요.">
					<span class="label-input101">모임 카테고리:</span> 
					<select name="category" class="form-control" style="height: 50px" id="cate">
                        <option selected value="">카테고리</option>
                        <option value="C1" >스포츠 / 아웃도어</option>
                        <option value="C2" >요리 / 먹방</option>
                        <option value="C3" >게임 / 오락</option>
                        <option value="C4" >반려동물</option>
                        <option value="C5" >음악 / 댄스</option>
                        <option value="C6" >공예 / 만들기</option>
                        <option value="C7" >문화 / 공연 / 축제</option>
                        <option value="C8" >스터디</option>
                        <option value="C9" >독서</option>
                        <option value="C10">자유주제</option>
                     </select>
                     <span class="focus-input100"></span>
				</div>
				 
				<div class="wrap-input100 validate-input" data-validate="주 모임장소를 입력해주세요." style="margin-bottom: 0px;">
					<span class="label-input101">모임 장소:</span> 
					<input class="input100" type="text" name="club_location" placeholder="ex) 경기도 고양시 일산동구">					 
					<span class="focus-input100"></span>
				</div>
					<small style="margin-bottom: 30px; opacity: 0.5;"> 00도 00시 00구 형식으로 입력해주세요!</small>
					
				<div class="wrap-input101 validate-input" data-validate="모임 정원을 입력해주세요">
					<span class="label-input101">모임 정원:</span> 
					<input class="input100" type="number" name="club_total" placeholder="1" min="1" required> 
					<span class="focus-input100"></span>
				</div>	
				
				<div class="wrap-input101 validate-input" data-validate="모임 사진을 등록해주세요.">
					<span class="label-input102">모임 사진:</span> 
					<input class="input100" type="file" name="club_picture" id="file_chk" onchange="fileChk(this.value);"> 
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input" data-validate="어떤 활동을 하는 모임인가요?">
					<span class="label-input101">모임 활동 내용:</span>
					<textarea class="input100" name="club_content" placeholder="활동 내용을 입력해주세요."></textarea>
					<span class="focus-input100"></span>
				</div>
				
				<div class="container-contact100-form-btn" style="position:relative; left: 18%">
					<div class="text-center">
						<button type="submit" id="btn_frm" class="contact100-form-btn" style="background-color: #7643ea">등록하기 
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"/>
	<!-- ****** Footer Area End ****** -->

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
<!--===============================================================================================-->
<script src="form/js/main.js"></script>


<!-- Popper js -->
<script src="js/bootstrap/popper.min.js"></script>
<!-- Bootstrap-4 js -->
<script src="js/bootstrap/bootstrap.min.js"></script>
<!-- All Plugins js -->
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDk9KNSL1jTv4MY9Pza6w8DJkpI_nHyCnk"></script>
<script src="js/google-map/explore-map-active.js"></script>
<!-- Active JS -->
<script src="js/active.js"></script>
<script src="imgjs/imgChk_js.js"></script> <!-- 이미지체크 함수 -->
<script src="club_js/register.js"></script>
</html>