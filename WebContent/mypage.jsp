<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=utf-8");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>마이페이지</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- font-awsome CSS 추가 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />

<%
	String userId = (String) session.getAttribute("userId");
	String test = (String)request.getParameter("tutorYN"); 
%>


</head>

<style type="text/css">
.contact-form textarea.form-control4 {
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

.btn_1234567890 {
	height: 30px;
	width: 70px;
	color: #fff;
	font-weight: 600;
	font-size: 15px;
	border: 0;
}

.club_btn {
	background: #7643EA;
	color: #fff;
	border: 0;
	outline: 0;
	padding: 8px 8px;
	font-size: 15px;
	margin: 2px 2px;
	margin-top: 15px;
	border-radius: 6px;
}

.club_btn:hover {
	background-color: darken(#7643EA, 10%);
}
#level{
	font-family: FontAwesome;
	font-size: 23pt;
}
</style>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="hero-search-form"
		style="margin-left: 22%; margin-right: 22%; margin-bottom: 10%">
		<!-- Tabs -->
		<div class="nav nav-tabs" id="heroTab" role="tablist">
			<a class="nav-item nav-link active" id="nav-places-tab"
				data-toggle="tab" href="#nav-places" role="tab"
				aria-controls="nav-places" aria-selected="true">내 정보 관리</a> <a
				class="nav-item nav-link" id="nav-events-tab" data-toggle="tab"
				href="#nav-events" role="tab" aria-controls="nav-events"
				aria-selected="false">강사 정보 관리</a>
		</div>

		<!-- Tabs Content -->
		<div class="tab-content" id="nav-tabContent">
			<div class="tab-pane fade show active" id="nav-places"
				role="tabpanel" aria-labelledby="nav-places-tab">
				<form action="momo.do?command=mypage-form" method="post" name="mypage" onsubmit="return checkValue()" enctype="multipart/form-data">
					<div class="overview-content mt-50" id="club_detail">
						<div class="contact-form">
							<div class="contact-form-title">
								<h3>${mypage.memberName}님의 마이페이지</h3>
								<br>
							</div>
							<div class="row">
								<div class="col-12">
									<!-- 프로필 사진 -->
									<center>
										<c:choose>
											<c:when test="${empty mypage.memberPicture}">
												<img src="img/header-img/logo_02.png" alt="">
											</c:when>
											<c:otherwise>
												<img src="img/memberProfile_img/${mypage.memberPicture}" name="memberPicture">
											</c:otherwise>
										</c:choose>
										<br> <br>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="file" name="memberPicture" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="memberPicture_or" value="${mypage.memberPicture}"/> <br> <br> <br>
									</center>
								</div>
								<div class="col-12 col-md-6">
									<small>아이디</small> <input type="text" name="memberName"
										id="memberName" class="form-control" readonly="readonly"
										value="${mypage.memberId}">
								</div>
								<div class="col-12 col-md-6">
									<small>레벨</small> 
									<input type="text" id="level" name="memberScore" class="form-control" placeholder="모임점수" value="&#xf005;" readonly="readonly">
                                 	<input type="hidden" id="level2" name="memberScore" class="form-control" placeholder="모임점수" value="${mypage.memberScore}" readonly>
								</div>
								<div class="col-12 col-md-6">
									<small>비밀번호 변경</small> <input type="password" name="memberPwd"	id="memberPwd" class="form-control">
										<input type="hidden" id="nowPwd" value="${mypage.memberPwd }"/>
								</div>
								<div class="col-12 col-md-6">
									<small>비밀번호 변경 확인</small> <input type="password"
										name="memberPwdCheck" id="memberPwdCheck" class="form-control">
								</div>
								<div class="col-12 col-md-6">
									<small>생년월일</small> <input type="text" name="birthday"
										id="birthday" class="form-control" readonly="readonly"
										value="${mypage.birthday}">
								</div>
								<div class="col-12 col-md-6">
									<small>이메일</small> <input type="email" name="email" id="email"
										class="form-control" value="${mypage.email}">
								</div>
								<div class="col-12 col-md-6">
									<small>전화번호</small> <input type="text" name="phone" id="phone"
										class="form-control" value="${mypage.phone}">
								</div>
								<div class="col-12 col-md-6">
									<small>주소</small> <input type="text" name="memberAddress"
										id="memberAddress" class="form-control"
										value="${mypage.memberAddress}">
								</div>
								<div class="col-12 col-md-6">
									<small>관심 카테고리</small> <select class="form-control"
										style="height: 50px" name="categoryName" id="categoryName">
										<option selected>${mypage.categoryName}</option>
										<option value="게임/오락">게임/오락</option>
										<option value="공예/만들기">공예/만들기</option>
										<option value="독서">독서</option>
										<option value="문화/공연/축제">문화/공연/축제</option>
										<option value="반려동물">반려동물</option>
										<option value="스터디">스터디</option>
										<option value="스포츠/아웃도어">스포츠/아웃도어</option>
										<option value="요리/먹방">요리/먹방</option>
										<option value="음악/댄스">음악/댄스</option>
										<option value="자유주제">자유주제</option>
									</select>
								</div>
								<div class="col-12">
									<input type="submit" class="btn dorne-btn" value="수정하기">
									<input type="button" class="btn dorne-btn" onclick="location.href='momo.do?command=main'" value="돌아가기">
								</div>
							</div>
						</div>
					</div>
				</form>

				<!-- 활동중인 모임 관리 ------------------------------------------------------------------------------>
				<div class="listing-menu-area mt-100" id="club_member">
					<hr>
					<h3 style="color: white">활동 중인 모임</h3>
					<br>
					<c:choose>
						<c:when test="${empty myClubList}">
							<p style="text-align: center; color: white;">
								<b>--- 활동 중인 모임이 없습니다 ---</b>
							</p>
						</c:when>
						<c:otherwise>
							<c:forEach var="myClubList" items="${myClubList}">
								<%-- <c:forEach var="myClassList" items=${myClassList }>
								
								</c:forEach> --%>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<br>
										<h6 style="color: black">${myClubList.clubName}</h6>
									</div>
									<div class="listing-menu-price">
										<button type="button" class="club_btn"
											onclick="location.href='momo.do?command=club_detail&clubNo=${myClubList.clubNo}'">모임
											상세 정보</button>
									</div>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			
			<div class="tab-pane fade" id="nav-events" role="tabpanel"
				aria-labelledby="nav-events-tab">
			<br>
			<br>
			<c:choose>
			<c:when test="${tutorYN eq 'N'}">
				<div id="tutorRegister">
				<input type="hidden" id="userNo" value="<%=userId%>">
					<button type="button" class="btn dorne-btn" onclick="tutorRegister()">강사로 등록하기</button>
					<br>
					<br>
					<p style="color: white">
						강사로 등록하기 버튼을 클릭하면 강사 정보를 업로드할 수 있습니다.
						<br> 추후 강사 정보 업로드를 완료해야 강사로 활동할 수 있습니다.
					</p>
				</div>
			</c:when>
			<c:otherwise>
				<div id="tutorRegister2">
					<button type="button" class="btn dorne-btn"
						onclick="tutorFileUpload()">강사 정보 업로드</button>
					<br>
				</div>
			</c:otherwise>
			</c:choose>
				<form class="tutor-file" action="momo.do?command=uploadTutorFile"
					method="post" enctype="multipart/form-data" id="registerForm"
					style="display: none;">
					<div class="listing-menu-area mt-30" id="club_member">
						<h3 style="color: white">강사 정보 업로드</h3>
						<br>
						<p style="color: white">
							학력 증명, 경력 증명, 자격증 등 본인에게 해당하는 파일을 업로드 할 수 있습니다. <br> 업로드한
							파일과 강사 소개는 수업 등록 시 수업 상세보기 페이지에서 누구나 열람이 가능합니다. <br> 파일을 허위로
							업로드하거나 위조 파일을 업로드했을 시 발생하는 문제에 대한 모든 책임은 본인에게 있습니다.
						</p>
						<br>
						<div class="row">
							<div class="col-12 col-md-6">
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>학력 증명</small>
										<br>
										<a href="img/tutorFile_img/${tutor.educationFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.educationFile}</a>
										<input type="file" name="education" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="education_or" value="${tutor.educationFile}"/>
									</div>
								</div>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>경력 증명</small>
										<br>
										<a href="img/tutorFile_img/${tutor.experienceFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.experienceFile}</a>
										<input type="file" name="work_experience" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="experience_or" value="${tutor.experienceFile}"/>
									</div>
								</div>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<small>자격증</small>
										<br>
										<a href="img/tutorFile_img/${tutor.certificateFile}" onclick="window.open(this.href, '', 'width=400, height=430'); return false;" style="color: black">${tutor.certificateFile}</a>
										<input type="file" name="certificate" id="file_chk"
											class="form-control-file" onchange="fileChk(this.value);"/>
										<input type="hidden" id="nullpicture"
											name="certificate_or" value="${tutor.certificateFile}"/>
									</div>
								</div>
							</div>
							<div class="col-12 col-md-6">
								<h6 style="margin-bottom: 16px;">강사 약력</h6>
								<textarea name="tutorIntroduce" id="tutorIntroduce"
									class="form-control" cols="13" rows="16"
									 placeholder="강사 소개를 입력해주세요.">${tutor.tutorIntroduce}</textarea>
							</div>
							<br>
							<div class="col-12">
								<input type="submit" class="btn dorne-btn" value="업로드 완료">
							</div>
						</div>
					</div>
				</form>

				<div class="listing-menu-area mt-100" id="club_member">
					<hr>
					<h3 style="color: white">개설 중인 수업</h3>
					<br>					
					<c:forEach var="myClass" items="${myClassList}">
						<c:choose>
							<c:when test="${empty myClass.className}">
								<p style="text-align: center; color: white;">
									<b>--- 개설 중인 수업이 없습니다 ---</b>
								</p>
							</c:when>
							<c:otherwise>
								<div class="single-listing-menu d-flex justify-content-between">
									<div class="listing-menu-title">
										<br>
										<h6 style="color: black">${myClass.className}</h6>
									</div>
									<div class="listing-menu-price">
										<button type="button" class="club_btn"
											onclick="location.href='momo.do?command=class_detail&classNo=${myClass.classNo}'">수업상세 정보</button>
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>


	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- ****** Footer Area End ****** -->

	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/others/plugins.js"></script>
	<!-- Google Maps js -->
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDk9KNSL1jTv4MY9Pza6w8DJkpI_nHyCnk"></script>
	<script src="js/google-map/location-map-active.js"></script>
	<!-- Active JS -->
	<script src="js/active.js"></script>
	<script src="club_js/levelJS.js"></script>
	<script src="imgjs/imgChk_js"></script>
	<!-- 마이 페이지용 소스파일 -->
	<script src="member/mypageJS.js?version=1.2"></script>
</body>

</html>