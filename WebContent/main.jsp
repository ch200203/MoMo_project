<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	response.setContentType("text/html; charset=UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>모임모아</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Font-awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
.picture_size {
	min-width: 300px;
	max-width: 300px;
	min-height: 220px;
	max-height: 220px;
}

.single-features-area {
	min-width: 300px;
	max-width: 300px;
}

#recommendedImg-size1 {
	min-width: 540px;
	max-width: 540px;
	min-height: 600px;
	max-height: 600px;
}

#recommendedImg-size2 {
	min-width: 540px;
	max-width: 540px;
	min-height: 290px;
	max-height: 290px;
}

#ranMainImg { <%int ranMainImg = (int) (Math.random() * 15) + 11;%>
	background-image: url(img/main_img/mainbg-<%=ranMainImg%>.jpg);
}

#categoryIcon1 {
	min-width: 130px;
	max-width: 130px;
	min-height: 35px;
	max-height: 35px;
	color: white;
	background-color: #7643EA;
}

#reviewPRF {
	min-width: 170px;
	max-width: 170px;
	min-height: 155px;
	max-height: 155px;
}

#reviewListDiv {
	min-width: 570px;
	max-width: 570px;
}

#reviewWriteDiv {
	text-align: right;
}

#reviewWirteBtn {
	height: 55px;
	color: white;
}
</style>

<%
	String userId = (String) session.getAttribute("userId");
	System.out.println("userId: " + userId);
%>

<script type="text/javascript">
	function unlogin(userId) {
		alert("userId: " + userId);
		if (userId == null || userId == "") {
			alert("후기작성은 로그인 후 가능합니다.");
		}
	}
</script>

</head>

