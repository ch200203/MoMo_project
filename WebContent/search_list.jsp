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
<title>검색</title>

<!-- Favicon -->
<link rel="icon" href="img/favicon-img/logo-favicon.png">

<!-- Font-awesome -->
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<!-- Core Stylesheet -->
<link href="style.css" rel="stylesheet">

<!-- Responsive CSS -->
<link href="css/responsive/responsive.css" rel="stylesheet">

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
		<br> <br>
		<div class="row h-100 align-items-center justify-content-center"
			style="margin: 0px">

			<div class="container" style="margin: auto;">
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

							<hr>

							<p>
							<h6>검색된 모임</h6>
							</p>

							<!-- 검색된 모임 리스트  -->
							<c:choose>
								<c:when test="${empty searchedList }">
									<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
								</c:when>
								<c:otherwise>
									<c:forEach var="searchedList" items="${searchedList }">
										<c:if test="${searchedList.openYN eq 'Y' }">
											<div class="single-features-area"
												style="position: relative; margin: 30px; display: inline-block;"
												onclick="location.href='momo.do?command=club_detail&clubNo=${searchedList.clubNo }'">
												<c:choose>
													<c:when test="${empty searchedList.clubPicture }">
														<img class="picture_size"
															src=img/default_img/default_picture_2.png alt="">
													</c:when>
													<c:otherwise>
														<img class="picture_size"
															src="img/club_img/${searchedList.clubPicture }" alt="">
													</c:otherwise>
												</c:choose>
												<div class="price-start">
													<p>${searchedList.clubCategoryName }</p>
												</div>
												<div
													class="feature-content d-flex align-items-center justify-content-between">
													<div class="feature-title">
														<h5>${searchedList.clubName }</h5>
														<p>${searchedList.clubAddress }</p>
													</div>
													<div class="feature-favourite">
														<a href="#">
															<c:if test="${searchedList.clubScore ge '0' && searchedList.clubScore le '20'}">
																<i class="fas fa-star level" style="color: #7643ea;"></i>
															</c:if> 
															<c:if test="${searchedList.clubScore ge '21' && searchedList.clubScore le '50'}">
																<i class="fas fa-star level" style="color: #D8F781;"></i>
															</c:if> 
															<c:if test="${searchedList.clubScore ge '51' && searchedList.clubScore le '100'}">
																<i class="fas fa-star level" style="color: #A9F5F2;"></i>
															</c:if> 
															<c:if test="${searchedList.clubScore ge '101' && searchedList.clubScore le '200'}">
																<i class="fas fa-star level" style="color: #2E9AFE;"></i>
															</c:if> 
															<c:if test="${searchedList.clubScore ge '201'}">
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

							<hr>

							<p>
							<h6>검색된 수업</h6>
							</p>

							<!-- 검색된 수업리스트 -->
							<c:choose>
								<c:when test="${empty searchedClassList }">
									<div style="text-align: center;">--해당 모임이 존재하지 않습니다--</div>
								</c:when>
								<c:otherwise>
									<c:forEach var="searchedClassList"
										items="${searchedClassList }">
										<c:if test="${searchedClassList.openYN eq 'Y' }">
											<div class="single-features-area"
												style="position: relative; margin: 30px; display: inline-block"
												onclick="location.href='momo.do?command=class_detail&classNo=${searchedClassList.classNo }'">
												<c:choose>
													<c:when test="${empty searchedClassList.classPicture}">
														<img class="picture_size"
															src="img/default_img/default_picture_2.png" alt="">
													</c:when>
													<c:otherwise>
														<img class="picture_size"
															src="img/class_img/${searchedClassList.classPicture }" alt="">
													</c:otherwise>
												</c:choose>
												<div class="price-start">
													<p>${searchedClassList.classCategoryName }</p>
												</div>
												<div
													class="feature-content d-flex align-items-center justify-content-between">
													<div class="feature-title">
														<h5>${searchedClassList.className }</h5>
														<p>${searchedClassList.memberName }</p>
														<p>${searchedClassList.classAddress }</p>
													</div>
													<div class="feature-favourite">
													<a href="#">
														<c:if test="${searchedClassList.classScore ge '0' && searchedClassList.classScore le '20'}">
															<i class="fas fa-star level" style="color: #7643ea;"></i>
														</c:if> 
														<c:if test="${searchedClassList.classScore ge '21' && searchedClassList.classScore le '50'}">
															<i class="fas fa-star level" style="color: #D8F781;"></i>
														</c:if> 
														<c:if test="${searchedClassList.classScore ge '51' && searchedClassList.classScore le '100'}">
															<i class="fas fa-star level" style="color: #A9F5F2;"></i>
														</c:if> 
														<c:if test="${searchedClassList.classScore ge '101' && searchedClassList.classScore le '200'}">
															<i class="fas fa-star level" style="color: #2E9AFE;"></i>
														</c:if> 
														<c:if test="${searchedClassList.classScore ge '201'}">
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