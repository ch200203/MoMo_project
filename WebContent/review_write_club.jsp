<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<!-- 모임 리뷰 상세보기 -->
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!-- single-listing html에서 가져옴 -->
<!-- Title -->
<title>모임 후기 작성</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">


<style type="text/css">
.contact-form textarea.form-control1 {
	height: 300px;
	font-size: 12px;
	color: #72728c;
	font-weight: 600;
	border: none;
	border-radius: 0;
	margin-bottom: 30px;
	overflow: auto;
	resize: vertical;
	display: block;
	width: 100%;
	padding: .375rem .75rem;
	background-color: #fff;
	background-image: none;
	background-clip: padding-box;
}

.club_btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 5px 5px;
	font-size: 18px;
	margin: 2px 2px;
	border-radius: 6px;
}

.club_btn:hover {
	background-color: darken(#7643EA, 10%);
}
</style>

<script type="text/javascript">
	function openFindClubName() {
	
		window.name = "parentForm";
		window.open("findClubName.jsp", "chkForm",
			"width=500, height=500, resizable=no, scrollbars=no, top = 200, left = 500, location = no");
	}
</script>
</head>


<body>

	<jsp:include page="header.jsp"></jsp:include>

	<!-- Preloader -->
	<div id="preloader">
		<div class="dorne-load"></div>
	</div>

	<!-- ***** Search Form Area ***** -->

	<!-- ***** Single Listing Area Start ***** -->
	<section class="dorne-single-listing-area section-padding-100">
		<div class="container">
			<div class="contact-form-title">
				<h2>모임 후기 작성</h2>
			</div>

			<!-- Single Listing Content -->
			<hr>
			<br>

			<form action="momo.do?command=writeClubReviewForm" method="post" enctype="multipart/form-data" name="reviewClub">
				<div class="contact-form">
					<div class="row">
						<div class="col-12">
							<h4>
								제&nbsp;&nbsp;&nbsp;목&nbsp;&nbsp;
								<input type="text" name="reviewTitle" id="reviewTitle" style="border:none;" required>
							</h4>
						</div>
						
						<br> <br> <br>
						
						<div class="col-12">
							<h4>
								모임명&nbsp;
								<input type="text" name="clubName" id="clubName" style="border:none;">
								<button type="button" class="club_btn" onclick="openFindClubName()">모임명 찾기</button>
							</h4>
						</div>
						
						<br> <br>
						
						<div class="col-12">
							<br>
							<h4>내용 작성</h4>
							<textarea class="form-control1" name="reviewContent" id="reviewContent"
								cols="100" rows="30" required></textarea>
						</div>
						
						<div class="col-12">
							<br>
							<h4>사진 입력</h4>
							<br>
							<h6>모임 활동 사진을 리뷰에 등록해보세요!</h6>
							<input type="file" name="reviewPicture" id="file_chk" class="form-control-file" onchange="fileChk(this.value);">
						</div>
						
						<div class="col-12">
							<br>
							<br>
							<br>
							<span style="position:relative; left:80%;"><input type="submit" class="btn dorne-btn" value="작성 완료"></span>
						</div>
						<div class="col-12">
							<br>
							<span style="position:relative; left:80%;">
								<input type="button" class="btn dorne-btn" onclick="location.href='momo.do?command=reviewClubList'" value="작성 취소"></span>
						</div>
					</div>
				</div>
			</form>
		</div>
	</section>
	<!-- ***** Single Listing Area End ***** -->


	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ****** Footer Area End ****** -->

	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/others/plugins.js"></script>

	<!-- Active JS -->
	<script src="js/active.js"></script>
	<script src="imgjs/imgChk_js"></script>
</body>

</html>