<body>
	<!-- Preloader -->
	<div id="preloader">
		<div class="dorne-load"></div>
	</div>

	<!-- ***** Header Area Start ***** -->
	<jsp:include page="header.jsp" />
	<!-- ***** Header Area End ***** -->

	<!-- ***** Welcome Area Start ***** -->
	<section class="dorne-welcome-area bg-img bg-overlay" id="ranMainImg">
		<!-- 메인이미지 -->
		<div class="container h-100">
			<div class="row h-100 align-items-center justify-content-center">
				<div class="col-12 col-md-10">
					<div class="hero-content">
						<h2>세상 모든 모임을 모아! MOIMMOA</h2>
					</div>
					<!-- Hero Search Form -->
					<div class="hero-search-form">
						<!-- Tabs -=> 가운데 탭 선택하기 -->
						<div class="nav nav-tabs" id="heroTab" role="tablist">
							<a class="nav-item nav-link active" id="nav-places-tab"
								data-toggle="tab" href="#nav-places" role="tab"
								aria-controls="nav-places" aria-selected="true">모임 찾기</a> <a
								class="nav-item nav-link" id="nav-events-tab" data-toggle="tab"
								href="#nav-events" role="tab" aria-controls="nav-events"
								aria-selected="false">수업 찾기</a>
						</div>
						<!-- Tabs Content -->
						<div class="tab-content" id="nav-tabContent">
							<div class="tab-pane fade show active" id="nav-places"
								role="tabpanel" aria-labelledby="nav-places-tab">
								<h6>어떤 모임을 찾고 계신가요?</h6>
								<form action="momo.do" method="post"
									style="position: relative; left: 2%;">
									<input type="hidden" name="command" value="selectedClubList" />
									<!-- 정보를 action에 담아서 보내기 -->
									<select class="custom-select" name="selectedClubLocation">
										<option selected>지역 구분</option>
										<option value="서울">서울</option>
										<option value="경기/인천">경기/인천</option>
										<option value="강원">강원</option>
										<option value="충청/대전">충청/대전</option>
										<option value="전라/광주">전라/광주</option>
										<option value="경상/울산/대구/부산">경상/울산/대구/부산</option>
										<option value="제주">제주</option>
									</select> <select class="custom-select" name="selectedClubCategory">
										<option selected>카테고리 구분</option>
										<option value="C3">게임/오락</option>
										<option value="C6">공예/만들기</option>
										<option value="C9">독서</option>
										<option value="C7">문화/공연/축제</option>
										<option value="C4">반려동물</option>
										<option value="C8">스터디</option>
										<option value="C1">스포츠/아웃도어</option>
										<option value="C2">요리/먹방</option>
										<option value="C5">음악/댄스</option>
										<option value="C10">자유주제</option>
									</select> <select class="custom-select" name="selectedClubSort">
										<option selected>정렬 구분</option>
										<option value="CLUB_SCORE">랭킹순</option>
										<option value="CLUB_NO">최신순</option>
									</select>
									<button type="submit" class="btn dorne-btn">
										<i class="fa fa-search pr-2" aria-hidden="true"></i> 검색
									</button>
								</form>
							</div>
							<div class="tab-pane fade" id="nav-events" role="tabpanel"
								aria-labelledby="nav-events-tab">
								<h6>어떤 수업를 찾고 계신가요?</h6>
								<form action="momo.do" method="post"
									style="position: relative; left: 2%;">
									<input type="hidden" name="command" value="selectedClassList" />
									<!-- 정보를 action에 담아서 보내기 -->
									<select class="custom-select" name="selectedClassLocation">
										<option selected>지역 구분</option>
										<option value="서울">서울</option>
										<option value="경기/인천">경기/인천</option>
										<option value="강원">강원</option>
										<option value="충청/대전">충청/대전</option>
										<option value="전라/광주">전라/광주</option>
										<option value="경상/울산/대구/부산">경상/울산/대구/부산</option>
										<option value="제주">제주</option>
									</select> <select class="custom-select" name="selectedClassCategory">
										<option selected>카테고리 구분</option>
										<option value="C3">게임/오락</option>
										<option value="C6">공예/만들기</option>
										<option value="C9">독서</option>
										<option value="C7">문화/공연/축제</option>
										<option value="C4">반려동물</option>
										<option value="C8">스터디</option>
										<option value="C1">스포츠/아웃도어</option>
										<option value="C2">요리/먹방</option>
										<option value="C5">음악/댄스</option>
										<option value="C10">자유주제</option>
									</select> <select class="custom-select" name="selectedClassSort">
										<option selected>정렬 구분</option>
										<option value="CLASS_SCORE">랭킹순</option>
										<option value="CLASS_NO">최신순</option>
									</select>
									<button type="submit" class="btn dorne-btn">
										<i class="fa fa-search pr-2" aria-hidden="true"></i> 검색
									</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- ***** Welcome Area End ***** -->

	<!-- ***** Catagory Area Start ***** -->
	<section class="dorne-catagory-area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="all-catagories">
						<div class="row">
							<!-- Single Catagory Area -->
							<div class="col-12 col-sm-6 col-md"
								onclick="location.href='momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C1&selectedClubSort=정렬+구분'">
								<div class="single-catagory-area wow fadeInUpBig"
									data-wow-delay="0.2s"
									style="padding-bottom: 30px; padding-top: 30px;">
									<div class="catagory-content">
										<i class="fas fa-running"
											style="font-size: 50pt; color: white;"></i> <br> <br>
										<h6>스포츠/아웃도어</h6>
										</a>
									</div>
								</div>
							</div>
							<!-- Single Catagory Area -->
							<div class="col-12 col-sm-6 col-md"
								onclick="location.href='momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C8&selectedClubSort=정렬+구분'">
								<div class="single-catagory-area wow fadeInUpBig"
									data-wow-delay="0.4s"
									style="padding-bottom: 30px; padding-top: 30px;">
									<div class="catagory-content">
										<i class="fas fa-pen" style="font-size: 50pt; color: white;"></i>
										<br> <br>
										<h6>스터디</h6>
										</a>
									</div>
								</div>
							</div>
							<!-- Single Catagory Area -->
							<div class="col-12 col-sm-6 col-md"
								onclick="location.href='momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C2&selectedClubSort=정렬+구분'">
								<div class="single-catagory-area wow fadeInUpBig"
									data-wow-delay="0.6s"
									style="padding-bottom: 30px; padding-top: 30px;">
									<div class="catagory-content">
										<i class="fas fa-utensils"
											style="font-size: 50pt; color: white;"></i> <br> <br>
										<h6>요리/먹방</h6>
										</a>
									</div>
								</div>
							</div>
							<!-- Single Catagory Area -->
							<div class="col-12 col-sm-6 col-md"
								onclick="location.href='momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C5&selectedClubSort=정렬+구분'">
								<div class="single-catagory-area wow fadeInUpBig"
									data-wow-delay="0.8s"
									style="padding-bottom: 30px; padding-top: 30px;">
									<div class="catagory-content">
										<i class="fas fa-music" style="font-size: 50pt; color: white;"></i>
										<br> <br>
										<h6>음악/댄스</h6>
										</a>
									</div>
								</div>
							</div>
							<!-- Single Catagory Area -->
							<div class="col-12 col-md"
								onclick="location.href='momo.do?command=selectedClubList&selectedClubLocation=지역+구분&selectedClubCategory=C4&selectedClubSort=정렬+구분'">
								<div class="single-catagory-area wow fadeInUpBig"
									data-wow-delay="1s"
									style="padding-bottom: 30px; padding-top: 30px;">
									<div class="catagory-content">
										<i class="fas fa-paw" style="font-size: 50pt; color: white;"></i>
										<br> <br>
										<h6>반려동물</h6>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Catagory Area End ***** -->

	<!-- ***** About Area Start ***** -->
	<section class="dorne-about-area section-padding-0-100">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="about-content text-center">
						<h2>
							모임이 필요할 땐? <span>MOIMMOA!</span> <br> 수업이 필요할 땐? <span>MOIMMOA!</span>
						</h2>
						<p>MOIMMOA에서 함께 성장하는 기쁨을 나눠보세요</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** About Area End ***** -->

	<!-- ***** Editor Pick Area Start 사이트 내 추천 시작-->
	<section
		class="dorne-editors-pick-area bg-img bg-overlay-9 section-padding-100"
		style="background-image: url(img/bg-img/hero-2.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-heading text-center">
						<span></span>
						<h4>회원님을 위한 MOIMMOA의 PICKS!</h4>
						<p>회원님의 관심 카테고리 BEST 모임입니다</p>
					</div>
				</div>
			</div>

			<%
				if (userId == null || userId == "") {
			%>
			<div class="row">
				<c:forEach var="clubList" items="${clubList }" begin="0" end="0">
					<c:if test="${clubList.openYN eq 'Y' }">
						<div class="col-12 col-lg-6"
							onclick="location.href='momo.do?command=club_detail&clubNo=${clubList.clubNo }'">
							<div class="single-editors-pick-area wow fadeInUp"
								data-wow-delay="0.2s">
								<c:choose>
									<c:when test="${empty clubList.clubPicture}">

										<img class="picture_size"
											src=img/default_img/default_540_600.png alt=""
											id="recommendedImg-size1">
									</c:when>
									<c:otherwise>
										<img src="img/club_img/${clubList.clubPicture }" alt=""
											id="recommendedImg-size1">
									</c:otherwise>
								</c:choose>
								<div class="editors-pick-info">
									<div class="add-more">
										<a style="font-size: 20px;">추천모임1</a>
									</div>
									<div class="places-total-destinations d-flex">
										<a
											style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubCategoryName }</a><a
											style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubName }</a>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
				<div class="col-12 col-lg-6">
					<c:forEach var="clubList" items="${clubList }" begin="1" end="1">
						<c:if test="${clubList.openYN eq 'Y' }">
							<div class="col-12 col-lg-6"
								onclick="location.href='momo.do?command=club_detail&clubNo=${clubList.clubNo }'">
								<div class="single-editors-pick-area wow fadeInUp"
									data-wow-delay="0.2s">
									<c:choose>
										<c:when test="${empty clubList.clubPicture}">

											<img class="picture_size"
												src=img/default_img/default_540_290.png alt=""
												id="recommendedImg-size2">
										</c:when>
										<c:otherwise>
											<img src="img/club_img/${clubList.clubPicture }" alt=""
												id="recommendedImg-size2">
										</c:otherwise>
									</c:choose>
									<div class="editors-pick-info">
										<div class="add-more">
											<a style="font-size: 20px;">추천모임2</a>
										</div>
										<div class="places-total-destinations d-flex">
											<a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubCategoryName }</a><a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubName }</a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<c:forEach var="clubList" items="${clubList }" begin="2" end="2">
						<c:if test="${clubList.openYN eq 'Y' }">
							<div class="col-12 col-lg-6"
								onclick="location.href='momo.do?command=club_detail&clubNo=${clubList.clubNo }'">
								<div class="single-editors-pick-area wow fadeInUp"
									data-wow-delay="0.2s">
									<c:choose>
										<c:when test="${empty clubList.clubPicture}">

											<img class="picture_size"
												src=img/default_img/default_540_290.png alt=""
												id="recommendedImg-size2">
										</c:when>
										<c:otherwise>
											<img src="img/club_img/${clubList.clubPicture }" alt=""
												id="recommendedImg-size2">
										</c:otherwise>
									</c:choose>
									<div class="editors-pick-info">
										<div class="add-more">
											<a style="font-size: 20px;">추천모임3</a>
										</div>
										<div class="places-total-destinations d-flex">
											<a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubCategoryName }</a><a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${clubList.clubName }</a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>

			</div>

			<%
				} else if (userId != null || userId != "") {
			%>

			<div class="row">
				<c:forEach var="recommendedClubList" items="${recommendedClubList }"
					begin="0" end="0">
					<c:if test="${recommendedClubList.openYN eq 'Y' }">
						<div class="col-12 col-lg-6"
							onclick="location.href='momo.do?command=club_detail&clubNo=${recommendedClubList.clubNo }'">
							<div class="single-editors-pick-area wow fadeInUp"
								data-wow-delay="0.2s">
								<c:choose>
									<c:when test="${empty recommendedClubList.clubPicture}">

										<img class="picture_size"
											src=img/default_img/default_540_600.png alt=""
											id="recommendedImg-size1">
									</c:when>
									<c:otherwise>
										<img src="img/club_img/${recommendedClubList.clubPicture }"
											alt="" id="recommendedImg-size1">
									</c:otherwise>
								</c:choose>
								<div class="editors-pick-info">
									<div class="add-more">
										<a style="font-size: 20px;">추천모임1</a>
									</div>
									<div class="places-total-destinations d-flex">
										<a
											style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubCategoryName }</a><a
											style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubName }</a>
									</div>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
				<div class="col-12 col-lg-6">
					<c:forEach var="recommendedClubList"
						items="${recommendedClubList }" begin="1" end="1">
						<c:if test="${recommendedClubList.openYN eq 'Y' }">
							<div class="col-12 col-lg-6"
								onclick="location.href='momo.do?command=club_detail&clubNo=${recommendedClubList.clubNo }'">
								<div class="single-editors-pick-area wow fadeInUp"
									data-wow-delay="0.2s">
									<c:choose>
										<c:when test="${empty recommendedClubList.clubPicture}">

											<img class="picture_size"
												src=img/default_img/default_540_290.png alt=""
												id="recommendedImg-size2">
										</c:when>
										<c:otherwise>
											<img src="img/club_img/${recommendedClubList.clubPicture }"
												alt="" id="recommendedImg-size2">
										</c:otherwise>
									</c:choose>
									<div class="editors-pick-info">
										<div class="add-more">
											<a style="font-size: 20px;">추천모임2</a>
										</div>
										<div class="places-total-destinations d-flex">
											<a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubCategoryName }</a><a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubName }</a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<c:forEach var="recommendedClubList"
						items="${recommendedClubList }" begin="2" end="2">
						<c:if test="${recommendedClubList.openYN eq 'Y' }">
							<div class="col-12 col-lg-6"
								onclick="location.href='momo.do?command=club_detail&clubNo=${recommendedClubList.clubNo }'">
								<div class="single-editors-pick-area wow fadeInUp"
									data-wow-delay="0.2s">
									<c:choose>
										<c:when test="${empty recommendedClubList.clubPicture}">
											<img class="picture_size"
												src=img/default_img/default_540_290.png alt=""
												id="recommendedImg-size2">
										</c:when>
										<c:otherwise>
											<img src="img/club_img/${recommendedClubList.clubPicture }"
												alt="" id="recommendedImg-size2">
										</c:otherwise>
									</c:choose>
									<div class="editors-pick-info">
										<div class="add-more">
											<a style="font-size: 20px;">추천모임3</a>
										</div>
										<div class="places-total-destinations d-flex">
											<a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubCategoryName }</a><a
												style="font-size: 15px; min-width: 210px; padding: 0px; text-align: center;">${recommendedClubList.clubName }</a>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>

			</div>

			<%
				}
			%>

		</div>
	</section>
	<!-- ***** Editor Pick Area End ***** -->

	<!-- ***** Features Destinations Area Start ***** -->
	<section class="dorne-features-destinations-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="section-heading dark text-center">
						<span></span>
						<h4>BEST 모임</h4>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-12">
					<div class="features-slides owl-carousel">

						<!-- 모임 리스트  -->
						<c:choose>
							<c:when test="${empty clubList }">
								<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="clubList" items="${clubList }">
									<c:if test="${clubList.openYN eq 'Y' }">
										<div class="single-features-area"
											onclick="location.href='momo.do?command=club_detail&clubNo=${clubList.clubNo }'"
											style="margin-right: 20%;">
											<c:choose>
												<c:when test="${empty clubList.clubPicture}">

													<img class="picture_size"
														src=img/default_img/default_picture_2.png alt="">
												</c:when>
												<c:otherwise>
													<img class="picture_size"
														src="img/club_img/${clubList.clubPicture }" alt="">
												</c:otherwise>
											</c:choose>
											<div class="price-start">
												<p>${clubList.clubCategoryName }</p>
											</div>
											<div
												class="feature-content d-flex align-items-center justify-content-between">
												<div class="feature-title">
													<h5>${clubList.clubName }</h5>
													<p>${clubList.clubAddress }</p>
												</div>
												<div class="feature-favourite">
													<a href="#">
														<c:if test="${clubList.clubScore ge '0' && clubList.clubScore le '20'}">
															<i class="fas fa-star level" style="color: #7643ea;"></i>
														</c:if> 
														<c:if test="${clubList.clubScore ge '21' && clubList.clubScore le '50'}">
															<i class="fas fa-star level" style="color: #D8F781;"></i>
														</c:if> 
														<c:if test="${clubList.clubScore ge '51' && clubList.clubScore le '100'}">
															<i class="fas fa-star level" style="color: #A9F5F2;"></i>
														</c:if> 
														<c:if test="${clubList.clubScore ge '101' && clubList.clubScore le '200'}">
															<i class="fas fa-star level" style="color: #2E9AFE;"></i>
														</c:if> 
														<c:if test="${clubList.clubScore ge '201'}">
															<i class="fas fa-star level" style="color: #F4FA58;"></i>
														</c:if>
													</a>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- /모임 리스트-->

					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Features Destinations Area End ***** -->

	<!-- ***** Features Restaurant Area Start ***** -->
	<section class="dorne-features-restaurant-area bg-default">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12">
					<div class="section-heading text-center">
						<span></span>
						<h4>BEST 수업</h4>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col-12">
					<div class="features-slides owl-carousel">

						<!-- 수업리스트 -->
						<c:choose>
							<c:when test="${empty classList }">
								<div style="text-align: center;">--해당 수업이 존재하지 않습니다--</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="classList" items="${classList }">
									<c:if test="${classList.openYN eq 'Y' }">
										<div class="single-features-area"
											onclick="location.href='momo.do?command=classDetail&classNo=${classList.classNo }'">
											<c:choose>
												<c:when test="${empty classList.classPicture}">
													<img class="picture_size"
														src="img/default_img/default_picture_2.png" alt="">
												</c:when>
												<c:otherwise>
													<img class="picture_size"
														src="img/class_img/${classList.classPicture }" alt="">
												</c:otherwise>
											</c:choose>
											<div class="price-start">
												<p>${classList.classCategoryName }</p>
											</div>
											<div
												class="feature-content d-flex align-items-center justify-content-between">
												<div class="feature-title">
													<h5>${classList.className }</h5>
													<p>${classList.memberName }</p>
													<p>${classList.classAddress }</p>
												</div>
												<div class="feature-favourite">
													<a href="#">
														<c:if test="${classList.classScore ge '0' && classList.classScore le '20'}">
															<i class="fas fa-star level" style="color: #7643ea;"></i>
														</c:if> 
														<c:if test="${classList.classScore ge '21' && classList.classScore le '50'}">
															<i class="fas fa-star level" style="color: #D8F781;"></i>
														</c:if> 
														<c:if test="${classList.classScore ge '51' && classList.classScore le '100'}">
															<i class="fas fa-star level" style="color: #A9F5F2;"></i>
														</c:if> 
														<c:if test="${classList.classScore ge '101' && classList.classScore le '200'}">
															<i class="fas fa-star level" style="color: #2E9AFE;"></i>
														</c:if> 
														<c:if test="${classList.classScore ge '201'}">
															<i class="fas fa-star level" style="color: #F4FA58;"></i>
														</c:if>
													</a>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- /수업 리스트 -->
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ***** Features Restaurant Area End ***** s-->

	<!-- ***** Features Events Area Start ***** -->
	<section
		class="dorne-features-events-area bg-img bg-overlay-9 section-padding-100-50"
		style="background-image: url(img/bg-img/hero-3.jpg)">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-heading text-center">
						<span></span>
						<h4>BEST 후기</h4>
					</div>
				</div>
			</div>

			<!-- 모임후기리스트 -->
			<div class="row">
				<c:choose>
					<c:when test="${empty reviewClubListTopSix }">
						<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
					</c:when>
					<c:otherwise>
						<c:forEach var="reviewClubListTopSix"
							items="${reviewClubListTopSix }" begin="0" end="5">
							<div class="col-12 col-lg-6" id="reviewListDiv"
								onclick="location.href='momo.do?command=reviewClubDetail&noClubReview=${reviewClubListTopSix.noClubReview }'">
								<div
									class="single-feature-events-area d-sm-flex align-items-center wow fadeInUpBig"
									data-wow-delay="0.2s">
									<div class="feature-events-thumb">
										<c:choose>
											<c:when
												test="${empty reviewClubListTopSix.pictureClubReview }">
												<img class="picture_size"
													src=img/default_img/default_picture_2.png alt=""
													id="reviewPRF">
											</c:when>
											<c:otherwise>
												<img
													src="img/clubReview_img/${reviewClubListTopSix.pictureClubReview}"
													alt="" id="reviewPRF">
											</c:otherwise>
										</c:choose>
										<div class="date-map-area d-flex">
											<a id="categoryIcon1">${reviewClubListTopSix.categoryName }</a>
										</div>
									</div>
									<div class="feature-events-content">
										<h5>${reviewClubListTopSix.titleClubReview }</h5>
										<h6>
											<td><b>모임명&nbsp;&nbsp;&nbsp;${reviewClubListTopSix.clubName }</b></td>
											<br>
											<td>작성자&nbsp;&nbsp;&nbsp;${reviewClubListTopSix.memberId }</td>
											<br>
											<td>작성일&nbsp;&nbsp;&nbsp;${reviewClubListTopSix.dateClubReview }</td>
										</h6>
										<p></p>
									</div>
									<div class="feature-events-details-btn">
										<a href="#">+</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				<!-- /모임후기리스트 -->

			</div>
		</div>
	</section>
	<!-- ***** Features Events Area End ***** -->

	<!-- ****** Footer Area Start 하단부 입니다ㅣ. ****** -->

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp" />
	<!-- ****** Footer Area End ****** -->

	<!-- 건드리지 마세요 -->
	<!--     Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!--     Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!--     All Plugins js -->
	<script src="js/others/plugins.js"></script>
	<!--     Active JS -->
	<script src="js/active.js"></script>
	<script src="js/levelJS.js"></script>
</body>
</html>