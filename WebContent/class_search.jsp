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
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->
<title>수업 찾기</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">
<!-- font-awsome CSS 추가 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css" />

<style type="text/css">
.section-heading2 {
	position: relative;
	z-index: 1;
}

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
</style>


</head>

<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>

	<div style="background-color: #E0E6F8">
		<!-- 전체 배경 색상 -->
		<div class="row h-100 align-items-center justify-content-center"
			style="margin: 0px;">

			<!-- Hero Search Form -->
			<div class="hero-search-form">
				<!-- 검색창 틀 -->
				<!-- Tabs -=> 가운데 탭 선택하기 -->
				<div class="nav nav-tabs" id="heroTab" role="tablist">
					<a class="nav-item nav-link active" id="nav-places-tab"
						data-toggle="tab" role="tab" aria-controls="nav-places"
						aria-selected="true">수업 찾기</a>
				</div>
				<!-- Tabs Content -->
				<div class="tab-content" id="nav-tabContent">
					<div class="tab-pane fade show active" id="nav-places"
						role="tabpanel" aria-labelledby="nav-places-tab">
						<h6>어떤 강의를 찾고 계신가요?</h6>
						<form action="momo.do" method="post">
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

		<br> <br>


		<div class="container" style="margin: auto">
			<div class="row">
				<div class="col-12">
					<div class="section-heading2 dark text-center">
						<span></span>
						<h4>검색결과</h4>
					</div>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-12">
					<div class="">

						<%
							String userId = (String) session.getAttribute("userId");
							System.out.println("userId: " + userId);
						%>

						<!-- 수업리스트 -->
						<c:choose>
							<c:when test="${empty classList }">
								<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="classList" items="${classList }">
									<c:if test="${classList.openYN eq 'Y' }">
										<div class="single-features-area"
											style="position: relative; margin: 30px; display: inline-block"
											onclick="location.href='momo.do?command=class_detail&classNo=${classList.classNo }'">
											<c:choose>
												<c:when test="${empty classList.classPicture}">
													<img class="picture_size"
														src="img/default_img/default_picture_2.png" alt="">
												</c:when>
												<c:otherwise>
													<img class="picture_size" src="img/class_img/${classList.classPicture }"
														alt="">
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
						<!-- /수업 리스트-->

						<%
							if (userId != null && userId.contains("admin")) {
						%>

						<hr>

						<p>
						<h6>삭제된 수업</h6>
						</p>

						<!-- 삭제된 수업 리스트  -->
						<c:choose>
							<c:when test="${empty classList }">
								<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
							</c:when>
							<c:otherwise>
								<c:forEach var="classList" items="${classList }">
									<c:if test="${classList.openYN eq 'N' }">
										<div class="single-features-area"
											style="position: relative; margin: 30px; display: inline-block"
											onclick="location.href='momo.do?command=class_detail&classNo=${classList.classNo }'">
											<c:choose>
												<c:when test="${empty classList.classPicture}">
													<img class="picture_size"
														src="img/default_img/default_picture_2.png" alt="">
												</c:when>
												<c:otherwise>
													<img class="picture_size" src="${classList.classPicture }"
														alt="">
												</c:otherwise>
											</c:choose>
											<div class="price-start">
												<p>${classList.classCategoryName }</p>
											</div>
											<div
												class="feature-content d-flex align-items-center justify-content-between">
												<div class="feature-title">
													<h5>
														<s style="color: gray">${classList.className }</s>
													</h5>
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
						<!-- /수업 리스트-->

						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
		<br> <br> <br> <br>
	</div>

	<!-- ****** Footer Area Start ****** -->
	<jsp:include page="footer.jsp" />
	<!-- ****** Footer Area End ****** -->

	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap-4 js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/others/plugins.js"></script>
	<!-- Active JS -->
	<script src="js/active.js"></script>
	<script src="js/levelJS.js"></script>
</body>

</html>